package fossilsarcheology.server.item;

import fossilsarcheology.server.entity.mob.EntityCoelacanth;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class LivingCoelacanthItem extends Item {
    public static final String[] NAMES = new String[] { "first", "second", "third" };
    private int dinosaur;

    public LivingCoelacanthItem(int dinosaur) {
        super();
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.dinosaur = dinosaur;
        this.setHasSubtypes(true);
    }

    public static boolean spawnCreature(World world, double x, double y, double z) {
        EntityCoelacanth entity = new EntityCoelacanth(world);
        entity.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360.0F, 0.0F);
        world.spawnEntityInWorld(entity);
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (int i = 0; i < 3; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int index = MathHelper.clamp_int(stack.getItemDamage(), 0, NAMES.length);
        return super.getUnlocalizedName() + "." + NAMES[index];
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        Vec3d positionEyes = player.getPositionEyes(1.0F);
        RayTraceResult rayTraceResult = this.rayTrace(world, player, true);
        Vec3d look = player.getLook(1.0F);
        boolean entityCollide = false;
        List<Entity> entities = world.getEntitiesWithinAABBExcludingEntity(player, player.getEntityBoundingBox().addCoord(look.xCoord, look.yCoord, look.zCoord).expand(1.0, 1.0, 1.0));
        for (Entity entity : entities) {
            if (entity.canBeCollidedWith()) {
                float borderSize = entity.getCollisionBorderSize();
                AxisAlignedBB bounds = entity.getEntityBoundingBox().expand(borderSize, borderSize, borderSize);
                if (bounds.isVecInside(positionEyes)) {
                    entityCollide = true;
                }
            }
        }
        if (!entityCollide) {
            if (rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK) {
                if (!world.isRemote) {
                    BlockPos position = rayTraceResult.getBlockPos();
                    if (world.getBlockState(position).getBlock() == Blocks.SNOW) {
                        position = position.down();
                    }
                    if (!spawnCreature(world, position.getX() + 0.5, position.getY() + 1.0, position.getZ() + 0.5)) {
                        return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
                    }
                }
                if (!player.capabilities.isCreativeMode) {
                    --stack.stackSize;
                }
            }
        }
        return ActionResult.newResult(EnumActionResult.PASS, stack);
    }
}
