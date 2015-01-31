package mods.fossil.client.model;

import org.lwjgl.opengl.GL11;

import mods.fossil.entity.mob.EntityCoelacanth;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCoelacanth extends ModelBase
{
  //fields
    ModelRenderer tail;
    ModelRenderer head;
    ModelRenderer fin2;
    ModelRenderer fin4;
    ModelRenderer DorsalFin2;
    ModelRenderer DorsalFin3;
    ModelRenderer fin1;
    ModelRenderer fin3;
    ModelRenderer DorsalFin1;
  
  public ModelCoelacanth()
  {
    textureWidth = 64;
    textureHeight = 32;
    setTextureOffset("tail.tail", 20, 0);
    setTextureOffset("fin2.Fin2", 0, 0);
    setTextureOffset("fin4.Fin4", 0, 0);
    setTextureOffset("DorsalFin2.DorsalFin2", 12, 0);
    setTextureOffset("DorsalFin3.DorsalFin3", 12, 0);
    setTextureOffset("head.Body", 0, 0);
    setTextureOffset("fin1.Fin1", 0, 0);
    setTextureOffset("fin3.Fin3", 0, 0);
    setTextureOffset("DorsalFin1.DorsalFin", 18, 0);
    
    tail = new ModelRenderer(this, "tail");
    tail.setRotationPoint(0F, 15F, 0F);
    setRotation(tail, 0F, 0F, 0F);
    tail.mirror = true;
      tail.addBox("tail", -0.5F, -1F, 0F, 1, 4, 10);
    fin2 = new ModelRenderer(this, "fin2");
    fin2.setRotationPoint(-0.5F, 2F, 1F);
    setRotation(fin2, 0F, 0F, 0F);
    fin2.mirror = true;
      fin2.addBox("Fin2", -1F, -0.3F, 0F, 1, 2, 3);
      tail.addChild(fin2);
    fin4 = new ModelRenderer(this, "fin4");
    fin4.setRotationPoint(0.5F, 2F, 1F);
    setRotation(fin4, 0F, 0F, 0F);
    fin4.mirror = true;
      fin4.addBox("Fin4", 0F, -0.3F, 0F, 1, 2, 3);
      tail.addChild(fin4);
    DorsalFin2 = new ModelRenderer(this, "DorsalFin2");
    DorsalFin2.setRotationPoint(0F, 0F, 0F);
    setRotation(DorsalFin2, 0F, 0F, 0F);
    DorsalFin2.mirror = true;
      DorsalFin2.addBox("DorsalFin2", 0F, 1F, 2F, 0, 2, 3);
      tail.addChild(DorsalFin2);
    DorsalFin3 = new ModelRenderer(this, "DorsalFin3");
    DorsalFin3.setRotationPoint(0F, 0F, 0F);
    setRotation(DorsalFin3, 0F, 0F, 0F);
    DorsalFin3.mirror = true;
      DorsalFin3.addBox("DorsalFin3", 0F, -0.5F, 3F, 0, 2, 3);
      tail.addChild(DorsalFin3);
    head = new ModelRenderer(this, "head");
    head.setRotationPoint(0F, 15F, 0F);
    setRotation(head, 0F, 0F, 0F);
    head.mirror = true;
      head.addBox("Body", -1F, -1F, -7.5F, 2, 5, 8);
    fin1 = new ModelRenderer(this, "fin1");
    fin1.setRotationPoint(0.9333333F, 2F, -2F);
    setRotation(fin1, 0F, 0F, 0F);
    fin1.mirror = true;
      fin1.addBox("Fin1", 0F, 0F, -0.5F, 1, 2, 3);
      head.addChild(fin1);
    fin3 = new ModelRenderer(this, "fin3");
    fin3.setRotationPoint(-1F, 2F, -2F);
    setRotation(fin3, 0F, 0F, 0F);
    fin3.mirror = true;
      fin3.addBox("Fin3", -1F, 0F, -0.5F, 1, 2, 3);
      head.addChild(fin3);
    DorsalFin1 = new ModelRenderer(this, "DorsalFin1");
    DorsalFin1.setRotationPoint(0F, -1F, -1F);
    setRotation(DorsalFin1, -0.6320364F, 0F, 0F);
    DorsalFin1.mirror = true;
      DorsalFin1.addBox("DorsalFin", -0.5F, -1F, -0.5F, 1, 2, 2);
      head.addChild(DorsalFin1);
  }
  
  public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
  {
    this.setRotationAngles(var2, var3, var4, var5, var6, var7, (EntityCoelacanth)var1);
    this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
    
    this.tail.render(var7);
    this.head.render(var7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7)
  {
      super.setRotationAngles(var1, var2, var3, var4, var5, var6, var7);
      

      this.DorsalFin1.rotateAngleX = -0.632036082F;
      if (var7.isInWater() || var7.getAir() > 0) 
      {     
    	  this.tail.rotateAngleZ = 0F;
    	  this.head.rotateAngleZ = 0F; 
      this.fin1.rotateAngleY = 0.4F * MathHelper.sin(var3 * 0.3F + 2.0F) + 0.4F;
      this.fin3.rotateAngleY = -(0.4F * MathHelper.sin(var3 * 0.3F + 3.0F) + 0.4F);
      this.fin1.rotateAngleX = 0.2F * MathHelper.sin(var3 * 0.3F + 3.0F) + 0.4F;
      this.fin3.rotateAngleX = 0.2F * MathHelper.sin(var3 * 0.3F + 3.0F) + 0.4F;
      
      this.fin4.rotateAngleY = 0.2F * MathHelper.sin(var3 * 0.3F + 3.0F) + 0.1F;
      this.fin2.rotateAngleY = -(0.2F * MathHelper.sin(var3 * 0.3F + 2.0F) + 0.1F);
      this.fin4.rotateAngleX = 0.1F * MathHelper.sin(var3 * 0.3F + 1.0F) + 0.1F;
      this.fin2.rotateAngleX = 0.1F * MathHelper.sin(var3 * 0.3F + 1.0F) + 0.1F;
      
      this.tail.rotateAngleY = 0.2F * MathHelper.sin(var3 * (float)0.15F + var2);
      }
      else
      {
    	  this.tail.rotateAngleZ = 1.57079633F;
    	  this.head.rotateAngleZ = 1.57079633F;
    	  
    	  this.tail.rotateAngleY = 0.2F * MathHelper.sin(var3 * (float)1.15F + var2);
    	  this.head.rotateAngleY = -0.2F * MathHelper.sin(var3 * (float)1.15F + var2);
      }
  }

}
