package com.github.revival.server.entity.toy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.github.revival.Revival;
import com.github.revival.server.entity.mob.test.EntityToyBase;
import com.github.revival.server.item.FAItemRegistry;
import com.github.revival.server.message.MessageRollBall;

public class EntityToyBall extends EntityToyBase{

	public int rollValue;

	public EntityToyBall(World world) {
		super(world, 15);
		this.setSize(0.5F, 0.5F);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1);
	}

	protected void entityInit(){
		super.entityInit();
		this.dataWatcher.addObject(20, 0);
	}

	public void writeEntityToNBT(NBTTagCompound compound){
		super.writeEntityToNBT(compound);
		compound.setInteger("Color", this.getColor());
	}

	public void readEntityFromNBT(NBTTagCompound compound){
		super.readEntityFromNBT(compound);
		this.setColor(compound.getInteger("Color"));
	}

	public void setColor(int color) {
		this.dataWatcher.updateObject(20, color);
	}

	public int getColor() {
		return this.dataWatcher.getWatchableObjectInt(20);
	}

	@Override
	public void applyEntityCollision(Entity entity) {
		if(entity != null && !(entity instanceof EntityToyBase)){
		this.rotationYaw = entity.rotationYaw;
        this.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * 0.5F));
		}
	}

	public void onUpdate(){
		super.onUpdate();
		if(this.motionX > 0 || this.motionZ < 0 || this.motionZ > 0 || this.motionZ < 0){
			rollValue++;
			Revival.NETWORK_WRAPPER.sendToAll(new MessageRollBall(this.getEntityId(), this.rollValue));
		}
	}

	@Override
	protected ItemStack getItem() {
		return new ItemStack(FAItemRegistry.INSTANCE.toyBall, 1, this.getColor());
	}

	@Override
	protected String getAttackNoise() {
		return "mob.slime.attack";
	}
}
