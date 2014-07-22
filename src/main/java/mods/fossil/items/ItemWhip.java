package mods.fossil.items;

import mods.fossil.entity.mob.EntityDinosaur;
import mods.fossil.entity.mob.test.EntityFlyingDinosaur;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemCarrotOnAStick;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
    public ItemStack onItemRightClick(ItemStack I, World W, EntityPlayer P)
    {
        if (P.isRiding() && P.ridingEntity instanceof EntityFlyingDinosaur)
        {
        	EntityFlyingDinosaur D = (EntityFlyingDinosaur)P.ridingEntity;
        	
        	if(!D.isFlying())
        	{
        	D.liftOff();
        	}else {
        //	D.islanding = !D.islanding;
        	}
        	
        	
                I.damageItem(1, P);
                P.swingItem();
                P.ridingEntity.playSound("fossil:whip", 1.0F, 1.0F);
        }
        else if (P.isRiding() && P.ridingEntity instanceof EntityDinosaur)
        {
            EntityDinosaur D = (EntityDinosaur)P.ridingEntity;
                I.damageItem(1, P);
                P.swingItem();
                P.ridingEntity.playSound("fossil:whip", 1.0F, 1.0F);
        }
        else
        {
            /*
            if (!W.isRemote)
            {
                W.spawnEntityInWorld(new EntityWhipAttachment(W, P));
            }
            */
            P.swingItem();
            W.playSoundAtEntity(P, "fossil:whip", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
        }

        return I;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon("fossil:Whip");
    }
}
