package com.github.revival.server.entity.mob;

import com.github.revival.client.gui.GuiPedia;
import com.github.revival.server.api.IPrehistoricAI;
import com.github.revival.server.enums.EnumPrehistoricAI;
import com.github.revival.server.enums.EnumPrehistoricAI.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import org.lwjgl.opengl.GL11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EntityPrehistoric extends EntityTameable implements IPrehistoricAI {

    public static final int OWNER_DISPLAY_NAME_INDEX = 24;
    protected static final ResourceLocation pediaclock = new ResourceLocation("fossil:textures/gui/PediaClock.png");
    protected static final ResourceLocation pediafood = new ResourceLocation("fossil:textures/gui/PediaFood.png");
    protected static final ResourceLocation pediaheart = new ResourceLocation("fossil:textures/gui/PediaHeart.png");
    public float animation_frame;
    private boolean inHerd = false;
    private float awarenessRadius;
    private int maxHerdSize;
    private float herdWanderRadius;

    public EntityPrehistoric(World world) {
        super(world);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(OWNER_DISPLAY_NAME_INDEX, "");
    }

    public boolean isInHerd() {
        return inHerd;
    }

    public float getAwarenessRadius() {
        return awarenessRadius;
    }

    @Override
    public void jump() {
        if (this.aiJumpType() == EnumPrehistoricAI.Jumping.TWOBLOCKS) {
            this.motionY = 0.41999998688697815D * 2;
            if (this.isPotionActive(Potion.jump)) {
                this.motionY += (double) ((float) (this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);
            }

            if (this.isSprinting()) {
                float f = this.rotationYaw * 0.017453292F;
                this.motionX -= (double) (MathHelper.sin(f) * 0.2F);
                this.motionZ += (double) (MathHelper.cos(f) * 0.2F);
            }

            this.isAirBorne = true;
            ForgeHooks.onLivingJump(this);
        } else {
            super.jump();
        }
    }

    public int getMaxHerdSize() {
        return maxHerdSize;
    }

    public float getHerdWanderRadius() {
        return herdWanderRadius;
    }

    /**
     * Override this and set temporary variables to the attributes.
     */
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(19.0D);
        getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        setBaseValues();
    }

    /**
     * Overrided in unique entity classes.
     */
    private void setBaseValues() {
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
        getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
        getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);

    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setString("OwnerDisplayName", this.getOwnerDisplayName());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound) {
        String s = "";

        if (compound.hasKey("Owner", 8)) {
            s = compound.getString("Owner");
            this.setOwnerDisplayName(s);
        } else {
            this.setOwnerDisplayName(compound.getString("OwnerDisplayName"));
        }

        super.readEntityFromNBT(compound);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable entityageable) {
        // TODO Auto-generated method stub
        return null;
    }

    public EntityPlayer getRidingPlayer() {
        if (riddenByEntity instanceof EntityPlayer) {
            return (EntityPlayer) riddenByEntity;
        } else {
            return null;
        }
    }

    //2:07 to
    @SideOnly(Side.CLIENT)
    public void ShowPedia2(GuiPedia p0, String mobName) {
        p0.reset();
        p0.addStringLR("", 150, false);
        String translatePath = "assets/fossil/dinopedia/" + Minecraft.getMinecraft().gameSettings.language + "/";
        String bioFile = String.valueOf(mobName) + ".txt";

        if (getClass().getClassLoader().getResourceAsStream(translatePath) == null) {
            translatePath = "assets/fossil/dinopedia/" + "en_US" + "/";
        }

        if (getClass().getClassLoader().getResourceAsStream(translatePath + bioFile) != null) {
            InputStream fileReader = getClass().getClassLoader().getResourceAsStream(translatePath + bioFile);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileReader));
                StringBuffer stringBuffer = new StringBuffer();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    GL11.glPushMatrix();
                    GL11.glScalef(0.5F, 0.5F, 0.5F);
                    p0.addStringLR(line, 150, false);
                    GL11.glPopMatrix();
                }
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            p0.addStringLR("File not found.", false);
            GL11.glPushMatrix();
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            p0.addStringLR(translatePath + bioFile, 150, false);
            GL11.glPopMatrix();
        }
    }

    public void onWhipRightClick() {
        // TODO Auto-generated method stub

    }

    public void onUpdate() {
        super.onUpdate();
        animation_frame++;
    }

    public String getOwnerDisplayName() {
        String s = this.dataWatcher.getWatchableObjectString(OWNER_DISPLAY_NAME_INDEX);
        return s;
    }

    public void setOwnerDisplayName(String displayName) {
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
    public Moving aiMovingType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WaterAbility aiWaterAbilityType() {
        // TODO Auto-generated method stub
        return null;
    }

}
