package com.github.revival.server.entity.mob.test;

import java.util.Random;

import com.github.revival.server.enums.EnumPrehistoricAI.Activity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class DinoAIHideFromSun extends EntityAIBase
{
    private EntityNewPrehistoric dinosaur;
    private double shelterX;
    private double shelterY;
    private double shelterZ;
    private World theWorld;

    public DinoAIHideFromSun(EntityNewPrehistoric dinosaur)
    {
        this.dinosaur = dinosaur;
        this.theWorld = dinosaur.worldObj;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (!this.theWorld.isDaytime())
        {
            return false;
        }
        if (this.dinosaur.aiActivityType() != Activity.NOCTURNAL)
        {
            return false;
        }
        else if (!this.theWorld.canBlockSeeTheSky(MathHelper.floor_double(this.dinosaur.posX), (int)this.dinosaur.boundingBox.minY, MathHelper.floor_double(this.dinosaur.posZ)))
        {
            return false;
        }
        else
        {
            Vec3 vec3 = this.findPossibleShelter();

            if (vec3 == null)
            {
                return false;
            }
            else
            {
                this.shelterX = vec3.xCoord;
                this.shelterY = vec3.yCoord;
                this.shelterZ = vec3.zCoord;
                return true;
            }
        }
    }

    public boolean continueExecuting()
    {
        return !this.dinosaur.getNavigator().noPath();
    }

    public void startExecuting()
    {
        this.dinosaur.getNavigator().tryMoveToXYZ(this.shelterX, this.shelterY, this.shelterZ, 1);
    }

    private Vec3 findPossibleShelter()
    {
        Random random = this.dinosaur.getRNG();

        for (int i = 0; i < 10; ++i)
        {
            int j = MathHelper.floor_double(this.dinosaur.posX + (double)random.nextInt(20) - 10.0D);
            int k = MathHelper.floor_double(this.dinosaur.boundingBox.minY + (double)random.nextInt(6) - 3.0D);
            int l = MathHelper.floor_double(this.dinosaur.posZ + (double)random.nextInt(20) - 10.0D);

            if (!this.theWorld.canBlockSeeTheSky(j, k, l) && this.dinosaur.getBlockPathWeight(j, k, l) < 0.0F)
            {
                return Vec3.createVectorHelper((double)j, (double)k, (double)l);
            }
        }

        return null;
    }
}