package fossilsarcheology.server.item;

import fossilsarcheology.Revival;
import fossilsarcheology.client.model.armor.ModelHeadbandRoman;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class HeadRelicItem extends ItemArmor {
    public static final String[] headbandItemNames = new String[] { "broken", "roman" };
    ModelBiped headband = new ModelHeadbandRoman();
    @SideOnly(Side.CLIENT)
    private IIcon[] headbandIcons;

    public HeadRelicItem(ArmorMaterial par2ArmorMaterial, int par3, int par4) {
        super(par2ArmorMaterial, par3, par4);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Gets an icon index based on an item's damage value
     */
    public IIcon getIconFromDamage(int par1) {
        int j = MathHelper.clamp_int(par1, 0, 15);
        return this.headbandIcons[j];
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an
     * ItemStack so different stacks can have different names based on their
     * damage or NBT.
     */
    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack) {
        int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 1);
        return super.getUnlocalizedName() + "." + headbandItemNames[i];
    }

    @SideOnly(Side.CLIENT)
    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        for (int j = 0; j < 2; ++j) {
            par3List.add(new ItemStack(this, 1, j));
        }
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
        if (slot == 0) {
            return "fossil:textures/armor/headband_master.png";
        }

        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IIconRegister) {
        this.headbandIcons = new IIcon[headbandItemNames.length];

        for (int i = 0; i < headbandItemNames.length; ++i) {

            this.headbandIcons[i] = par1IIconRegister.registerIcon("fossil:headrelic_" + headbandItemNames[i]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {

        ModelBiped armorModel = null;

        if (itemStack != null) {
            if (itemStack.getItem() instanceof HeadRelicItem) {
                int type = ((ItemArmor) itemStack.getItem()).armorType;

                if (type == 1 || type == 3) {
                    armorModel = Revival.PROXY.getArmorModel(0);
                } else {
                    armorModel = Revival.PROXY.getArmorModel(1);
                }
            }
            if (armorModel != null) {
                armorModel.bipedHead.showModel = armorSlot == 0;
                armorModel.bipedHeadwear.showModel = armorSlot == 0;
                armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
                armorModel.bipedRightArm.showModel = armorSlot == 1;
                armorModel.bipedLeftArm.showModel = armorSlot == 1;
                armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
                armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;

                armorModel.isSneak = entityLiving.isSneaking();
                armorModel.isRiding = entityLiving.isRiding();
                armorModel.isChild = entityLiving.isChild();
                armorModel.heldItemRight = entityLiving.getEquipmentInSlot(0) != null ? 1 : 0;
                if (entityLiving instanceof EntityPlayer) {
                    armorModel.aimedBow = ((EntityPlayer) entityLiving).getItemInUseDuration() > 2;
                }
                return armorModel;
            }
        }

        return null;
    }

}