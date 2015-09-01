package com.github.revival.common.entity.ai;

import com.github.revival.common.entity.mob.EntityDinosaur;
import com.github.revival.common.enums.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.Vec3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DinoHerd
{

    /**
     * TODO
     * -Way to start a dino herd
     * -Specific code fore each mode
     * -Figure out how to do general direction wandering (bodies of water, biome specific, etc)
     */

    public static final int MODE_IDLE = 0;
    public static final int MODE_WANDER = 1;
    public static final int MODE_ATTACK = 2;
    public static final int MODE_CHASE = 3;
    public static final int MODE_DISPERSE = 4;

    private ArrayList<EntityDinosaur> herdDinos;
    private ArrayList<EntityLiving> targets;
    private ArrayList<EntityLiving> longTermTargets;
    private EntityDinosaur leader;
    private EnumPrehistoric dinoType;
    private float awarenessRadius;
    private float wanderRadius;
    private float heightAwareness;
    private float immediateAwarenessRadius;
    private float averageSize;
    private float averageAge;
    private float totalSize;
    private int maxHerdSize;
    private int maxTargets;
    private int totalAge;
    private int mode;
    private boolean carnivorous = false;
    private boolean fleeFromLarger = false;
    private boolean allowMultipleSpecies = false;
    private boolean allowCarnivoreHerbivoreMixing = false;

    private Vec3 generalTarget;
    private Entity fleeFrom;

    private Comparator<EntityLiving> comparatorDistanceFromLeader = new Comparator<EntityLiving>()
    {
        @Override
        public int compare(EntityLiving arg0, EntityLiving arg1)
        {
            return (int) (entityDistance(leader, arg0) - entityDistance(leader, arg1));
        }

    };

    public DinoHerd(EnumPrehistoric dinoType, int maxHerdSize, int maxTargets, float awarenessRadius, float immediateAwarenessRadius, float wanderRadius, float heightAwareness)
    {
        herdDinos = new ArrayList<EntityDinosaur>();
        this.dinoType = dinoType;
        this.carnivorous = dinoType.isCarnivore();
        this.maxHerdSize = maxHerdSize;
        this.maxTargets = maxTargets;
        this.awarenessRadius = awarenessRadius;
        this.wanderRadius = wanderRadius;
        this.immediateAwarenessRadius = immediateAwarenessRadius;
    }

    public DinoHerd(EnumPrehistoric dinoType, int maxHerdSize, int maxTargets, float awarenessRadius, float wanderRadius)
    {
        this(dinoType, maxHerdSize, maxTargets, awarenessRadius, awarenessRadius / 2, wanderRadius, 5.0F + awarenessRadius / 5);
    }

    /**
     * Adds a dinosaur to the herd
     *
     * @param dino The dinosaur to add
     * @return True if the dinosaur was added to the herd
     */
    public boolean addDinoToHerd(EntityDinosaur dino)
    {
        // Don't add if the herd is full
        if (herdDinos.size() >= maxHerdSize)
        {
            return false;
        }
        if (!dino.SelfType.equals(dinoType))
        {
            if (!allowMultipleSpecies || (!allowCarnivoreHerbivoreMixing && dino.SelfType.isCarnivore() != carnivorous))
            {
                return false;
            }
        }
        if (!herdDinos.contains(dino))
        {
            herdDinos.add(dino);
            updateHerdData();
            return true;
        }
        return false;
    }

    public void removeDinoFromHerd(EntityDinosaur dino)
    {
        if (herdDinos.contains(dino))
        {
            herdDinos.remove(dino);
            updateHerdData();
        }
    }

    /**
     * Updates the herd data and leader
     */
    public void updateHerdData()
    {
        totalAge = 0;
        totalSize = 0.0F;
        int maxAge = 0;
        EntityDinosaur oldest = null;
        for (int i = 0; i < herdDinos.size(); i++)
        {
            EntityDinosaur dino = herdDinos.get(i);
            totalAge += dino.getAge();
            totalSize += dino.getDinosaurSize();
            if (dino.getAge() > maxAge)
            {
                maxAge = dino.getAge();
                oldest = dino;
            }
        }
        leader = oldest;
        averageAge = ((float) totalAge) / herdDinos.size();
        averageSize = totalSize / herdDinos.size();
    }

    /**
     * Updates the herd movements and strategies
     */
    public void updateHerd()
    {
        updateHerdData();
        if (this.fleeFromLarger && shouldDisperse())
        {
            mode = MODE_DISPERSE;
        }
        else
        {
            if (carnivorous)
            {
                removeDeadTargets();
                updateTargets();
                if (targets.isEmpty())
                {
                    if (((double) leader.getHunger()) / leader.getMaxHunger() < 0.5)
                    {
                        mode = MODE_WANDER;
                    }
                    else
                    {
                        mode = MODE_IDLE;
                    }
                }
                else
                {
                    if (targets.size() < herdDinos.size() / 2)
                    {
                        mode = MODE_CHASE;
                    }
                    else
                    {
                        mode = MODE_ATTACK;
                    }
                }
            }
            else
            {
                if (((double) leader.getHunger()) / leader.getMaxHunger() < 0.5)
                {
                    mode = MODE_WANDER;
                }
                else
                {
                    mode = MODE_ATTACK;
                }
            }
        }
    }

    /**
     * AI for herd idling, the dinosaur equivalent to grazing
     */
    public void modeIdle()
    {

    }

    /**
     * AI for herd wandering
     */
    public void modeWander()
    {

    }

    /**
     * AI for herd attack
     */
    public void modeAttack()
    {

    }

    /**
     * AI for herd chase
     */
    public void modeChase()
    {

    }

    /**
     * AI for herd disperse
     */
    public void modeDisperse()
    {

    }

    /**
     * Checks surrounding dinosaurs to see if they are large and carnivorous
     *
     * @return If the herd should disperse
     */
    public boolean shouldDisperse()
    {
        boolean toDisperse = false;
        for (Object tempEntity : leader.worldObj.loadedEntityList)
        {
            if (tempEntity instanceof EntityDinosaur)
            {
                EntityDinosaur tempDino = (EntityDinosaur) tempEntity;
                if (leader.SelfType.isCarnivore())
                {
                    if (tempDino.SelfType.isCarnivore() && tempDino.getDinosaurSize() > leader.getDinosaurSize() + averageSize && tempDino.getAge() > leader.getAge() + averageAge)
                    {
                        toDisperse = true;
                    }
                }
                else
                {
                    if (tempDino.SelfType.isCarnivore() && tempDino.getDinosaurSize() > (leader.getDinosaurSize() + averageSize) / 2 && tempDino.getAge() > (leader.getAge() + averageAge) / 2)
                    {
                        toDisperse = true;
                    }
                }

            }
        }
        return toDisperse;
    }

    /**
     * Removes dead targets.  Always call before calling updateTargets();
     */
    public void removeDeadTargets()
    {
        // Removes any dead targets
        for (int i = 0; i < targets.size(); i++)
        {
            if (targets.get(i).isDead)
            {
                targets.remove(i);
            }
        }
        for (int i = 0; i < longTermTargets.size(); i++)
        {
            if (longTermTargets.get(i).isDead)
            {
                longTermTargets.remove(i);
            }
        }
    }

    /**
     * Updates the targets of the herd
     */
    public void updateTargets()
    {
        if (leader.SelfType.isHerbivore())
        {
            return;
        }
        // An array list to store all possible targets
        ArrayList<EntityLiving> possibleTargets = new ArrayList<EntityLiving>();
        // Loops through every entity in the world
        for (Object tempEntity : leader.worldObj.loadedEntityList)
        {
            // Don't target entities in the herd
            if (herdDinos.contains(tempEntity))
            {
                continue;
            }
            // The distance between the entity and the leader
            float distance;
            // Temp variable to reduce typecasting
            EntityLiving tempEntityLiving;
            // Checks if it is a living entity and if it is within the awareness radius
            if (tempEntity instanceof EntityLiving && (distance = entityDistance(tempEntityLiving = (EntityLiving) tempEntity, leader)) < awarenessRadius && Math.abs(tempEntityLiving.posZ - leader.posZ) < heightAwareness)
            {
                // Add if it is not already a target and it is within the immediate awareness radius or visible to the leader
                if (!targets.contains(tempEntity) && (distance < immediateAwarenessRadius || leader.worldObj.rayTraceBlocks(Vec3.createVectorHelper(leader.posX, leader.posY, leader.posZ),
                        Vec3.createVectorHelper(tempEntityLiving.posX, tempEntityLiving.posY, tempEntityLiving.posZ)) == null))
                {
                    // Add to the list of possible targets
                    possibleTargets.add((EntityLiving) tempEntity);
                }
            }
        }
        // Temp storage for the past targets
        ArrayList<EntityLiving> pastTargets = new ArrayList<EntityLiving>();
        // If there are more possible targets and past targets than the max targets
        if (possibleTargets.size() + targets.size() > maxTargets)
        {
            // Add all targets to the possible targets list
            possibleTargets.addAll(targets);
            // Add all targets to the past targets list
            pastTargets.addAll(targets);
            // Clear the targets list
            targets.clear();
        }
        // Sort the possible targets by distance from the leader
        Collections.sort(possibleTargets, comparatorDistanceFromLeader);
        // The number of targets to choose
        int targetsToChoose = Math.min(maxTargets, possibleTargets.size());
        // Add the targets
        for (int i = 0; i < targetsToChoose; i++)
        {
            targets.add(possibleTargets.get(i));
            if (longTermTargets.contains(possibleTargets.get(i)))
            {
                longTermTargets.remove(possibleTargets.get(i));
            }
        }
        // Add only the remaining targets that were previously targets to the long term targets list
        for (int i = targetsToChoose; i < possibleTargets.size(); i++)
        {
            if (pastTargets.contains(possibleTargets.get(i)) && !longTermTargets.contains(possibleTargets.get(i)))
            {
                longTermTargets.add(possibleTargets.get(i));
            }
        }
        // If there is room for long term targets add the nearest ones
        if (targets.size() < maxTargets && !longTermTargets.isEmpty())
        {
            Collections.sort(longTermTargets, comparatorDistanceFromLeader);
            for (int i = 0; i < maxTargets - targets.size(); i++)
            {
                if (!longTermTargets.isEmpty())
                {
                    targets.add(longTermTargets.get(0));
                    longTermTargets.remove(0);
                }
                else
                {
                    break;
                }
            }
        }
    }

    /**
     * Get the distance between entities
     *
     * @param e1 First entity
     * @param e2 Second entity
     * @return The distance between entities
     */
    private float entityDistance(Entity e1, Entity e2)
    {
        return (float) Math.sqrt(Math.pow(e1.posX - e2.posX, 2) + Math.pow(e1.posY - e2.posY, 2));
    }

    public void setFleeFromLarger(boolean flee)
    {
        fleeFromLarger = flee;
    }

    public boolean fleesFromLarger()
    {
        return fleeFromLarger;
    }

    public EntityDinosaur getLeader()
    {
        return leader;
    }

}
