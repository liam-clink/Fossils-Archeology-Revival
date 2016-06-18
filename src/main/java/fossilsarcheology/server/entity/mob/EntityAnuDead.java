package fossilsarcheology.server.entity.mob;

import fossilsarcheology.Revival;
import fossilsarcheology.server.handler.AnuTeleporter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class EntityAnuDead extends EntityLiving {

    public boolean slowed;
    public int deathTicks = 0;
    public int deathTicks_animation = 0;
    public int maxLifespan = 940;
    private Entity target;

    public EntityAnuDead(World world) {
        super(world);
        this.setSize(1.8F, 0.8F);
        this.isImmuneToFire = true;
        this.ignoreFrustumCheck = true;

    }

    @Override
    public void moveEntityWithHeading(float par1, float par2) {
        this.motionX *= 0.0D;
        this.motionY *= 0.0D;
        this.motionZ *= 0.0D;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (byte) 0);
    }

    public void playSummonSong() {
        this.playSound("fossil:anu_death_effect", 1F, 1F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0D);
    }

    @Override
    public boolean interact(EntityPlayer entity) {
        if ((entity.ridingEntity == null) && (entity.riddenByEntity == null) && (entity instanceof EntityPlayerMP)) {
            EntityPlayerMP thePlayer = (EntityPlayerMP) entity;

            if (thePlayer.timeUntilPortal > 0) {
                thePlayer.timeUntilPortal = 10;
            } else if (thePlayer.dimension != Revival.CONFIG.dimensionIDTreasure) {
                thePlayer.timeUntilPortal = 10;
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, Revival.CONFIG.dimensionIDTreasure, new AnuTeleporter(thePlayer.mcServer.worldServerForDimension(Revival.CONFIG.dimensionIDTreasure)));
            } else {
                thePlayer.timeUntilPortal = 10;
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new AnuTeleporter(thePlayer.mcServer.worldServerForDimension(0)));
            }
        }
        return true;
    }

    /**
     * handles entity death timer, experience orb and particle creation
     */
    @Override
    protected void onDeathUpdate() {
        if (deathTicks < this.maxLifespan) {
            deathTicks++;
        }
        if (deathTicks == this.maxLifespan) {
            this.setDead();
        }
        if (deathTicks == 40) {
            this.playSummonSong();
        }
        for (int i = 0; i < 2; ++i) {
            if (worldObj.isRemote) {
                Revival.PROXY.spawnAnuParticle(worldObj, posX, posY, posZ);

            }
        }
    }

    /**
     * Makes the entity despawn if requirements are reached
     */
    @Override
    protected void despawnEntity() {

    }

    /**
     * Returns true if other Entities should be prevented from moving through
     * this Entity.
     */
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    @Override
    protected float getSoundVolume() {
        return 5.0F;
    }
}