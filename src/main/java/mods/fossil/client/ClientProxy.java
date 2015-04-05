package mods.fossil.client;

import mods.fossil.CommonProxy;
import mods.fossil.Fossil;
import mods.fossil.client.gui.GuiBoneHelmet;
import mods.fossil.client.model.*;
import mods.fossil.client.renderer.entity.*;
import mods.fossil.client.renderer.item.ItemFigurineRenderer;
import mods.fossil.client.renderer.item.ItemRenderTileEntity;
import mods.fossil.client.renderer.item.ItemVaseAmphoraRenderer;
import mods.fossil.client.renderer.item.ItemVaseKylixRenderer;
import mods.fossil.client.renderer.item.ItemVaseVoluteRenderer;
import mods.fossil.client.renderer.tileentity.RenderFeeder;
import mods.fossil.client.renderer.tileentity.RenderTNClock;
import mods.fossil.client.renderer.tileentity.TileEntityCultivateRenderer;
import mods.fossil.client.renderer.tileentity.TileEntityFigurineRenderer;
import mods.fossil.client.renderer.tileentity.TileEntityVaseRenderer;
import mods.fossil.entity.EntityAncientJavelin;
import mods.fossil.entity.EntityCultivatedDodoEgg;
import mods.fossil.entity.EntityDinoEgg;
import mods.fossil.entity.EntityDodoEgg;
import mods.fossil.entity.EntityJavelin;
import mods.fossil.entity.EntityStoneboard;
import mods.fossil.entity.EntityTerrorBirdEgg;
import mods.fossil.entity.mob.*;
import mods.fossil.guiBlocks.TileEntityCultivate;
import mods.fossil.guiBlocks.TileEntityFigurine;
import mods.fossil.guiBlocks.TileEntityTimeMachine;
import mods.fossil.guiBlocks.TileEntityVase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

public class ClientProxy extends CommonProxy {
	public static int cultivateRenderType;
	public static int cultivateRenderPass;

    @Override
    public void registerRenderThings() {
    	
    	/*
    	 * Entity Registry
    	 */
    	
        RenderingRegistry.registerEntityRenderingHandler(EntityStoneboard.class, new RenderStoneboard());
        RenderingRegistry.registerEntityRenderingHandler(EntityTriceratops.class, new RenderTriceratops(new ModelTriceratops(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityVelociraptor.class, new RenderVelociraptor(new ModelVelociraptor(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityTRex.class, new RenderTRex(new ModelTRex(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityFailuresaurus.class, new RenderFailuresaurus(new ModelFailuresaurus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPigBoss.class, new RenderPigBoss(new ModelPigBoss(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityFriendlyPigZombie.class, new RenderFPZ());
        RenderingRegistry.registerEntityRenderingHandler(EntityPterosaur.class, new RenderPterosaur(new ModelPteranodon(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityNautilus.class, new RenderNautilus(new ModelNautilus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPlesiosaur.class, new RenderPlesiosaur(new ModelPlesiosaur(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMosasaurus.class, new RenderMosasaurus(new ModelMosasaurus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityStegosaurus.class, new RenderStegosaurus(new ModelStegosaurus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityDinoEgg.class, new RenderDinoEgg(1.5F));
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
        RenderingRegistry.registerEntityRenderingHandler(EntitySarcosuchus.class, new RenderSarcosuchus(new ModelSarcosuchus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityAllosaurus.class, new RenderAllosaurus(new ModelAllosaurus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityCoelacanth.class, new RenderCoelacanth(new ModelCoelacanth(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityLiopleurodon.class, new RenderLiopleurodon(new ModelLiopleurodon(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityQuagga.class, new RenderQuagga(new ModelQuagga(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityTerrorBird.class, new RenderTerrorBird(new ModelTerrorBird(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityTerrorBirdEgg.class, new RenderSnowball(Fossil.terrorBirdEgg));
        RenderingRegistry.registerEntityRenderingHandler(EntityElasmotherium.class, new RenderElasmotherium(new ModelElasmotherium(), 0.5F));

       
        /*
         * Item Registry
         */
        
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.figurineBlock), new ItemFigurineRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.vaseVoluteBlock), new ItemVaseVoluteRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.vaseAmphoraBlock), new ItemVaseAmphoraRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.vaseKylixBlock), new ItemVaseKylixRenderer());
        
        /*
         * Block Registry
         */
        
        RenderingRegistry.registerBlockHandler(Fossil.feederRenderID, new RenderFeeder());

        /*
         * Villager Registry
         */
        
    	VillagerRegistry.instance().registerVillagerSkin(10, new ResourceLocation("fossil:textures/mob/Archaeologist.png"));
    }

    /*
     * TileEntity Registry
     */
    
    @Override
    public void registerTileEntitySpecialRenderer() {
		TileEntitySpecialRenderer cultivate = new TileEntityCultivateRenderer();

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCultivate.class, cultivate); 
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.blockcultivateActive),new ItemRenderTileEntity(cultivate, new TileEntityCultivate()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.blockcultivateIdle),new ItemRenderTileEntity(cultivate, new TileEntityCultivate()));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTimeMachine.class, new RenderTNClock());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFigurine.class, new TileEntityFigurineRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVase.class, new TileEntityVaseRenderer()); 
    }

    /*
     * Events Registery
     */
    
    public void registerEvents() {
        MinecraftForge.EVENT_BUS.register(new GuiBoneHelmet(Minecraft.getMinecraft()));
        MinecraftForge.EVENT_BUS.register(new RenderPlayer());
    }
    

}
