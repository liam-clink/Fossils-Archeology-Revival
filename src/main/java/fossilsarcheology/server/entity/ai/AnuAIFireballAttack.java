package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.monster.EntityAnu;
import net.minecraft.entity.ai.EntityAIAttackRangedBow;


public class AnuAIFireballAttack extends EntityAIAttackRangedBow {
    private EntityAnu theEntity;

    public AnuAIFireballAttack(EntityAnu anu, double entityMoveSpeed, int timedeductor, int maxRangedAttackTime, float sqDistance) {
        super(anu, entityMoveSpeed, timedeductor, maxRangedAttackTime);
        theEntity = anu;
    }

    @Override
    public boolean shouldExecute() {
        return theEntity.getAttackMode() == 1 && super.shouldExecute();
    }
}
