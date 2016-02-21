package com.github.revival.common.entity.mob;

import com.github.revival.Revival;
import com.github.revival.client.gui.GuiPedia;
import com.github.revival.common.item.FAItemRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public abstract class EntityFishBase extends EntityWaterMob {

    public int BreedTick = 3000;
    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;

    public EntityFishBase(World par1World) {
        super(par1World);
        this.setSize(this.width * 3.5F, this.height * 0.5F);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }

    private void setPedia() {
        Revival.toPedia = (Object) this;
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected Item getDropItem() {
        return Items.fish;
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking() {
        return false;
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1) {
        ItemStack var2 = var1.inventory.getCurrentItem();

        if (var2 != null && FMLCommonHandler.instance().getSide().isClient() && var2.getItem() == FAItemRegistry.dinoPedia) {
            this.setPedia();
            var1.openGui(Revival.instance, 4, this.worldObj, (int) this.posX, (int) this.posY, (int) this.posZ);
            return true;
        }

        if (var2 == null) {


            ItemStack var3 = new ItemStack(this.getItem(), 1);


            if (var1.inventory.addItemStackToInventory(var3)) {
                if (!this.worldObj.isRemote) {
                    this.worldObj.playSoundAtEntity(var1, "random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                    this.setDead();
                }

                return true;
            }
        }

        return super.interact(var1);
    }

    @SideOnly(Side.CLIENT)
    public void ShowPedia(GuiPedia p0) {
        p0.reset();

        if (this.hasCustomNameTag()) {
            p0.PrintStringXY(this.getCustomNameTag(), p0.rightIndent, 24, 40, 90, 245);
        }

        p0.PrintStringXY(StatCollector.translateToLocal(getCodeName()), p0.rightIndent, 34, 0, 0, 0);

        p0.PrintPictXY(new ResourceLocation(this.getItemTexture()), ((p0.xGui / 2) + (p0.xGui / 4)), 7, 16, 16);
        if (this.hasCustomNameTag()) {
            p0.AddStringLR("No Despawn", true);
        }
    }


    @SideOnly(Side.CLIENT)
    public void ShowPedia2(GuiPedia p0) {
        this.showPedia2(p0, this.getName());
    }

    @SideOnly(Side.CLIENT)
    public void showPedia2(GuiPedia p0, String mobName) {
        p0.reset();
        p0.AddStringLR("", 150, false);
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
                    p0.AddStringLR(line, 150, false);
                    GL11.glPopMatrix();
                }
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            p0.AddStringLR("File not found.", false);
            GL11.glPushMatrix();
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            p0.AddStringLR(translatePath + bioFile, 150, false);
            GL11.glPopMatrix();
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate() {
        super.onUpdate();
        HandleBreed();
    }

    /**
     * Checks if this entity is inside water (if inWater field is true as a result of handleWaterMovement() returning
     * true)
     */
    public boolean isInWater() {
        return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, this);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.isInWater()) {
            float f;
            if (!this.worldObj.isRemote) {
                this.motionX = (double) (this.randomMotionVecX);
                this.motionY = (double) (this.randomMotionVecY);
                this.motionZ = (double) (this.randomMotionVecZ);
            }

            f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.renderYawOffset += (-((float) Math.atan2(this.motionX, this.motionZ)) * 180.0F / (float) Math.PI - this.renderYawOffset) * 0.1F;
            this.rotationYaw = this.renderYawOffset;
        } else {
            if (!this.worldObj.isRemote) {
                this.motionX = 0.0D;
                this.motionY -= 0.08D;
                this.motionY *= 0.9800000190734863D;
                this.motionZ = 0.0D;
            }

        }
    }

    /**
     * Moves the entity based on the specified heading.  Args: strafe, forward
     */
    public void moveEntityWithHeading(float par1, float par2) {
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
    }

    protected void updateEntityActionState() {
        ++this.entityAge;

        if (this.entityAge > 100) {
            this.randomMotionVecX = this.randomMotionVecY = this.randomMotionVecZ = 0.0F;
        } else if (this.rand.nextInt(50) == 0 || !this.inWater || this.randomMotionVecX == 0.0F && this.randomMotionVecY == 0.0F && this.randomMotionVecZ == 0.0F) {
            float f = this.rand.nextFloat() * (float) Math.PI * 2.0F;
            this.randomMotionVecX = MathHelper.cos(f) * 0.2F;
            this.randomMotionVecY = -0.1F + this.rand.nextFloat() * 0.2F;
            this.randomMotionVecZ = MathHelper.sin(f) * 0.2F;
        }

        this.despawnEntity();
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere() {
        return this.posY > 45.0D && this.posY < 63.0D && super.getCanSpawnHere();
    }

    public void HandleBreed() {
        boolean var1 = false;
        --this.BreedTick;

        if (this.BreedTick == 0) {
            int var2 = 0;
            List var3 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

            for (int var4 = 0; var4 < var3.size(); ++var4) {
                if (var3.get(var4) instanceof EntityFishBase) {
                    if (!var1) {
                        ++var2;

                        if (var2 > 30)//too many, start damaging them
                        {
                            var1 = true;//restart
                            var4 = 0;
                        }
                    } else {
                        //damage them
                        EntityFishBase var5 = (EntityFishBase) ((EntityFishBase) var3.get(var4));
                        var5.attackEntityFrom(DamageSource.starve, 100);
                    }
                }
            }

            if (!var1) {
                if (var2 > 30) {
                    ;//no more
                } else {
                    spawnBaby(var2);
                }
                /*	EntityFishBase var6 = null;

					if ((new Random()).nextInt(100) + 1 < var2)
					{
						var6 = new EntityFishBase(this.worldObj);
						var6.setLocationAndAngles(this.posX + (double) ((new Random()).nextInt(3) - 1), this.posY, this.posZ + (double) ((new Random()).nextInt(3) - 1), this.worldObj.rand.nextFloat() * 360.0F, 0.0F);

						if (this.worldObj.checkNoEntityCollision(var6.boundingBox) && this.worldObj.getCollidingBoundingBoxes(var6, var6.boundingBox).size() == 0 && this.worldObj.isAnyLiquid(var6.boundingBox))
						{
							this.worldObj.spawnEntityInWorld(var6);
						}
					}
					*/
            }
        }

        this.BreedTick = 3000;
    }

    public abstract String getItemTexture();

    public abstract String getTexture();

    public abstract void spawnBaby(int i);

    public abstract String getName();

    public abstract String getCodeName();

    public abstract Item getItem();

}
	
	