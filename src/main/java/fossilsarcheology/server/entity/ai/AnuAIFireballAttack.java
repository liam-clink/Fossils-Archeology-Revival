package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.mob.EntityAnu;
import net.minecraft.entity.ai.EntityAIArrowAttack;

public class AnuAIFireballAttack extends EntityAIArrowAttack {
    private EntityAnu theEntity;

    public AnuAIFireballAttack(EntityAnu anu, double entityMoveSpeed, int timedeductor, int maxRangedAttackTime, float sqDistance) {
        super(anu, entityMoveSpeed, timedeductor, maxRangedAttackTime, sqDistance);
        theEntity = anu;
    }

    @Override
    public boolean shouldExecute() {
        return theEntity.getAttackMode() == 1 && super.shouldExecute();
    }
}
