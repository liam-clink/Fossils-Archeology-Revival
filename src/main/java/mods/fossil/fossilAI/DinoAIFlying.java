package mods.fossil.fossilAI;

//=============
//  IMPORTS
//=============

//Parent class
import java.util.Random;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import mods.fossil.client.FossilOptions;
import mods.fossil.entity.mob.EntityFlyingDino;
import mods.fossil.fossilEnums.EnumOrderType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.entity.ai.RandomPositionGenerator;

//=============
//  CLASSES
//=============

public class DinoAIFlying extends EntityAIBase {

	// =============
	// CONSTANTS
	// =============
	public enum eFlyingState {
		FS_ON_GROUND, FS_IN_AIR, FS_ASCENDING, FS_DESCENDING
	};

	private final float DESTINATION_HEIGHT_MULTIPLIER = 0.25f;
	private final float MAX_DESTINATION_HEIGHT = 30.0f;
	private final float SPEED_ASCENDING = 0.05f;
	private final float SPEED_IN_AIR = 0.1f;
	private final int REASSESS_THRESHOLD = 1;
	private final int REASSESS_BASE = 1;
	private final float MOTION_VECTOR_SCALE = 100.0f;
	private final double WANDER_RADIUS = 10.0;

	// =============
	// CLASS MEMBERS
	// =============
	protected EntityFlyingDino dinoAgent = null;
	public static eFlyingState currentState = eFlyingState.FS_ON_GROUND;
	protected eFlyingState previousState = eFlyingState.FS_ON_GROUND;
	protected boolean isAscending = false;
	private double takeOffInitialHeight = 0;
	private double takeOffDestinationHeight = 0;
	private Vec3 wanderDestination = null;
	private static Vec3 motionVector = Vec3.createVectorHelper(0.0D, 0.0D,
			0.0D);;
	private int m_nReassessAt = 1;
	private int m_nReassessTicker = 0;

	// =============
	// CONSTRUCTOR
	// =============
	public DinoAIFlying(EntityFlyingDino Dinosaur) {
		dinoAgent = Dinosaur;
		m_nReassessTicker = REASSESS_THRESHOLD;
	}

	// =============
	// OVERRIDES
	// =============
	/**
	 * Determines if we need to execute this task.
	 */
	@Override
	public boolean shouldExecute() {
		if (dinoAgent.isAdult()) {
			return true;
		}
		
		if(FossilOptions.Allow_Flying = true) {
			return true;
		}

		if (dinoAgent.IsHungry()) {
			return false;
		}
		
		if(!dinoAgent.OrderStatus.equals(dinoAgent.OrderStatus.FreeMove)) {
			return false;
		}	
		return true;
	}

	/**
	 * Updates the task.
	 */
	public void updateTask() {
		// ========================================================
		// There are four states which the dino can be in:
		// 1. On Ground
		// 2. In Air
		// 3. Ascending
		// 4. Descending
		// ========================================================

		// Find out which state we're in and process that one.
		switch (currentState) {
		case FS_ASCENDING:
			ProcessAscending();
			break;

		case FS_DESCENDING: 
			ProcessDescending();
			break;

		case FS_IN_AIR: 
			ProcessInAir();
			break;

		case FS_ON_GROUND:
			ProcessOnGround();
			break;
		default:
			break;

		}
	}

	// =============
	// INTERNAL
	// =============
	private boolean SetTakeOffData() {
		if(!dinoAgent.OrderStatus.equals(dinoAgent.OrderStatus.FreeMove)) {
			return false;
		}	
		if(currentState == eFlyingState.FS_IN_AIR) {
			return false;
		}
		if (currentState != eFlyingState.FS_ASCENDING) {
			takeOffInitialHeight = dinoAgent.posY;
			takeOffDestinationHeight = dinoAgent.posY
					+ DESTINATION_HEIGHT_MULTIPLIER * dinoAgent.getAge();

			if (takeOffDestinationHeight > MAX_DESTINATION_HEIGHT) {
				takeOffDestinationHeight = MAX_DESTINATION_HEIGHT;
			}

			previousState = currentState;
			currentState = eFlyingState.FS_ASCENDING;
			dinoAgent.SetInWater(true);
		}

		return false;
	}

	private boolean ProcessOnGround() {
			Random randy = new Random();
			int rand = randy.nextInt(100);
			if(rand >= 50) {
			this.SetTakeOffData();
			return true;
			} else {
		return false;
			}
	}

	// Basically a wander
	private boolean ProcessInAir() {
		++m_nReassessTicker;
		if (m_nReassessTicker >= m_nReassessAt) {

			Random rand = new Random();

			motionVector.xCoord = dinoAgent.motionX
					* MOTION_VECTOR_SCALE;
			motionVector.yCoord = dinoAgent.motionY
					* MOTION_VECTOR_SCALE;
			motionVector.zCoord = dinoAgent.motionZ
					* MOTION_VECTOR_SCALE;

			wanderDestination = RandomPositionGenerator
					.findRandomTargetBlockTowards(this.dinoAgent, 5, 10,
							motionVector);

			if (wanderDestination == null) {
				// We'll just chill here for now.
				return false;
			}

			// Make sure the block is not on the ground.
			if (dinoAgent.worldObj.getHeightValue(
					(int) wanderDestination.xCoord,
					(int) wanderDestination.zCoord) + 1 > wanderDestination.yCoord) {
				wanderDestination.yCoord += 3;
			}

			m_nReassessAt = rand.nextInt(REASSESS_THRESHOLD) + REASSESS_BASE;
			m_nReassessTicker = 0;
		}

		// Always try to move to your new destination
		dinoAgent.FlyToPoint(wanderDestination, SPEED_IN_AIR);

		return true;
	}

	private boolean ProcessAscending() {
		// Fly
		if (dinoAgent.posY < takeOffDestinationHeight) {
			dinoAgent.FlyToPoint((float) dinoAgent.posX,
					(float) takeOffDestinationHeight,
					(float) dinoAgent.posZ, dinoAgent.getAge()
							* SPEED_ASCENDING);
		} else {
			previousState = currentState;
			currentState = eFlyingState.FS_IN_AIR;
		}

		dinoAgent.isAirBorne = true;
		// dinoAgent
		return true;
	}

	private boolean ProcessDescending() {
		previousState = currentState;
		dinoAgent.motionY =- 1;
		currentState = eFlyingState.FS_DESCENDING;
		dinoAgent.isAirBorne = false;
		return true;
	}

	// ==============
	// ACCESSORS
	// ==============
	public eFlyingState GetCurrentState() {
		return currentState;
	}

}