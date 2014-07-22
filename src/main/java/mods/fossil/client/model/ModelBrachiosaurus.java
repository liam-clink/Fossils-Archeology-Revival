package mods.fossil.client.model;

import mods.fossil.Fossil;
import mods.fossil.entity.mob.EntityDinosaur;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBrachiosaurus extends ModelDinosaurs
{
    float yoffset = 0.0F;
    ModelRenderer Snout = (new ModelRenderer(this, 50, 8)).setTextureSize(64, 32);
    ModelRenderer Head;
    ModelRenderer Crest;
    ModelRenderer Neck;
    ModelRenderer Neck1;
    ModelRenderer Neck2;
    ModelRenderer Neck3;
    ModelRenderer Neck4;
    ModelRenderer Neck5;
    ModelRenderer Neck6;
    ModelRenderer Neck7;
    ModelRenderer Lower_Neck;
    ModelRenderer Lower_Neck1;
    ModelRenderer Body;
    ModelRenderer Body2;
    ModelRenderer Lower_Body;
    ModelRenderer Front_ThighRight;
    ModelRenderer Front_ThighLeft;
    ModelRenderer Back_CalfRight;
    ModelRenderer Front_CalfRight;
    ModelRenderer Back_ThighLeft;
    ModelRenderer Back_ThighRight;
    ModelRenderer Front_CalfLeft;
    ModelRenderer Back_CalfLeft;
    ModelRenderer Tail;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Tail3;

    ModelRenderer dummy;

    public ModelBrachiosaurus()
    {
        // Head
        Head = (new ModelRenderer(this, 48, 14)).setTextureSize(64, 32);
        Head.addBox(-2.0F, -1.0F, -4.0F, 4, 3, 4);
        Head.setRotationPoint(0.0F, -6.0F, -10.5F);
        setRotation(Head, 0.0F, 0.0F, 0.0F);
        Head.mirror = true;
        Snout.addBox(-1.5F, -1.0F, -6.5F, 3, 2, 4);
        Snout.setRotationPoint(0.0F, -0.0F, -0.0F);
        setRotation(Snout, 0.2617994F, 0.0F, 0.0F);
        Snout.mirror = true;
        Crest = (new ModelRenderer(this, 52, 0)).setTextureSize(64, 32);
        Crest.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 4);
        Crest.setRotationPoint(0.0F, -3.0F, -5.0F);
        setRotation(Crest, 0.0F, 0.0F, 0.0F);
        Crest.mirror = true;
        Head.addChild(Crest);
        Head.addChild(Snout);
        Neck = (new ModelRenderer(this, 22, 0)).setTextureSize(64, 32);
        Neck.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 2);
        Neck.setRotationPoint(0.0F, -6.0F - yoffset, -10.5F);
        setRotation(Neck, -((float)Math.PI / 4F), 0.0F, 0.0F);
        Neck.mirror = true;
        Neck1 = (new ModelRenderer(this, 22, 0)).setTextureSize(64, 32);
        Neck1.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 2);
        Neck1.setRotationPoint(0.0F, -4.5F - yoffset, -9.0F);
        setRotation(Neck1, -0.9599311F, 0.0F, 0.0F);
        Neck1.mirror = true;
        Neck2 = (new ModelRenderer(this, 22, 0)).setTextureSize(64, 32);
        Neck2.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 2);
        Neck2.setRotationPoint(0.0F, -3.0F - yoffset, -8.0F);
        setRotation(Neck2, -1.23464F, 0.0F, 0.0F);
        Neck2.mirror = true;
        Neck3 = (new ModelRenderer(this, 22, 0)).setTextureSize(64, 32);
        Neck3.addBox(-1.5F, 0.0F, 2.0F, 3, 2, 2);
        Neck3.setRotationPoint(0.0F, -1.5F - yoffset, -7.5F);
        setRotation(Neck3, -1.343904F, 0.0F, 0.0F);
        Neck3.mirror = true;
        Neck4 = (new ModelRenderer(this, 22, 0)).setTextureSize(64, 32);
        Neck4.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 2);
        Neck4.setRotationPoint(0.0F, -1.5F - yoffset, -7.5F);
        setRotation(Neck4, -1.343904F, 0.0F, 0.0F);
        Neck4.mirror = true;
        Neck5 = (new ModelRenderer(this, 22, 0)).setTextureSize(64, 32);
        Neck5.addBox(-1.5F, 0.0F, 4.0F, 3, 2, 2);
        Neck5.setRotationPoint(0.0F, -1.5F - yoffset, -7.5F);
        setRotation(Neck5, -1.343904F, 0.0F, 0.0F);
        Neck5.mirror = true;
        Neck6 = (new ModelRenderer(this, 22, 0)).setTextureSize(64, 32);
        Neck6.addBox(-1.5F, 0.0F, 6.0F, 3, 2, 2);
        Neck6.setRotationPoint(0.0F, -1.5F - yoffset, -7.5F);
        setRotation(Neck6, -1.343904F, 0.0F, 0.0F);
        Neck6.mirror = true;
        Neck7 = (new ModelRenderer(this, 34, 11)).setTextureSize(64, 32);
        Neck7.addBox(-2.0F, -1.0F, -0.5F, 4, 3, 3);
        Neck7.setRotationPoint(0.0F, 6.0F - yoffset, -6.5F);
        setRotation(Neck7, -0.9637522F, 0.0F, 0.0F);
        Neck7.mirror = true;
        Lower_Neck = (new ModelRenderer(this, 32, 24)).setTextureSize(64, 32);
        Lower_Neck.addBox(-2.5F, -0.5F, -0.5F, 5, 4, 4);
        Lower_Neck.setRotationPoint(0.0F, 7.0F - yoffset, -5.0F);
        setRotation(Lower_Neck, -0.8377581F, 0.0F, 0.0F);
        Lower_Neck.mirror = true;
        //Body
        Lower_Neck1 = (new ModelRenderer(this, 10, 21)).setTextureSize(64, 32);
        Lower_Neck1.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 5);
        Lower_Neck1.setRotationPoint(0.0F, 3.0F, -0.0F);
        setRotation(Lower_Neck1, -0.5907885F, 0.0F, 0.0F);
        Lower_Neck1.mirror = true;
        Body = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 32);
        Body.addBox(-4.0F, 0.0F, 0.0F, 8, 8, 6);
        Body.setRotationPoint(0.0F, 9.0F, -3.0F);
        setRotation(Body, -0.0F, 0.0F, 0.0F);
        Body.mirror = true;
        Body2 = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 32);
        Body2.addBox(-4.0F, 0.0F, 0.0F, 8, 8, 2);
        Body2.setRotationPoint(0.0F, 0.0F, 6.0F);
        setRotation(Body2, -0.0F, 0.0F, 0.0F);
        Body2.mirror = true;
        Lower_Body = (new ModelRenderer(this, 28, 0)).setTextureSize(64, 32);
        Lower_Body.addBox(-3.5F, 0.0F, 3.0F, 7, 6, 5);
        Lower_Body.setRotationPoint(0.0F, 0.0F, 5.0F);
        setRotation(Lower_Body, -0.3346075F, 0.0F, 0.0F);
        Lower_Body.mirror = true;
        //Tail
        Tail = (new ModelRenderer(this, 0, 13)).setTextureSize(64, 32);
        Tail.addBox(-2.5F, 0.0F, 3.0F, 5, 4, 5);
        Tail.setRotationPoint(0.0F, 0.0F, 4.0F);
        setRotation(Tail, -0.2064018F, 0.0F, 0.0F);
        Tail.mirror = true;
        Tail1 = (new ModelRenderer(this, 18, 13)).setTextureSize(64, 32);
        Tail1.addBox(-2.0F, -1.0F, 4.0F, 4, 3, 6);
        Tail1.setRotationPoint(0.0F, 0.5F, 4.0F);
        setRotation(Tail1, -0.2576873F, 0.0F, 0.0F);
        Tail1.mirror = true;
        Tail2 = (new ModelRenderer(this, 34, 17)).setTextureSize(64, 32);
        Tail2.addBox(-1.5F, 1.5F, 5.0F, 3, 2, 3);
        Tail2.setRotationPoint(0.0F, 0.0F, 4F);
        setRotation(Tail2, 0.3717943F, 0.0F, 0.0F);
        Tail2.mirror = true;
        Tail3 = (new ModelRenderer(this, 34, 17)).setTextureSize(64, 32);
        Tail3.addBox(-1.5F, 2.F, 0.0F, 3, 1, 3);
        Tail3.setRotationPoint(0.0F, 0.5F, 6.0F);
        setRotation(Tail3, 0.3717943F, 0.0F, 0.0F);
        Tail3.mirror = true;
        Body.addChild(Lower_Body);
        Body.addChild(Body2);
        Body.addChild(Lower_Neck1);
        Lower_Body.addChild(Tail);
        Tail.addChild(Tail1);
        Tail1.addChild(Tail2);
        Tail2.addChild(Tail3);
        //Legs
        Front_ThighRight = (new ModelRenderer(this, 50, 21)).setTextureSize(64, 32);
        Front_ThighRight.addBox(0.0F, 0.0F, -2.0F, 3, 7, 4);
        Front_ThighRight.setRotationPoint(2.0F, 3.0F, -0.5F);
        setRotation(Front_ThighRight, 0.0F, 0.0F, 0.0F);
        Front_ThighRight.mirror = true;
        Front_CalfRight = (new ModelRenderer(this, 0, 24)).setTextureSize(64, 32);
        Front_CalfRight.addBox(1.5F, 7.0F, -0.5F, 2, 5, 3);
        Front_CalfRight.setRotationPoint(-1.0F, 0.0F, -1.0F);
        setRotation(Front_CalfRight, 0.0F, 0.0F, 0.0F);
        Front_CalfRight.mirror = true;
        Front_ThighRight.addChild(Front_CalfRight);
        Front_ThighLeft = (new ModelRenderer(this, 50, 21)).setTextureSize(64, 32);
        Front_ThighLeft.addBox(-3.0F, 0.0F, -2.0F, 3, 7, 4);
        Front_ThighLeft.setRotationPoint(-2.0F, 3.0F, -0.5F);
        setRotation(Front_ThighLeft, 0.0F, 0.0F, 0.0F);
        Front_ThighLeft.mirror = true;
        Front_CalfLeft = (new ModelRenderer(this, 0, 24)).setTextureSize(64, 32);
        Front_CalfLeft.addBox(-3.5F, 7.0F, -0.5F, 2, 5, 3);
        Front_CalfLeft.setRotationPoint(1.0F, 0.0F, -1.0F);
        setRotation(Front_CalfLeft, 0.0F, 0.0F, 0.0F);
        Front_CalfLeft.mirror = true;
        Front_ThighLeft.addChild(Front_CalfLeft);
        Back_ThighRight = (new ModelRenderer(this, 50, 21)).setTextureSize(64, 32);
        Back_ThighRight.addBox(-1.0F, 0.0F, -2.0F, 3, 5, 4);
        Back_ThighRight.setRotationPoint(3.0F, 5.0F, 9.5F);
        setRotation(Back_ThighRight, 0.0F, 0.0F, 0.0F);
        Back_ThighRight.mirror = true;
        Back_CalfRight = (new ModelRenderer(this, 0, 24)).setTextureSize(64, 32);
        Back_CalfRight.addBox(0.5F, 5.0F, -0.5F, 2, 5, 3);
        Back_CalfRight.setRotationPoint(-1.0F, 0.0F, -1.0F);
        setRotation(Back_CalfRight, 0.0F, 0.0F, 0.0F);
        Back_CalfRight.mirror = true;
        Back_ThighRight.addChild(Back_CalfRight);
        Back_ThighLeft = (new ModelRenderer(this, 50, 21)).setTextureSize(64, 32);
        Back_ThighLeft.addBox(-2.0F, 0.0F, -2.0F, 3, 5, 4);
        Back_ThighLeft.setRotationPoint(-3.0F, 5.0F, 9.5F);
        setRotation(Back_ThighLeft, 0.0F, 0.0F, 0.0F);
        Back_ThighLeft.mirror = true;
        Back_CalfLeft = (new ModelRenderer(this, 0, 24)).setTextureSize(64, 32);
        Back_CalfLeft.addBox(-0.5F, 5.0F, -0.5F, 2, 5, 3);
        Back_CalfLeft.setRotationPoint(-1.0F, 0.0F, -1.0F);
        setRotation(Back_CalfLeft, 0.0F, 0.0F, 0.0F);
        Back_CalfLeft.mirror = true;
        Back_ThighLeft.addChild(Back_CalfLeft);
        Body.addChild(Back_ThighLeft);
        Body.addChild(Back_ThighRight);
        Body.addChild(Front_ThighRight);
        Body.addChild(Front_ThighLeft);
        float legspeed = 0.5F;
        float legRotationLimit = 1.4F;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        float var14 = 0.0225F;
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaur)var1).isModelized());
        this.Head.render(var7);
        this.Neck.render(var7);
        this.Neck1.render(var7);
        this.Neck2.render(var7);
        this.Neck3.render(var7);
        this.Neck4.render(var7);
        this.Neck5.render(var7);
        this.Neck6.render(var7);
        this.Neck7.render(var7);
        this.Lower_Neck.render(var7);
        this.Body.render(var7);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean isModelized)
    {

    	if(!isModelized){
	        this.Head.rotateAngleX = var5 / (180F / (float)Math.PI);
	        this.Head.rotateAngleY = var4 / (180F / (float)Math.PI);
	        this.Front_ThighLeft.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 1.0F * var2;
	        this.Front_ThighRight.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float)Math.PI) * 1.0F * var2;
	        this.Back_ThighLeft.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float)Math.PI + 2) * 1.0F * var2;
	        this.Back_ThighRight.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 1.0F * var2;
	        this.Tail.rotateAngleY = 0.05F * MathHelper.sin(var3 * (float)0.1F + (var2+2));
	        this.Tail1.rotateAngleY = 0.06F * MathHelper.sin(var3 * (float)0.1F + (var2+1));
	        this.Tail2.rotateAngleY = 0.07F * MathHelper.sin(var3 * (float)0.1F + (var2));
    	}
    	else
    	{
            this.Head.rotateAngleX = 0;
            this.Head.rotateAngleY = 0;
            this.Front_ThighLeft.rotateAngleX = 0;
            this.Front_ThighRight.rotateAngleX = 0;
            this.Back_ThighLeft.rotateAngleX = 0;
            this.Back_ThighRight.rotateAngleX = 0;
            this.Tail.rotateAngleY =0;
            this.Tail1.rotateAngleY = 0;
            this.Tail2.rotateAngleY = 0;
    	}
    }
}
