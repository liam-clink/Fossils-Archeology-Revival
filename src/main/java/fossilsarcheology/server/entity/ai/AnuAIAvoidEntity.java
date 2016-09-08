package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.mob.EntityAnu;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAvoidEntity;

public class AnuAIAvoidEntity<T extends Entity> extends EntityAIAvoidEntity<T> {
    private EntityAnu entity;

    public AnuAIAvoidEntity(EntityAnu entity, Class<T> avoid, float distance, double farSpeed, double nearSpeed) {
        super(entity, avoid, distance, farSpeed, nearSpeed);
        this.entity = entity;
    }

    @Override
    public boolean shouldExecute() {
        return this.entity.getAttackMode() == EntityAnu.AttackMode.DEFENSE && super.shouldExecute();
    }

}
