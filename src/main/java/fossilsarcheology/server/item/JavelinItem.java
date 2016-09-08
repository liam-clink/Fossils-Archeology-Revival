package fossilsarcheology.server.item;

import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.mob.projectile.EntityAncientJavelin;
import fossilsarcheology.server.entity.mob.projectile.EntityJavelin;
import fossilsarcheology.server.message.MessageJavelinType;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class JavelinItem extends Item {
    public ToolMaterial material;
    private String name;

    public JavelinItem(ToolMaterial material, String name) {
        super();
        this.maxStackSize = 16;
        this.setMaxDamage(30);
        this.hasSubtypes = false;
        this.material = material;
        this.name = name;
        this.bFull3D = true;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase entity, int timeLeft) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            boolean infinity = EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            int time = this.getMaxItemUseDuration(stack) - timeLeft;
            float timeScaled = (float) time / 20.0F;
            timeScaled = (timeScaled * timeScaled + timeScaled * 2.0F) / 3.0F;
            if (timeScaled < 0.1D) {
                return;
            }
            if (timeScaled > 1.0F) {
                timeScaled = 1.0F;
            }
            EntityJavelin javelin;
            if (this != FAItemRegistry.INSTANCE.ancientJavelin) {
                javelin = new EntityJavelin(world, player, timeScaled * 2.0F, this.material, stack.getMaxDamage() - (stack.getItemDamage() + 1));
            } else {
                javelin = new EntityAncientJavelin(world, player, timeScaled * 2.0F, this.material, stack.getMaxDamage() - (stack.getItemDamage() + 1));
            }
            if (timeScaled == 1.0F) {
                javelin.arrowCritical = true;
            }
            int power = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
            if (power > 0) {
                javelin.setDamage(javelin.getDamage() + power * 0.5D + 0.5D);
            }
            int knockback = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
            if (knockback > 0) {
                javelin.setKnockbackStrength(knockback);
            }
            if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
                javelin.setFire(100);
            }
            player.playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + timeScaled * 0.5F);
            if (!infinity) {
                player.inventory.decrStackSize(player.inventory.getSlotFor(stack), 1);
            } else {
                javelin.pickupStatus = EntityArrow.PickupStatus.ALLOWED;
            }
            if (!world.isRemote) {
                world.spawnEntityInWorld(javelin);
            }
            if (this != FAItemRegistry.INSTANCE.ancientJavelin) {
                Revival.NETWORK_WRAPPER.sendToAll(new MessageJavelinType(javelin.getEntityId(), material.ordinal()));
            }
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 720000;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        player.setActiveHand(hand);
        return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
    }

    @Override
    public int getItemEnchantability() {
        return 1;
    }
}