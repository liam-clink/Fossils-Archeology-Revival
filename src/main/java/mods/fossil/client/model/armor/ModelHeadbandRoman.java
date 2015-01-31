package mods.fossil.client.model.armor;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHeadbandRoman extends ModelBiped
{
	  //fields
	ModelRenderer LeftFeather1;
	ModelRenderer LeftFeather2;
	ModelRenderer LeftFeather3;
	ModelRenderer RightFeather1;
	ModelRenderer RightFeather2;
	ModelRenderer RightFeather3;
	ModelRenderer BandFront;
	ModelRenderer BandRight;
	ModelRenderer BandLeft;
	ModelRenderer BandBack;
	  
	  public ModelHeadbandRoman()
	  {
		    textureWidth = 64;
		    textureHeight = 32;
		    
		    setTextureOffset("BandFront.BandFront", 0, 0);
		    setTextureOffset("BandBack.BandBack", 0, 0);
		    setTextureOffset("BandLeft.BandLeft", 0, 0);
		    setTextureOffset("BandRight.BandRight", 0, 0);
		    
		    setTextureOffset("LeftFeather1.LeftFeather1", 0, -2);
		    setTextureOffset("RightFeather1.RightFeather1", 0, -2);
		    
		    setTextureOffset("LeftFeather2.LeftFeather2", 0, 1);
		    setTextureOffset("RightFeather2.RightFeather2", 0, 1);
		    
		    setTextureOffset("LeftFeather3.LeftFeather3", 0, 2);
		    setTextureOffset("RightFeather3.RightFeather3", 0, 2);
		    
		    BandFront = new ModelRenderer(this, "BandFront");
		    BandFront.setRotationPoint(0F, 0F, 0F);
		    setRotation(BandFront, 0F, 0F, 0F);
		    BandFront.mirror = true;
		      BandFront.addBox("BandFront", -4.5F, -7F, -4.5F, 9, 1, 0);
		    BandBack = new ModelRenderer(this, "BandBack");
		    BandBack.setRotationPoint(0F, 0F, 0F);
		    setRotation(BandBack, 0F, 3.14159265F, 0F);
		    BandBack.mirror = true;
		      BandBack.addBox("BandBack", -4.5F, -7F, -4.5F, 9, 1, 0);
		      BandFront.addChild(BandBack);
		    BandRight = new ModelRenderer(this, "BandRight");
		    BandRight.setRotationPoint(0F, 0F, 0F);
		    setRotation(BandRight, 0F, 1.57079633F, 0F);
		    BandRight.mirror = true;
		      BandRight.addBox("BandRight", -4.5F, -7F, -4.5F, 9, 1, 0);
		      BandFront.addChild(BandRight);
		    BandLeft = new ModelRenderer(this, "BandLeft");
		    BandLeft.setRotationPoint(0F, 0F, 0F);
		    setRotation(BandLeft, 0F, -1.57079633F, 0F);
		    BandLeft.mirror = true;
		      BandLeft.addBox("BandLeft", -4.5F, -7F, -4.5F, 9, 1, 0);
		      BandFront.addChild(BandLeft);
		    LeftFeather1 = new ModelRenderer(this, "LeftFeather1");
		    LeftFeather1.setRotationPoint(4F, -7F, -2F);
		    setRotation(LeftFeather1, 0.780755588F, 0.261799388F, 0F);
		    //LeftFeather1.mirror = true;
		      LeftFeather1.addBox("LeftFeather1", 0F, -2F, -1F, 0, 3, 3);
		    LeftFeather2 = new ModelRenderer(this, "LeftFeather2");
		    LeftFeather2.setRotationPoint(0F, -0.5F, 1.5F);
		    setRotation(LeftFeather2, -0.242810206F, 0F, 0F);
		    //LeftFeather2.mirror = true;
		      LeftFeather2.addBox("LeftFeather2", 0F, -1.5F, 0F, 0, 2, 3);
		    LeftFeather3 = new ModelRenderer(this, "LeftFeather3");
		    LeftFeather3.setRotationPoint(0F, -1F, 2.5F);
		    setRotation(LeftFeather3, -0.31487485F, 0F, 0F);
		    //LeftFeather3.mirror = true;
		      LeftFeather3.addBox("LeftFeather3", 0F, -0.5F, 0F, 0, 1, 4);
		      LeftFeather2.addChild(LeftFeather3);
		      LeftFeather1.addChild(LeftFeather2);
		      BandFront.addChild(LeftFeather1);
		    RightFeather1 = new ModelRenderer(this, "RightFeather1");
		    RightFeather1.setRotationPoint(-4F, -7F, -2F);
		    setRotation(RightFeather1, 0.780755588F, -0.261799388F, 0F);
		    //RightFeather1.mirror = true;
		      RightFeather1.addBox("RightFeather1", 0F, -2F, -1F, 0, 3, 3);
		    RightFeather2 = new ModelRenderer(this, "RightFeather2");
		    RightFeather2.setRotationPoint(0F, -0.5F, 1.5F);
		    setRotation(RightFeather2, -0.242810206F, 0F, 0F);
		    //RightFeather2.mirror = true;
		      RightFeather2.addBox("RightFeather2", 0F, -1.5F, 0F, 0, 2, 3);
		    RightFeather3 = new ModelRenderer(this, "RightFeather3");
		    RightFeather3.setRotationPoint(0F, -1F, 2.5F);
		    setRotation(RightFeather3, -0.31487485F, 0F, 0F);
		    //RightFeather3.mirror = true;
		      RightFeather3.addBox("RightFeather3", 0F, -0.5F, 0F, 0, 1, 4);
		      RightFeather2.addChild(RightFeather3);
		      RightFeather1.addChild(RightFeather2);
		      BandFront.addChild(RightFeather1);
		      this.bipedHead.addChild(BandFront);
		  }
		  
		  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
		  {
		    super.render(entity, f, f1, f2, f3, f4, f5);
		    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		  }
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
}
