package com.github.revival.common.entity.mob.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import com.github.revival.client.gui.GuiPedia;
import com.github.revival.common.api.IPrehistoricAI;
import com.github.revival.common.enums.EnumPrehistoric;
import com.github.revival.common.enums.EnumOrderType;
import com.github.revival.common.enums.EnumPrehistoricAI.Activity;
import com.github.revival.common.enums.EnumPrehistoricAI.Attacking;
import com.github.revival.common.enums.EnumPrehistoricAI.Climbing;
import com.github.revival.common.enums.EnumPrehistoricAI.Dexterity;
import com.github.revival.common.enums.EnumPrehistoricAI.Following;
import com.github.revival.common.enums.EnumPrehistoricAI.Jumping;
import com.github.revival.common.enums.EnumPrehistoricAI.Response;
import com.github.revival.common.enums.EnumPrehistoricAI.Stalking;
import com.github.revival.common.enums.EnumPrehistoricAI.Taming;
import com.github.revival.common.enums.EnumPrehistoricAI.Untaming;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityNewPrehistoric extends EntityTameable implements IPrehistoricAI {

	public static final int OWNER_DISPLAY_NAME_INDEX = 24;
	public static final int HUNGER_TICK_DATA_INDEX = 18;
	public static final int HUNGER_DATA_INDEX = 19;
	public static final int AGE_TICK_DATA_INDEX = 20;
	public static final int AGE_DATA_INDEX = 21;
	public static final int SUBSPECIES_INDEX = 22;
	public static final int MODELIZED_INDEX = 23;
	public static final byte HEART_MESSAGE = 35;
	public static final byte SMOKE_MESSAGE = 36;
	public static final byte AGING_MESSAGE = 37;
	public float animation_frame;
	public float RiderStrafe = 0.0F;
	public float RiderForward = 0.0F;
	public boolean RiderJump = false;
	public boolean RiderSneak = false;
	public float minSize;
	public float maxSize;
	public int adultAge;
	public EnumPrehistoric SelfType = null;	public int BreedTick;
	public ItemStack ItemInMouth = null;
	public EnumOrderType OrderStatus;
	public double baseHealth;
	public double baseDamage;
	public double baseSpeed;
	public double maxHealth;
	public double maxDamage;
	public double maxSpeed;
	protected static final ResourceLocation pediaclock = new ResourceLocation("fossil:textures/gui/PediaClock.png");
	protected static final ResourceLocation pediafood = new ResourceLocation("fossil:textures/gui/PediaFood.png");
	protected static final ResourceLocation pediaheart = new ResourceLocation("fossil:textures/gui/PediaHeart.png");

	public EntityNewPrehistoric(World world) {
		super(world);
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(OWNER_DISPLAY_NAME_INDEX, "");
	}

	/**
	 * Override this and set temporary variables to the attributes.
	 */
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		setBaseValues();
	}


	private void setBaseValues()
	{
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
		getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);

	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound compound)
	{
		super.writeEntityToNBT(compound);
		compound.setString("OwnerDisplayName", this.getOwnerDisplayName());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound compound)
	{
		String s = "";

		if (compound.hasKey("Owner", 8))
		{
			s = compound.getString("Owner");
			this.setOwnerDisplayName(s);
		}
		else
		{
			this.setOwnerDisplayName(compound.getString("OwnerDisplayName"));
		}

		super.readEntityFromNBT(compound);
	}

	public EntityPlayer getRidingPlayer()
	{
		if (riddenByEntity instanceof EntityPlayer)
		{
			return (EntityPlayer) riddenByEntity;
		}
		else
		{
			return null;
		}
	}

	@SideOnly(Side.CLIENT)
	public void ShowPedia2(GuiPedia p0, String mobName)
	{
		p0.reset();
		p0.AddStringLR("", 150, false);
		String translatePath = "assets/fossil/dinopedia/" + Minecraft.getMinecraft().gameSettings.language + "/";
		String bioFile = String.valueOf(mobName) + ".txt";

		if (getClass().getClassLoader().getResourceAsStream(translatePath) == null)
		{
			translatePath = "assets/fossil/dinopedia/" + "en_US" + "/";
		}

		if (getClass().getClassLoader().getResourceAsStream(translatePath + bioFile) != null)
		{
			InputStream fileReader = getClass().getClassLoader().getResourceAsStream(translatePath + bioFile);
			try
			{
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileReader));
				StringBuffer stringBuffer = new StringBuffer();
				String line;
				while ((line = bufferedReader.readLine()) != null)
				{
					GL11.glPushMatrix();
					GL11.glScalef(0.5F, 0.5F, 0.5F);
					p0.AddStringLR(line, 150, false);
					GL11.glPopMatrix();
				}
				fileReader.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			p0.AddStringLR("File not found.", false);
			GL11.glPushMatrix();
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			p0.AddStringLR(translatePath + bioFile, 150, false);
			GL11.glPopMatrix();
		}
	}

	public void onUpdate(){
		super.onUpdate();
		animation_frame++;
	}

	public String getOwnerDisplayName()
	{
		String s = this.dataWatcher.getWatchableObjectString(OWNER_DISPLAY_NAME_INDEX);
		return s;
	}

	public void setOwnerDisplayName(String displayName)
	{
		this.dataWatcher.updateObject(OWNER_DISPLAY_NAME_INDEX, displayName);
	}


	@Override
	public Activity aiActivityType() {
		return Activity.DURINAL;
	}

	@Override
	public Attacking aiAttackType() {
		return Attacking.BASIC;
	}

	@Override
	public Climbing aiClimbType() {
		return Climbing.NONE;
	}

	@Override
	public Dexterity aiDexterityType() {
		return Dexterity.NONE;
	}

	@Override
	public Following aiFollowType() {
		return Following.NONE;
	}

	@Override
	public Jumping aiJumpType() {
		return Jumping.BASIC;
	}

	@Override
	public Response aiResponseType() {
		return Response.NONE;
	}

	@Override
	public Stalking aiStalkType() {
		return Stalking.NONE;
	}

	@Override
	public Taming aiTameType() {
		return Taming.IMPRINTING;
	}

	@Override
	public Untaming aiUntameType() {
		return Untaming.STARVE;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return null;
	}

}
