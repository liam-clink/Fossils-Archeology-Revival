package mods.fossil.handler;

import java.util.Random;

import mods.fossil.entity.mob.EntityElasmotherium;
import mods.fossil.entity.mob.EntityMammoth;
import mods.fossil.entity.mob.EntityPregnantCow;
import mods.fossil.entity.mob.EntityPregnantHorse;
import mods.fossil.entity.mob.EntityPregnantPig;
import mods.fossil.entity.mob.EntityPregnantSheep;
import mods.fossil.entity.mob.EntityQuagga;
import mods.fossil.entity.mob.EntitySmilodon;
import mods.fossil.entity.mob.EntityTRex;
import mods.fossil.fossilEnums.EnumAnimalType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class FossilLivingEvent {

	protected Random rand;
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityHorse && EntityPregnantHorse.get((EntityHorse) event.entity) == null)
			EntityPregnantHorse.register((EntityHorse) event.entity);
		
		if (event.entity instanceof EntityCow && EntityPregnantCow.get((EntityCow) event.entity) == null)
			EntityPregnantCow.register((EntityCow) event.entity);
		
		if (event.entity instanceof EntityPig && EntityPregnantPig.get((EntityPig) event.entity) == null)
			EntityPregnantPig.register((EntityPig) event.entity);
		
		if (event.entity instanceof EntitySheep && EntityPregnantSheep.get((EntitySheep) event.entity) == null)
			EntityPregnantSheep.register((EntitySheep) event.entity);
	}
	
	@SubscribeEvent
	public void onEntityLivingDeath(LivingDeathEvent event)
	{
		if (event.source.getEntity() instanceof EntityPlayerMP) 
		{
			  if (event.source.getEntity() instanceof EntityTRex)
			  { 
				  EntityTRex entity = (EntityTRex) event.entityLiving;
				  
				  entity.openMouth(true);
			
			  }
		 }   
	}
	
	
	@SubscribeEvent
	public void onEntityLiving(LivingUpdateEvent event)
	{
		this.rand = new Random();
		
		if (event.entityLiving instanceof EntityHorse)
		{
			EntityPregnantHorse props = EntityPregnantHorse.get((EntityHorse) event.entityLiving);
			
			if (props.Embryo != null)
			{	
		        ++props.EmbryoProgress;
		        this.getClass();

		        if (props.EmbryoProgress >= props.Embryo.GrowTime) //var10000 == 3000)
		        {
		        	GrowEntity(props.Embryo, event);
		            props.EmbryoProgress = 0;
		            props.SetEmbryo(null);
		        }
		        else
		        {
		            event.entityLiving.onLivingUpdate();
		        }
			}
		}
		
		if (event.entityLiving instanceof EntityCow)
		{
			EntityPregnantCow props = EntityPregnantCow.get((EntityCow) event.entityLiving);
			
			if (props.Embryo != null)
			{	
		        ++props.EmbryoProgress;
		        this.getClass();

		        if (props.EmbryoProgress >= props.Embryo.GrowTime) //var10000 == 3000)
		        {
		        	GrowEntity(props.Embryo, event);
		            props.EmbryoProgress = 0;
		            props.SetEmbryo(null);
		        }
		        else
		        {
		            event.entityLiving.onLivingUpdate();
		        }
			}
		}
		
		if (event.entityLiving instanceof EntityPig)
		{
			EntityPregnantPig props = EntityPregnantPig.get((EntityPig) event.entityLiving);
			
			if (props.Embryo != null)
			{	
		        ++props.EmbryoProgress;
		        this.getClass();

		        if (props.EmbryoProgress >= props.Embryo.GrowTime) //var10000 == 3000)
		        {
		        	GrowEntity(props.Embryo, event);
		            props.EmbryoProgress = 0;
		            props.SetEmbryo(null);
		        }
		        else
		        {
		            event.entityLiving.onLivingUpdate();
		        }
			}
		}
		
		if (event.entityLiving instanceof EntitySheep)
		{
			EntityPregnantSheep props = EntityPregnantSheep.get((EntitySheep) event.entityLiving);
			
			if (props.Embryo != null)
			{	
		        ++props.EmbryoProgress;
		        this.getClass();

		        if (props.EmbryoProgress >= props.Embryo.GrowTime) //var10000 == 3000)
		        {
		        	GrowEntity(props.Embryo, event);
		            props.EmbryoProgress = 0;
		            props.SetEmbryo(null);
		        }
		        else
		        {
		            event.entityLiving.onLivingUpdate();
		        }
			}
		}
	}
		
	public void GrowEntity(EnumAnimalType embryo, LivingUpdateEvent event)
	{
		float rnd = new Random().nextInt(100);
		Object birthEntity;
		switch (embryo)
		{
        case Pig:
            birthEntity = new EntityPig(event.entityLiving.worldObj);
            break;

        case Sheep:
            birthEntity = new EntitySheep(event.entityLiving.worldObj);
            break;

        case Cow:
            birthEntity = new EntityCow(event.entityLiving.worldObj);
            break;

        case Chicken:
            birthEntity = new EntityChicken(event.entityLiving.worldObj);
            break;
            
        case Horse:
    		if(event.entityLiving instanceof EntityHorse)
    		{  
	        	if(rnd < 1)
	        	{
	        		birthEntity = new EntityHorse(event.entityLiving.worldObj);
	        		((EntityHorse)birthEntity).setHorseType(3);
	                if (((EntityHorse) event.entityLiving).func_152119_ch() != null)
	                {
	        		((EntityHorse)birthEntity).func_152120_b(((EntityHorse) event.entityLiving).func_152119_ch());
	        		((EntityHorse)birthEntity).setHorseTamed(true);
	                }
	        		break;
	        	}
	        	else if(rnd < 2)
	        	{
	        		birthEntity = new EntityHorse(event.entityLiving.worldObj);
	        		((EntityHorse)birthEntity).setHorseType(4);
	                if (((EntityHorse) event.entityLiving).func_152119_ch() != null)
	                {
	        		((EntityHorse)birthEntity).func_152120_b(((EntityHorse) event.entityLiving).func_152119_ch());
	        		((EntityHorse)birthEntity).setHorseTamed(true);
	                }
	        		break;
	        	}
	        	else
	        	{
                	birthEntity = ((EntityHorse)event.entityLiving).createChild(new EntityHorse(event.entityLiving.worldObj));
	        	}
    		}
        	else
        	{
        		EntityHorse entityHorse = new EntityHorse(event.entityLiving.worldObj);
        		birthEntity = entityHorse.createChild(new EntityHorse(event.entityLiving.worldObj));
        	}
        	break;

        case Smilodon:
            birthEntity = new EntitySmilodon(event.entityLiving.worldObj).Imprinting(event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ);
            break;

        case Mammoth:
            birthEntity = (new EntityMammoth(event.entityLiving.worldObj)).Imprinting(event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ);
            break;
            
        case Elasmotherium:
            birthEntity = (new EntityElasmotherium(event.entityLiving.worldObj)).Imprinting(event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ);
            break;
            
        case Quagga:
            birthEntity = new EntityQuagga(event.entityLiving.worldObj);
            
            int d0 = (int)(event.entityLiving.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + ((EntityQuagga)birthEntity).getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + (int)((EntityQuagga)birthEntity).randomHealthStat());
            ((EntityQuagga)birthEntity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(d0 / 3.0D);
            double d2 = event.entityLiving.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + ((EntityQuagga)birthEntity).getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + ((EntityQuagga)birthEntity).randomSpeedStat();
            ((EntityQuagga)birthEntity).getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(d2 / 3.0D);
            break;

        default:
            birthEntity = new EntityPig(event.entityLiving.worldObj);
		}
	
	    ((EntityAnimal)birthEntity).setGrowingAge(-24000);
	    ((EntityAnimal)birthEntity).setLocationAndAngles(event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, event.entityLiving.rotationYaw, event.entityLiving.rotationPitch);
	
	    for (int var3 = 0; var3 < 7; ++var3)
	    {
	        double var4 = this.rand.nextGaussian() * 0.02D;
	        double var6 = this.rand.nextGaussian() * 0.02D;
	        double var8 = this.rand.nextGaussian() * 0.02D;
	        event.entityLiving.worldObj.spawnParticle("heart", event.entityLiving.posX + (double)(this.rand.nextFloat() * event.entityLiving.width * 2.0F) - (double)event.entityLiving.width, event.entityLiving.posY + 0.5D + (double)(this.rand.nextFloat() * event.entityLiving.height), event.entityLiving.posZ + (double)(this.rand.nextFloat() * event.entityLiving.width * 2.0F) - (double)event.entityLiving.width, var4, var6, var8);
	    }
	
	    if (!event.entityLiving.worldObj.isRemote)
	    {
	        event.entityLiving.worldObj.spawnEntityInWorld((Entity)birthEntity);
		}
	}
	
}
