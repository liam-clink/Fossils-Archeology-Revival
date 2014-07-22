package mods.fossil.client.model;

import mods.fossil.Fossil;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSifter extends ModelBase
{
  //fields
    ModelRenderer longwall1;
    ModelRenderer shortwall2;
    ModelRenderer longwall2;
    ModelRenderer shortwall1;
    ModelRenderer top;
    ModelRenderer floor;
    public ModelRenderer sifter;
  
  public ModelSifter()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      longwall1 = new ModelRenderer(this, 0, 34);
      longwall1.addBox(6F, -14F, -8F, 2, 14, 16);
      longwall1.setRotationPoint(0F, 24F, 0F);
      longwall1.setTextureSize(64, 64);
      longwall1.mirror = true;
      //setRotation(longwall1, 0F, 0F, 0F);
      shortwall2 = new ModelRenderer(this, 0, 18);
      shortwall2.addBox(-6F, -14F, -8F, 12, 14, 2);
      shortwall2.setRotationPoint(0F, 24F, 0F);
      shortwall2.setTextureSize(64, 64);
      shortwall2.mirror = true;
      //setRotation(shortwall2, 0F, 0F, 0F);
      longwall2 = new ModelRenderer(this, 0, 34);
      longwall2.addBox(-8F, -14F, -8F, 2, 14, 16);
      longwall2.setRotationPoint(0F, 24F, 0F);
      longwall2.setTextureSize(64, 64);
      longwall2.mirror = true;
      //setRotation(longwall2, 0F, 0F, 0F);
      shortwall1 = new ModelRenderer(this, 0, 18);
      shortwall1.addBox(-6F, -14F, 6F, 12, 14, 2);
      shortwall1.setRotationPoint(0F, 24F, 0F);
      shortwall1.setTextureSize(64, 64);
      shortwall1.mirror = true;
      //setRotation(shortwall1, 0F, 0F, 0F);
      top = new ModelRenderer(this, 0, 0);
      top.addBox(-6F, 0F, -6F, 12, 1, 12);
      top.setRotationPoint(0F, 12F, 0F);
      top.setTextureSize(64, 64);
      top.mirror = true;
      //setRotation(top, 0F, 0F, 0F);
      floor = new ModelRenderer(this, 0, 0);
      floor.addBox(-6F, 0F, -6F, 12, 1, 12);
      floor.setRotationPoint(0F, 21F, 0F);
      floor.setTextureSize(64, 64);
      floor.mirror = true;
      //setRotation(floor, 0F, 0F, 0F);
      sifter = new ModelRenderer(this, 36, 42);
      sifter.addBox(-0.4666667F, -5.5F, -5.5F, 2, 11, 11);
      sifter.setRotationPoint(0F, 11F, 0F);
      sifter.setTextureSize(64, 64);
      sifter.mirror = true;
      //setRotation(sifter, 0F, 0F, 1.570796F);
  }
  /*
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    longwall1.render(f5);
    shortwall2.render(f5);
    longwall2.render(f5);
    shortwall1.render(f5);
    top.render(f5);
    floor.render(f5);
    sifter.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  */
  public void renderAll()
  {
	    longwall1.render(0.0625F);
	    shortwall2.render(0.0625F);
	    longwall2.render(0.0625F);
	    shortwall1.render(0.0625F);
	    top.render(0.0625F);
	    floor.render(0.0625F);
	    sifter.render(0.0625F);
  }
  
 // modelSifter.sifter.offsetX = (float) (f1 * Math.cos(theta));
 // modelSifter.sifter.offsetZ = (float) (f1 * Math.sin(theta));

}
