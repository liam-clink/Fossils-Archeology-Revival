package com.github.revival.client.model.prehistoric;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.common.entity.mob.EntityDinosaur;
import com.github.revival.common.entity.mob.EntityPachycephalosaurus;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

public class ModelPachycephalosaurus extends ModelPrehistoric
{
    public boolean isAttacking = false;

    //fields
    MowzieModelRenderer Body;
    MowzieModelRenderer UpperBody;
    MowzieModelRenderer Neck;
    MowzieModelRenderer Head;
    MowzieModelRenderer RUpperarm;
    MowzieModelRenderer LUpperarm;
    MowzieModelRenderer RForearm;
    MowzieModelRenderer LForearm;
    MowzieModelRenderer UpperJaw;
    MowzieModelRenderer RUpperThigh;
    MowzieModelRenderer LUpperThigh;
    MowzieModelRenderer RCalf;
    MowzieModelRenderer LCalf;
    MowzieModelRenderer RFoot;
    MowzieModelRenderer LFoot;
    MowzieModelRenderer Tail;
    MowzieModelRenderer Tail1;

    private MowzieModelRenderer headpivot;

    private MowzieModelRenderer headdummy;

    public ModelPachycephalosaurus()
    {
        textureWidth = 64;
        textureHeight = 32;
        setTextureOffset("headdummy.headdummy", 32, 6);
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
        Body = new MowzieModelRenderer(this, "Body");
        Body.setRotationPoint(0F, 24F, -5F);
        setRotateAngle(Body, 0F, 0F, 0F);
        Body.mirror = true;
        Body.addBox("Body", -4F, -15F, 0F, 8, 7, 8);
        UpperBody = new MowzieModelRenderer(this, "UpperBody");
        UpperBody.setRotationPoint(0F, -14.2F, 1F);
        setRotateAngle(UpperBody, 0F, 0F, 0F);
        UpperBody.mirror = true;
        UpperBody.addBox("UpperBody", -2.5F, 0F, -5F, 5, 6, 6);
        LUpperarm = new MowzieModelRenderer(this, "LUpperarm");
        LUpperarm.setRotationPoint(2F, 3F, -4F);
        setRotateAngle(LUpperarm, 0.314F, 0F, 0F);
        LUpperarm.mirror = true;
        LUpperarm.addBox("LUpperarm", 0F, 0F, -1F, 2, 4, 2);
        LForearm = new MowzieModelRenderer(this, "LForearm");
        LForearm.setRotationPoint(1F, 3F, 0F);
        setRotateAngle(LForearm, -0.314F, 0F, 0F);
        LForearm.mirror = true;
        LForearm.addBox("LForearm", -0.9F, 0F, 0F, 2, 3, 2);
        LUpperarm.addChild(LForearm);
        UpperBody.addChild(LUpperarm);
        Neck = new MowzieModelRenderer(this, "Neck");
        Neck.setRotationPoint(0F, 1F, -4.5F);
        setRotateAngle(Neck, -0.4F, 0F, 0F);
        Neck.mirror = true;
        Neck.addBox("Neck", -2F, -1F, -3F, 4, 4, 4);
        
        headpivot = new MowzieModelRenderer(this, "headpivot");
        headpivot.setRotationPoint(0F, 0F, 0.0F);
        setRotateAngle(headpivot, 0F, 0F, 0F);
        
        headdummy = new MowzieModelRenderer(this, "headdummy");
        headdummy.setRotationPoint(0F, 0F, -2.5F);
        headdummy.addBox("headdummy", 0F, 0F, 0F, 1, 1, 1);
        setRotateAngle(headpivot, 0F, 0F, 0F);
        
        Head = new MowzieModelRenderer(this, "Head");
        Head.setRotationPoint(0F, 0F, 0F);
        setRotateAngle(Head, -0.614F, 0F, 0F);
        Head.mirror = true;
        Head.addBox("HornBumps", -4F, -2F, -4F, 8, 4, 2);
        Head.addBox("Dome", -3.5F, -1F, -6F, 7, 8, 7);
        
        UpperJaw = new MowzieModelRenderer(this, "UpperJaw");
        UpperJaw.setRotationPoint(0F, 7F, -3F);
        setRotateAngle(UpperJaw, 0.514F, 0F, 0F);
        UpperJaw.mirror = true;
        UpperJaw.addBox("UpperJaw", -2F, -2F, -0.5F, 4, 4, 4);
        Head.addChild(UpperJaw);
        Neck.addChild(headdummy);
        headpivot.addChild(Head);
        UpperBody.addChild(Neck);
        RUpperarm = new MowzieModelRenderer(this, "RUpperarm");
        RUpperarm.setRotationPoint(-2F, 3F, -4F);
        setRotateAngle(RUpperarm, 0.314F, 0F, 0F);
        RUpperarm.mirror = true;
        RUpperarm.addBox("RUpperarm", -2F, 0F, -1F, 2, 4, 2);
        RForearm = new MowzieModelRenderer(this, "RForearm");
        RForearm.setRotationPoint(-1F, 3F, 0F);
        setRotateAngle(RForearm, -0.314F, 0F, 0F);
        RForearm.mirror = true;
        RForearm.addBox("RForearm", -1.1F, 0F, 0F, 2, 3, 2);
        RUpperarm.addChild(RForearm);
        UpperBody.addChild(RUpperarm);
        Body.addChild(UpperBody);
        LUpperThigh = new MowzieModelRenderer(this, "LUpperThigh");
        LUpperThigh.setRotationPoint(4F, -10.5F, 5.5F);
        setRotateAngle(LUpperThigh, -0.2617994F, 0F, 0F);
        LUpperThigh.mirror = true;
        LUpperThigh.addBox("LUpperThigh", 0F, -0.5F, -2F, 3, 6, 4);
        LCalf = new MowzieModelRenderer(this, "LCalf");
        LCalf.setRotationPoint(1F, 3.5F, 0.5F);
        setRotateAngle(LCalf, -0.281F, 0F, 0F);
        LCalf.mirror = true;
        LCalf.addBox("LCalf", -0.7F, 0F, 0F, 2, 6, 3);
        LFoot = new MowzieModelRenderer(this, "LFoot");
        LFoot.setRotationPoint(-0.5F, 5F, 2F);
        setRotateAngle(LFoot, 0.281F, 0F, 0F);
        LFoot.mirror = true;
        LFoot.addBox("LFoot", -0.5F, 0F, -4F, 3, 2, 4);
        LCalf.addChild(LFoot);
        LUpperThigh.addChild(LCalf);
        Body.addChild(LUpperThigh);
        RUpperThigh = new MowzieModelRenderer(this, "RUpperThigh");
        RUpperThigh.setRotationPoint(-4F, -10.5F, 5.5F);
        setRotateAngle(RUpperThigh, -0.2617994F, 0F, 0F);
        RUpperThigh.mirror = true;
        RUpperThigh.addBox("RUpperThigh", -3F, -0.5F, -2F, 3, 6, 4);
        RCalf = new MowzieModelRenderer(this, "RCalf");
        RCalf.setRotationPoint(-1F, 3.5F, 0F);
        setRotateAngle(RCalf, -0.281F, 0F, 0F);
        RCalf.mirror = true;
        RCalf.addBox("RCalf", -1.25F, 0F, 0F, 2, 6, 3);
        RFoot = new MowzieModelRenderer(this, "RFoot");
        RFoot.setRotationPoint(-0.5F, 5F, 2F);
        setRotateAngle(RFoot, 0.281F, 0F, 0F);
        RFoot.mirror = true;
        RFoot.addBox("RFoot", -1.5F, 0F, -4F, 3, 2, 4);
        RCalf.addChild(RFoot);
        RUpperThigh.addChild(RCalf);
        Body.addChild(RUpperThigh);
        Tail = new MowzieModelRenderer(this, "Tail");
        Tail.setRotationPoint(0F, -13.8F, 7F);
        setRotateAngle(Tail, -0.2F, 0F, 0F);
        Tail.mirror = true;
        Tail.addBox("Tail", -3F, 0F, 0F, 6, 5, 6);
        Tail1 = new MowzieModelRenderer(this, "Tail1");
        Tail1.setRotationPoint(0F, 1F, 6F);
        setRotateAngle(Tail1, 0.1F, 0F, 0F);
        Tail1.mirror = true;
        Tail1.addBox("Tail1", -2F, 0F, -1F, 4, 3, 8);
        Tail.addChild(Tail1);
        Body.addChild(Tail);
        doMowzieStuff(false);
    }
 

