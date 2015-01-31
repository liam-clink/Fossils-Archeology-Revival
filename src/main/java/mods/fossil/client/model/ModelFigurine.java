package mods.fossil.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFigurine extends ModelBase
{
    //fields
    ModelRenderer Body;
    ModelRenderer Head;
    ModelRenderer ArmLeft;
    ModelRenderer ArmRight;

    public ModelFigurine()
    {
        textureWidth = 64;
        textureHeight = 32;
        Body = new ModelRenderer(this, 0, 14);
        Body.addBox(-5F, -9F, -4F, 10, 9, 8);
        Body.setRotationPoint(0F, 24F, 0F);
        Body.setTextureSize(64, 32);
        Body.mirror = true;
        setRotation(Body, 0F, 0F, 0F);
        Head = new ModelRenderer(this, 0, 0);
        Head.addBox(-3.5F, -5F, -3.5F, 7, 7, 7);
        Head.setRotationPoint(0F, 13F, 0F);
        Head.setTextureSize(64, 32);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        ArmLeft = new ModelRenderer(this, 36, 21);
        ArmLeft.addBox(5F, -1F, -1.5F, 2, 8, 3);
        ArmLeft.setRotationPoint(0F, 17F, 0F);
        ArmLeft.setTextureSize(64, 32);
        ArmLeft.mirror = true;
        setRotation(ArmLeft, 0F, 0F, 0F);
        ArmRight = new ModelRenderer(this, 36, 21);
        ArmRight.addBox(-7F, -1F, -1.5F, 2, 8, 3);
        ArmRight.setRotationPoint(0F, 17F, 0F);
        ArmRight.setTextureSize(64, 32);
        ArmRight.mirror = true;
        setRotation(ArmRight, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Body.render(f5);
        Head.render(f5);
        ArmLeft.render(f5);
        ArmRight.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}