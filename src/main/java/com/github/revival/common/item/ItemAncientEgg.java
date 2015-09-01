package com.github.revival.common.item;

import com.github.revival.common.entity.EntityDinoEgg;
import com.github.revival.common.entity.mob.EntityNautilus;
import com.github.revival.common.enums.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class ItemAncientEgg extends Item
{
    public static final int TypeCount = EnumPrehistoric.values().length;
    private int DinoType;

    public ItemAncientEgg(int DinoType0)
    {
        super();
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.DinoType = DinoType0;
    }

}
