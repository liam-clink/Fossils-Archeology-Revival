package mods.fossil.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityPrehistoric extends EntityTameable {
	
	
	//TODO: Move all the datawatchers here for easy access
    // data value IDs
	
    protected static final int INDEX_FLYING = 18;
    protected static final int INDEX_CAN_FLY = 19;
    
    protected static final ResourceLocation pediaclock = new ResourceLocation("fossil:textures/gui/PediaClock.png");
    protected static final ResourceLocation pediafood = new ResourceLocation("fossil:textures/gui/PediaFood.png");
    protected static final ResourceLocation pediaheart = new ResourceLocation("fossil:textures/gui/PediaHeart.png");
    

	public EntityPrehistoric(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
	}
	
    /**
     * Override this and set temporary variables to the attributes.
     */
    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(19.0D);
        getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        setBaseValues();
    }
    
    /**
     * Overrided in unique entity classes.
     */
    private void setBaseValues()
    {
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
        getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
        getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
        
    }

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		// TODO Auto-generated method stub
		return null;
	}

    public EntityPlayer getRidingPlayer()
    {
        if (riddenByEntity instanceof EntityPlayer)
        {
            return (EntityPlayer) riddenByEntity;
        }
        else
        {
            return null;
        }
    }

    /**
     * Returns true if the entity is flying.
     */
    public boolean isFlying() {
        return (dataWatcher.getWatchableObjectByte(INDEX_FLYING) & 1) != 0;
    }
    
}
