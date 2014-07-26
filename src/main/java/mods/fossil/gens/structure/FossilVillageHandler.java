package mods.fossil.gens.structure;

import cpw.mods.fml.common.registry.VillagerRegistry.IVillageCreationHandler;
import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import java.util.List;
import java.util.Random;

public class FossilVillageHandler implements IVillageCreationHandler
{
    public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int size)
    {
        return new StructureVillagePieces.PieceWeight(ComponentDigSiteTent01.class, 4, MathHelper.getRandomIntegerInRange(random, 0, 1));
    }

    public Class getComponentClass()
    {
        return ComponentDigSiteTent01.class;
    }

    public Object buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5)
    {
        return ComponentDigSiteTent01.buildComponent(startPiece, pieces, random, p1, p2, p3, p4, p5);
    }
}