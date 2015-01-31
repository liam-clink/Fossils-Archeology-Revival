package mods.fossil.items;

import mods.fossil.Fossil;
import mods.fossil.entity.EntityCultivatedDodoEgg;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCultivatedDodoEgg extends Item
{
    public ItemCultivatedDodoEgg()
    {
        super();
        this.maxStackSize = 16;
        this.setCreativeTab(Fossil.tabFItems);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("fossil:Egg_Cultivated_Dodo");
    }
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!par2World.isRemote)
        {
            par2World.spawnEntityInWorld(new EntityCultivatedDodoEgg(par2World, par3EntityPlayer));
        }

        return par1ItemStack;
    }
}
