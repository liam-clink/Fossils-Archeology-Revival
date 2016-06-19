package fossilsarcheology.server.entity.mob.test;

import fossilsarcheology.server.enums.EnumPrehistoric;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Flock {
    public float flockYaw;
    public List<EntityNewPrehistoric> flockMembers = new ArrayList<EntityNewPrehistoric>();
    public EntityNewPrehistoric flockLeader;
    public EnumPrehistoric type;
    private double flockPosX;
    private double flockPosY;
    private double flockPosZ;
    /**
     * The PathEntity of our entity
     */
    private PathEntity flockPathEntity;
    /**
     * The PathNavigate of our entity
     */
    private PathNavigate flockPathNavigate;

    public static int generateVarience(int max, int min) {
        return -min + (int) (Math.random() * ((max - (-min)) + 1));
    }

    public void createFlock(EntityNewPrehistoric creator) {
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
        for (EntityNewPrehistoric member : flockMembers) {
            if (member != null && flockLeader != null && this.flockPathNavigate != null && this.flockPathNavigate.getPath() != null) {
                if (member.getNavigator().noPath() && member != this.flockLeader) {
                	PathEntity path = this.flockLeader.getNavigator().getPath();
                    member.getNavigator().setPath(this.flockPathNavigate.getPathToXYZ(path.getFinalPathPoint().xCoord + generateVarience(-4, -4), path.getFinalPathPoint().yCoord + generateVarience(-4, -4), path.getFinalPathPoint().zCoord + generateVarience(-4, -4)), 1);
                }
            }
        }

        if (flockPathNavigate == null) {
            flockPathNavigate = flockLeader.getNavigator();
        }
        if (flockLeader != null) {
            if (findNewMember(flockLeader.worldObj, flockLeader.boundingBox.expand(5, 5, 5), flockLeader) != null) {
                if (flockLeader.getRNG().nextInt(20) == 0) {
                    Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockAwayFrom(flockLeader, 32, 7, Vec3.createVectorHelper(flockLeader.posX, flockLeader.posY, flockLeader.posZ));
                    this.flockPathEntity = this.flockPathNavigate.getPathToXYZ(vec3.xCoord, vec3.yCoord, vec3.zCoord);
                    this.flockPathNavigate.setPath(this.flockPathEntity, 0.7);
                }
            }
        }
    }

    public EntityNewPrehistoric findNewMember(World world, AxisAlignedBB bb, EntityNewPrehistoric leader) {
        List list = world.getEntitiesWithinAABB(EntityNewPrehistoric.class, bb);
        EntityNewPrehistoric entity1 = null;
        double d0 = Double.MAX_VALUE;

        for (int i = 0; i < list.size(); ++i) {
            EntityNewPrehistoric entity2 = (EntityNewPrehistoric) list.get(i);

            if (entity2 != leader && !this.flockMembers.contains(entity2) && entity2.type == leader.type) {
                double d1 = leader.getDistanceSqToEntity(entity2);

                if (d1 <= d0) {
                    entity1 = entity2;
                    d0 = d1;
                }
            }
        }
        return entity1;
    }

    public void setNewLeader() {
        flockLeader = flockMembers.get(new Random().nextInt(flockMembers.size()));
    }

    public void disband() {
        flockMembers.clear();

    }
}
