package fossilsarcheology.server.block;

import fossilsarcheology.server.block.entity.TileEntityFigurine;
import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockFigurine extends BlockContainer implements IBlockItem {
    public static final PropertyEnum<BlockFigurine.EnumType> VARIANT = PropertyEnum.<BlockFigurine.EnumType>create("variant", BlockFigurine.EnumType.class);

    protected BlockFigurine() {
        super(Material.ROCK);
        this.setCreativeTab(FATabRegistry.BLOCKS);
        this.setUnlocalizedName("figurine");
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.FIGURINE_STEVE_PRISTINE));

    }

    public int damageDropped(IBlockState state) {
        return ((BlockFigurine.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        int l = MathHelper.floor((double) (placer.rotationYaw * 4.0F / 360.0F) + 1.5D) & 3;
        TileEntity tileentity = worldIn.getTileEntity(pos);
        ((TileEntityFigurine) tileentity).setFigurineType(stack.getItemDamage());
        ((TileEntityFigurine) tileentity).setFigurineRotation(l);
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
        for (BlockPlanks.EnumType blockplanks$enumtype : BlockPlanks.EnumType.values()) {
            list.add(new ItemStack(itemIn, 1, blockplanks$enumtype.getMetadata()));
        }
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, BlockFigurine.EnumType.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state) {
        return ((BlockFigurine.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityFigurine();
    }

    public static enum EnumType implements IStringSerializable
    {
        FIGURINE_STEVE_PRISTINE(0, "figurine_steve_pristine"),
        FIGURINE_SKELETON_PRISTINE(1, "figurine_skeleton_pristine"),
        FIGURINE_ZOMBIE_PRISTINE(2, "figurine_zombie_pristine"),
        FIGURINE_PIGZOMBIE_PRISTINE(3, "figurine_pigzombie_pristine"),
        FIGURINE_ENDERMAN_PRISTINE(4, "figurine_enderman_pristine"),
        FIGURINE_STEVE_DAMAGED(5, "figurine_steve_damaged"),
        FIGURINE_SKELETON_DAMAGED(6, "figurine_skeleton_damaged"),
        FIGURINE_ZOMBIE_DAMAGED(7, "figurine_zombie_damaged"),
        FIGURINE_PIGZOMBIE_DAMAGED(8, "figurine_pigzombie_damaged"),
        FIGURINE_ENDERMAN_DAMAGED(9, "figurine_enderman_damaged"),
        FIGURINE_STEVE_BROKEN(10, "figurine_steve_broken"),
        FIGURINE_SKELETON_BROKEN(11, "figurine_skeleton_broken"),
        FIGURINE_ZOMBIE_BROKEN(12, "figurine_zombie_broken"),
        FIGURINE_PIGZOMBIE_BROKEN(13, "figurine_pigzombie_broken"),
        FIGURINE_ENDERMAN_BROKEN(14, "figurine_enderman_broken"),
        FIGURINE_MYSTERIOUS(15, "figurine_mysterious");

        private static final BlockFigurine.EnumType[] META_LOOKUP = new BlockFigurine.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;

        private EnumType(int metaIn, String nameIn) {
            this(metaIn, nameIn, nameIn);
        }

        private EnumType(int metaIn, String nameIn, String unlocalizedNameIn) {
            this.meta = metaIn;
            this.name = nameIn;
            this.unlocalizedName = unlocalizedNameIn;
        }

        public int getMetadata() {
            return this.meta;
        }


        public String toString() {
            return this.name;
        }

        public static BlockFigurine.EnumType byMetadata(int meta) {
            if (meta < 0 || meta >= META_LOOKUP.length) {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName() {
            return this.name;
        }

        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }

        static {
            for (BlockFigurine.EnumType blockplanks$enumtype : values()) {
                META_LOOKUP[blockplanks$enumtype.getMetadata()] = blockplanks$enumtype;
            }
        }
    }

    @Override
    public Class<? extends ItemBlock> getItemBlockClass() {
        return FigurineBlockItem.class;
    }

    class FigurineBlockItem extends ItemBlock {
        public FigurineBlockItem(Block block) {
            super(block);
        }

        @Override
        public String getUnlocalizedName(ItemStack itemstack) {
            return getUnlocalizedName() + "." + EnumType.byMetadata(itemstack.getItemDamage()).getName();
        }
    }
}
