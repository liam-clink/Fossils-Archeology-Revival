package com.github.revival.client.model.prehistoric;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

/**
 * MammothPivots.tcn - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelMammoth extends ModelPrehistoric
{
    public MowzieModelRenderer leftFrontLeg;
    public MowzieModelRenderer rightFrontLeg;
    public MowzieModelRenderer rightHindLeg;
    public MowzieModelRenderer leftHindLeg;
    public MowzieModelRenderer middleBody;
    public MowzieModelRenderer middleBodyFur;
    public MowzieModelRenderer lowerBody;
    public MowzieModelRenderer upperBody;
    public MowzieModelRenderer lowerBodyFur;
    public MowzieModelRenderer upperBodyFur;
    public MowzieModelRenderer bodyHump;
    public MowzieModelRenderer neck;
    public MowzieModelRenderer neckFur;
    public MowzieModelRenderer headPivot;
    public MowzieModelRenderer head;
    public MowzieModelRenderer headFur;
    public MowzieModelRenderer nose1;
    public MowzieModelRenderer headHump;
    public MowzieModelRenderer rightTusk;
    public MowzieModelRenderer leftTusk;
    public MowzieModelRenderer bottomjaw;
    public MowzieModelRenderer nose2;
    public MowzieModelRenderer nose3;
    public MowzieModelRenderer nose4;
    private MowzieModelRenderer nose2Pivot;
    private MowzieModelRenderer nose3Pivot;
    private MowzieModelRenderer nose4Pivot;

    public ModelMammoth()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.rightFrontLeg = new MowzieModelRenderer(this, 48, 0);
        this.rightFrontLeg.mirror = true;
        this.rightFrontLeg.setRotationPoint(-1.5F, 17.0F, -1.0F);
        this.rightFrontLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.lowerBodyFur = new MowzieModelRenderer(this, 46, 40);
        this.lowerBodyFur.setRotationPoint(0.5F, 3.95F, 1.55F);
        this.lowerBodyFur.addBox(-3.0F, 0.0F, -1.5F, 5, 2, 3, 0.0F);
        this.rightHindLeg = new MowzieModelRenderer(this, 48, 0);
        this.rightHindLeg.mirror = true;
        this.rightHindLeg.setRotationPoint(-1.3F, 17.0F, 6.5F);
        this.rightHindLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.lowerBody = new MowzieModelRenderer(this, 30, 33);
        this.lowerBody.setRotationPoint(0.0F, 2.2F, 4.7F);
        this.lowerBody.addBox(-2.5F, -2.0F, 0.0F, 5, 6, 3, 0.0F);
        this.setRotateAngle(lowerBody, 0.08726646259971647F, -0.0F, 0.0F);
        this.neck = new MowzieModelRenderer(this, 48, 11);
        this.neck.setRotationPoint(0.0F, -0.7F, -1.0F);
        this.neck.addBox(-1.5F, -2.0F, -4.3F, 3, 5, 3, 0.0F);
        this.headPivot = new MowzieModelRenderer(this, 0, 0);
        this.headPivot.setRotationPoint(0.0F, 0.5F, -4F);
        this.headPivot.addBox(0F, 0F, 0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(headPivot, -0.05235987755982988F, -0.0F, 0.0F);
        this.head = new MowzieModelRenderer(this, 48, 25);
        this.head.mirror = true;
        this.head.setRotationPoint(0.0F, 0F, 0F);
        this.head.addBox(-2.0F, -3.0F, -3.3F, 4, 6, 4, 0.0F);
        this.setRotateAngle(head, 0F, -0.0F, 0.0F);
        this.rightTusk = new MowzieModelRenderer(this, 30, 40);
        this.rightTusk.setRotationPoint(-1.0F, 2.5F, -1.5F);
        this.rightTusk.addBox(0.0F, 0.0F, -7.0F, 0, 7, 8, 0.0F);
        this.setRotateAngle(rightTusk, 0.0F, -0.0F, 0.5235987755982988F);
        this.middleBodyFur = new MowzieModelRenderer(this, 0, 50);
        this.middleBodyFur.setRotationPoint(-0.1F, -0.1F, 1.2F);
        this.middleBodyFur.addBox(-3.0F, 0.0F, 0.0F, 6, 9, 4, 0.0F);
        this.nose4Pivot = new MowzieModelRenderer(this, 0, 0);
        this.nose4Pivot.setRotationPoint(0.0F, 2.5F, -0.3F);
        this.nose4Pivot.addBox(0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(nose4Pivot, 0.2565634000431664F, -0.0F, 0.0F);
        this.nose4 = new MowzieModelRenderer(this, 0, 33);
        this.nose4.setRotationPoint(0.0F, 0F, -0F);
        this.nose4.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(nose4, 0F, -0.0F, 0.0F);
        this.upperBody = new MowzieModelRenderer(this, 20, 15);
        this.upperBody.mirror = true;
        this.upperBody.setRotationPoint(0.0F, 2.0F, -0.3F);
        this.upperBody.addBox(-3.0F, -2.0F, -3.0F, 6, 7, 4, 0.0F);
        this.setRotateAngle(upperBody, 0.08726646259971647F, -0.0F, 0.0F);
        this.upperBodyFur = new MowzieModelRenderer(this, 0, 0);
        this.upperBodyFur.setRotationPoint(0.0F, 0.0F, -3.8F);
        this.upperBodyFur.addBox(-3.5F, -2.5F, 0.5F, 7, 10, 5, 0.0F);
        this.setRotateAngle(upperBodyFur, -0.03490658503988659F, -0.0F, 0.0F);
        this.leftHindLeg = new MowzieModelRenderer(this, 48, 0);
        this.leftHindLeg.mirror = true;
        this.leftHindLeg.setRotationPoint(1.3F, 17.0F, 6.5F);
        this.leftHindLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.neckFur = new MowzieModelRenderer(this, 63, 47);
        this.neckFur.setRotationPoint(0.0F, 0.9F, -0.2F);
        this.neckFur.addBox(-2.0F, -3.0F, -3.0F, 4, 6, 3, 0.0F);
        this.leftTusk = new MowzieModelRenderer(this, 22, 40);
        this.leftTusk.setRotationPoint(1.0F, 2.5F, -1.5F);
        this.leftTusk.addBox(0.0F, 0.0F, -1.0F, 0, 7, 8, 0.0F);
        this.setRotateAngle(leftTusk, -3.141592653589793F, -0.0F, -3.6651914291880923F);
        this.nose3Pivot = new MowzieModelRenderer(this, 0, 0);
        this.nose3Pivot.setRotationPoint(0.0F, 3.9F, 0.5F);
        this.nose3Pivot.addBox(0F, 0.0F, 0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(nose3Pivot, 0.2565634000431664F, -0.0F, 0.0F);
        this.nose3 = new MowzieModelRenderer(this, 0, 27);
        this.nose3.setRotationPoint(0.0F, 0F, 0F);
        this.nose3.addBox(-1.0F, 0.0F, -0.5F, 2, 3, 2, 0.0F);
        this.setRotateAngle(nose3, 0F, -0.0F, 0.0F);
        this.nose2Pivot = new MowzieModelRenderer(this, 0, 0);
        this.nose2Pivot.setRotationPoint(0.0F, 1.0F, -3.5F);
        this.nose2Pivot.addBox(0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(nose2Pivot, 0.3164281933865719F, -0.0F, 0.0F);
        this.nose2 = new MowzieModelRenderer(this, 0, 21);
        this.nose2.setRotationPoint(0.0F, 0F, 0F);
        this.nose2.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(nose2, 0F, -0.0F, 0.0F);
        this.headFur = new MowzieModelRenderer(this, 44, 53);
        this.headFur.setRotationPoint(0.0F, 0.7F, 1.0F);
        this.headFur.addBox(-2.5F, -4.0F, -5.0F, 5, 6, 5, 0.0F);
        this.nose1 = new MowzieModelRenderer(this, 0, 21);
        this.nose1.setRotationPoint(0.0F, 0.6F, -0.8F);
        this.nose1.addBox(-1.0F, -1.0F, -3.5F, 2, 2, 2, 0.0F);
        this.setRotateAngle(nose1, -0.5736897251305361F, -0.0F, 0.0F);
        this.bottomjaw = new MowzieModelRenderer(this, 9, 27);
        this.bottomjaw.setRotationPoint(0.0F, 1.5F, 0.03F);
        this.bottomjaw.addBox(-1.0F, 0.0F, -0.5F, 2, 3, 2, 0.0F);
        this.setRotateAngle(bottomjaw, -1.3491395117916165F, -0.0F, 0.0F);
        this.headHump = new MowzieModelRenderer(this, 29, 56);
        this.headHump.setRotationPoint(0.0F, -3.0F, -1.5F);
        this.headHump.addBox(-2.0F, -1.0F, -1.5F, 4, 1, 3, 0.0F);
        this.leftFrontLeg = new MowzieModelRenderer(this, 48, 0);
        this.leftFrontLeg.mirror = true;
        this.leftFrontLeg.setRotationPoint(1.5F, 17.0F, -1.0F);
        this.leftFrontLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.bodyHump = new MowzieModelRenderer(this, 2, 37);
        this.bodyHump.setRotationPoint(0.0F, -2.2F, -0.5F);
        this.bodyHump.addBox(-3.0F, -1.0F, -2.0F, 6, 1, 4, 0.0F);
        this.middleBody = new MowzieModelRenderer(this, 20, 14);
        this.middleBody.setRotationPoint(0.0F, 11.9F, 1.2F);
        this.middleBody.addBox(-2.5F, 0.0F, 0.0F, 5, 7, 5, 0.0F);
        this.setRotateAngle(middleBody, -0.12217304763960307F, -0.0F, 0.0F);
        this.lowerBody.addChild(this.lowerBodyFur);
        this.middleBody.addChild(this.lowerBody);
        this.upperBody.addChild(this.neck);
        this.neck.addChild(this.headPivot);
        this.headPivot.addChild(this.head);
        this.head.addChild(this.rightTusk);
        this.middleBody.addChild(this.middleBodyFur);
        this.nose3.addChild(this.nose4Pivot);
        this.nose4Pivot.addChild(this.nose4);
        this.middleBody.addChild(this.upperBody);
        this.upperBody.addChild(this.upperBodyFur);
        this.neck.addChild(this.neckFur);
        this.head.addChild(this.leftTusk);
        this.nose2Pivot.addChild(this.nose2);
        this.nose2.addChild(this.nose3Pivot);
        this.nose3Pivot.addChild(this.nose3);
        this.nose1.addChild(this.nose2Pivot);
        this.head.addChild(this.headFur);
        this.head.addChild(this.nose1);
        this.head.addChild(this.bottomjaw);
        this.head.addChild(this.headHump);
        this.upperBody.addChild(this.bodyHump);
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

/*
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.rightFrontLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
        this.leftFrontLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.0F * f1;
        this.rightHindLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.0F * f1;
        this.leftHindLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
        this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
        this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
        this.nose2.rotateAngleX = (0.06F * MathHelper.sin(f2 * (float) 0.1F + (f1 + 2)));
        this.nose3.rotateAngleX = (0.1F * MathHelper.sin(f2 * (float) 0.1F + (f1 + 2)));
        this.nose4.rotateAngleX = (0.2F * MathHelper.sin(f2 * (float) 0.1F + (f1 + 2)));
    }
*/
}
