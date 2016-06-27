package fossilsarcheology.server.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.mob.projectile.EntityAncientJavelin;
import fossilsarcheology.server.entity.mob.projectile.EntityJavelin;
import fossilsarcheology.server.message.MessageJavelinType;

public class JavelinItem extends Item {
	public ToolMaterial material;
	private String name;

	public JavelinItem(ToolMaterial var2, String name) {
		super();
		this.maxStackSize = 16;
		this.setMaxDamage(30);
		this.hasSubtypes = false;
		this.material = var2;
		this.name = name;
		this.bFull3D = true;
	}

	@Override
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("fossil:" + name);
	}

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

			Object javelin;

			if (this != FAItemRegistry.INSTANCE.ancientJavelin) // !this.isAncient)
			{
				javelin = new EntityJavelin(var2, var3, var7 * 2.0F, this.material, var1.getMaxDamage() - (var1.getItemDamage() + 1));
			} else {
				javelin = new EntityAncientJavelin(var2, var3, var7 * 2.0F, this.material, var1.getMaxDamage() - (var1.getItemDamage() + 1));
			}

			if (var7 == 1.0F) {
				((EntityJavelin) javelin).arrowCritical = true;
			}

			int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, var1);

			if (var9 > 0) {
				((EntityJavelin) javelin).setDamage(((EntityJavelin) javelin).getDamage() + (double) var9 * 0.5D + 0.5D);
			}

			int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, var1);

			if (var10 > 0) {
				((EntityJavelin) javelin).setKnockbackStrength(var10);
			}

			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, var1) > 0) {
				((EntityJavelin) javelin).setFire(100);
			}

			var2.playSoundAtEntity(var3, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);

			if (!var5) {
				var3.inventory.consumeInventoryItem(this);
			} else {
				((EntityJavelin) javelin).canBePickedUp = 2;
			}

			if (!var2.isRemote) {
				var2.spawnEntityInWorld((Entity) javelin);
			}
			if (this != FAItemRegistry.INSTANCE.ancientJavelin && javelin instanceof EntityJavelin) {
				Revival.NETWORK_WRAPPER.sendToAll(new MessageJavelinType(((EntityJavelin)javelin).getEntityId(), material.ordinal()));
			}
		}
	}

	public ItemStack onFoodEaten(ItemStack var1, World var2, EntityPlayer var3) {
		return var1;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack var1) {
		return 720000;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack var1) {
		return EnumAction.bow;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		if (var3.capabilities.isCreativeMode || var3.inventory.hasItem(this)) {
			var3.setItemInUse(var1, this.getMaxItemUseDuration(var1));
		}

		return var1;
	}

	@Override
	public int getItemEnchantability() {
		return 1;
	}
}