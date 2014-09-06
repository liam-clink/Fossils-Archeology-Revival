package mods.fossil.client.model;

import mods.fossil.entity.mob.EntityDinosaur;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelAllosaurus extends ModelDinosaurs
{
    ModelRenderer headpivot;
	private ModelRenderer head;
	private ModelRenderer lowerJaw;
	private ModelRenderer upperJaw;
	private ModelRenderer lowerBody;
	private ModelRenderer tail1;
	private ModelRenderer tail2;
	private ModelRenderer rightUpperLeg;
	private ModelRenderer rightLowerLeg;
	private ModelRenderer rightFoot;
	private ModelRenderer leftUpperLeg;
	private ModelRenderer leftLowerLeg;
	private ModelRenderer leftFoot;
	private ModelRenderer upperBody;
	private ModelRenderer leftUpperArm;
	private ModelRenderer leftLowerArm;
	private ModelRenderer neck;
	private ModelRenderer headdummy;
	private ModelRenderer rightUpperArm;
	private ModelRenderer rightLowerArm;
	private ModelRenderer leftCrest;
	private ModelRenderer rightCrest;
	private ModelRenderer teeth;
	private ModelRenderer allosaurus;
	private ModelRenderer tail3;

    public ModelAllosaurus()
    {
        textureWidth = 128;
        textureHeight = 64;
        setTextureOffset("head.head", 100, 6);
        setTextureOffset("rightCrest.rightCrest", 100, 0);
        setTextureOffset("leftCrest.leftCrest", 100, 0);
        setTextureOffset("lowerJaw.lowerJaw", 80, 17);
        setTextureOffset("upperJaw.upperJaw", 80, 0);
        setTextureOffset("teeth.teeth", 80, 10);
        setTextureOffset("rightUpperLeg.rightUpperLeg", 8, 26);
        setTextureOffset("rightLowerLeg.rightLowerLeg", 35, 26);
        setTextureOffset("rightFoot.rightFoot", 50, 23);
        setTextureOffset("leftUpperLeg.leftUpperLeg", 8, 26);
        setTextureOffset("leftLowerLeg.leftLowerLeg", 35, 26);
        setTextureOffset("leftFoot.leftFoot", 50, 23);
        setTextureOffset("lowerBody.lowerBody", 96, 41);
        setTextureOffset("tail1.tail1", 67, 46);
        setTextureOffset("tail2.tail2", 39, 42);
        setTextureOffset("tail3.tail3", 19, 48);
        setTextureOffset("upperBody.upperBody", 75, 28);
        setTextureOffset("neck.neck", 100, 18);
        setTextureOffset("leftUpperArm.leftUpperArm", 10, 9);
        setTextureOffset("rightLowerArm.rightLowerArm", 20, 8);
        setTextureOffset("rightUpperArm.rightUpperArm", 10, 9);
        setTextureOffset("leftLowerArm.leftLowerArm", 20, 8);
        
        headpivot = new ModelRenderer(this, "headpivot");
        headpivot.setRotationPoint(0F, 8F, -8F);
        setRotation(headpivot, 0F, 0F, 0F);
        headpivot.mirror = true;
        head = new ModelRenderer(this, "head");
        head.setRotationPoint(0F, 0F, 0F);
        setRotation(head, 0F, 0F, 0F);
        head.mirror = true;
          head.addBox("head", -2F, -3F, -4F, 4, 6, 4);
        rightCrest = new ModelRenderer(this, "rightCrest");
        rightCrest.setRotationPoint(-1.5F, -3F, -2F);
        setRotation(rightCrest, 0F, 0F, 0F);
        rightCrest.mirror = true;
          rightCrest.mirror = true;
          rightCrest.addBox("rightCrest", -0.5F, -1F, -1F, 1, 2, 2);
          rightCrest.mirror = false;
          head.addChild(rightCrest);
        leftCrest = new ModelRenderer(this, "leftCrest");
        leftCrest.setRotationPoint(1.5F, -3F, -2F);
        setRotation(leftCrest, 0F, 0F, 0F);
        leftCrest.mirror = true;
          leftCrest.addBox("leftCrest", -0.5F, -1F, -1F, 1, 2, 2);
          head.addChild(leftCrest);
        lowerJaw = new ModelRenderer(this, "lowerJaw");
        lowerJaw.setRotationPoint(0F, 2F, -3.8F);
        setRotation(lowerJaw, 0F, 0F, 0F);
        lowerJaw.mirror = true;
          lowerJaw.addBox("lowerJaw", -1F, -1F, -5F, 2, 2, 5);
          head.addChild(lowerJaw);
        upperJaw = new ModelRenderer(this, "upperJaw");
        upperJaw.setRotationPoint(0F, -2.8F, -4F);
        setRotation(upperJaw, 0F, 0F, 0F);
        upperJaw.mirror = true;
          upperJaw.addBox("upperJaw", -1.5F, 0F, -5F, 3, 4, 5);
        teeth = new ModelRenderer(this, "teeth");
        teeth.setRotationPoint(0F, 4.5F, 0F);
        setRotation(teeth, 0F, 0F, 0F);
        teeth.mirror = true;
          teeth.addBox("teeth", -1.5F, -0.5F, -5F, 3, 1, 5);
          upperJaw.addChild(teeth);
          head.addChild(upperJaw);
          headpivot.addChild(head);
        allosaurus = new ModelRenderer(this, "allosaurus");
        allosaurus.setRotationPoint(0F, 8.5F, 3F);
        setRotation(allosaurus, 0F, 0F, 0F);
        allosaurus.mirror = true;
        rightUpperLeg = new ModelRenderer(this, "rightUpperLeg");
        rightUpperLeg.setRotationPoint(-3F, 4F, 5.5F);
        setRotation(rightUpperLeg, 0F, 0F, 0F);
        rightUpperLeg.mirror = true;
          rightUpperLeg.addBox("rightUpperLeg", -3F, 0F, -2.5F, 3, 6, 5);
        rightLowerLeg = new ModelRenderer(this, "rightLowerLeg");
        rightLowerLeg.setRotationPoint(-1F, 4F, 2.5F);
        setRotation(rightLowerLeg, 0F, 0F, 0F);
        rightLowerLeg.mirror = true;
          rightLowerLeg.addBox("rightLowerLeg", -1F, 0F, -1F, 2, 7, 2);
        rightFoot = new ModelRenderer(this, "rightFoot");
        rightFoot.setRotationPoint(0F, 6F, 0F);
        setRotation(rightFoot, 0F, 0F, 0F);
        rightFoot.mirror = true;
          rightFoot.addBox("rightFoot", -1.5F, 0F, -3F, 3, 2, 4);
          rightLowerLeg.addChild(rightFoot);
          rightUpperLeg.addChild(rightLowerLeg);
          allosaurus.addChild(rightUpperLeg);
        leftUpperLeg = new ModelRenderer(this, "leftUpperLeg");
        leftUpperLeg.setRotationPoint(3F, 4F, 5.5F);
        setRotation(leftUpperLeg, 0F, 0F, 0F);
        leftUpperLeg.mirror = true;
          leftUpperLeg.mirror = true;
          leftUpperLeg.addBox("leftUpperLeg", 0F, 0F, -2.5F, 3, 6, 5);
          leftUpperLeg.mirror = false;
        leftLowerLeg = new ModelRenderer(this, "leftLowerLeg");
        leftLowerLeg.setRotationPoint(1F, 4F, 2.5F);
        setRotation(leftLowerLeg, 0F, 0F, 0F);
        leftLowerLeg.mirror = true;
          leftLowerLeg.mirror = true;
          leftLowerLeg.addBox("leftLowerLeg", -1F, 0F, -1F, 2, 7, 2);
          leftLowerLeg.mirror = false;
        leftFoot = new ModelRenderer(this, "leftFoot");
        leftFoot.setRotationPoint(0F, 6F, 0F);
        setRotation(leftFoot, 0F, 0F, 0F);
        leftFoot.mirror = true;
          leftFoot.mirror = true;
          leftFoot.addBox("leftFoot", -1.5F, 0F, -3F, 3, 2, 4);
          leftFoot.mirror = false;
          leftLowerLeg.addChild(leftFoot);
          leftUpperLeg.addChild(leftLowerLeg);
          allosaurus.addChild(leftUpperLeg);
        lowerBody = new ModelRenderer(this, "lowerBody");
        lowerBody.setRotationPoint(0F, 0F, 0F);
        setRotation(lowerBody, 0F, 0F, 0F);
        lowerBody.mirror = true;
          lowerBody.addBox("lowerBody", -3.5F, 0F, 0F, 7, 8, 7);
        tail1 = new ModelRenderer(this, "tail1");
        tail1.setRotationPoint(0F, 3.2F, 6F);
        setRotation(tail1, 0F, 0F, 0F);
        tail1.mirror = true;
          tail1.addBox("tail1", -2.5F, -3F, 0F, 5, 6, 6);
        tail2 = new ModelRenderer(this, "tail2");
        tail2.setRotationPoint(0F, -0.8F, 6F);
        setRotation(tail2, 0F, 0F, 0F);
        tail2.mirror = true;
          tail2.addBox("tail2", -1.5F, -2F, 0F, 3, 4, 9);
        tail3 = new ModelRenderer(this, "tail3");
        tail3.setRotationPoint(0F, -0.2F, 9F);
        setRotation(tail3, 0F, 0F, 0F);
        tail3.mirror = true;
          tail3.addBox("tail3", -1F, -1.5F, 0F, 2, 3, 10);
          tail2.addChild(tail3);
          tail1.addChild(tail2);
          lowerBody.addChild(tail1);
          allosaurus.addChild(lowerBody);
        upperBody = new ModelRenderer(this, "upperBody");
        upperBody.setRotationPoint(0F, 0.5F, 0F);
        setRotation(upperBody, 0F, 0F, 0F);
        upperBody.mirror = true;
          upperBody.addBox("upperBody", -2.5F, 0F, -7F, 5, 7, 7);
        neck = new ModelRenderer(this, "neck");
        neck.setRotationPoint(0F, 2.5F, -6F);
        setRotation(neck, 0F, 0F, 0F);
        neck.mirror = true;
          neck.addBox("neck", -1.5F, -2.5F, -8F, 3, 5, 8);
        headdummy = new ModelRenderer(this, "headdummy");
        headdummy.setRotationPoint(0F, 0F, -7F);
        setRotation(headdummy, 0F, 0F, 0F);
        headdummy.mirror = true;
          neck.addChild(headdummy);
          upperBody.addChild(neck);
        leftUpperArm = new ModelRenderer(this, "leftUpperArm");
        leftUpperArm.setRotationPoint(2.5F, 2.5F, -5.5F);
        setRotation(leftUpperArm, 0F, 0F, 0F);
        leftUpperArm.mirror = true;
          leftUpperArm.mirror = true;
          leftUpperArm.addBox("leftUpperArm", 0F, 0F, -1F, 2, 4, 2);
          leftUpperArm.mirror = false;
        rightLowerArm = new ModelRenderer(this, "rightLowerArm");
        rightLowerArm.setRotationPoint(1F, 2.5F, 1F);
        setRotation(rightLowerArm, 0F, 0F, 0F);
        rightLowerArm.mirror = false;
          rightLowerArm.addBox("rightLowerArm", -1.1F, 0F, 0F, 2, 5, 2);
          leftUpperArm.addChild(rightLowerArm);
          upperBody.addChild(leftUpperArm);
        rightUpperArm = new ModelRenderer(this, "rightUpperArm");
        rightUpperArm.setRotationPoint(-2.5F, 2.5F, -5.5F);
        setRotation(rightUpperArm, 0F, 0F, 0F);
        rightUpperArm.mirror = true;
          rightUpperArm.addBox("rightUpperArm", -2F, 0F, -1F, 2, 4, 2);
        leftLowerArm = new ModelRenderer(this, "leftLowerArm");
        leftLowerArm.setRotationPoint(-1F, 2.5F, 1F);
        setRotation(leftLowerArm, 0F, 0F, 0F);
        leftLowerArm.mirror = true;
          leftLowerArm.addBox("leftLowerArm", -0.9F, 0F, 0F, 2, 5, 2);
          rightUpperArm.addChild(leftLowerArm);
          upperBody.addChild(rightUpperArm);
          allosaurus.addChild(upperBody);
      }

    @Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, ((EntityDinosaur)entity).isModelized());
        allosaurus.render(f5);
        headpivot.render(f5);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    @Override
	protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean modelized)
    {
    	
        this.leftUpperArm.rotateAngleX = (float)Math.toRadians(-10);
        this.rightUpperArm.rotateAngleX = (float)Math.toRadians(-10);
        this.leftLowerArm.rotateAngleX = (float)Math.toRadians(-40);
        this.rightLowerArm.rotateAngleX = (float)Math.toRadians(-40);
		this.neck.rotateAngleX = (float)Math.toRadians(-32);
        this.tail2.rotateAngleX = (float)Math.toRadians(1);
        this.lowerBody.rotateAngleX = (float)Math.toRadians(-2);
        this.upperBody.rotateAngleX = (float)Math.toRadians(3);
        
        this.lowerJaw.rotateAngleX = (float)Math.toRadians(-5);
        
        this.leftCrest.rotateAngleX = (float)Math.toRadians(-40);
        this.leftCrest.rotateAngleZ = (float)Math.toRadians(18);
        this.rightCrest.rotateAngleX = (float)Math.toRadians(-40);
        this.rightCrest.rotateAngleZ = (float)Math.toRadians(-18);
        
        this.leftLowerLeg.rotateAngleX = (float)Math.toRadians(-18);
        this.rightLowerLeg.rotateAngleX = (float)Math.toRadians(-18);
        
        this.leftFoot.rotateAngleX = (float)Math.toRadians(18);
        this.rightFoot.rotateAngleX = (float)Math.toRadians(18);

        
    	if(!modelized){
	        this.head.rotateAngleX = (float)Math.toRadians(5) + var5 / (180F / (float)Math.PI);
	        this.head.rotateAngleY = var4 / (180F / (float)Math.PI);
	        this.rightUpperLeg.rotateAngleX = MathHelper.cos(var1 * 0.5662F + (float)Math.PI) * 1.0F * var2;
	        this.leftUpperLeg.rotateAngleX = MathHelper.cos(var1 * 0.5662F) * 1.0F * var2;
	        this.tail1.rotateAngleY = 0.08F * MathHelper.sin(var3 * (float)0.1F + (var2 + 2));
		    this.tail2.rotateAngleY = 0.10F * MathHelper.sin(var3  * (float)0.1F + var2+1);
		    this.tail3.rotateAngleY = 0.15F * MathHelper.sin(var3  * (float)0.1F + var2);

	        

    	}
    	else {
            this.head.rotateAngleX = 0;
            this.head.rotateAngleY = 0;
            this.rightUpperLeg.rotateAngleX = 0;
            this.leftUpperLeg.rotateAngleX = 0;
            this.tail1.rotateAngleY = 0;
            this.tail2.rotateAngleY = 0;
            this.tail3.rotateAngleY = 0;
    	}
    }
}
