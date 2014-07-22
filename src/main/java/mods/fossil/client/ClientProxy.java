package mods.fossil.client;

import mods.fossil.CommonProxy;
import mods.fossil.Fossil;
import mods.fossil.client.gui.GuiBoneHelmet;
import mods.fossil.client.model.ModelAnkylosaurus;
import mods.fossil.client.model.ModelBrachiosaurus;
import mods.fossil.client.model.ModelCoelacanth;
import mods.fossil.client.model.ModelCompsognathus;
import mods.fossil.client.model.ModelDeinonychus;
import mods.fossil.client.model.ModelDilophosaurus;
import mods.fossil.client.model.ModelDodo;
import mods.fossil.client.model.ModelFailuresaurus;
import mods.fossil.client.model.ModelGallimimus;
import mods.fossil.client.model.ModelMammoth;
import mods.fossil.client.model.ModelMosasaurus;
import mods.fossil.client.model.ModelNautilus;
import mods.fossil.client.model.ModelPachycephalosaurus;
import mods.fossil.client.model.ModelPigBoss;
import mods.fossil.client.model.ModelPlesiosaur;
import mods.fossil.client.model.ModelSmilodon;
import mods.fossil.client.model.ModelSpinosaurus;
import mods.fossil.client.model.ModelStegosaurus;
import mods.fossil.client.model.ModelTRex;
import mods.fossil.client.model.ModelTriceratops;
import mods.fossil.client.model.ModelVelociraptor;
import mods.fossil.client.renderer.entity.RenderAnkylosaurus;
import mods.fossil.client.renderer.entity.RenderBones;
import mods.fossil.client.renderer.entity.RenderBrachiosaurus;
import mods.fossil.client.renderer.entity.RenderCoelacanth;
import mods.fossil.client.renderer.entity.RenderCompsognathus;
import mods.fossil.client.renderer.entity.RenderDeinonychus;
import mods.fossil.client.renderer.entity.RenderDilophosaurus;
import mods.fossil.client.renderer.entity.RenderDinoEgg;
import mods.fossil.client.renderer.entity.RenderDodo;
import mods.fossil.client.renderer.entity.RenderFPZ;
import mods.fossil.client.renderer.entity.RenderFailuresaurus;
import mods.fossil.client.renderer.entity.RenderGallimimus;
import mods.fossil.client.renderer.entity.RenderJavelin;
import mods.fossil.client.renderer.entity.RenderMammoth;
import mods.fossil.client.renderer.entity.RenderMosasaurus;
import mods.fossil.client.renderer.entity.RenderNautilus;
import mods.fossil.client.renderer.entity.RenderPachycephalosaurus;
import mods.fossil.client.renderer.entity.RenderPigBoss;
import mods.fossil.client.renderer.entity.RenderPlesiosaur;
import mods.fossil.client.renderer.entity.RenderPterosaur;
import mods.fossil.client.renderer.entity.RenderSmilodon;
import mods.fossil.client.renderer.entity.RenderSpinosaurus;
import mods.fossil.client.renderer.entity.RenderStegosaurus;
import mods.fossil.client.renderer.entity.RenderStoneboard;
import mods.fossil.client.renderer.entity.RenderTRex;
import mods.fossil.client.renderer.entity.RenderTriceratops;
import mods.fossil.client.renderer.entity.RenderVelociraptor;
import mods.fossil.client.renderer.item.ItemFigurineRenderer;
import mods.fossil.client.renderer.item.ItemVaseAmphoraRenderer;
import mods.fossil.client.renderer.item.ItemVaseKylixRenderer;
import mods.fossil.client.renderer.item.ItemVaseVoluteRenderer;
import mods.fossil.client.renderer.tileentity.RenderTNClock;
import mods.fossil.client.renderer.tileentity.TileEntityFigurineRenderer;
import mods.fossil.client.renderer.tileentity.TileEntityVaseRenderer;
import mods.fossil.entity.EntityAncientJavelin;
import mods.fossil.entity.EntityCultivatedDodoEgg;
import mods.fossil.entity.EntityDinoEgg;
import mods.fossil.entity.EntityDodoEgg;
import mods.fossil.entity.EntityJavelin;
import mods.fossil.entity.EntityStoneboard;
import mods.fossil.entity.mob.EntityAnkylosaurus;
import mods.fossil.entity.mob.EntityBones;
import mods.fossil.entity.mob.EntityBrachiosaurus;
import mods.fossil.entity.mob.EntityCoelacanth;
import mods.fossil.entity.mob.EntityCompsognathus;
import mods.fossil.entity.mob.EntityDeinonychus;
import mods.fossil.entity.mob.EntityDilophosaurus;
import mods.fossil.entity.mob.EntityDodo;
import mods.fossil.entity.mob.EntityFailuresaurus;
import mods.fossil.entity.mob.EntityFriendlyPigZombie;
import mods.fossil.entity.mob.EntityGallimimus;
import mods.fossil.entity.mob.EntityMammoth;
import mods.fossil.entity.mob.EntityMosasaurus;
import mods.fossil.entity.mob.EntityNautilus;
import mods.fossil.entity.mob.EntityPachycephalosaurus;
import mods.fossil.entity.mob.EntityPigBoss;
import mods.fossil.entity.mob.EntityPlesiosaur;
import mods.fossil.entity.mob.EntityPregnantPig;
import mods.fossil.entity.mob.EntityPterosaur;
import mods.fossil.entity.mob.EntitySmilodon;
import mods.fossil.entity.mob.EntitySpinosaurus;
import mods.fossil.entity.mob.EntityStegosaurus;
import mods.fossil.entity.mob.EntityTRex;
import mods.fossil.entity.mob.EntityTriceratops;
import mods.fossil.entity.mob.EntityVelociraptor;
import mods.fossil.guiBlocks.TileEntityFigurine;
import mods.fossil.guiBlocks.TileEntityTimeMachine;
import mods.fossil.guiBlocks.TileEntityVase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

