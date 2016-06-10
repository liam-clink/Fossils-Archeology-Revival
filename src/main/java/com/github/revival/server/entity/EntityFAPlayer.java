package com.github.revival.server.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class EntityFAPlayer implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "FAPlayer";
	private final EntityPlayer player;
	private boolean hasKilledAnu;

	public EntityFAPlayer(EntityPlayer player) {
		this.player = player;
		hasKilledAnu = false;
	}

	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(EntityFAPlayer.EXT_PROP_NAME, new EntityFAPlayer(player));
	}

	public static final EntityFAPlayer get(EntityPlayer player) {
		return (EntityFAPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setBoolean("HasKilledAnu", this.hasKilledAnu);
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.hasKilledAnu = properties.getBoolean("HasKilledAnu");
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void init(Entity entity, World world) {
	}

	public boolean isKilledAnu() {
		return hasKilledAnu;
	}

	public void setKilledAnu(boolean i) {
		this.hasKilledAnu = i;
	}

}