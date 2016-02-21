package com.github.revival.common.item;

import com.github.revival.Revival;
import com.github.revival.common.entity.mob.EntityDinosaur;
import com.github.revival.common.enums.EnumPrehistoric;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;

public class ItemDinosaurModels extends Item {

    @SideOnly(Side.CLIENT)
    public static IIcon[] icons;


    public ItemDinosaurModels() {
        super();
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + EnumPrehistoric.values()[itemstack.getItemDamage()].name();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage) {
        return icons[damage];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister icon) {
        icons = new IIcon[EnumPrehistoric.values().length];

        for (int i = 0; i < icons.length; i++) {
            if (i != 4) //Silly Nautilus, bones are for dinosaurs.
            {
                icons[i] = icon.registerIcon(Revival.MODID + ":" + "dinosaur_bones/models/" + EnumPrehistoric.values()[i] + "_model");
            }
        }
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < icons.length; i++) {
            if (i != 4) //Silly Nautilus, bones are for dinosaurs.
            {
                ItemStack itemstack = new ItemStack(item, 1, i);
                list.add(itemstack);
            }
        }
    }

    public boolean tryPlaceIntoWorld(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6/*, int var7, float var8, float var9, float var10*/) {
        if (var3.isRemote) {
            return true;
        } else {
            Class var11 = EnumPrehistoric.values()[var1.getItemDamage()].getDinoClass();
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

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
        float var4 = 1.0F;
        float var5 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * var4;
        float var6 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * var4;
        double x = player.prevPosX + (player.posX - player.prevPosX) * (double) var4;
        double y = player.prevPosY + (player.posY - player.prevPosY) * (double) var4 + 1.62D - (double) player.yOffset;
        double z = player.prevPosZ + (player.posZ - player.prevPosZ) * (double) var4;
        Vec3 var13 = Vec3.createVectorHelper(x, y, z);
        float var14 = MathHelper.cos(-var6 * 0.017453292F - (float) Math.PI);
        float var15 = MathHelper.sin(-var6 * 0.017453292F - (float) Math.PI);
        float var16 = -MathHelper.cos(-var5 * 0.017453292F);
        float var17 = MathHelper.sin(-var5 * 0.017453292F);
        float var18 = var15 * var16;
        float var19 = var14 * var16;
        double var20 = 5.0D;
        Vec3 var22 = var13.addVector((double) var18 * var20, (double) var17 * var20, (double) var19 * var20);
        MovingObjectPosition var23 = this.getMovingObjectPositionFromPlayer(world, player, true);

        if (var23 == null) {
            return itemstack;
        } else if (var23.typeOfHit == MovingObjectType.BLOCK && world.getBlock(var23.blockX, var23.blockY, var23.blockZ).getMaterial().isSolid()) {
            int var34 = var23.blockX;
            int var32 = var23.blockY;
            int var33 = var23.blockZ;
            this.tryPlaceIntoWorld(itemstack, player, world, var34, var32, var33);
        }

        return itemstack;
    }
}
