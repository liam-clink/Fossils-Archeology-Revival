package mods.fossil.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGastornis extends ModelBase
{
//fields
private ModelRenderer Body;
private ModelRenderer TailFeathers;
private ModelRenderer TailFeathers2;
private ModelRenderer UpperLegRight;
private ModelRenderer LowerLegRight;
private ModelRenderer UpperLegLeft;
private ModelRenderer LowerLegLeft;
private ModelRenderer WingLeft;
private ModelRenderer WingRight;
private ModelRenderer Neck;
private ModelRenderer Head;
private ModelRenderer HeadFeather1;
private ModelRenderer HeadFeather2;
private ModelRenderer LowerBeak;

public ModelGastornis()
{
 textureWidth = 128;
 textureHeight = 64;
 setTextureOffset("Body.Body", 0, 0);
 setTextureOffset("TailFeathers.TailFeathers", 64, 10);
 setTextureOffset("TailFeathers2.TailFeathers2", 84, 21);
 setTextureOffset("UpperLegRight.UpperLegRight", 44, 0);
 setTextureOffset("LowerLegRight.LowerLegRight", 44, 9);
 setTextureOffset("UpperLegLeft.UpperLegLeft", 44, 0);
 setTextureOffset("LowerLegLeft.LowerLegLeft", 44, 9);
 setTextureOffset("WingLeft.WingLeft", 104, 0);
 setTextureOffset("WingRight.WingRight", 104, 0);
 setTextureOffset("Neck.Neck", 88, 0);
 setTextureOffset("Head.Head", 0, 26);
 setTextureOffset("HeadFeather1.HeadFeather1", 66, 0);
 setTextureOffset("HeadFeather2.HeadFeather2", 62, 10);
 setTextureOffset("LowerBeak.LowerBeak", 48, 26);

 Body = new ModelRenderer(this, "Body");
 Body.setRotationPoint(-1F, 2F, 0F);
 setRotation(Body, 0F, 0F, 0F);
 Body.mirror = true;
   Body.addBox("Body", -5F, -7F, -4F, 12, 15, 10);
 TailFeathers = new ModelRenderer(this, "TailFeathers");
 TailFeathers.setRotationPoint(0F, 8F, 5F);
 setRotation(TailFeathers, 0F, 0F, 0F);
 TailFeathers.mirror = true;
   TailFeathers.addBox("TailFeathers", 0F, -1F, 1F, 4, 1, 10);
 TailFeathers2 = new ModelRenderer(this, "TailFeathers2");
 TailFeathers2.setRotationPoint(0F, 0F, 0F);
 setRotation(TailFeathers2, 0F, 0F, 0F);
 TailFeathers2.mirror = true;
   TailFeathers2.addBox("TailFeathers2", 0F, 0F, 1F, 3, 2, 4);
   TailFeathers.addChild(TailFeathers2);
   Body.addChild(TailFeathers);
 UpperLegRight = new ModelRenderer(this, "UpperLegRight");
 UpperLegRight.setRotationPoint(-2.9F, 4F, -3F);
 setRotation(UpperLegRight, 0F, 0F, 0F);
 UpperLegRight.mirror = true;
   UpperLegRight.addBox("UpperLegRight", -2F, 0F, -2F, 4, 9, 4);
 LowerLegRight = new ModelRenderer(this, "LowerLegRight");
 LowerLegRight.setRotationPoint(0F, 9F, 0F);
 setRotation(LowerLegRight, 0F, 0F, 0F);
 LowerLegRight.mirror = true;
   LowerLegRight.addBox("LowerLegRight", -2F, 0F, -2F, 4, 9, 4);
   UpperLegRight.addChild(LowerLegRight);
   Body.addChild(UpperLegRight);
 UpperLegLeft = new ModelRenderer(this, "UpperLegLeft");
 UpperLegLeft.setRotationPoint(4.9F, 4F, -3F);
 setRotation(UpperLegLeft, 0F, 0F, 0F);
 UpperLegLeft.mirror = true;
   UpperLegLeft.addBox("UpperLegLeft", -2F, 0F, -2F, 4, 9, 4);
 LowerLegLeft = new ModelRenderer(this, "LowerLegLeft");
 LowerLegLeft.setRotationPoint(0F, 9F, 0F);
 setRotation(LowerLegLeft, 0F, 0F, 0F);
 LowerLegLeft.mirror = true;
   LowerLegLeft.addBox("LowerLegLeft", -2F, 0F, -2F, 4, 9, 4);
   UpperLegLeft.addChild(LowerLegLeft);
   Body.addChild(UpperLegLeft);
 WingLeft = new ModelRenderer(this, "WingLeft");
 WingLeft.setRotationPoint(7F, -4F, 1F);
 setRotation(WingLeft, 0F, 0F, 0F);
 WingLeft.mirror = true;
   WingLeft.addBox("WingLeft", 0F, 0F, -2F, 1, 9, 5);
   Body.addChild(WingLeft);
 WingRight = new ModelRenderer(this, "WingRight");
 WingRight.setRotationPoint(-5F, -4F, 1F);
 setRotation(WingRight, 0F, 0F, 0F);
 WingRight.mirror = true;
   WingRight.addBox("WingRight", -1F, 0F, -2F, 1, 9, 5);
   Body.addChild(WingRight);
 Neck = new ModelRenderer(this, "Neck");
 Neck.setRotationPoint(1F, -6F, 4F);
 setRotation(Neck, 0F, 0F, 0F);
 Neck.mirror = true;
   Neck.addBox("Neck", -2F, -14F, -2F, 4, 14, 4);
 Head = new ModelRenderer(this, "Head");
 Head.setRotationPoint(0F, -13F, 0F);
 setRotation(Head, 0F, 0F, 0F);
 Head.mirror = true;
   Head.addBox("Head", -4F, -8F, -13F, 8, 8, 16);
 HeadFeather1 = new ModelRenderer(this, "HeadFeather1");
 HeadFeather1.setRotationPoint(0F, -7F, 2F);
 setRotation(HeadFeather1, 0F, 0F, 0F);
 HeadFeather1.mirror = true;
   HeadFeather1.addBox("HeadFeather1", -2F, -2F, 0F, 4, 6, 4);
   Head.addChild(HeadFeather1);
 HeadFeather2 = new ModelRenderer(this, "HeadFeather2");
 HeadFeather2.setRotationPoint(0F, -6F, 6F);
 setRotation(HeadFeather2, 0F, 0F, 0F);
 HeadFeather2.mirror = true;
   HeadFeather2.addBox("HeadFeather2", -1F, -5F, -1F, 2, 6, 4);
   Head.addChild(HeadFeather2);
 LowerBeak = new ModelRenderer(this, "LowerBeak");
 LowerBeak.setRotationPoint(0.5F, -2F, 2F);
 setRotation(LowerBeak, 0F, 0F, 0F);
 LowerBeak.mirror = true;
   LowerBeak.addBox("LowerBeak", -4F, 0.1F, -13.1F, 7, 2, 14);
   Head.addChild(LowerBeak);
   Neck.addChild(Head);
   Body.addChild(Neck);
}

public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
{
 super.render(entity, f, f1, f2, f3, f4, f5);
 setRotationAngles(f, f1, f2, f3, f4, f5);
 Body.render(f5);
}

private void setRotation(ModelRenderer model, float x, float y, float z)
{
 model.rotateAngleX = x;
 model.rotateAngleY = y;
 model.rotateAngleZ = z;
}

public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
{
	this.Body.rotateAngleX = (float)Math.toRadians(90.0);
}

}
