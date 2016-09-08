package fossilsarcheology.server.entity.mob;

import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Flock {
    public float flockYaw;
    public List<EntityPrehistoric> flockMembers = new ArrayList<>();
    public EntityPrehistoric flockLeader;
    public PrehistoricEntityType type;
    private double flockPosX;
    private double flockPosY;
    private double flockPosZ;
    private Path flockPath;
    private PathNavigate flockNavigator;

    public static int random(Random random, int max, int min) {
        return random.nextInt(max - min) + min;
    }

    public void createFlock(EntityPrehistoric creator) {
        flockMembers.add(creator);
        flockLeader = creator;
        flockPosX = creator.posX;
        flockPosY = creator.posY;
        flockPosZ = creator.posZ;
    }

    public void onUpdate() {
        if (flockLeader == null || flockLeader.isDead) {
            setNewLeader();
        }
        for (EntityPrehistoric member : flockMembers) {
            if (member != null && flockLeader != null && this.flockNavigator != null && this.flockNavigator.getPath() != null) {
                if (member.getNavigator().noPath() && member != this.flockLeader) {
                    Path path = this.flockLeader.getNavigator().getPath();
                    member.getNavigator().setPath(this.flockNavigator.getPathToXYZ(path.getFinalPathPoint().xCoord + random(member.getRNG(), 6, -6), path.getFinalPathPoint().yCoord + random(member.getRNG(), 6, -6), path.getFinalPathPoint().zCoord + random(member.getRNG(), 6, -6)), 1);
                }
            }
        }
        if (flockNavigator == null) {
            flockNavigator = flockLeader.getNavigator();
        }
        if (flockLeader != null) {
            if (!flockLeader.isMovementBlocked() && flockLeader.getNavigator().noPath()) {
                Vec3d vec3 = RandomPositionGenerator.findRandomTargetBlockAwayFrom(flockLeader, 32, 7, new Vec3d(flockLeader.posX, flockLeader.posY, flockLeader.posZ));
                this.flockLeader.getNavigator().setPath(this.flockNavigator.getPathToXYZ(vec3.xCoord, vec3.yCoord, vec3.zCoord), 1);
            }
        }
    }

    public EntityPrehistoric findNewMember(World world, AxisAlignedBB bounds, EntityPrehistoric leader) {
        List<EntityPrehistoric> prehistoric = world.getEntitiesWithinAABB(EntityPrehistoric.class, bounds);
        EntityPrehistoric newMember = null;
        double closest = Double.MAX_VALUE;
        for (EntityPrehistoric entity : prehistoric) {
            if (entity != leader && !this.flockMembers.contains(entity) && entity.type == leader.type) {
                double distance = leader.getDistanceSqToEntity(entity);
                if (distance <= closest) {
                    newMember = entity;
                    closest = distance;
                }
            }
        }
        return newMember;
    }

    public void setNewLeader() {
        flockLeader = flockMembers.get(new Random().nextInt(flockMembers.size()));
    }

    public void disband() {
        flockMembers.clear();
    }
}
