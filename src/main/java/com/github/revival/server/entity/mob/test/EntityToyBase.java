package com.github.revival.server.entity.mob.test;

import net.minecraft.entity.EntityLiving;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityToyBase extends EntityLiving{
	
	public int toyBonus;
	
	public EntityToyBase(World world, int toyBonus) {
	    super(world);
	    this.toyBonus = toyBonus;

    }
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("Invulnerable", true);
	}
}
