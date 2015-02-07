package mods.fossil.client.model;

import mods.fossil.entity.mob.EntityDinosaur;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBrachiosaurus extends ModelDinosaurs {
	private ModelRenderer Snout;
	private ModelRenderer Crest;
	private ModelRenderer Brachiosaurus;
	private ModelRenderer headpivot;
	private ModelRenderer head;
	private ModelRenderer tail;
	private ModelRenderer lowerneck1;
	private ModelRenderer Lowerneck2;
	private ModelRenderer neck1;
	private ModelRenderer neck3;
	private ModelRenderer frontcalfleft;
	private ModelRenderer frontthighleft;
	private ModelRenderer Head;
	private ModelRenderer neck2;
	private ModelRenderer tail2;
	private ModelRenderer tail1;
	private ModelRenderer lowerbody;
	private ModelRenderer backcalfright;
	private ModelRenderer backthighright;
	private ModelRenderer backthighleft;
	private ModelRenderer frontcalfright;
	private ModelRenderer back_calfleft;
	private ModelRenderer frontthighright;
	private ModelRenderer Body2;
	
	public ModelBrachiosaurus() {
    textureWidth = 128;
    textureHeight = 64;
    setTextureOffset("Brachiosaurus.Body", 44, 48);
    setTextureOffset("frontthighright.FrontThighright", 50, 21);
    setTextureOffset("frontcalfright.FrontCalfright", 0, 24);
    setTextureOffset("Body2.Body2", 44, 34);
    setTextureOffset("backthighleft.BackThighleft", 50, 21);
    setTextureOffset("back_calfleft.BackCalfleft", 0, 24);
    setTextureOffset("backthighright.BackThighright", 50, 21);
    setTextureOffset("backcalfright.BackCalfright", 0, 24);
    setTextureOffset("lowerbody.LowerBody", 73, 48);
    setTextureOffset("tail.Tail", 0, 13);
    setTextureOffset("tail1.Tail1", 17, 1);
    setTextureOffset("tail2.Tail2", 34, 10);
    setTextureOffset("frontthighleft.FrontThighleft", 50, 21);
    setTextureOffset("frontcalfleft.FrontCalfleft", 0, 24);
    setTextureOffset("lowerneck1.LowerNeck1", 0, 33);
    setTextureOffset("Lowerneck2.LowerNeck2", 0, 45);
    setTextureOffset("neck1.Neck1", 17, 53);
    setTextureOffset("neck2.Neck2", 18, 41);
    setTextureOffset("neck3.Neck3", 23, 33);
    setTextureOffset("Head.Head", 66, 0);
    setTextureOffset("Snout.Snout", 67, 8);
    setTextureOffset("Crest.Crest", 52, 0);
    
    Brachiosaurus = new ModelRenderer(this, "Brachiosaurus");
    Brachiosaurus.setRotationPoint(0F, 8F, -4F);
    setRotation(Brachiosaurus, -0.4833219F, 0F, 0F);
    Brachiosaurus.mirror = true;
      Brachiosaurus.addBox("Body", -4F, -0.3F, 0F, 8, 9, 6);
    frontthighright = new ModelRenderer(this, "frontthighright");
    frontthighright.setRotationPoint(-4F, 4F, 2F);
    setRotation(frontthighright, 0F, 0F, 0F);
    frontthighright.mirror = true;
      frontthighright.addBox("FrontThighright", -2F, 0F, -1.5F, 3, 7, 4);
    frontcalfright = new ModelRenderer(this, "frontcalfright");
    frontcalfright.setRotationPoint(-1F, 7F, 0F);
    setRotation(frontcalfright, 0F, 0F, 0F);
    frontcalfright.mirror = true;
      frontcalfright.addBox("FrontCalfright", -0.5F, 0F, -0.5F, 2, 5, 3);
      frontthighright.addChild(frontcalfright);
      Brachiosaurus.addChild(frontthighright);
    Body2 = new ModelRenderer(this, "Body2");
    Body2.setRotationPoint(0F, 4F, 6F);
    setRotation(Body2, 0F, 0F, 0F);
    Body2.mirror = true;
      Body2.mirror = true;
      Body2.addBox("Body2", -4F, -4F, -0.2F, 8, 9, 4);
      Body2.mirror = false;
    backthighleft = new ModelRenderer(this, "backthighleft");
    backthighleft.setRotationPoint(4F, 1F, 5F);
    setRotation(backthighleft, 0F, 0F, 0F);
    backthighleft.mirror = true;
      backthighleft.mirror = true;
      backthighleft.addBox("BackThighleft", -1F, 0F, -2F, 3, 6, 4);
      backthighleft.mirror = false;
    back_calfleft = new ModelRenderer(this, "back_calfleft");
    back_calfleft.setRotationPoint(0F, 6F, 0F);
    setRotation(back_calfleft, 0F, 0F, 0F);
    back_calfleft.mirror = true;
    back_calfleft.mirror = true;
      back_calfleft.addBox("BackCalfleft", -0.5F, 0F, -1.5F, 2, 5, 3);
      back_calfleft.mirror = false;
      backthighleft.addChild(back_calfleft);
      Body2.addChild(backthighleft);
    backthighright = new ModelRenderer(this, "backthighright");
    backthighright.setRotationPoint(-4F, 1F, 5F);
    setRotation(backthighright, 0F, 0F, 0F);
    backthighright.mirror = true;
      backthighright.addBox("BackThighright", -2F, 0F, -2F, 3, 6, 4);
    backcalfright = new ModelRenderer(this, "backcalfright");
    backcalfright.setRotationPoint(0F, 6F, 0F);
    setRotation(backcalfright, 0F, 0F, 0F);
    backcalfright.mirror = true;
      backcalfright.addBox("BackCalfright", -1.5F, 0F, -1.5F, 2, 5, 3);
      backthighright.addChild(backcalfright);
      Body2.addChild(backthighright);
    lowerbody = new ModelRenderer(this, "lowerbody");
    lowerbody.setRotationPoint(0F, 1F, 4F);
    setRotation(lowerbody, 0F, 0F, 0F);
    lowerbody.mirror = true;
      lowerbody.mirror = true;
      lowerbody.addBox("LowerBody", -3F, -5F, -2F, 6, 8, 5);
      lowerbody.mirror = false;
    tail = new ModelRenderer(this, "tail");
    tail.setRotationPoint(0F, -1F, 2F);
    setRotation(tail, 0F, 0F, 0F);
    tail.mirror = true;
      tail.mirror = true;
      tail.addBox("Tail", -2.5F, -3F, 1F, 5, 5, 5);
      tail.mirror = false;
    tail1 = new ModelRenderer(this, "tail1");
    tail1.setRotationPoint(0F, -1F, 5F);
    setRotation(tail1, 0F, 0F, 0F);
    tail1.mirror = true;
      tail1.mirror = true;
      tail1.addBox("Tail1", -1.5F, -1.5F, 1F, 3, 4, 5);
      tail1.mirror = false;
    tail2 = new ModelRenderer(this, "tail2");
    tail2.setRotationPoint(0F, 0F, 5F);
    setRotation(tail2, 0F, 0F, 0F);
    tail2.mirror = true;
      tail2.mirror = true;
      tail2.addBox("Tail2", -1F, -1F, 1F, 2, 3, 6);
      tail2.mirror = false;
      tail1.addChild(tail2);
      tail.addChild(tail1);
      lowerbody.addChild(tail);
      Body2.addChild(lowerbody);
      Brachiosaurus.addChild(Body2);
    frontthighleft = new ModelRenderer(this, "frontthighleft");
    frontthighleft.setRotationPoint(4F, 4F, 2F);
    setRotation(frontthighleft, 0F, 0F, 0F);
    frontthighleft.mirror = true;
      frontthighleft.mirror = true;
      frontthighleft.addBox("FrontThighleft", -1F, 0F, -1.5F, 3, 7, 4);
      frontthighleft.mirror = false;
    frontcalfleft = new ModelRenderer(this, "frontcalfleft");
    frontcalfleft.setRotationPoint(1F, 7F, 0F);
    setRotation(frontcalfleft, 0F, 0F, 0F);
    frontcalfleft.mirror = true;
      frontcalfleft.mirror = true;
      frontcalfleft.addBox("FrontCalfleft", -1.5F, 0F, -0.5F, 2, 5, 3);
      frontcalfleft.mirror = false;
      frontthighleft.addChild(frontcalfleft);
      Brachiosaurus.addChild(frontthighleft);
    lowerneck1 = new ModelRenderer(this, "lowerneck1");
    lowerneck1.setRotationPoint(0F, 2F, -2F);
    setRotation(lowerneck1, 0F, 0F, 0F);
    lowerneck1.mirror = true;
      lowerneck1.addBox("LowerNeck1", -3F, -2F, -2.5F, 6, 6, 5);
    Lowerneck2 = new ModelRenderer(this, "Lowerneck2");
    Lowerneck2.setRotationPoint(0F, 0F, -2F);
    setRotation(Lowerneck2, 0F, 0F, 0F);
    Lowerneck2.mirror = true;
      Lowerneck2.mirror = true;
      Lowerneck2.addBox("LowerNeck2", -2F, -1.9F, -4.5F, 4, 5, 4);
      Lowerneck2.mirror = false;
    neck1 = new ModelRenderer(this, "neck1");
    neck1.setRotationPoint(0F, 0F, -4F);
    setRotation(neck1, 0F, 0F, 0F);
    neck1.mirror = true;
      neck1.mirror = true;
      neck1.addBox("Neck1", -2F, -1.5F, -7F, 4, 4, 7);
      neck1.mirror = false;
    neck2 = new ModelRenderer(this, "neck2");
    neck2.setRotationPoint(0F, 0F, -7F);
    setRotation(neck2, 0F, 0F, 0F);
    neck2.mirror = true;
      neck2.mirror = true;
      neck2.addBox("Neck2", -1.5F, -1.2F, -6.2F, 3, 3, 7);
      neck2.mirror = false;
    neck3 = new ModelRenderer(this, "neck3");
    neck3.setRotationPoint(0F, 0F, -6F);
    setRotation(neck3, 0F, 0F, 0F);
    neck3.mirror = true;
      neck3.mirror = true;
      neck3.addBox("Neck3", -1F, -1F, -3.2F, 2, 3, 3);
      neck3.mirror = false;
    Head = new ModelRenderer(this, "Head");
    Head.setRotationPoint(0F, 0F, -3F);
    setRotation(Head, 0F, 0F, 0F);
    Head.mirror = true;
      Head.mirror = true;
      Head.addBox("Head", -2F, -1F, -3.7F, 4, 3, 4);
      Head.mirror = false;
    Snout = new ModelRenderer(this, "Snout");
    Snout.setRotationPoint(0F, 0F, -3F);
    setRotation(Snout, 0F, 0F, 0F);
    Snout.mirror = true;
      Snout.mirror = true;
      Snout.addBox("Snout", -1.5F, 0F, -3.3F, 3, 2, 4);
      Snout.mirror = false;
      Head.addChild(Snout);
    Crest = new ModelRenderer(this, "Crest");
    Crest.setRotationPoint(0F, 0F, -2F);
    setRotation(Crest, 0F, 0F, 0F);
    Crest.mirror = true;
      Crest.mirror = true;
      Crest.addBox("Crest", -1F, -4F, -1.7F, 2, 4, 4);
      Crest.mirror = false;
      Head.addChild(Crest);
      neck3.addChild(Head);
      neck2.addChild(neck3);
      neck1.addChild(neck2);
      Lowerneck2.addChild(neck1);
      lowerneck1.addChild(Lowerneck2);
      Brachiosaurus.addChild(lowerneck1);
  }

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Brachiosaurus.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
	}

	@Override
	protected void setRotationAngles(float var1, float var2, float var3,
			float var4, float var5, float var6, boolean var7) {
		// TODO Auto-generated method stub

	}

}