  /*  protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7)
    {
        this.headpivot.rotationPointX = this.headdummy.rotationPointX;
        this.headpivot.rotationPointY = this.headdummy.rotationPointY + 9;
        this.headpivot.rotationPointZ = this.headdummy.rotationPointZ - 8;


        if (!var7)
        {


            this.headpivot.rotateAngleX = var5 / (180F / (float) Math.PI);
            this.headpivot.rotateAngleY = var4 / (180F / (float) Math.PI);
            this.RUpperThigh.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.0F * var2;
            this.LUpperThigh.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float) Math.PI) * 1.0F * var2;
            //Tail anim
            this.Tail.rotateAngleY = 0.05F * MathHelper.sin(var3 * (float) 0.1F + (var2 + 1));
            this.Tail1.rotateAngleY = 0.06F * MathHelper.sin(var3 * (float) 0.1F + (var2 + 0));
        }
        else
        {
            this.headpivot.rotateAngleX = 0;
            this.headpivot.rotateAngleY = 0;
            this.RUpperThigh.rotateAngleX = 0;
            this.LUpperThigh.rotateAngleX = 0;
            //Tail anim
            this.Tail.rotateAngleY = 0;
            this.Tail1.rotateAngleY = 0;
        }
    }

    public void setLivingAnimations(EntityLivingBase par1EntityLiving, float par2, float par3, float par4)
    {
        EntityPachycephalosaurus entity = (EntityPachycephalosaurus) par1EntityLiving;
        int i = entity.getAttackTimer();

        if (i > 0)
        {
            this.UpperBody.rotateAngleX = 0.0F;
            this.Head.rotateAngleX = 0.0F;
        }
        else
        {
            this.UpperBody.rotateAngleX = -0.074F;
            this.Head.rotateAngleX = -0.914F;
        }
    }*/

    private float func_78172_a(float par1, float par2)
    {
        return (Math.abs(par1 % par2 - par2 * 0.5F) - par2 * 0.25F) / (par2 * 0.25F);
    }

	@Override
	public void renderFossil(EntityNewPrehistoric entity, float f, float f1,
			float f2, float f3, float f4, float f5) {
		
	}

	@Override
	public void renderLiving(EntityNewPrehistoric entity, float f, float f1,
			float f2, float f3, float f4, float f5) {
		
	}

	@Override
	public void renderSleeping(EntityNewPrehistoric entity, float f, float f1,
			float f2, float f3, float f4, float f5) {
		
	}
}
