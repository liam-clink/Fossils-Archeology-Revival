package fossilsarcheology.server.entity.monster;

import com.google.common.base.Predicate;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityAnubite extends EntityMob {

	private int teleportDelay;

	public EntityAnubite(World world) {
		super(world);
		this.setSize(0.8F, 2.3F);
		this.isImmuneToFire = true;
		this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityLiving.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 1, true, false, new Predicate<EntityPlayer>() {
			public boolean apply(@Nullable EntityPlayer p_apply_1_) {
				return EntityAnubite.this.shouldAttackPlayer(p_apply_1_);
			}
		}));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityAnimal.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));

	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.34000001192092896D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4D);
	}

	private boolean shouldAttackPlayer(EntityPlayer player) {
		ItemStack stack = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		return stack.isEmpty() || stack.getItem() != FAItemRegistry.ANCIENT_HELMET;
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();

		if (this.getAttackTarget() != null) {
			this.faceEntity(this.getAttackTarget(), 100.0F, 100.0F);
		}
		if (!this.world.isRemote && this.isEntityAlive()) {
			if (this.getAttackTarget() != null) {
				if (this.getAttackTarget() instanceof EntityPlayer && this.shouldAttackPlayer((EntityPlayer) this.getAttackTarget())) {
					if (this.getAttackTarget().getDistanceSq(this) < 16.0D) {
						this.teleportRandomly();
					}

					this.teleportDelay = 0;
				} else if (this.getAttackTarget().getDistanceSq(this) > 256.0D && this.teleportDelay++ >= 30 && this.teleportToEntity(this.getAttackTarget())) {
					this.teleportDelay = 0;
				}
			} else {
				this.teleportDelay = 0;
			}
		}
	}

	/**
	 * Teleport the anubite to a random nearby position
	 */
	protected boolean teleportRandomly() {
		double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 32.0D;
		double d1 = this.posY + (double) (this.rand.nextInt(32) - 32);
		double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 32.0D;
		return this.teleportTo(d0, d1, d2);
	}

	/**
	 * Teleport the anubite to another entity
	 */
	protected boolean teleportToEntity(Entity entity) {
		Vec3d vec3 = new Vec3d(this.posX - entity.posX, this.getEntityBoundingBox().minY + (double) (this.height / 2.0F) - entity.posY + (double) entity.getEyeHeight(), this.posZ - entity.posZ);
		vec3 = vec3.normalize();
		double d0 = 16.0D;
		double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.x * d0;
		double d2 = this.posY + (double) (this.rand.nextInt(16) - 8) - vec3.y * d0;
		double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.z * d0;
		return this.teleportTo(d1, d2, d3);
	}

	protected boolean teleportTo(double x, double y, double z) {
		net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(this, x, y, z, 0);
		if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return false;
		boolean flag = this.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ());

		if (flag) {
			this.world.playSound(null, this.prevPosX, this.prevPosY, this.prevPosZ, SoundEvents.ENTITY_ENDERMEN_TELEPORT, this.getSoundCategory(), 1.0F, 1.0F);
			this.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
		}

		return flag;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_WITHER_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_ITEM_BREAK;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_IRONGOLEM_DEATH;
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		super.attackEntityAsMob(entity);
		if (rand.nextInt(3) == 0) {
			this.teleportRandomly();
		}
		return super.attackEntityAsMob(entity);

	}
}
