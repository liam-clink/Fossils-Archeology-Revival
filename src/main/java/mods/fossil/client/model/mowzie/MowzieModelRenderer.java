package mods.fossil.client.model.mowzie;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class MowzieModelRenderer
extends ModelRenderer
{
	public float initRotateAngleX;
	public float initRotateAngleY;
	public float initRotateAngleZ;
	public float initRotationPointX;
	public float initRotationPointY;
	public float initRotationPointZ;

	public MowzieModelRenderer(ModelBase modelBase, String name)
	{
		super(modelBase, name);
	}

	public MowzieModelRenderer(ModelBase modelBase, int x, int y)
	{
		super(modelBase, x, y);
	}

	public MowzieModelRenderer(ModelBase modelBase)
	{
		super(modelBase);
	}

	public void setInitValuesToCurrentPose()
	{
		this.initRotateAngleX = this.rotateAngleX;
		this.initRotateAngleY = this.rotateAngleY;
		this.initRotateAngleZ = this.rotateAngleZ;

		this.initRotationPointX = this.rotationPointX;
		this.initRotationPointY = this.rotationPointY;
		this.initRotationPointZ = this.rotationPointZ;
	}

	public void setCurrentPoseToInitValues()
	{
		this.rotateAngleX = this.initRotateAngleX;
		this.rotateAngleY = this.initRotateAngleY;
		this.rotateAngleZ = this.initRotateAngleZ;

		this.rotationPointX = this.initRotationPointX;
		this.rotationPointY = this.initRotationPointY;
		this.rotationPointZ = this.initRotationPointZ;
	}

	public void setRotationAngles(float x, float y, float z)
	{
		this.rotateAngleX = x;
		this.rotateAngleY = y;
		this.rotateAngleZ = z;
	}
}
