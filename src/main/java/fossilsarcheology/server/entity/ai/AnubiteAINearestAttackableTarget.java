package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.player.EntityPlayer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnubiteAINearestAttackableTarget extends EntityAITarget {
    private static final String __OBFID = "CL_00001620";
    private final Class targetClass;
    private final int targetChance;
    /**
     * Instance of EntityAINearestAttackableTargetSorter.
     */
    private final AnubiteAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter;
    /**
     * This filter is applied to the Entity search. Only matching entities will
     * be targetted. (null -> no restrictions)
     */
    private final IEntitySelector targetEntitySelector;
    private EntityLivingBase targetEntity;

    public AnubiteAINearestAttackableTarget(EntityCreature prey, Class preyClass, int targetChance, boolean shouldCheckSight) {
        this(prey, preyClass, targetChance, shouldCheckSight, false);
    }

    public AnubiteAINearestAttackableTarget(EntityCreature prey, Class preyClass, int targetChance, boolean shouldCheckSight, boolean bool) {
        this(prey, preyClass, targetChance, shouldCheckSight, bool, null);
    }

    public AnubiteAINearestAttackableTarget(EntityCreature prey, Class preyClass, int targetChance, boolean shouldCheckSight, boolean bool, final IEntitySelector p_i1665_6_) {
        super(prey, shouldCheckSight, bool);
        this.targetClass = preyClass;
        this.targetChance = targetChance;
        this.theNearestAttackableTargetSorter = new AnubiteAINearestAttackableTarget.Sorter(prey);
        this.setMutexBits(1);
        this.targetEntitySelector = new IEntitySelector() {
            private static final String __OBFID = "CL_00001621";

            /**
             * Return whether the specified entity is applicable to this filter.
             */
            @Override
            public boolean isEntityApplicable(Entity prey) {
                if (prey != null) {
                    if (prey instanceof EntityPlayer) {
                        EntityPlayer player = (EntityPlayer) prey;
                        if (player.getCurrentArmor(3) != null) {
                            if (player.getCurrentArmor(3).getItem() != null) {
                                if (player.getCurrentArmor(3).getItem() == FAItemRegistry.INSTANCE.ancienthelmet) {
                                    return false;
                                }
                            }
                        }
                    }
                }
                return prey.getClass() != taskOwner.getClass() && prey instanceof EntityLivingBase && (!(p_i1665_6_ != null && !p_i1665_6_.isEntityApplicable(prey)) && AnubiteAINearestAttackableTarget.this.isSuitableTarget((EntityLivingBase) prey, false));
            }
        };
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {

        if (this.targetChance > 0 && this.taskOwner.getRNG().nextInt(this.targetChance) != 0) {
            return false;
        } else {
            double d0 = this.getTargetDistance();
            List list = this.taskOwner.worldObj.selectEntitiesWithinAABB(this.targetClass, this.taskOwner.boundingBox.expand(d0, 4.0D, d0), this.targetEntitySelector);
            Collections.sort(list, this.theNearestAttackableTargetSorter);

            if (list.isEmpty()) {
                return false;
            } else {
                this.targetEntity = (EntityLivingBase) list.get(0);
                return true;
            }
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.targetEntity);
        super.startExecuting();
    }

    public static class Sorter implements Comparator {
        private static final String __OBFID = "CL_00001622";
        private final Entity theEntity;

        public Sorter(Entity p_i1662_1_) {
            this.theEntity = p_i1662_1_;
        }

        public int compare(Entity p_compare_1_, Entity p_compare_2_) {
            double d0 = this.theEntity.getDistanceSqToEntity(p_compare_1_);
            double d1 = this.theEntity.getDistanceSqToEntity(p_compare_2_);
            return d0 < d1 ? -1 : (d0 > d1 ? 1 : 0);
        }

        @Override
        public int compare(Object p_compare_1_, Object p_compare_2_) {
            return this.compare((Entity) p_compare_1_, (Entity) p_compare_2_);
        }
    }
}