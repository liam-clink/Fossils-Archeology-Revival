package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.mob.EntityAnu;
import net.minecraft.entity.ai.EntityAIAttackRanged;

public class AnuAIFireballAttack extends EntityAIAttackRanged {
    private EntityAnu entity;

    public AnuAIFireballAttack(EntityAnu entity, double speed, int delay, int maxAttackTime, float maxDistance) {
        super(entity, speed, delay, maxAttackTime, maxDistance);
        this.entity = entity;
    }

    @Override
    public boolean shouldExecute() {
        return this.entity.getAttackMode() == EntityAnu.AttackMode.RANGED_FLIGHT && super.shouldExecute();
    }
}
