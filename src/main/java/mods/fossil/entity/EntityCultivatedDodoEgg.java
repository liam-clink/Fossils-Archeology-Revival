package mods.fossil.entity;

import mods.fossil.entity.mob.EntityDodo;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityCultivatedDodoEgg extends EntityThrowable
{
    public EntityCultivatedDodoEgg(World par1World)
    {
        super(par1World);
    }

    public EntityCultivatedDodoEgg(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }

    public EntityCultivatedDodoEgg(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    public String getTexture()
    {
        return "/mods/fossil/textures/items/Egg_Cultivated_Dodo.png";
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (par1MovingObjectPosition.entityHit != null)
        {
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0);
        }

        if (!this.worldObj.isRemote)
        {
            EntityDodo entitydodo = new EntityDodo(this.worldObj);
            entitydodo.setGrowingAge(-24000);
            entitydodo.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
            this.worldObj.spawnEntityInWorld(entitydodo);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}
