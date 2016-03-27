package com.github.revival.server.item;

import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.entity.mob.EntityDinosaur;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.handler.LocalizationStrings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.Random;

public class BioFossilItem extends Item {
    public BioFossilItem() {
        maxStackSize = 64;
        setMaxDamage(0);
        setUnlocalizedName(LocalizationStrings.BIO_FOSSIL_NAME);
        setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
    }


    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("fossil:Bio_Fossil");
    }

    public boolean tryPlaceIntoWorld(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6/*, int var7, float var8, float var9, float var10*/) {
        if (var3.isRemote) {
            return true;
        } else {
            Class var11 = this.getRandomModel().getDinoClass();
            EntityDinosaur var12;

            try {
                var12 = (EntityDinosaur) var11.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var3});
            } catch (Throwable var14) {
                var14.printStackTrace();
                return false;
            }

            var12.setModelized(true);
            var12.setLocationAndAngles((double) var4, (double) (var5 + 1), (double) var6, var3.rand.nextFloat() * 360.0F, 0.0F);
            var12.faceEntity(var2, 360.0F, 360.0F);

            if (var3.checkNoEntityCollision(var12.boundingBox) && var3.getCollidingBoundingBoxes(var12, var12.boundingBox).size() == 0) {
                var3.spawnEntityInWorld(var12);
                --var1.stackSize;
                return true;
            } else {
                return false;
            }
        }
    }

    private EnumPrehistoric getRandomModel() {
        EnumPrehistoric[] var1 = EnumPrehistoric.values();
        int var2 = var1.length;
        Random var4 = new Random();
        EnumPrehistoric var3;

        do {
            var3 = var1[var4.nextInt(var2)];
        }
        while (!var3.isModelable());

        return var3;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
        float var4 = 1.0F;
        float var5 = var3.prevRotationPitch + (var3.rotationPitch - var3.prevRotationPitch) * var4;
        float var6 = var3.prevRotationYaw + (var3.rotationYaw - var3.prevRotationYaw) * var4;
        double var7 = var3.prevPosX + (var3.posX - var3.prevPosX) * (double) var4;
        double var9 = var3.prevPosY + (var3.posY - var3.prevPosY) * (double) var4 + 1.62D - (double) var3.yOffset;
        double var11 = var3.prevPosZ + (var3.posZ - var3.prevPosZ) * (double) var4;
        Vec3 var13 = Vec3.createVectorHelper(var7, var9, var11);
        float var14 = MathHelper.cos(-var6 * 0.017453292F - (float) Math.PI);
        float var15 = MathHelper.sin(-var6 * 0.017453292F - (float) Math.PI);
        float var16 = -MathHelper.cos(-var5 * 0.017453292F);
        float var17 = MathHelper.sin(-var5 * 0.017453292F);
        float var18 = var15 * var16;
        float var19 = var14 * var16;
        double var20 = 5.0D;
        Vec3 var22 = var13.addVector((double) var18 * var20, (double) var17 * var20, (double) var19 * var20);
        MovingObjectPosition var23 = this.getMovingObjectPositionFromPlayer(var2, var3, true);

        if (var23 == null) {
            return var1;
        } else if (var23.typeOfHit == MovingObjectType.BLOCK && var2.getBlock(var23.blockX, var23.blockY, var23.blockZ).getMaterial().isSolid()) {
            int var34 = var23.blockX;
            int var32 = var23.blockY;
            int var33 = var23.blockZ;
            this.tryPlaceIntoWorld(var1, var3, var2, var34, var32, var33);
        }

        return var1;
    }
}
