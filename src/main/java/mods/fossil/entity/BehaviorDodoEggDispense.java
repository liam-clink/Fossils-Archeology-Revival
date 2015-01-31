package mods.fossil.entity;

import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class BehaviorDodoEggDispense extends BehaviorProjectileDispense
{
    /** Reference to the MinecraftServer object. */
    final MinecraftServer mcServer;
    int javelin;

    public BehaviorDodoEggDispense(MinecraftServer par1, int jav0)
    {
        this.mcServer = par1;
        this.javelin = jav0;
    }

    /**
     * Return the projectile entity spawned by this dispense behavior.
     */
    protected IProjectile getProjectileEntity(World par1World, IPosition par2IPosition)
    {
        if (this.javelin < 0)
        {
            EntityDodoEgg var3 = new EntityDodoEgg(par1World, par2IPosition.getX(), par2IPosition.getY(), par2IPosition.getZ());
            return var3;
        }

        EntityDodoEgg var3 = new EntityDodoEgg(par1World, par2IPosition.getX(), par2IPosition.getY(), par2IPosition.getZ());
        return var3;
    }
}
