package fossilsarcheology.server.entity.mob.projectile;

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

    public EntityAncientJavelin(World world) {
        super(world);
    }

    public EntityAncientJavelin(World world, double x, double y, double z) {
        super(world, pos);
    }

    public EntityAncientJavelin(World world, EntityPlayer player, float var3, ToolMaterial material, int damaged) {
        super(world, player, var3, material, damaged);
        this.material = material;
        this.damaged = damaged;
    }

    public EntityAncientJavelin(World var1, EntityLiving var2, float var3) {
        super(var1, var2, var3);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setBoolean("lighteningShot", this.lighteningShot);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        if (compound.hasKey("lighteningShot")) {
            this.lighteningShot = compound.getBoolean("lighteningShot");
        }
    }

    @Override
    public void onUpdate() {
        if (this.inGround && !this.lighteningShot) {
            if ((new Random()).nextInt(100) < 30) {
                this.worldObj.addWeatherEffect(new EntityLightningBolt(this.worldObj, this.posX, this.posY, this.posZ, false));
            }

            this.lighteningShot = true;
        }

        super.onUpdate();
    }

    @Override
    protected boolean addJavelinToPlayer(EntityPlayer player) {
        ItemStack stack = new ItemStack(FAItemRegistry.INSTANCE.ancientJavelin, 1);
        stack.setItemDamage(stack.getMaxDamage() - damaged);
        return player.inventory.addItemStackToInventory(stack);
    }
}
