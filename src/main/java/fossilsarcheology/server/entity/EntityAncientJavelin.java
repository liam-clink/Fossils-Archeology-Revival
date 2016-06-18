package fossilsarcheology.server.entity;

import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.Random;

public class EntityAncientJavelin extends EntityJavelin {
    private boolean lighteningShot = false;

    public EntityAncientJavelin(World var1) {
        super(var1);
    }

    public EntityAncientJavelin(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6);
    }

    public EntityAncientJavelin(World var1, EntityPlayer var32, float var3, ToolMaterial var4, int damagevalue) {
        super(var1, var32, var3, var4, damagevalue);
        this.SelfMaterial = var4;
        this.damaged = damagevalue;
    }

    public EntityAncientJavelin(World var1, EntityLiving var2, float var3) {
        super(var1, var2, var3);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound var1) {
        super.writeEntityToNBT(var1);
        var1.setBoolean("lighteningShot", this.lighteningShot);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound var1) {
        super.readEntityFromNBT(var1);

        if (var1.hasKey("lighteningShot")) {
            this.lighteningShot = var1.getBoolean("lighteningShot");
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        if (this.inGround && !this.lighteningShot) {
            if ((new Random()).nextInt(100) < 30) {
                this.worldObj.addWeatherEffect(new EntityLightningBolt(this.worldObj, this.posX, this.posY, this.posZ));
            }

            this.lighteningShot = true;
        }

        super.onUpdate();
    }

    @Override
    protected boolean addJavelinToPlayer(EntityPlayer var1) {
        ItemStack var2 = new ItemStack(FAItemRegistry.INSTANCE.ancientJavelin, 1);
        var2.setItemDamage(var2.getMaxDamage() - damaged);
        return var1.inventory.addItemStackToInventory(var2);
    }
}
