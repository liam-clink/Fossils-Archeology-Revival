package fossilsarcheology.client.model;

import fossilsarcheology.server.entity.toy.EntityToyBall;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.entity.Entity;

public class ModelToyBall extends AdvancedModelBase {
    public AdvancedModelRenderer ball;

    public ModelToyBall() {
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.ball = new AdvancedModelRenderer(this, 0, 0);
        this.ball.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.ball.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float age, float yaw, float pitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, age, yaw, pitch, scale, entity);
        this.ball.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float age, float yaw, float pitch, float scale, Entity entity) {
        ball.rotateAngleX = (float) Math.toRadians(((EntityToyBall) entity).rollValue * 7);
    }
}
