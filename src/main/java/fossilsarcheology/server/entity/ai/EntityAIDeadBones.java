package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.mob.EntityBones;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIDeadBones extends EntityAIBase {
    private EntityBones entity;

    public EntityAIDeadBones(EntityBones entity) {
        this.entity = entity;
    }

    @Override
    public boolean shouldExecute() {
        return true;
    }

    @Override
    public void updateTask() {
        this.entity.rotationPitch = 45.0F;
    }
}
