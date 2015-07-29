package com.github.revival.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.MathHelper;

public abstract class ModelDinosaurs extends ModelBase
{
    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        this.setRotationAngles(var1, var2, var3, var4, var5, var6, false);
    }

    public void walk(ModelRenderer box, float speed, float degree, boolean invert, float offset, float weight, float f, float f1)
    {
        int inverted = 1;
        if (invert)
        {
            inverted = -1;
        }
        box.rotateAngleX += MathHelper.cos(f * speed + offset) * degree * inverted * f1 + weight * f1;
    }

    protected abstract void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7);
}
