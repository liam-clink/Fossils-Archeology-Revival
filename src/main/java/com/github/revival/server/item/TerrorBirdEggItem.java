package com.github.revival.server.item;

import com.github.revival.Revival;
import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.entity.TerrorBirdEggEntity;
import com.github.revival.server.entity.mob.TerrorBirdEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class TerrorBirdEggItem extends Item {
    public static final String[] names = TerrorBirdEntity.names;
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    private boolean isCultivated;

    public TerrorBirdEggItem(boolean isCultivated) {
        super();
        this.maxStackSize = 16;
        this.setCreativeTab(FATabRegistry.tabFItems);
        this.setHasSubtypes(true);
        this.isCultivated = isCultivated;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister) {
        icons = new IIcon[names.length];

        for (int i = 0; i < icons.length; i++) {
            icons[i] = iconregister.registerIcon(Revival.MODID + ":TerrorBird/" + "Egg_" + this.cultivatedPrefix() + names[i]);
        }
    }

    private String cultivatedPrefix() {
        if (this.isCultivated) {
            return "Cultivated_";
        }

        return "";

    }

    public IIcon getIconFromDamage(int par1) {
        return icons[par1];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item item, CreativeTabs creativeTab, List list) {
        for (int x = 0; x < (names.length); x++) {
            list.add(new ItemStack(this, 1, x));
        }
    }

    public String getUnlocalizedName(ItemStack itemstack) {
        int i = MathHelper.clamp_int(itemstack.getItemDamage(), 0, 15);
        return super.getUnlocalizedName() + "." + names[i];
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            --itemstack.stackSize;
        }

        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote) {
            Item item = player.inventory.getCurrentItem().getItem();
            int subitem = itemstack.getItemDamage();

            world.spawnEntityInWorld(new TerrorBirdEggEntity(world, player, subitem, isCultivated));
        }

        return itemstack;
    }
}
