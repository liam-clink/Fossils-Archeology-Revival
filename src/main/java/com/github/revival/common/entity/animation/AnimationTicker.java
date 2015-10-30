package com.github.revival.common.entity.animation;

import net.ilexiconn.llibrary.common.animation.Animation;
import net.ilexiconn.llibrary.common.animation.IAnimated;
import net.minecraft.entity.Entity;

import com.github.revival.Revival;
import com.github.revival.common.message.MessageCorrectAnimation;

import cpw.mods.fml.common.FMLCommonHandler;

public class AnimationTicker
{
    public int animationId;
    public int duration;

    public AnimationTicker(int id, int d)
    {
        animationId = id;
        duration = d;
    }

    public static void sendAnimationPacket(IAnimated entity, Animation animation)
    {
        if (FMLCommonHandler.instance().getEffectiveSide().isClient()) return;
        entity.setAnimation(animation);
        Revival.channel.sendToAll(new MessageCorrectAnimation((byte) animation.animationId, ((Entity) entity).getEntityId()));
    }

    public static void tickAnimations(IAnimated entity)
    {
        if (entity.getAnimation() == null) entity.setAnimation(entity.animations()[0]);
        else
        {
            if (entity.getAnimation().animationId != 0)
            {
                if (entity.getAnimationTick() == 0) sendAnimationPacket(entity, entity.getAnimation());
                if (entity.getAnimationTick() < entity.getAnimation().duration) entity.setAnimationTick(entity.getAnimationTick() + 1);
                if (entity.getAnimationTick() == entity.getAnimation().duration)
                {
                    entity.setAnimationTick(0);
                    entity.setAnimation(entity.animations()[0]);
                }
            }
        }
    }
}
