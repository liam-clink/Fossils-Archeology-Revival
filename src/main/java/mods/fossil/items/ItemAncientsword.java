package mods.fossil.items;

import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.entity.EntityMLighting;
import mods.fossil.entity.mob.EntityFriendlyPigZombie;
import mods.fossil.fossilEnums.EnumPigmenSpeaks;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.EnumDifficulty;

public class ItemAncientsword extends ItemSword
{
    public ItemAncientsword(ToolMaterial var2)
    {
        super(var2);
        this.maxStackSize = 1;
        this.setMaxDamage(250);
    }

    public ItemAncientsword()
    {
        this(ToolMaterial.IRON);
    }

    
    /**
    * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
    * the damage on the stack.
    */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase targetentity, EntityLivingBase player)
    {
        EntityPlayer var2 = this.SearchUser(targetentity);
    	if (player != null && this.checkHelmet(var2))
    	{
        if (targetentity != null && player.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && (targetentity instanceof EntityPig || targetentity instanceof EntityPigZombie))
        {

            if (!targetentity.worldObj.isRemote)
            {
                EntityFriendlyPigZombie fpz = new EntityFriendlyPigZombie(targetentity.worldObj);
                fpz.LeaderName = var2.getCommandSenderName();
                fpz.setLocationAndAngles(targetentity.posX, targetentity.posY, targetentity.posZ, targetentity.rotationYaw, targetentity.rotationPitch);
                targetentity.setDead();
                targetentity.worldObj.spawnEntityInWorld(fpz);
                fpz.Mouth.SendSpeech(EnumPigmenSpeaks.LifeFor, fpz.LeaderName);
            }
        }    	
        
        if (targetentity != null && (new Random()).nextInt(100) < 8)
           {
        targetentity.worldObj.addWeatherEffect(new EntityMLighting(targetentity.worldObj, targetentity.posX, targetentity.posY, targetentity.posZ));    	
           }
    	}
    	
    	par1ItemStack.damageItem(1, player);
    	
		return true;
    }

    private EntityPlayer SearchUser(Entity var1)
    {
        EntityPlayer var2 = (EntityPlayer)var1.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, var1.boundingBox.expand(6.0D, 6.0D, 6.0D), var1);
        return var2 == null ? null : var2;
    }

    private boolean checkHelmet(EntityPlayer var1)
    {
        ItemStack var2 = var1.inventory.armorInventory[3];
        return var2 == null ? false : var2.getItem() == Fossil.ancienthelmet;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("fossil:Ancient_Sword");
    }
}
