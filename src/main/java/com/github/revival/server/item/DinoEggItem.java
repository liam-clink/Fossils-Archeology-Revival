package com.github.revival.server.item;

import com.github.revival.Revival;
import com.github.revival.server.entity.EntityDinoEgg;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.Taming;
import com.github.revival.server.message.MessageUpdateEgg;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DinoEggItem extends Item {
	public static final int TypeCount = EnumPrehistoric.values().length;
	private EnumPrehistoric dino;

	public DinoEggItem(EnumPrehistoric dino) {
		super();
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.maxStackSize = 1;
		this.dino = dino;
	}

	public static boolean spawnCreature(World world, EnumPrehistoric prehistoricEnum, double x, double y, double z) {
		Object egg;
		if (!prehistoricEnum.isAquatic()) {
			egg = new EntityDinoEgg(world, prehistoricEnum);
			((Entity) egg).setLocationAndAngles(x, y + 1.0F, z, world.rand.nextFloat() * 360.0F, 0.0F);
			if (!world.isRemote) {
				world.spawnEntityInWorld((Entity) egg);
			}
			((EntityDinoEgg) egg).selfType = prehistoricEnum;
			if (!world.isRemote)
				Revival.NETWORK_WRAPPER.sendToAll(new MessageUpdateEgg(((EntityDinoEgg) egg).getEntityId(), prehistoricEnum.ordinal()));
			return true;
		} else {
			egg = prehistoricEnum.invokeClass(world);
			if (egg != null) {
				((Entity) egg).setLocationAndAngles(x, y + 1, z, world.rand.nextFloat() * 360.0F, 0.0F);
				if(!world.isRemote){
					world.spawnEntityInWorld((Entity) egg);
				}
				if (egg instanceof EntityNewPrehistoric) {
					EntityNewPrehistoric prehistoric = (EntityNewPrehistoric) egg;
					if (prehistoric.aiTameType() == Taming.IMPRINTING) {
						prehistoric.setTamed(true);
						prehistoric.setAgeInDays(1);
						prehistoric.func_152115_b(world.getClosestPlayerToEntity(prehistoric, 10).getDisplayName());
					}
				}
			}
		}
		return egg != null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iicon) {
		this.itemIcon = iicon.registerIcon("fossil:prehistoric/dinoEggs/" + dino.name() + "_Egg");
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float f1, float f2) {
		boolean b = spawnCreature(world, dino, (double) ((float) x + 0.5F), (double) ((float) y), (double) ((float) z + 0.5F));
		if (b && !player.capabilities.isCreativeMode) {
			--stack.stackSize;
		}
		return b;
	}
}
