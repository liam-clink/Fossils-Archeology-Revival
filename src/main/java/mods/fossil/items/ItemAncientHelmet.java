package mods.fossil.items;

import mods.fossil.Fossil;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemAncientHelmet extends ItemArmor
{
    public ItemAncientHelmet(ArmorMaterial par2ArmorMaterial, int par3, int par4)
    {
        super(par2ArmorMaterial, par3, par4);
        this.setCreativeTab(Fossil.tabFCombat);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return "fossil:textures/armor/TextureAncientHelmet.png";
    }
    @Override 
	@SideOnly(Side.CLIENT) 
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
		ModelBiped armorModel = new ModelBiped(); 

		if(itemStack != null){ if(itemStack.getItem() instanceof ItemAncientHelmet){ 

			int type = ((ItemArmor)itemStack.getItem()).armorType;
			if(type == 1 || type == 3){

				armorModel = Fossil.proxy.getArmorModel(0); 
			}else{
				armorModel = Fossil.proxy.getArmorModel(1); 
			} 
		}
		if(armorModel != null){ 
			armorModel.bipedHead.showModel = armorSlot == 0; armorModel.bipedHeadwear.showModel = armorSlot == 0; 
			armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2; armorModel.bipedRightArm.showModel = armorSlot == 1; 
			armorModel.bipedLeftArm.showModel = armorSlot == 1; armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3; 
			armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3; armorModel.isSneak = entityLiving.isSneaking();
			armorModel.isRiding = entityLiving.isRiding(); armorModel.isChild = entityLiving.isChild();
			armorModel.heldItemRight = entityLiving.getEquipmentInSlot(0) != null ? 1 :0;
			if(entityLiving instanceof EntityPlayer){
				armorModel.aimedBow =((EntityPlayer)entityLiving).getItemInUseDuration() > 2;
			} 
			return armorModel; 
		}
		} 
		return null; 
	} 

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("fossil:Ancient_Helm");
    }
}