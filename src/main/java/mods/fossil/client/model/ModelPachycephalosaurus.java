package mods.fossil.client.model;

import mods.fossil.entity.mob.EntityDinosaur;
import mods.fossil.entity.mob.EntityPachycephalosaurus;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelPachycephalosaurus extends ModelDinosaurs
{
    public boolean isAttacking = false;

    //fields
    ModelRenderer Body;
    ModelRenderer UpperBody;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer RUpperarm;
    ModelRenderer LUpperarm;
    ModelRenderer RForearm;
    ModelRenderer LForearm;
    ModelRenderer UpperJaw;
    ModelRenderer RUpperThigh;
    ModelRenderer LUpperThigh;
    ModelRenderer RCalf;
    ModelRenderer LCalf;
    ModelRenderer RFoot;
    ModelRenderer LFoot;
    ModelRenderer Tail;
    ModelRenderer Tail1;

    public ModelPachycephalosaurus()
    {
        textureWidth = 64;
        textureHeight = 32;
        setTextureOffset("Body.Body", 32, 6);
        setTextureOffset("UpperBody.UpperBody", 37, 8);
        setTextureOffset("LUpperarm.LUpperarm", 45, 0);
        setTextureOffset("LForearm.LForearm", 28, 6);
        setTextureOffset("Neck.Neck", 10, 23);
        setTextureOffset("Head.HornBumps", 25, 0);
        setTextureOffset("Head.Dome", 0, 0);
        setTextureOffset("UpperJaw.UpperJaw", 0, 15);
        setTextureOffset("RUpperarm.RUpperarm", 45, 0);
        setTextureOffset("RForearm.RForearm", 28, 6);
        setTextureOffset("LUpperThigh.LUpperThigh", 26, 22);
        setTextureOffset("LCalf.LCalf", 0, 23);
        setTextureOffset("LFoot.LFoot", 16, 15);
        setTextureOffset("RUpperThigh.RUpperThigh", 26, 22);
        setTextureOffset("RCalf.RCalf", 0, 23);
        setTextureOffset("RFoot.RFoot", 16, 15);
        setTextureOffset("Tail.Tail", 40, 21);
        setTextureOffset("Tail1.Tail1", 32, 6);
        Body = new ModelRenderer(this, "Body");
        Body.setRotationPoint(0F, 24F, -5F);
        setRotation(Body, 0F, 0F, 0F);
        Body.mirror = true;
        Body.addBox("Body", -4F, -14F, 0F, 8, 7, 8);
        UpperBody = new ModelRenderer(this, "UpperBody");
        UpperBody.setRotationPoint(0F, -14.2F, 1F);
        setRotation(UpperBody, -0.314F, 0F, 0F);
        UpperBody.mirror = true;
        UpperBody.addBox("UpperBody", -2.5F, 0F, -5F, 5, 6, 6);
        LUpperarm = new ModelRenderer(this, "LUpperarm");
        LUpperarm.setRotationPoint(2F, 3F, -4F);
        setRotation(LUpperarm, 0.314F, 0F, 0F);
        LUpperarm.mirror = true;
        LUpperarm.addBox("LUpperarm", 0F, 0F, -1F, 2, 4, 2);
        LForearm = new ModelRenderer(this, "LForearm");
        LForearm.setRotationPoint(1F, 3F, 0F);
        setRotation(LForearm, -0.314F, 0F, 0F);
        LForearm.mirror = true;
        LForearm.addBox("LForearm", -0.9F, 0F, 0F, 2, 3, 2);
        LUpperarm.addChild(LForearm);
        UpperBody.addChild(LUpperarm);
        Neck = new ModelRenderer(this, "Neck");
        Neck.setRotationPoint(0F, 0.4F, -4.5F);
        setRotation(Neck, -0.1F, 0F, 0F);
        Neck.mirror = true;
        Neck.addBox("Neck", -2F, 0F, -4F, 4, 4, 4);
        Head = new ModelRenderer(this, "Head");
        Head.setRotationPoint(0F, 0F, -2.5F);
        setRotation(Head, -0.614F, 0F, 0F);
        Head.mirror = true;
        Head.addBox("HornBumps", -4F, -2F, -4F, 8, 4, 2);
        Head.addBox("Dome", -3.5F, -1F, -6F, 7, 8, 7);
        UpperJaw = new ModelRenderer(this, "UpperJaw");
        UpperJaw.setRotationPoint(0F, 7F, -3F);
        setRotation(UpperJaw, 0.514F, 0F, 0F);
        UpperJaw.mirror = true;
        UpperJaw.addBox("UpperJaw", -2F, -2F, -0.5F, 4, 4, 4);
        Head.addChild(UpperJaw);
        Neck.addChild(Head);
        UpperBody.addChild(Neck);
        RUpperarm = new ModelRenderer(this, "RUpperarm");
        RUpperarm.setRotationPoint(-2F, 3F, -4F);
        setRotation(RUpperarm, 0.314F, 0F, 0F);
        RUpperarm.mirror = true;
        RUpperarm.addBox("RUpperarm", -2F, 0F, -1F, 2, 4, 2);
        RForearm = new ModelRenderer(this, "RForearm");
        RForearm.setRotationPoint(-1F, 3F, 0F);
        setRotation(RForearm, -0.314F, 0F, 0F);
        RForearm.mirror = true;
        RForearm.addBox("RForearm", -1.1F, 0F, 0F, 2, 3, 2);
        RUpperarm.addChild(RForearm);
        UpperBody.addChild(RUpperarm);
        Body.addChild(UpperBody);
        LUpperThigh = new ModelRenderer(this, "LUpperThigh");
        LUpperThigh.setRotationPoint(4F, -10.5F, 5.5F);
        setRotation(LUpperThigh, -0.2617994F, 0F, 0F);
        LUpperThigh.mirror = true;
        LUpperThigh.addBox("LUpperThigh", 0F, -0.5F, -2F, 3, 6, 4);
        LCalf = new ModelRenderer(this, "LCalf");
        LCalf.setRotationPoint(1F, 3.5F, 0.5F);
        setRotation(LCalf, -0.281F, 0F, 0F);
        LCalf.mirror = true;
        LCalf.addBox("LCalf", -0.7F, 0F, 0F, 2, 6, 3);
        LFoot = new ModelRenderer(this, "LFoot");
        LFoot.setRotationPoint(-0.5F, 5F, 2F);
        setRotation(LFoot, 0.281F, 0F, 0F);
        LFoot.mirror = true;
        LFoot.addBox("LFoot", -0.5F, 0F, -4F, 3, 2, 4);
        LCalf.addChild(LFoot);
        LUpperThigh.addChild(LCalf);
        Body.addChild(LUpperThigh);
        RUpperThigh = new ModelRenderer(this, "RUpperThigh");
        RUpperThigh.setRotationPoint(-4F, -10.5F, 5.5F);
        setRotation(RUpperThigh, -0.2617994F, 0F, 0F);
        RUpperThigh.mirror = true;
        RUpperThigh.addBox("RUpperThigh", -3F, -0.5F, -2F, 3, 6, 4);
        RCalf = new ModelRenderer(this, "RCalf");
        RCalf.setRotationPoint(-1F, 3.5F, 0F);
        setRotation(RCalf, -0.281F, 0F, 0F);
        RCalf.mirror = true;
        RCalf.addBox("RCalf", -1.25F, 0F, 0F, 2, 6, 3);
        RFoot = new ModelRenderer(this, "RFoot");
        RFoot.setRotationPoint(-0.5F, 5F, 2F);
        setRotation(RFoot, 0.281F, 0F, 0F);
        RFoot.mirror = true;
        RFoot.addBox("RFoot", -1.5F, 0F, -4F, 3, 2, 4);
        RCalf.addChild(RFoot);
        RUpperThigh.addChild(RCalf);
        Body.addChild(RUpperThigh);
        Tail = new ModelRenderer(this, "Tail");
        Tail.setRotationPoint(0F, -13.8F, 7F);
        setRotation(Tail, -0.2F, 0F, 0F);
        Tail.mirror = true;
        Tail.addBox("Tail", -3F, 0F, 0F, 6, 5, 6);
        Tail1 = new ModelRenderer(this, "Tail1");
        Tail1.setRotationPoint(0F, 1F, 6F);
        setRotation(Tail1, 0.1F, 0F, 0F);
        Tail1.mirror = true;
        Tail1.addBox("Tail1", -2F, 0F, -1F, 4, 3, 8);
        Tail.addChild(Tail1);
        Body.addChild(Tail);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, ((EntityDinosaur)entity).isModelized());
        Body.render(f5);
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
        if (!var7){
        this.Head.rotateAngleZ = var5 / (180F / (float)Math.PI);
        this.Head.rotateAngleY = var4 / (180F / (float)Math.PI);
        this.RUpperThigh.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.0F * var2;
        this.LUpperThigh.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.0F * var2;
        //Tail anim
        this.Tail.rotateAngleY = ((float) Math.pow(0.25F, 1)) * (MathHelper.cos(-0.6F * var1 + initialOffset));
        currentAngle = Tail.rotateAngleY;
        this.Tail1.rotateAngleY = ((float) Math.pow(0.25F, 1)) * (MathHelper.cos(-0.6F * var1 + 1F * offset + initialOffset)) - currentAngle;
        currentAngle = Tail.rotateAngleY + Tail1.rotateAngleY;
        }
        else {
            this.Head.rotateAngleZ = 0;
            this.Head.rotateAngleY = 0;
            this.RUpperThigh.rotateAngleX = 0;
            this.LUpperThigh.rotateAngleX = 0;
            //Tail anim
            this.Tail.rotateAngleY = 0;
            currentAngle = 0;
            this.Tail1.rotateAngleY = 0;
            currentAngle = 0;
        }
    }

    public void setLivingAnimations(EntityLivingBase par1EntityLiving, float par2, float par3, float par4)
    {
        EntityPachycephalosaurus entity = (EntityPachycephalosaurus)par1EntityLiving;
        int i = entity.getAttackTimer();

        if (i > 0)
        {
//          this.UpperBody.rotateAngleX = -0.614F + 1.4F * this.func_78172_a((float)i - par4, 10.0F);
//         this.Head.rotateAngleX = -0.614F + 1.4F * this.func_78172_a((float)i - par4, 10.0F);
            this.UpperBody.rotateAngleX = 0.0F;
            this.Head.rotateAngleX = 0.0F;
        }
        else
        {
            this.UpperBody.rotateAngleX = -0.314F;
            this.Head.rotateAngleX = -0.614F;
        }
    }

    private float func_78172_a(float par1, float par2)
    {
        return (Math.abs(par1 % par2 - par2 * 0.5F) - par2 * 0.25F) / (par2 * 0.25F);
    }
}
