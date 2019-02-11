package fossilsarcheology.server.compat.tinkers;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.client.book.repository.FileRepository;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.book.TinkerBook;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;

public class TinkersCompatClient {

    @SideOnly(Side.CLIENT)
    static void preInit() {
        TinkerBook.INSTANCE.addTransformer(new FABookTransformer());
        TinkerBook.INSTANCE.addRepository(new FileRepository("fossil:tinkers/book"));
        MaterialRenderInfo renderInfo = new MaterialRenderInfo.Metal(0XF23726, 0.5f, 0.1f, 0.0f);
        renderInfo.setTextureSuffix("contrast");
        TinkersCompat.ancientMetal.setRenderInfo(renderInfo);
        ModelRegisterUtil.registerModifierModel(TinkersCompat.fossilModifier, new ResourceLocation("fossil:models/item/tinkers/paleontologist"));
        ModelRegisterUtil.registerModifierModel(TinkersCompat.archeologistModifier, new ResourceLocation("fossil:models/item/tinkers/archeologist"));
        ModelRegisterUtil.registerModifierModel(TinkersCompat.scarabModifier, new ResourceLocation("fossil:models/item/tinkers/scarab"));
    }
}
