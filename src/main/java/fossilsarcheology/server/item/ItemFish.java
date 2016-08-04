package fossilsarcheology.server.item;

import fossilsarcheology.server.entity.EntityFishBase;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFish extends Item {
    public static final int TypeCount = PrehistoricEntityType.values().length;
    private PrehistoricEntityType dino;
    public boolean isEggs;

    public ItemFish(PrehistoricEntityType dino, boolean isEggs) {
        super();
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.dino = dino;
        this.isEggs = isEggs;
    }

    public boolean spawnCreature(World world, PrehistoricEntityType prehistoricEnum, double x, double y, double z) {
        Entity egg = prehistoricEnum.invokeClass(world);
        if (egg != null) {
            egg.setLocationAndAngles(x, y + 1, z, world.rand.nextFloat() * 360.0F, 0.0F);
            if (egg instanceof EntityFishBase) {
                EntityFishBase prehistoric = (EntityFishBase) egg;
                if (isEggs) {
                    prehistoric.setGrowingAge(-24000);
                } else {
                    prehistoric.setGrowingAge(12000);
                }
                if (!world.isRemote) {
                    world.spawnEntityInWorld(egg);
                }
            }
        }
        return egg != null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iicon) {
        this.itemIcon = isEggs ? iicon.registerIcon("fossil:prehistoric/dinoEggs/" + dino.name() + "_Egg") : iicon.registerIcon("fossil:prehistoric/fish/" + dino.name().toLowerCase());
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, int i, float f, float f1, float f2) {
        boolean b = spawnCreature(world, dino, (double) ((float) x + 0.5F), (double) ((float) y), (double) ((float) z + 0.5F));
        if (b && !player.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        return b;
    }
}
