package mods.fossil.entity.mob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import mods.fossil.client.gui.GuiPedia;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityPrehistoric extends EntityTameable {
    
    protected static final ResourceLocation pediaclock = new ResourceLocation("fossil:textures/gui/PediaClock.png");
    protected static final ResourceLocation pediafood = new ResourceLocation("fossil:textures/gui/PediaFood.png");
    protected static final ResourceLocation pediaheart = new ResourceLocation("fossil:textures/gui/PediaHeart.png");
    

	public EntityPrehistoric(World par1World) {
		super(par1World);
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

    @SideOnly(Side.CLIENT)
    public void ShowPedia2(GuiPedia p0, String mobName)
    {
    	p0.reset();
		p0.AddStringLR("", 150, false);
		String translatePath = "assets/fossil/dinopedia/" + Minecraft.getMinecraft().gameSettings.language +"/";
		String bioFile = String.valueOf(mobName) + ".txt";
		
		if(getClass().getClassLoader().getResourceAsStream( translatePath ) == null)
		{
			translatePath = "assets/fossil/dinopedia/" + "en_US" + "/";
		}

    	if(getClass().getClassLoader().getResourceAsStream( translatePath + bioFile ) != null)
    	{
			InputStream fileReader = getClass().getClassLoader().getResourceAsStream( translatePath + bioFile );
			try {
			BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(fileReader));
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				GL11.glPushMatrix();
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				p0.AddStringLR(line, 150, false);
				GL11.glPopMatrix();
			}
			fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	else
    	{
    		p0.AddStringLR("File not found.", false);
			GL11.glPushMatrix();
			GL11.glScalef(0.5F, 0.5F, 0.5F);
    		p0.AddStringLR(translatePath + bioFile, 150, false);
			GL11.glPopMatrix();
    	}
    }
    
}
