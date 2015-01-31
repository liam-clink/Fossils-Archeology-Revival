package mods.fossil.client.model;

import mods.fossil.entity.mob.EntityDinosaur;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCompsognathus extends ModelDinosaurs
{
    //fields
	public ModelRenderer neck;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer leftLowerLeg;
    public ModelRenderer rightLowerLeg;
    public ModelRenderer rightUpperArm;
    public ModelRenderer leftUpperArm;
    public ModelRenderer leftUpperLeg;
    public ModelRenderer rightUpperLeg;
    public ModelRenderer tail1;

    public ModelCompsognathus()
    {
      textureWidth = 64;
      textureHeight = 32;
      setTextureOffset("body.body", 0, 18);
      setTextureOffset("leftUpperArm.leftUpperArm", 0, 0);
      setTextureOffset("leftUpperArm.leftUpperArmWing", 5, 11);
      setTextureOffset("leftUpperLeg.leftUpperLeg", 38, 8);
      setTextureOffset("leftLowerLeg.leftLowerLeg", 38, 0);
      setTextureOffset("neck.neck", 4, 4);
      setTextureOffset("head.crest", 9, 13);
      setTextureOffset("head.head", 14, 0);
      setTextureOffset("rightUpperLeg.rightUpperLeg", 38, 8);
      setTextureOffset("rightLowerLeg.rightLowerLeg", 38, 0);
      setTextureOffset("tail1.tail1", 26, 20);
      setTextureOffset("rightUpperArm.rightUpperArm", 0, 0);
      setTextureOffset("rightUpperArm.rightUpperArmWing", 5, 11);
      
      head = new ModelRenderer(this, "head");
      head.setRotationPoint(0F, 13.5F, -4.5F);
      setRotation(head, 0F, 0F, 0F);
      head.mirror = false;
        head.addBox("crest", 0F, -3.5F, 0.5F, 1, 2, 2);
        head.addBox("head", -1.5F, -3F, -5F, 3, 3, 6);
      body = new ModelRenderer(this, "body");
      body.setRotationPoint(0F, 18F, 0F);
      setRotation(body, 0F, 0F, 0F);
      body.mirror = true;
        body.addBox("body", -2F, -4F, -3F, 4, 5, 8);
      leftUpperArm = new ModelRenderer(this, "leftUpperArm");
      leftUpperArm.setRotationPoint(2F, -1.5F, -1.5F);
      setRotation(leftUpperArm, 0F, 0F, 0F);
      leftUpperArm.mirror = true;
        leftUpperArm.addBox("leftUpperArm", 0F, 0F, -0.5F, 1, 3, 1);
        leftUpperArm.addBox("leftUpperArmWing", 0F, 0F, 0.5F, 1, 4, 2);
        body.addChild(leftUpperArm);
      leftUpperLeg = new ModelRenderer(this, "leftUpperLeg");
      leftUpperLeg.setRotationPoint(2F, -3F, 4F);
      setRotation(leftUpperLeg, 0F, 0F, 0F);
      leftUpperLeg.mirror = true;
        leftUpperLeg.addBox("leftUpperLeg", 0F, 0F, -1F, 1, 4, 2);
      leftLowerLeg = new ModelRenderer(this, "leftLowerLeg");
      leftLowerLeg.setRotationPoint(0F, 4F, 0F);
      setRotation(leftLowerLeg, 0F, 0F, 0F);
      leftLowerLeg.mirror = true;
        leftLowerLeg.addBox("leftLowerLeg", -1F, 0F, -2.5F, 3, 5, 3);
        leftUpperLeg.addChild(leftLowerLeg);
        body.addChild(leftUpperLeg);
      neck = new ModelRenderer(this, "neck");
      neck.setRotationPoint(0F, -2.5F, -1.5F);
      setRotation(neck, 0F, 0F, 0F);
      neck.mirror = true;
        neck.addBox("neck", -1F, -4F, -1.5F, 2, 4, 3);
        body.addChild(neck);
      rightUpperLeg = new ModelRenderer(this, "rightUpperLeg");
      rightUpperLeg.setRotationPoint(-2F, -3F, 4F);
      setRotation(rightUpperLeg, 0F, 0F, 0F);
      rightUpperLeg.mirror = true;
        rightUpperLeg.addBox("rightUpperLeg", -1F, 0F, -1F, 1, 4, 2);
      rightLowerLeg = new ModelRenderer(this, "rightLowerLeg");
      rightLowerLeg.setRotationPoint(0F, 4F, 0F);
      setRotation(rightLowerLeg, 0F, 0F, 0F);
      rightLowerLeg.mirror = true;
        rightLowerLeg.addBox("rightLowerLeg", -2F, 0F, -2.5F, 3, 5, 3);
        rightUpperLeg.addChild(rightLowerLeg);
        body.addChild(rightUpperLeg);
      tail1 = new ModelRenderer(this, "tail1");
      tail1.setRotationPoint(0F, -4F, 5F);
      setRotation(tail1, 0F, 0F, 0F);
      tail1.mirror = true;
        tail1.addBox("tail1", -1F, 0F, 0F, 2, 2, 10);
        body.addChild(tail1);
      rightUpperArm = new ModelRenderer(this, "rightUpperArm");
      rightUpperArm.setRotationPoint(-2F, -1.5F, -1.5F);
      setRotation(rightUpperArm, 0F, 0F, 0F);
      rightUpperArm.mirror = true;
        rightUpperArm.addBox("rightUpperArm", -1F, 0F, -0.5F, 1, 3, 1);
        rightUpperArm.addBox("rightUpperArmWing", -1F, 0F, 0.5F, 1, 4, 2);
        body.addChild(rightUpperArm);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, ((EntityDinosaur)entity).isModelized());
        body.render(f5);
        head.render(f5);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7)
    {
    	
        this.leftUpperArm.rotateAngleX = (float)Math.toRadians(-10);
        this.rightUpperArm.rotateAngleX = (float)Math.toRadians(-10);
		this.neck.rotateAngleX = (float)Math.toRadians(45);
        this.tail1.rotateAngleX = (float)Math.toRadians(-5);

        
    	if(!var7){
	        this.head.rotateAngleX = var5 / (180F / (float)Math.PI);
	        this.head.rotateAngleY = var4 / (180F / (float)Math.PI);
	        this.rightUpperLeg.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
	        this.leftUpperLeg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
	        this.tail1.rotateAngleY =  0.05F * MathHelper.sin(var3 * (float)0.3F + var2);

    	}
    	else {
            this.head.rotateAngleX = 0;
            this.head.rotateAngleY = 0;
            this.rightUpperLeg.rotateAngleX = 0;
            this.leftUpperLeg.rotateAngleX = 0;
            this.tail1.rotateAngleY = 0;
            this.tail1.rotateAngleX = 0;
    	}
    }
}
