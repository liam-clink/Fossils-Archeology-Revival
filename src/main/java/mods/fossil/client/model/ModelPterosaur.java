package mods.fossil.client.model;

import org.lwjgl.opengl.GL11;

import mods.fossil.Fossil;
import mods.fossil.entity.mob.EntityDinosaur;
import mods.fossil.entity.mob.EntityPachycephalosaurus;
import mods.fossil.entity.mob.EntityPterosaur;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelPterosaur extends ModelDinosaurs {

    public ModelRenderer Body;
    public ModelRenderer Tail;
    public ModelRenderer RightLeg1;
    public ModelRenderer LeftLeg1;
    public ModelRenderer Neck1;
    public ModelRenderer Neck2;
    public ModelRenderer Head;
    public ModelRenderer LowerJaw;
    public ModelRenderer UpperJaw;
    public ModelRenderer Crest;
    public ModelRenderer RightWing1;
    public ModelRenderer RightWing2;
    public ModelRenderer LeftWing1;
    public ModelRenderer LeftWing2;
    public ModelRenderer LeftHand;
    public ModelRenderer RightHand;
    
	  public ModelPterosaur()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    setTextureOffset("RightLeg1.RightLeg1", 12, 19);
	    setTextureOffset("RightWing1.RightWing1", 34, 7);
	    setTextureOffset("RightWing2.RightWing2", 36, 14);
	    setTextureOffset("RightHand.RightHand", 58, 28);
	    setTextureOffset("Body.Body", 0, 0);
	    setTextureOffset("Neck1.Neck1", 0, 11);
	    setTextureOffset("Neck2.Neck2", 0, 17);
	    setTextureOffset("Head.Head", 0, 23);
	    setTextureOffset("Crest.Crest", 30, 21);
	    setTextureOffset("LowerJaw.LowerJaw", 38, 23);
	    setTextureOffset("UpperJaw.UpperJaw", 18, 23);
	    setTextureOffset("LeftWing1.LeftWing1", 34, 0);
	    setTextureOffset("LeftWing2.LeftWing2", 12, 14);
	    setTextureOffset("LeftHand.LeftHand", 58, 30);
	    setTextureOffset("Tail.Tail", 22, 0);
	    setTextureOffset("LeftLeg1.LeftLeg1", 20, 19);
	    
	    Body = new ModelRenderer(this, "Body");
	    Body.setRotationPoint(0F, 16.5F, 0F);
	    setRotation(Body, 0F, 0F, 0F);
	    Body.mirror = true;
	    RightLeg1 = new ModelRenderer(this, "RightLeg1");
	    RightLeg1.setRotationPoint(-1.0F, 1F, 7F);
	    setRotation(RightLeg1, 0F, 0F, 0F);
	    RightLeg1.mirror = true;
	      RightLeg1.addBox("RightLeg1", -0.5F, 0F, 0F, 1, 1, 3);
	      Body.addChild(RightLeg1);
	    RightWing1 = new ModelRenderer(this, "RightWing1");
	    RightWing1.setRotationPoint(-1F, 0F, 1F);
	    setRotation(RightWing1, 0F, 0F, 0F);
	    RightWing1.mirror = true;
	      RightWing1.addBox("RightWing1", -9F, -0.5F, 0F, 9, 1, 6);
	    RightWing2 = new ModelRenderer(this, "RightWing2");
	    RightWing2.setRotationPoint(-9F, 0F, 0F);
	    setRotation(RightWing2, 0F, 0F, 0F);
	    RightWing2.mirror = true;
	      RightWing2.addBox("RightWing2", -8F, -0.5F, 0F, 8, 1, 4);
	      RightWing1.addChild(RightWing2);
	    RightHand = new ModelRenderer(this, "RightHand");
	    RightHand.setRotationPoint(-8.5F, 0F, 0F);
	    setRotation(RightHand, 0F, 0F, 0F);
	    RightHand.mirror = true;
	      RightHand.addBox("RightHand", -0.5F, -0.5F, -1F, 1, 1, 1);
	      RightWing1.addChild(RightHand);
	      Body.addChild(RightWing1);
	      Body.addBox("Body", -2F, -2F, 0F, 4, 4, 7);
	    Neck1 = new ModelRenderer(this, "Neck1");
	    Neck1.setRotationPoint(0F, -2F, 0F);
	    setRotation(Neck1, 0F, 0F, 0F);
	    Neck1.mirror = true;
	      Neck1.addBox("Neck1", -1F, 0F, -4F, 2, 2, 4);
	    Neck2 = new ModelRenderer(this, "Neck2");
	    Neck2.setRotationPoint(0F, 0F, -4F);
	    setRotation(Neck2, 0F, 0F, 0F);
	    Neck2.mirror = true;
	      Neck2.addBox("Neck2", -1F, 0F, -4F, 2, 2, 4);
	    Head = new ModelRenderer(this, "Head");
	    Head.setRotationPoint(0F, 0.5F, -3F);
	    setRotation(Head, 0F, 0F, 0F);
	    Head.mirror = true;
	      Head.addBox("Head", -2F, -2F, -5F, 4, 4, 5);
	    Crest = new ModelRenderer(this, "Crest");
	    Crest.setRotationPoint(0F, 0F, -2F);
	    setRotation(Crest, 0F, 0F, 0F);
	    Crest.mirror = true;
	      Crest.addBox("Crest", -1F, -3F, -1F, 2, 4, 6);
	      Head.addChild(Crest);
	    LowerJaw = new ModelRenderer(this, "LowerJaw");
	    LowerJaw.setRotationPoint(0F, 0.5F, -5F);
	    setRotation(LowerJaw, 0F, 0F, 0F);
	    LowerJaw.mirror = true;
	      LowerJaw.addBox("LowerJaw", -1F, 0F, -8F, 2, 1, 8);
	      Head.addChild(LowerJaw);
	    UpperJaw = new ModelRenderer(this, "UpperJaw");
	    UpperJaw.setRotationPoint(0F, -0.5F, -5F);
	    setRotation(UpperJaw, 0F, 0F, 0F);
	    UpperJaw.mirror = true;
	      UpperJaw.addBox("UpperJaw", -1F, 0F, -8F, 2, 1, 8);
	      Head.addChild(UpperJaw);
	      Neck2.addChild(Head);
	      Neck1.addChild(Neck2);
	      Body.addChild(Neck1);
	    LeftWing1 = new ModelRenderer(this, "LeftWing1");
	    LeftWing1.setRotationPoint(1F, 0F, 1F);
	    setRotation(LeftWing1, 0F, 0F, 0F);
	    LeftWing1.mirror = true;
	      LeftWing1.addBox("LeftWing1", 0F, -0.5F, 0F, 9, 1, 6);
	    LeftWing2 = new ModelRenderer(this, "LeftWing2");
	    LeftWing2.setRotationPoint(9F, 0F, 0F);
	    setRotation(LeftWing2, 0F, 0F, 0F);
	    LeftWing2.mirror = true;
	      LeftWing2.addBox("LeftWing2", 0F, -0.5F, 0F, 8, 1, 4);
	      LeftWing1.addChild(LeftWing2);
	    LeftHand = new ModelRenderer(this, "LeftHand");
	    LeftHand.setRotationPoint(8.5F, 0F, 0F);
	    setRotation(LeftHand, 0F, 0F, 0F);
	    LeftHand.mirror = true;
	      LeftHand.addBox("LeftHand", -0.5F, -0.5F, -1F, 1, 1, 1);
	      LeftWing1.addChild(LeftHand);
	      Body.addChild(LeftWing1);
	    Tail = new ModelRenderer(this, "Tail");
	    Tail.setRotationPoint(0F, -1.5F, 7F);
	    setRotation(Tail, 0F, 0F, 0F);
	    Tail.mirror = true;
	      Tail.addBox("Tail", -2F, 0F, 0F, 4, 3, 2);
	      Body.addChild(Tail);
	    LeftLeg1 = new ModelRenderer(this, "LeftLeg1");
	    LeftLeg1.setRotationPoint(1.0F, 1F, 7F);
	    setRotation(LeftLeg1, 0F, 0F, 0F);
	    LeftLeg1.mirror = true;
	      LeftLeg1.addBox("LeftLeg1", -0.5F, 0F, 0F, 1, 1, 3);
	      Body.addChild(LeftLeg1);
	  }

	  
	    /**
	     * Sets the models various rotation angles then renders the model.
	     */
	    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
	    {
	        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaur)var1).isModelized());
	        this.Body.render(var7);
	    }
	    
	    private void setRotation(ModelRenderer model, float x, float y, float z)
	    {
	      model.rotateAngleX = x;
	      model.rotateAngleY = y;
	      model.rotateAngleZ = z;
	    }
	  
	    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean modelized)
	    {
	       // if (modelized)
	        //{
	        	// Ground pose
	        	this.Body.rotateAngleX =  -0.587636F;
	        	this.Neck1.rotateAngleX = 0.261799388F;
	        	this.Neck2.rotateAngleX = 0.261799388F;
	        	this.Crest.rotateAngleX = 0.785398163F;
	        	this.UpperJaw.rotateAngleX = 0.0872664626F;
	        	
	        	this.LeftLeg1.rotateAngleX = -1.15191731F;
	        	this.RightLeg1.rotateAngleX = -1.15191731F;
	        	
	        	this.LeftWing1.rotateAngleX = (-this.Body.rotateAngleX) + 0.523598776F;// + 0.925024504F);
	        	this.LeftWing1.rotateAngleZ = 1.08210414F;
	        	
	        	this.LeftWing2.rotateAngleX = -0.37079633F;
	        	this.LeftWing2.rotateAngleY = -1.37079633F;
	        	
	        	this.RightWing1.rotateAngleX = (-this.Body.rotateAngleX) + 0.523598776F;// + 0.925024504F);
	        	this.RightWing1.rotateAngleZ = -1.08210414F;
	        	
	        	this.RightWing2.rotateAngleX = -0.37079633F;
	        	this.RightWing2.rotateAngleY = 1.37079633F;
	        //}
	        	
	        	if(!modelized)
	        	{
	                this.Head.rotateAngleX = var5 / (180F / (float)Math.PI);
	                this.Head.rotateAngleY = var4 / (180F / (float)Math.PI);
	                this.LeftLeg1.rotateAngleX = -1.15191731F + MathHelper.cos((var1) * 0.63330555F + (float)Math.PI + 2) * 1.0F * var2;
	                this.RightLeg1.rotateAngleX = -1.15191731F + MathHelper.cos((var1) * 0.63330555F + 1) * 1.0F * var2;
	        	}
	        	else {
	                this.Head.rotateAngleX = 0;
	                this.Head.rotateAngleY = 0;
		        	this.LeftLeg1.rotateAngleX = -1.15191731F;
		        	this.RightLeg1.rotateAngleX = -1.15191731F;
	        	}
	    }
	    
	    public void setLivingAnimations(EntityLivingBase par1EntityLiving, float par2, float par3, float par4)
	    {
	        EntityPterosaur entity = (EntityPterosaur)par1EntityLiving;

	        if(entity.isAirBorne) {
	        	this.Body.rotateAngleX = 0;
	        	this.Neck1.rotateAngleX = 0;
	        	this.Neck2.rotateAngleX = 0;
	        	this.Crest.rotateAngleX = 0;
	        	this.UpperJaw.rotateAngleX = 0;
	        	
	        	this.LeftLeg1.rotateAngleX = 0;
	        	this.RightLeg1.rotateAngleX = 0;
	        	
	        	this.LeftWing1.rotateAngleX = 0;
	        	this.LeftWing1.rotateAngleZ = 0;
	        	
	        	this.LeftWing2.rotateAngleX = 0;
	        	this.LeftWing2.rotateAngleY = 0;
	        	
	        	this.RightWing1.rotateAngleX = 0;
	        	this.RightWing1.rotateAngleZ = 0;
	        	
	        	this.RightWing2.rotateAngleX = 0;
	        	this.RightWing2.rotateAngleY = 0;
	        }
	    }
}
