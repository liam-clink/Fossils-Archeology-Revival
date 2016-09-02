package fossilsarcheology.client.model;

import fossilsarcheology.server.entity.mob.EntityFriendlyPigZombie;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelFPZ extends ModelBiped {

    public ModelFPZ() {
        this(0.0F, false);
    }

    protected ModelFPZ(float scale, float height, int textureWidth, int textureHeight) {
        super(scale, height, textureWidth, textureHeight);
    }

    public ModelFPZ(float scale, boolean tallTexture) {
        super(scale, 0.0F, 64, tallTexture ? 32 : 64);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float age, float yaw, float pitch, float scale, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, age, yaw, pitch, scale, entity);
        float f6 = MathHelper.sin(this.swingProgress * (float) Math.PI);
        float f7 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float) Math.PI);
        this.bipedRightArm.rotateAngleZ = 0.0F;
        this.bipedLeftArm.rotateAngleZ = 0.0F;
        this.bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F);
        this.bipedLeftArm.rotateAngleY = 0.1F - f6 * 0.6F;
        this.bipedRightArm.rotateAngleX = -((float) Math.PI / 2F);
        this.bipedLeftArm.rotateAngleX = -((float) Math.PI / 2F);
        this.bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
        this.bipedLeftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
        this.bipedRightArm.rotateAngleZ += MathHelper.cos(age * 0.09F) * 0.05F + 0.05F;
        this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(age * 0.09F) * 0.05F + 0.05F;
        this.bipedRightArm.rotateAngleX += MathHelper.sin(age * 0.067F) * 0.05F;
        this.bipedLeftArm.rotateAngleX -= MathHelper.sin(age * 0.067F) * 0.05F;
        if (((EntityFriendlyPigZombie) entity).isSitting()) {
            this.bipedRightLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
            this.bipedLeftLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
            this.bipedRightLeg.rotateAngleY = ((float) Math.PI / 10F);
            this.bipedLeftLeg.rotateAngleY = -((float) Math.PI / 10F);
        }
    }
}
