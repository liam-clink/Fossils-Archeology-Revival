package com.github.revival.common.item;

import com.github.revival.common.entity.mob.EntityDinosaur;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemCarrotOnAStick;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWhip extends ItemCarrotOnAStick
{
    public ItemWhip()
    {
        super();
        this.setMaxDamage(100);
        this.setMaxStackSize(1);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if this item should be rotated by 180 degrees around the Y axis when being held in an entities
     * hands.
     */
    public boolean shouldRotateAroundWhenRendering()
    {
        return true;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
        if (player.isRiding() && player.ridingEntity instanceof EntityDinosaur)
        {
            EntityDinosaur dinosaur = (EntityDinosaur) player.ridingEntity;
            dinosaur.onWhipRightClick();
            itemstack.damageItem(1, player);
            player.swingItem();
            player.ridingEntity.playSound("fossil:whip", 1.0F, 1.0F);
        }
        else
        {
            /*
            if (!W.isRemote)
            {
                W.spawnEntityInWorld(new EntityWhipAttachment(W, P));
            }
            */
            player.swingItem();
            world.playSoundAtEntity(player, "fossil:whip", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
        }

        return itemstack;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon("fossil:Whip");
    }
}