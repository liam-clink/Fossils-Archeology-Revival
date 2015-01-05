package mods.fossil.entity.mobs;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.util.Vec3;

public abstract class FossilModelBase extends ModelBase {
	
	public FossilModelBase() {
		
	}
	
	abstract void setLookVector(Vec3 lookVector);
	
	abstract void setAnimationToRun(int animationIndex);
	
}
