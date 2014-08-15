package mods.fossil.client.model;

import mods.fossil.entity.mob.EntityDinosaur;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSpinosaurus extends ModelDinosaurs
{
    //fields
    ModelRenderer Upper_Jaw;
    ModelRenderer Lower_Jaw;
    ModelRenderer Head;
    ModelRenderer Teeth;
    ModelRenderer Neck;
    ModelRenderer Crest;
    ModelRenderer Upper_Body;
    ModelRenderer Lower_Body;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer Thigh1;
    ModelRenderer Thigh2;
    ModelRenderer Calf1;
    ModelRenderer Calf2;
    ModelRenderer Foot1;
    ModelRenderer Foot2;
    ModelRenderer UpperArm1;
    ModelRenderer UpperArm2;
    ModelRenderer LowerArm1;
    ModelRenderer LowerArm2;
    ModelRenderer Sail1;
    ModelRenderer Sail2;
    ModelRenderer Sail3;
    ModelRenderer Sail4;
    ModelRenderer Sail5;
    ModelRenderer Sail6;
    ModelRenderer Sail7;

    public ModelSpinosaurus()
    {
        textureWidth = 64;
        textureHeight = 64;
        float yoffset = 6.5F;
////////////////////////////////////////////////////

        Upper_Jaw = new ModelRenderer(this, 0, 10);
        Upper_Jaw.addBox(-2F, 0F, -7F, 4, 3, 7);
        Upper_Jaw.setRotationPoint(0F, -1.5F, -5F);
        Upper_Jaw.setTextureSize(64, 64);
        Upper_Jaw.mirror = true;
        setRotation(Upper_Jaw, 0F, 0F, 0F);

        Lower_Jaw = new ModelRenderer(this, 0, 20);
        Lower_Jaw.addBox(-1.5F, 0F, -6F, 3, 1, 6);
        Lower_Jaw.setRotationPoint(0F, 1.5F, -5F);
        Lower_Jaw.setTextureSize(64, 64);
        Lower_Jaw.mirror = true;
        setRotation(Lower_Jaw, 0F, 0F, 0F);

        Head = new ModelRenderer(this, 0, 0);
        Head.addBox(-2.5F, -2.5F, -5F, 5, 5, 5);
        Head.setRotationPoint(0F, 8F, -6F);
        Head.setTextureSize(64, 64);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);

        Teeth = new ModelRenderer(this, 15, 0);
        Teeth.addBox(0F, 0F, 0F, 4, 1, 4);
        Teeth.setRotationPoint(-2.0F, 3F, -7F);
        Teeth.setTextureSize(64, 64);
        Teeth.mirror = true;
        setRotation(Teeth, 0F, 0F, 0F);

        Crest = new ModelRenderer(this, 0, 10);
        Crest.addBox(0F, 0F, 0F, 1, 1, 2);
        Crest.setRotationPoint(-0.5F, -2.5F, -7F);
        Crest.setTextureSize(64, 64);
        Crest.mirror = true;
        setRotation(Crest, 0F, 0F, 0F);
        Head.addChild(Upper_Jaw);
        Head.addChild(Lower_Jaw);
        Head.addChild(Crest);
        Upper_Jaw.addChild(Teeth);
////////////////////////////////////////////////////////////////
        Neck = new ModelRenderer(this, 22, 30);
        Neck.addBox(0.5F, 0F, -5F, 4, 4, 6);
        Neck.setRotationPoint(0F, 1F, 0F);
        Neck.setTextureSize(64, 64);
        Neck.mirror = true;
        setRotation(Neck, 0, 0F, 0F);
        Upper_Body = new ModelRenderer(this, 0, 27);
        Upper_Body.addBox(0F, 0F, 0F, 5, 6, 6);
        Upper_Body.setRotationPoint(-2.5F, (1.5F + yoffset), -2F);
        Upper_Body.setTextureSize(64, 64);
        Upper_Body.mirror = true;
        setRotation(Upper_Body, -0.5235988F, 0F, 0F);
        Upper_Body.addChild(Neck);
//        Neck.addChild(Head);
        Lower_Body = new ModelRenderer(this, 0, 46);
        Lower_Body.addBox(0F, 0F, 0F, 7, 8, 10);
        Lower_Body.setRotationPoint(-3.5F, (2.5F + yoffset), 0F);
        Lower_Body.setTextureSize(64, 64);
        Lower_Body.mirror = true;
        setRotation(Lower_Body, 0F, 0F, 0F);
        Sail1 = new ModelRenderer(this, 34, 52);
        Sail1.addBox(0F, 0F, 0F, 1, 10, 2);
        Sail1.setRotationPoint(3F, -7.0F, -2.0F);
        Sail1.setTextureSize(64, 64);
        Sail1.mirror = true;
        setRotation(Sail1, 0F, 0F, 0F);
        Sail2 = new ModelRenderer(this, 40, 52);
        Sail2.addBox(0F, 0F, 0F, 1, 10, 2);
        Sail2.setRotationPoint(0F, -1.0F, 2F);
        Sail2.setTextureSize(64, 64);
        Sail2.mirror = true;
        setRotation(Sail2, 0F, 0F, 0F);
        Sail3 = new ModelRenderer(this, 46, 52);
        Sail3.addBox(0F, 0F, 0F, 1, 10, 2);
        Sail3.setRotationPoint(0F, -2.0F, 4F);
        Sail3.setTextureSize(64, 64);
        Sail3.mirror = true;
        setRotation(Sail3, 0F, 0F, 0F);
        Sail4 = new ModelRenderer(this, 46, 52);
        Sail4.addBox(0F, 0F, 0F, 1, 10, 2);
        Sail4.setRotationPoint(0F, -3.0F, 6F);
        Sail4.setTextureSize(64, 64);
        Sail4.mirror = true;
        setRotation(Sail4, 0F, 0F, 0F);
        Sail5 = new ModelRenderer(this, 46, 52);
        Sail5.addBox(0F, 0F, 0F, 1, 10, 2);
        Sail5.setRotationPoint(0F, -3.0F, 8F);
        Sail5.setTextureSize(64, 64);
        Sail5.mirror = true;
        setRotation(Sail5, 0F, 0F, 0F);
        Sail6 = new ModelRenderer(this, 40, 52);
        Sail6.addBox(0F, 0F, 0F, 1, 10, 2);
        Sail6.setRotationPoint(0F, -2.0F, 10F);
        Sail6.setTextureSize(64, 64);
        Sail6.mirror = true;
        setRotation(Sail6, 0F, 0F, 0F);
        Sail7 = new ModelRenderer(this, 52, 52);
        Sail7.addBox(0F, 0F, 0F, 1, 10, 2);
        Sail7.setRotationPoint(0F, -1.0F, 12F);
        Sail7.setTextureSize(64, 64);
        Sail7.mirror = true;
        setRotation(Sail7, 0F, 0F, 0F);
        Lower_Body.addChild(Sail1);
        Sail1.addChild(Sail2);
        Sail1.addChild(Sail3);
        Sail1.addChild(Sail4);
        Sail1.addChild(Sail5);
        Sail1.addChild(Sail6);
        Sail1.addChild(Sail7);
        ////////////////////////////////////////////////////
        Tail1 = new ModelRenderer(this, 40, 0);
        Tail1.addBox(0F, 0F, 0F, 4, 5, 8);
        Tail1.setRotationPoint(1F, 2F, 9F);
        Tail1.setTextureSize(64, 64);
        Tail1.mirror = true;
        setRotation(Tail1, 0F, 0F, 0F);
        Tail2 = new ModelRenderer(this, 42, 13);
        Tail2.addBox(0F, 0F, -1F, 3, 3, 8);
        Tail2.setRotationPoint(0.5F, 0.5F, 8F);
        Tail2.setTextureSize(64, 64);
        Tail2.mirror = true;
        setRotation(Tail2, 0F, 0F, 0F);
        Tail3 = new ModelRenderer(this, 50, 24);
        Tail3.addBox(0F, 0F, -1F, 2, 2, 5);
        Tail3.setRotationPoint(0.5F, 0.5F, 7F);
        Tail3.setTextureSize(64, 64);
        Tail3.mirror = true;
        setRotation(Tail3, 0F, 0F, 0F);
        Lower_Body.addChild(Tail1);
        Tail1.addChild(Tail2);
        Tail2.addChild(Tail3);
/////////////////
        setTextureOffset("Calf1.Calf1piece", 30, 2);
        setTextureOffset("Foot1.Foot1piece", 16, 21);
        Thigh1 = new ModelRenderer(this, 22, 11);
        Thigh1.addBox(0F, 0F, 0F, 3, 6, 4);
        Thigh1.setRotationPoint(2.5F, (5F + yoffset), 4F);
        Thigh1.setTextureSize(64, 64);
        Thigh1.mirror = true;
        setRotation(Thigh1, -0.2617994F, 0F, 0F);
        Calf1 = new ModelRenderer(this, "Calf1");
        Calf1.setRotationPoint(-0.1F, 5F, 1.1F);
//      setRotation(Calf1, -0.2617994F, 0F, 0F);
        Calf1.addBox("Calf1piece", 0F, 0F, 0F, 2, 6, 3);
        Foot1 = new ModelRenderer(this, "Foot1");
        Foot1.addBox("Foot1piece", 0F, 0F, 0F, 3, 2, 7);
        Foot1.setRotationPoint(0F, 6F, -4F);
        Foot1.setTextureSize(64, 64);
        Foot1.mirror = true;
        setRotation(Foot1, 0F, 0F, 0F);
        Thigh1.addChild(Calf1);
        Calf1.addChild(Foot1);
//////////////////////
        setTextureOffset("Calf2.Calf2piece", 30, 2);
        setTextureOffset("Foot2.Foot2piece", 16, 21);
        Thigh2 = new ModelRenderer(this, 22, 11);
        Thigh2.addBox(0F, 0F, 0F, 3, 6, 4);
        Thigh2.setRotationPoint(-5.0F, (5F + yoffset), 4F);
        Thigh2.setTextureSize(64, 64);
        Thigh2.mirror = true;
        setRotation(Thigh2, -0.2617994F, 0F, 0F);
        Calf2 = new ModelRenderer(this, "Calf2");
        Calf2.addBox("Calf2piece", 0F, 0F, 0F, 2, 6, 3);
        Calf2.setRotationPoint(0.1F, 5F, 1.1F);
        Calf2.setTextureSize(64, 64);
        Calf2.mirror = true;
//      setRotation(Calf2, -0.2617994F, 0F, 0F);
        Foot2 = new ModelRenderer(this, "Foot2");
        Foot2.addBox("Foot2piece", 0F, 0F, 0F, 3, 2, 7);
        Foot2.setRotationPoint(-1F, 6F, -4F);
        Foot2.setTextureSize(64, 64);
        Foot2.mirror = true;
        setRotation(Foot2, 0F, 0F, 0F);
        Thigh2.addChild(Calf2);
        Calf2.addChild(Foot2);
////////////////////////////////
        UpperArm1 = new ModelRenderer(this, 40, 24);
        UpperArm1.addBox(0F, 0F, 0F, 2, 4, 3);
        UpperArm1.setRotationPoint(4.5F, 3F, 1F);
        UpperArm1.setTextureSize(64, 64);
        UpperArm1.mirror = true;
        setRotation(UpperArm1, 0.5235988F, 0F, 0F);
        UpperArm2 = new ModelRenderer(this, 40, 24);
        UpperArm2.addBox(0F, 0F, 0F, 2, 4, 3);
        UpperArm2.setRotationPoint(-1.5F, 3F, 1F);
        UpperArm2.setTextureSize(64, 64);
        UpperArm2.mirror = true;
        setRotation(UpperArm2, 0.5235988F, 0F, 0F);
        LowerArm1 = new ModelRenderer(this, 42, 13);
        LowerArm1.addBox(0F, 0F, 0F, 2, 4, 2);
        LowerArm1.setRotationPoint(0F, 3F, 1F);
        LowerArm1.setTextureSize(64, 64);
        LowerArm1.mirror = true;
        setRotation(LowerArm1, -0.5235988F, 0F, 0F);
        LowerArm2 = new ModelRenderer(this, 42, 13);
        LowerArm2.addBox(0F, 0F, 0F, 2, 4, 2);
        LowerArm2.setRotationPoint(0F, 3F, 1F);
        LowerArm2.setTextureSize(64, 64);
        LowerArm2.mirror = true;
        setRotation(LowerArm2, -0.5235988F, 0F, 0F);
        Upper_Body.addChild(UpperArm1);
        Upper_Body.addChild(UpperArm2);
        UpperArm1.addChild(LowerArm1);
        UpperArm2.addChild(LowerArm2);
    }

    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaur)var1).isModelized());

        Head.render(var7);
        Upper_Body.render(var7);
        Lower_Body.render(var7);
        Thigh1.render(var7);
        Thigh2.render(var7);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean modelized)
    {
        if (!modelized)
        {
            this.Head.rotateAngleX =  var5 / (180F / (float)Math.PI);
            this.Head.rotateAngleY = var4 / (180F / (float)Math.PI);
            this.Head.rotationPointY = 8F;
            this.Head.rotationPointZ = -6F;
            this.Lower_Jaw.rotateAngleX = 0;
        	
        	this.Upper_Body.rotateAngleX = -0.5235988F;
        	this.Upper_Body.rotationPointY = 8F;
        	this.Upper_Body.rotationPointZ = -2F;
        	this.Neck.rotateAngleX = 0;
        	this.Lower_Jaw.rotateAngleX = 0;
        	
            this.Thigh1.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.0F * var2;
            this.Thigh2.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.0F * var2;
            this.Calf2.rotateAngleX = 0;
            this.Calf1.rotateAngleX = 0;
            this.Foot1.rotateAngleX = 0;
            
            this.Tail1.rotateAngleY = 0.1F * MathHelper.sin(var3 * (float)0.1F + (var2 + 2));
            this.Tail2.rotateAngleY = 0.2F * MathHelper.sin(var3  * (float)0.1F +( var2+1));
            this.Tail3.rotateAngleY = 0.25F * MathHelper.sin(var3  * (float)0.1F + var2);
            this.Tail2.rotateAngleX = (float)Math.toRadians(10);
            this.Tail3.rotateAngleX = (float)Math.toRadians(-15);
        }
        else {
        	this.modelizedPose();
        }
    }
    
    //////////// Add poses below ///////////////
    
    public void modelizedPose()
    {
        this.Head.rotateAngleX =  0;
        this.Head.rotateAngleY = 0;
        this.Head.rotationPointY = 13;
        this.Head.rotationPointZ = -9F;
        this.Lower_Jaw.rotateAngleX = (float)Math.toRadians(30);
    	
    	this.Upper_Body.rotateAngleX = (float)Math.toRadians(10);
    	this.Upper_Body.rotationPointY = 10F;
    	this.Upper_Body.rotationPointZ = -5F;
    	this.Neck.rotateAngleX = -this.Upper_Body.rotateAngleX;
    	this.Lower_Jaw.rotateAngleX = (float)Math.toRadians(30);
    			
        this.Thigh1.rotateAngleX = 0;
        this.Thigh2.rotateAngleX = 0;
        this.Tail1.rotateAngleY = (float)Math.toRadians(10);
        this.Tail2.rotateAngleY = (float)Math.toRadians(15);
        this.Tail3.rotateAngleY = (float)Math.toRadians(10);
        this.Tail1.rotateAngleX = (float)Math.toRadians(-10);
        this.Tail2.rotateAngleX = (float)Math.toRadians(10);
        this.Tail3.rotateAngleX = (float)Math.toRadians(-15);
        
        this.Thigh1.rotateAngleX = (float)Math.toRadians(20);
        this.Calf1.rotateAngleX = (float)Math.toRadians(30);
        this.Foot1.rotateAngleX = (float)Math.toRadians(0);
        
        this.Thigh2.rotateAngleX = (float)Math.toRadians(-20);
        this.Calf2.rotateAngleX = (float)Math.toRadians(20);
    }
}