package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.mob.EntityAnu;
import net.minecraft.entity.ai.EntityAIAttackMelee;

public class AnuAIMelee extends EntityAIAttackMelee {
    private EntityAnu entity;

    public AnuAIMelee(EntityAnu entity, double speed, boolean longMemory) {
        super(entity, speed, longMemory);
        this.entity = entity;
    }

    @Override
    public boolean shouldExecute() {
        return this.entity.getAttackMode() == EntityAnu.AttackMode.MELEE && super.shouldExecute();
    }

}
