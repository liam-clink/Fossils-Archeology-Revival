package fossilsarcheology.server.item;

import fossilsarcheology.server.entity.EntityAnuLightning;
import fossilsarcheology.server.entity.mob.EntityFriendlyPigZombie;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class AncientSwordItem extends ItemSword {
    public AncientSwordItem(ToolMaterial var2) {
        super(var2);
        this.maxStackSize = 1;
        this.setMaxDamage(250);
    }

    public AncientSwordItem() {
        this(ToolMaterial.IRON);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase attacked, EntityLivingBase attacker) {
        if (attacker instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) attacker;
            if (this.checkHelmet(player)) {
                if (attacked != null && (attacked instanceof EntityPig || attacked instanceof EntityPigZombie)) {
                    if (!attacked.worldObj.isRemote) {
                        EntityFriendlyPigZombie friendlyPigZombie = new EntityFriendlyPigZombie(attacked.worldObj);
                        friendlyPigZombie.setLocationAndAngles(attacked.posX, attacked.posY, attacked.posZ, attacked.rotationYaw, attacked.rotationPitch);
                        attacked.worldObj.spawnEntityInWorld(friendlyPigZombie);
                        friendlyPigZombie.setOwnerId(player.getUniqueID());
                        friendlyPigZombie.sendMessageToOwner("pigman.summon");
                        friendlyPigZombie.setTamed(true);
                        attacked.worldObj.spawnEntityInWorld(friendlyPigZombie);
                        attacked.setDead();
                        attacked.worldObj.spawnEntityInWorld(new EntityLightningBolt(attacked.worldObj, attacked.posX, attacked.posY, attacked.posZ, false));
                    }
                } else if (attacked != null && attacked.worldObj.rand.nextInt(5) == 0) {
                    attacked.worldObj.addWeatherEffect(new EntityAnuLightning(attacked.worldObj, attacked.posX, attacked.posY, attacked.posZ));
                }
            }
            stack.damageItem(1, attacker);
        }
        return true;
    }

    private boolean checkHelmet(EntityPlayer player) {
        ItemStack item = player.inventory.armorInventory[3];
        if (item != null) {
            if (item.getItem() == FAItemRegistry.INSTANCE.ancienthelmet) {
                return true;
            }
        }
        return false;
    }
}
