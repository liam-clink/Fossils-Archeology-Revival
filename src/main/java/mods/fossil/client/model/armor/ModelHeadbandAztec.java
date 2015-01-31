package mods.fossil.client.model.armor;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelHeadbandAztec extends ModelBiped
{
	  //fields
	ModelRenderer AztecFeather;
	ModelRenderer BandFront;
	ModelRenderer BandRight;
	ModelRenderer BandLeft;
	ModelRenderer BandBack;
	
    public final ResourceLocation texture;
	  
	  public ModelHeadbandAztec(float f)
	  {
		  super(f, 0, 64,32);

		  texture = new ResourceLocation("fossil:textures/armor/headband_master.png");
	        
		    //textureWidth = 64;
		   // textureHeight = 32;
		    
		    setTextureOffset("BandFront.BandFront", 18, 0);
		    setTextureOffset("BandBack.BandBack", 18, 0);
		    setTextureOffset("BandLeft.BandLeft", 18, 0);
		    setTextureOffset("BandRight.BandRight", 18, 0);
		    
		    setTextureOffset("AztecFeather.AztecFeather", 0, 7);
		    
		    BandFront = new ModelRenderer(this, "BandFront");
		    BandFront.setRotationPoint(0F, 0F, 0F);
		    setRotation(BandFront, 0F, 0F, 0F);
		    BandFront.mirror = false;
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
		      
		      AztecFeather = new ModelRenderer(this, "AztecFeather");
		      AztecFeather.setRotationPoint(0F, -7F, 4F);
		    setRotation(AztecFeather, 0F, 1.57079633F, 0F);
		    AztecFeather.mirror = true;
		    AztecFeather.addBox("AztecFeather", -0.5F, -10F, -1F, 1, 10, 2);

		      BandFront.addChild(AztecFeather);
		      
		      
		      this.bipedHead.addChild(BandFront);
		  }
		  
		  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
		  {
		    super.render(entity, f, f1, f2, f3, f4, f5);
			  this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		    
		    
		  }
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
}