public class ClientProxy extends CommonProxy
{
    
    @Override
    public void registerRenderThings()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityStoneboard.class, new RenderStoneboard());
        RenderingRegistry.registerEntityRenderingHandler(EntityTriceratops.class, new RenderTriceratops(new ModelTriceratops(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityVelociraptor.class, new RenderVelociraptor(new ModelVelociraptor(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityTRex.class, new RenderTRex(new ModelTRex(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityFailuresaurus.class, new RenderFailuresaurus(new ModelFailuresaurus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPigBoss.class, new RenderPigBoss(new ModelPigBoss(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityFriendlyPigZombie.class, new RenderFPZ());
        RenderingRegistry.registerEntityRenderingHandler(EntityPterosaur.class, new RenderPterosaur());
        RenderingRegistry.registerEntityRenderingHandler(EntityNautilus.class, new RenderNautilus(new ModelNautilus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPlesiosaur.class, new RenderPlesiosaur(new ModelPlesiosaur(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMosasaurus.class, new RenderMosasaurus(new ModelMosasaurus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityStegosaurus.class, new RenderStegosaurus(new ModelStegosaurus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityDinoEgg.class, new RenderDinoEgg(1.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPregnantPig.class, new RenderPig(new ModelPig(), new ModelPig(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityDilophosaurus.class, new RenderDilophosaurus(new ModelDilophosaurus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySmilodon.class, new RenderSmilodon(new ModelSmilodon(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityJavelin.class, new RenderJavelin());
        RenderingRegistry.registerEntityRenderingHandler(EntityAncientJavelin.class, new RenderJavelin());
        RenderingRegistry.registerEntityRenderingHandler(EntityBones.class, new RenderBones());
        RenderingRegistry.registerEntityRenderingHandler(EntityBrachiosaurus.class, new RenderBrachiosaurus(new ModelBrachiosaurus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMammoth.class, new RenderMammoth(new ModelMammoth(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySpinosaurus.class, new RenderSpinosaurus(new ModelSpinosaurus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityCompsognathus.class, new RenderCompsognathus(new ModelCompsognathus(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityDodo.class, new RenderDodo(new ModelDodo(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityDodoEgg.class, new RenderSnowball(Fossil.dodoEgg));
        RenderingRegistry.registerEntityRenderingHandler(EntityCultivatedDodoEgg.class, new RenderSnowball(Fossil.cultivatedDodoEgg));
        RenderingRegistry.registerEntityRenderingHandler(EntityAnkylosaurus.class, new RenderAnkylosaurus(new ModelAnkylosaurus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPachycephalosaurus.class, new RenderPachycephalosaurus(new ModelPachycephalosaurus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityDeinonychus.class, new RenderDeinonychus(new ModelDeinonychus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGallimimus.class, new RenderGallimimus(new ModelGallimimus(), 0.5F));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.figurineBlock), new ItemFigurineRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.vaseVoluteBlock), new ItemVaseVoluteRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.vaseAmphoraBlock), new ItemVaseAmphoraRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.vaseKylixBlock), new ItemVaseKylixRenderer());
        //MinecraftForgeClient.registerItemRenderer(Fossil.blockSifterIdle.blockID, new ItemSifterRenderer());
        RenderingRegistry.registerEntityRenderingHandler(EntityCoelacanth.class, new RenderCoelacanth(new ModelCoelacanth(), 0.5F));
        
    	VillagerRegistry.instance().registerVillagerSkin(10, new ResourceLocation("fossil:textures/mob/Archaeologist.png"));
    }

    @Override
    public void registerTileEntitySpecialRenderer()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTimeMachine.class, new RenderTNClock());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFigurine.class, new TileEntityFigurineRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVase.class, new TileEntityVaseRenderer()); 
       // ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySifter.class, new TileEntitySifterRenderer());
    }

    public void registerEvents()
    {
        MinecraftForge.EVENT_BUS.register(new GuiBoneHelmet(Minecraft.getMinecraft()));
    }
    

}
