package com.github.revival.server.item;

import com.github.revival.server.entity.EntityAncientJavelin;
import com.github.revival.server.entity.EntityJavelin;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class JavelinItem extends Item {
    public ToolMaterial SelfMaterial;
    //private boolean isAncient = false;
    String TextureFileName;

    public JavelinItem(ToolMaterial var2, String TextureFileName0) {
        super();
        this.maxStackSize = 16;
        this.setMaxDamage(30);
        //this.iconIndex = 48;
        this.hasSubtypes = false;
        this.SelfMaterial = var2;
        this.TextureFileName = TextureFileName0;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("fossil:" + TextureFileName);
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    /*public int getIconFromDamage(int var1)
    {
        return this.SelfMaterial == ToolMaterial.GOLD ? 52 : (this.SelfMaterial == ToolMaterial.EMERALD ? 51 : (this.isAncient ? 64 : this.SelfMaterial.getHarvestLevel() + 48));
    }*/

    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    @Override
    public void onPlayerStoppedUsing(ItemStack var1, World var2, EntityPlayer var3, int var4) {
        boolean var5 = EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, var1) > 0;

        if (var5 || var3.inventory.hasItem(this)) {
            int var6 = this.getMaxItemUseDuration(var1) - var4;
            float var7 = (float) var6 / 20.0F;
            var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;

            if ((double) var7 < 0.1D) {
                return;
            }

            if (var7 > 1.0F) {
                var7 = 1.0F;
            }

            Object var8;

            if (this != FAItemRegistry.INSTANCE.ancientJavelin) //!this.isAncient)
            {
                var8 = new EntityJavelin(var2, var3, var7 * 2.0F, this.SelfMaterial, var1.getMaxDamage() - (var1.getItemDamage() + 1));
            } else {
                var8 = new EntityAncientJavelin(var2, var3, var7 * 2.0F, this.SelfMaterial, var1.getMaxDamage() - (var1.getItemDamage() + 1));
            }

            if (var7 == 1.0F) {
                ((EntityJavelin) var8).arrowCritical = true;
            }

            int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, var1);

            if (var9 > 0) {
                ((EntityJavelin) var8).setDamage(((EntityJavelin) var8).getDamage() + (double) var9 * 0.5D + 0.5D);
            }

            int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, var1);

            if (var10 > 0) {
                ((EntityJavelin) var8).setKnockbackStrength(var10);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, var1) > 0) {
                ((EntityJavelin) var8).setFire(100);
            }

            var2.playSoundAtEntity(var3, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);

            if (!var5) {
                var3.inventory.consumeInventoryItem(this);
            } else {
                ((EntityJavelin) var8).canBePickedUp = 2;
            }

            if (!var2.isRemote) {
                var2.spawnEntityInWorld((Entity) var8);
            }
        }
    }

    public ItemStack onFoodEaten(ItemStack var1, World var2, EntityPlayer var3) {
        return var1;
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(ItemStack var1) {
        return 720000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack var1) {
        return EnumAction.bow;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
        if (var3.capabilities.isCreativeMode || var3.inventory.hasItem(this)) {
            var3.setItemInUse(var1, this.getMaxItemUseDuration(var1));
        }

        return var1;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    @Override
    public int getItemEnchantability() {
        return 1;
    }

    /*public boolean isAncient()
    {
        return this.isAncient;
    }

    public Item setAncient(boolean var1)
    {
        this.isAncient = var1;
        return this;
    }*/
}