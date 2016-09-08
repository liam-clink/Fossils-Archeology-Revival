package fossilsarcheology.server.item;

import fossilsarcheology.Revival;
import fossilsarcheology.server.creativetab.FATabRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;

public class AncientHelmetItem extends ItemArmor {
    public AncientHelmetItem(ArmorMaterial material, int renderIndex, EntityEquipmentSlot slot) {
        super(material, renderIndex, slot);
        this.setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return "fossil:textures/armor/TextureAncientHelmet.png";
    }

    @Override
    public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack stack, EntityEquipmentSlot armorSlot, ModelBiped armorModel) {
        if (stack != null) {
            if (stack.getItem() instanceof AncientHelmetItem) {
                EntityEquipmentSlot type = ((ItemArmor) stack.getItem()).armorType;
                if (type == EntityEquipmentSlot.CHEST || type == EntityEquipmentSlot.LEGS) {
                    armorModel = Revival.PROXY.getArmorModel(0);
                } else {
                    armorModel = Revival.PROXY.getArmorModel(1);
                }
            }
            if (armorModel != null) {
                armorModel.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                armorModel.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                armorModel.bipedBody.showModel = armorSlot == EntityEquipmentSlot.CHEST || armorSlot == EntityEquipmentSlot.LEGS;
                armorModel.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                armorModel.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                armorModel.bipedRightLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET;
                armorModel.bipedLeftLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET;
                armorModel.isSneak = entity.isSneaking();
                armorModel.isRiding = entity.isRiding();
                armorModel.isChild = entity.isChild();
                ModelBiped.ArmPose pose = entity.getHeldItem(EnumHand.MAIN_HAND) != null ? ModelBiped.ArmPose.ITEM : ModelBiped.ArmPose.EMPTY;
                if (entity.getItemInUseCount() > 0) {
                    EnumAction action = stack.getItemUseAction();
                    if (action == EnumAction.BLOCK) {
                        pose = ModelBiped.ArmPose.BLOCK;
                    } else if (action == EnumAction.BOW) {
                        pose = ModelBiped.ArmPose.BOW_AND_ARROW;
                    }
                }
                if (entity.getPrimaryHand() == EnumHandSide.RIGHT) {
                    armorModel.rightArmPose = pose;
                } else {
                    armorModel.leftArmPose = pose;
                }
                return armorModel;
            }
        }
        return null;
    }
}