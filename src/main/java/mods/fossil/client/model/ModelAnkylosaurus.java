package mods.fossil.client.model;

import mods.fossil.entity.mob.EntityAnkylosaurus;
import mods.fossil.entity.mob.EntityDinosaur;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelAnkylosaurus extends ModelDinosaurs
{
    //fields
    ModelRenderer Head;
    ModelRenderer Mouth;
    ModelRenderer Head_Block;
    ModelRenderer HeadHorn1;
    ModelRenderer HeadHorn2;
    ModelRenderer HeadHorn3;
    ModelRenderer HeadHorn4;
    ModelRenderer Body;
    ModelRenderer BodySpikes;
    ModelRenderer Neck;
    ModelRenderer Tail1;
    ModelRenderer Tail3;
    ModelRenderer Tail2;
    ModelRenderer Front_ThighLeft;
    ModelRenderer Front_ThighRight;
    ModelRenderer Back_ThighLeft;
    ModelRenderer Back_ThighRight;
    ModelRenderer Front_LowerLegRight;
    ModelRenderer Front_LowerLegLeft;
    ModelRenderer Back_LowerLegRight;
    ModelRenderer Back_LowerLegLeft;

    public ModelRenderer Tail[];

    public ModelAnkylosaurus()
    {
        textureWidth = 128;
        textureHeight = 64;
        Head = new ModelRenderer(this, 0, 0);
        Head.addBox(-4F, 0F, -8F, 8, 7, 8);
        Head.setRotationPoint(0F, 10.5F, -8F);
        Head.setTextureSize(128, 64);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Head_Block = new ModelRenderer(this, 24, 0);
        Head_Block.addBox(-3.0F, -0.9F, -4.9F, 6, 2, 5);
        Head_Block.setRotationPoint(0F, 10.5F, -8F);
        Head_Block.setTextureSize(128, 64);
        Head_Block.mirror = true;
        setRotation(Head_Block, 0.1745329F, 0F, 0F);
        Mouth = new ModelRenderer(this, 0, 15);
        Mouth.addBox(-2F, -2F, -11F, 4, 6, 4);
        Mouth.setRotationPoint(0F, 10.5F, -8F);
        Mouth.setTextureSize(128, 64);
        Mouth.mirror = true;
        setRotation(Mouth, 0.4363323F, 0F, 0F);
        HeadHorn1 = new ModelRenderer(this, 32, 7);
        HeadHorn1.addBox(3F, -0.9F, -2.9F, 3, 3, 3);
        HeadHorn1.setRotationPoint(0F, 10.5F, -8F);
        HeadHorn1.setTextureSize(128, 64);
        HeadHorn1.mirror = true;
        setRotation(HeadHorn1, 0.1745329F, 0F, 0F);
        HeadHorn2 = new ModelRenderer(this, 44, 7);
        HeadHorn2.addBox(-6F, -0.9F, -2.9F, 3, 3, 3);
        HeadHorn2.setRotationPoint(0F, 10.5F, -8F);
        HeadHorn2.setTextureSize(128, 64);
        HeadHorn2.mirror = true;
        setRotation(HeadHorn2, 0.1745329F, 0F, 0F);
        HeadHorn3 = new ModelRenderer(this, 32, 7);
        HeadHorn3.addBox(3F, 3.5F, -3F, 3, 3, 3);
        HeadHorn3.setRotationPoint(0F, 10.5F, -8F);
        HeadHorn3.setTextureSize(128, 64);
        HeadHorn3.mirror = true;
        setRotation(HeadHorn3, 0F, 0F, 0.1745329F);
        HeadHorn4 = new ModelRenderer(this, 44, 7);
        HeadHorn4.addBox(-6F, 3.5F, -3F, 3, 3, 3);
        HeadHorn4.setRotationPoint(0F, 10.5F, -8F);
        HeadHorn4.setTextureSize(128, 64);
        HeadHorn4.mirror = true;
        setRotation(HeadHorn4, 0F, 0F, -0.1745329F);
        Body = new ModelRenderer(this, 68, 0);
        Body.addBox(0F, 3F, 0F, 14, 10, 16);
        Body.setRotationPoint(-7F, 6F, -7F);
        Body.setTextureSize(128, 64);
        Body.mirror = true;
        setRotation(Body, 0F, 0F, 0F);
        BodySpikes = new ModelRenderer(this, 56, 26);
        BodySpikes.addBox(0F, 3F, 0F, 18, 2, 18);
        BodySpikes.setRotationPoint(-9F, 10F, -8F);
        BodySpikes.setTextureSize(128, 64);
        BodySpikes.mirror = true;
        setRotation(BodySpikes, 0F, 0F, 0F);
        Neck = new ModelRenderer(this, 46, 0);
        Neck.addBox(0F, -9F, -2.5F, 4, 5, 2);
        Neck.setRotationPoint(-2F, 8F, -8F);
        Neck.setTextureSize(128, 64);
        Neck.mirror = true;
        setRotation(Neck, 3F, 0F, 0F);
        Tail1 = new ModelRenderer(this, 104, 46);
        Tail1.addBox(-3F, 3F, 0F, 6, 6, 6);
        Tail1.setRotationPoint(0F, 7F, 8F);
        Tail1.setTextureSize(128, 64);
        Tail1.mirror = true;
        setRotation(Tail1, -0.2617994F, 0F, 0F);
        Tail3 = new ModelRenderer(this, 80, 46);
        Tail3.addBox(-3F, -3F, 0F, 6, 6, 6);
        Tail3.setRotationPoint(0F, 2F, 7F);
        Tail3.setTextureSize(128, 64);
        Tail3.mirror = true;
        setRotation(Tail3, 0F, 0F, 0F);
        Tail2 = new ModelRenderer(this, 56, 46);
        Tail2.addBox(-2F, 0F, 0F, 4, 4, 8);
        Tail2.setRotationPoint(0F, 4F, 5F);
        Tail2.setTextureSize(128, 64);
        Tail2.mirror = true;
        setRotation(Tail2, 0F, 0F, 0F);
        Tail1.addChild(Tail2);
        Tail2.addChild(Tail3);
        Front_ThighRight = new ModelRenderer(this, 18, 24);
        Front_ThighRight.addBox(0F, 3F, -2F, 4, 4, 4);
        Front_ThighRight.setRotationPoint(-9F, 14F, -4F);
        Front_ThighRight.setTextureSize(128, 64);
        Front_ThighRight.mirror = true;
        setRotation(Front_ThighRight, 0F, 0F, 0F);
        Front_ThighLeft = new ModelRenderer(this, 18, 24);
        Front_ThighLeft.addBox(0F, 3F, -2F, 4, 4, 4);
        Front_ThighLeft.setRotationPoint(5F, 14F, -4F);
        Front_ThighLeft.setTextureSize(128, 64);
        Front_ThighLeft.mirror = true;
        setRotation(Front_ThighLeft, 0F, 0F, 0F);
        Back_ThighRight = new ModelRenderer(this, 0, 25);
        Back_ThighRight.addBox(0F, 3F, -2F, 4, 5, 5);
        Back_ThighRight.setRotationPoint(-9F, 13F, 5F);
        Back_ThighRight.setTextureSize(128, 64);
        Back_ThighRight.mirror = true;
        setRotation(Back_ThighRight, 0F, 0F, 0F);
        Back_ThighLeft = new ModelRenderer(this, 0, 25);
        Back_ThighLeft.addBox(0F, 3F, -2F, 4, 5, 5);
        Back_ThighLeft.setRotationPoint(5F, 13F, 5F);
        Back_ThighLeft.setTextureSize(128, 64);
        Back_ThighLeft.mirror = true;
        setRotation(Back_ThighLeft, 0F, 0F, 0F);
        Front_LowerLegRight = new ModelRenderer(this, 0, 35);
        Front_LowerLegRight.addBox(0F, 6F, -1F, 3, 4, 4);
        Front_LowerLegRight.setRotationPoint(0F, 0F, 0F);
        Front_LowerLegRight.setTextureSize(128, 64);
        Front_LowerLegRight.mirror = true;
        setRotation(Front_LowerLegRight, 0F, 0F, 0F);
        Front_LowerLegLeft = new ModelRenderer(this, 0, 35);
        Front_LowerLegLeft.addBox(0F, 6F, -1F, 3, 4, 4);
        Front_LowerLegLeft.setRotationPoint(0F, 0F, 0F);
        Front_LowerLegLeft.setTextureSize(128, 64);
        Front_LowerLegLeft.mirror = true;
        setRotation(Front_LowerLegLeft, 0F, 0F, 0F);
        Back_LowerLegRight = new ModelRenderer(this, 0, 35);
        Back_LowerLegRight.addBox(0F, 7F, 0F, 3, 4, 4);
        Back_LowerLegRight.setRotationPoint(0F, 0F, 0F);
        Back_LowerLegRight.setTextureSize(128, 64);
        Back_LowerLegRight.mirror = true;
        setRotation(Back_LowerLegRight, 0F, 0F, 0F);
        Back_LowerLegLeft = new ModelRenderer(this, 0, 35);
        Back_LowerLegLeft.addBox(0F, 7F, 0F, 3, 4, 4);
        Back_LowerLegLeft.setRotationPoint(0F, 0F, 0F);
        Back_LowerLegLeft.setTextureSize(128, 64);
        Back_LowerLegLeft.mirror = true;
        setRotation(Back_LowerLegLeft, 0F, 0F, 0F);
        Front_ThighRight.addChild(Front_LowerLegRight);
        Front_ThighLeft.addChild(Front_LowerLegLeft);
        Back_ThighRight.addChild(Back_LowerLegRight);
        Back_ThighLeft.addChild(Back_LowerLegLeft);
    }

    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaur)var1).isModelized());
        Head.render(var7);
        Mouth.render(var7);
        Head_Block.render(var7);
        HeadHorn1.render(var7);
        HeadHorn2.render(var7);
        HeadHorn3.render(var7);
        HeadHorn4.render(var7);
        Body.render(var7);
        BodySpikes.render(var7);
        Neck.render(var7);
        Tail1.render(var7);
        Front_ThighRight.render(var7);
        Front_ThighLeft.render(var7);
        Back_ThighRight.render(var7);
        Back_ThighLeft.render(var7);
        /*
        Front_LowerLegRight.render(var7);
        Front_LowerLegLeft.render(var7);
        Back_LowerLegRight.render(var7);
        Back_LowerLegLeft.render(var7);
        */
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7)
    {

        float PI = (float) Math.PI;
        float initialOffset = PI / 2;
        float offset = PI * 2 / 11;
        float currentAngle = 0;
        
    	if(!var7){
        //make sure to re-add initial parts offset rotation at the end.
        this.Head.rotateAngleX = var5 / 2 / (180F / (float)Math.PI);
        this.Head.rotateAngleY = var4 / 2 / (180F / (float)Math.PI);
        this.Mouth.rotateAngleX = var5 / 2 / (180F / (float)Math.PI) + 0.4363323F;
        this.HeadHorn1.rotateAngleX = var5 / 2 / (180F / (float)Math.PI) + 0.1745329F;
        this.HeadHorn2.rotateAngleX = var5 / 2 / (180F / (float)Math.PI) + 0.1745329F;
        this.HeadHorn3.rotateAngleX = var5 / 2 / (180F / (float)Math.PI);
        this.HeadHorn4.rotateAngleX = var5 / 2 / (180F / (float)Math.PI);
        this.Head_Block.rotateAngleX = var5 / 2 / (180F / (float)Math.PI) + 0.1745329F;
        this.Mouth.rotateAngleY = var4 / 2 / (180F / (float)Math.PI);
        this.HeadHorn1.rotateAngleY = var4 / 2 / (180F / (float)Math.PI);
        this.HeadHorn2.rotateAngleY = var4 / 2 / (180F / (float)Math.PI);
        this.HeadHorn3.rotateAngleY = var4 / 2 / (180F / (float)Math.PI);
        this.HeadHorn4.rotateAngleY = var4 / 2 / (180F / (float)Math.PI);
        this.Head_Block.rotateAngleY = var4 / 2 / (180F / (float)Math.PI);
        this.Front_ThighLeft.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 1.0F * var2;
        this.Front_ThighRight.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float)Math.PI) * 1.0F * var2;
        this.Back_ThighLeft.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float)Math.PI + 2) * 1.0F * var2;
        this.Back_ThighRight.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 1.0F * var2;
        this.Tail1.rotateAngleY = 0.15F * MathHelper.sin(var3 * (float)0.1F + (var2+2));
        this.Tail2.rotateAngleY = 0.25F * MathHelper.sin(var3 * (float)0.1F + (var2+1));
        this.Tail3.rotateAngleY = 0.15F * MathHelper.sin(var3 * (float)0.1F + var2);
    	}
    	else {
            this.Head.rotateAngleX = 0;
            this.Head.rotateAngleY = 0;
            this.Mouth.rotateAngleX = 0.4363323F;
            this.HeadHorn1.rotateAngleX = 0.1745329F;
            this.HeadHorn2.rotateAngleX = 0.1745329F;
            this.HeadHorn3.rotateAngleX = 0;
            this.HeadHorn4.rotateAngleX = 0;
            this.Head_Block.rotateAngleX = 0.1745329F;
            this.Mouth.rotateAngleY = 0;
            this.HeadHorn1.rotateAngleY = 0;
            this.HeadHorn2.rotateAngleY = 0;
            this.HeadHorn3.rotateAngleY = 0;
            this.HeadHorn4.rotateAngleY = 0;
            this.Head_Block.rotateAngleY = 0;
            this.Front_ThighLeft.rotateAngleX = 0;
            this.Front_ThighRight.rotateAngleX = 0;
            this.Back_ThighLeft.rotateAngleX = 0;
            this.Back_ThighRight.rotateAngleX = 0;
            this.Tail1.rotateAngleY = 0;
            this.Tail2.rotateAngleY = 0;
            this.Tail3.rotateAngleY = 0;
    	}
    }
}