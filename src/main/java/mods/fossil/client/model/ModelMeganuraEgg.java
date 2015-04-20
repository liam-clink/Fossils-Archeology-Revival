
package mods.fossil.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMeganuraEgg extends ModelBase
{
  //fields
    ModelRenderer inside;
    ModelRenderer outside;
    ModelRenderer left;
    ModelRenderer bottom;
    ModelRenderer top;
    ModelRenderer back;
    ModelRenderer front;
    ModelRenderer Right;
  
  public ModelMeganuraEgg()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      inside = new ModelRenderer(this, 0, 12);
      inside.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3);
      inside.setRotationPoint(0F, 20F, 0F);
      inside.setTextureSize(64, 32);
      inside.mirror = true;
      setRotation(inside, 0F, 0F, 0F);
      outside = new ModelRenderer(this, 0, 0);
      outside.addBox(-3F, -3F, -3F, 6, 6, 6);
      outside.setRotationPoint(0F, 20F, 0F);
      outside.setTextureSize(64, 32);
      outside.mirror = true;
      setRotation(outside, 0F, 0F, 0F);
      Right = new ModelRenderer(this, 24, 0);
      Right.addBox(-1F, -2F, -2F, 1, 4, 4);
      Right.setRotationPoint(-3F, 20F, 0F);
      Right.setTextureSize(64, 32);
      Right.mirror = true;
      setRotation(Right, 0F, 0F, 0F);
      bottom = new ModelRenderer(this, 0, 23);
      bottom.addBox(-2F, 0F, -2F, 4, 1, 4);
      bottom.setRotationPoint(0F, 23F, 0F);
      bottom.setTextureSize(64, 32);
      bottom.mirror = true;
      setRotation(bottom, 0F, 0F, 0F);
      top = new ModelRenderer(this, 0, 18);
      top.addBox(-2F, -1F, -2F, 4, 1, 4);
      top.setRotationPoint(0F, 17F, 0F);
      top.setTextureSize(64, 32);
      top.mirror = true;
      setRotation(top, 0F, 0F, 0F);
      back = new ModelRenderer(this, 34, 8);
      back.addBox(-2F, -2F, 0F, 4, 4, 1);
      back.setRotationPoint(0F, 20F, 3F);
      back.setTextureSize(64, 32);
      back.mirror = true;
      setRotation(back, 0F, 0F, 0F);
      front = new ModelRenderer(this, 24, 8);
      front.addBox(-2F, -2F, -1F, 4, 4, 1);
      front.setRotationPoint(0F, 20F, -3F);
      front.setTextureSize(64, 32);
      front.mirror = true;
      setRotation(front, 0F, 0F, 0F);
      left = new ModelRenderer(this, 34, 0);
      left.addBox(0F, -2F, -2F, 1, 4, 4);
      left.setRotationPoint(3F, 20F, 0F);
      left.setTextureSize(64, 32);
      left.mirror = true;
      setRotation(left, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    inside.render(f5);
    outside.render(f5);
    left.render(f5);
    bottom.render(f5);
    top.render(f5);
    back.render(f5);
    front.render(f5);
    left.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

}
