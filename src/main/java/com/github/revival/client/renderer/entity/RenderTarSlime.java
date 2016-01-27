package com.github.revival.client.renderer.entity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import org.lwjgl.opengl.GL11;

import com.github.revival.client.model.ModelTarSlime;
import com.github.revival.client.model.ModelTarSlimeOuter;

public class RenderTarSlime extends RenderSlime{

	public RenderTarSlime() {
		super(new ModelTarSlime(), new ModelTarSlimeOuter(), 0.3F);
	}

	protected ResourceLocation getEntityTexture(EntitySlime entity)
	{
		return new ResourceLocation("fossil:textures/model/tar_slime.png");
	}
}
