package mods.fossil.client.renderer.entity;

import java.util.UUID;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.fossil.Fossil;
import mods.fossil.client.model.ModelAnubite;
import mods.fossil.entity.mob.EntityAnubite;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.mojang.authlib.GameProfile;

@SideOnly(Side.CLIENT)
public class RenderAnubite extends RenderBiped
{
    private static final ResourceLocation skeletonTextures = new ResourceLocation("fossil:textures/mob/Anubite_ancient.png");

    public RenderAnubite()
    {
        super(new ModelAnubite(), 0.3F);
    }
   
    protected ResourceLocation getEntityTexture(EntityLiving p_110775_1_)
    {
        return skeletonTextures;
    }

}