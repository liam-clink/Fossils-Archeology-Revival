package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.monster.EntityAnu;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAvoidEntity;

public class AnuAIAvoidEntity<T extends Entity> extends EntityAIAvoidEntity<T> {
    private final EntityAnu anu;

    public AnuAIAvoidEntity(EntityAnu anu, Class<T> clazz, float f, double d0, double d1) {
        super(anu, clazz, f, d0, d1);
        this.anu = anu;
    }

    @Override
    public boolean shouldExecute() {
        return this.anu.getAttackMode() == 2 && super.shouldExecute();
    }
}
