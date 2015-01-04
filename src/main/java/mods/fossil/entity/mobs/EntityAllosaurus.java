package mods.fossil.entity.mobs;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;

public class EntityAllosaurus extends EntityPrehistoric {
	
	public EntityAllosaurus(World world) {
		super(world, EnumEntityPrehistoric.Allosaurus);
	}

	@Override
	void addAI() {

	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		return new EntityAllosaurus(worldObj);
	}
	
}
