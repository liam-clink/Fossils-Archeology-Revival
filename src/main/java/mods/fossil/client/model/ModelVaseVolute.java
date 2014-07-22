package mods.fossil.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelVaseVolute extends ModelBase
{
  //fields
    ModelRenderer stand;
    ModelRenderer body;
    ModelRenderer lefthandle;
    ModelRenderer righthandle;
    ModelRenderer backLip;
    ModelRenderer frontLip;
    ModelRenderer leftLip;
    ModelRenderer rightLip;
  
  public ModelVaseVolute()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      stand = new ModelRenderer(this, 0, 0);
      stand.addBox(-3F, 0F, -3F, 6, 1, 6);
      stand.setRotationPoint(0F, 23F, 0F);
      stand.setTextureSize(64, 32);
      stand.mirror = true;
      setRotation(stand, 0F, 0F, 0F);
      body = new ModelRenderer(this, 0, 13);
      body.addBox(-4F, -9F, -4F, 8, 9, 8);
      body.setRotationPoint(0F, 23F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      lefthandle = new ModelRenderer(this, 35, 0);
      lefthandle.addBox(-2F, -8F, 0F, 4, 9, 1);
      lefthandle.setRotationPoint(0F, 18F, 4F);
      lefthandle.setTextureSize(64, 32);
      lefthandle.mirror = true;
      setRotation(lefthandle, 0F, 0F, 0F);
      righthandle = new ModelRenderer(this, 35, 0);
      righthandle.addBox(-2F, -8F, -1F, 4, 9, 1);
      righthandle.setRotationPoint(0F, 18F, -4F);
      righthandle.setTextureSize(64, 32);
      righthandle.mirror = true;
      setRotation(righthandle, 0F, 0F, 0F);
      backLip = new ModelRenderer(this, 44, 14);
      backLip.addBox(-1F, 0F, 0F, 2, 1, 8);
      backLip.setRotationPoint(3F, 13F, -4F);
      backLip.setTextureSize(64, 32);
      backLip.mirror = true;
      setRotation(backLip, 0F, 0F, 0F);
      frontLip = new ModelRenderer(this, 44, 14);
      frontLip.addBox(-1F, 0F, 0F, 2, 1, 8);
      frontLip.setRotationPoint(-3F, 13F, -4F);
      frontLip.setTextureSize(64, 32);
      frontLip.mirror = true;
      setRotation(frontLip, 0F, 0F, 0F);
      leftLip = new ModelRenderer(this, 52, 0);
      leftLip.addBox(-2F, 0F, 0F, 4, 1, 2);
      leftLip.setRotationPoint(0F, 13F, 2F);
      leftLip.setTextureSize(64, 32);
      leftLip.mirror = true;
      setRotation(leftLip, 0F, 0F, 0F);
      rightLip = new ModelRenderer(this, 52, 0);
      rightLip.addBox(-2F, 0F, -2F, 4, 1, 2);
      rightLip.setRotationPoint(0F, 13F, -2F);
      rightLip.setTextureSize(64, 32);
      rightLip.mirror = true;
      setRotation(rightLip, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    stand.render(f5);
    body.render(f5);
    lefthandle.render(f5);
    righthandle.render(f5);
    backLip.render(f5);
    frontLip.render(f5);
    leftLip.render(f5);
    rightLip.render(f5);
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

}
