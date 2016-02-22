package com.github.revival.common.entity.mob;

import net.minecraft.item.Item;
import net.minecraft.world.World;


public class EntityNautilus extends EntityFishBase {

    public EntityNautilus(World par1World) {
        super(par1World);
    }

    @Override
    public String getItemTexture() {
        return "fossil:textures/items/Nautilus_Meat.png";
    }

    @Override
    public String getTexture() {
        return "fossil:textures/mob/fish/nautilus.png";
    }

    @Override
    public void spawnBaby(int i) {

    }

    @Override
    public String getName() {
        return "Nautilus";
    }

    @Override
    public String getCodeName() {
        return "entity.nautilus.name";
    }

    @Override
    public Item getItem() {
        return (Item) null;
    }

}
