package mods.fossil.entity.mob;
 
import io.netty.buffer.ByteBuf;
import mods.fossil.fossilEnums.EnumDinoType;
import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.util.Vec3;;
 
public class EntityFlyingDino extends EntityDinosaur
{
    // =============
    // CONSTANTS
    // =============
    final private float     FLY_TO_POINT_BASE_SPEED = 0.25f;
    final private float     FLY_TO_POINT_SPEED = 0.05f;
    final private float     FLY_TO_POINT_MAX_SPEED = 20.0f;
     
    // =============
    // MEMBERS
    // =============
    private float           m_fFlightDestinationX = 0;
    private float           m_fFlightDestinationY = 0;
    private float           m_fFlightDestinationZ = 0;
    private float           m_fCurrentFlightSpeed = 0;
     
    // =============
    // CLASS METHODS
    // =============
     
    public EntityFlyingDino( World _TheWorld, EnumDinoType _DinoType )
    {
        super( _TheWorld, _DinoType );
 
        this.getNavigator().setCanSwim(true);
    }
     
     /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall( float par1 )
    {
        // Intentionally left blank.        
    }
     
     /**
     * Takes in the distance the entity has fallen this tick and whether its on the ground to update the fall distance
     * and deal fall damage if landing on the ground.  Args: distanceFallenThisTick, onGround
     */
    protected void updateFallState(double par1, boolean par3)
    {
        // Intentionally left blank.
    }
 
    /**
     * Moves the entity based on the specified heading.  Args: strafe, forward
     *
     *  !!!Copied directly from EntityFlying.java!!!
     */
    public void moveEntityWithHeading(float par1, float par2)
    {
        if (this.isInWater())
        {
            this.moveFlying(par1, par2, 0.02F);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.800000011920929D;
            this.motionY *= 0.800000011920929D;
            this.motionZ *= 0.800000011920929D;
        }
        else if (this.handleLavaMovement())
        {
            this.moveFlying(par1, par2, 0.02F);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5D;
            this.motionY *= 0.5D;
            this.motionZ *= 0.5D;
        }
        else
        {
            float f2 = 0.91F;
 
            if (this.onGround)
            {
                f2 = 0.54600006F;
                int i = this.worldObj.getBlockMetadata(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ));
                if (i > 0)
                {
                	f2 = 0.54600006F;
                }
            }
 
            float f3 = 0.16277136F / (f2 * f2 * f2);
            this.moveFlying(par1, par2, this.onGround ? 0.1F * f3 : 0.02F);
            f2 = 0.91F;
 
            if (this.onGround)
            {
                f2 = 0.54600006F;
                int j = this.worldObj.getBlockMetadata(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ));
 
                if (j > 0)
                {
                	f2 = 0.54600006F;
                }
            }
 
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)f2;
            this.motionY *= (double)f2;
            this.motionZ *= (double)f2;
        }
 
        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d0 = this.posX - this.prevPosX;
        double d1 = this.posZ - this.prevPosZ;
        float f4 = MathHelper.sqrt_double(d0 * d0 + d1 * d1) * 4.0F;
 
        if (f4 > 1.0F)
        {
            f4 = 1.0F;
        }
 
        this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;
    }
     
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
 
        // Update flight.
       // if( this.isAirBorne )
        {
            //if( this.worldObj.isAirBlock( (int)m_fFlightDestinationX, (int)m_fFlightDestinationY, (int)m_fFlightDestinationZ ) == false  )
            //{
            //  return;
            //}
             
            double dToDestX = m_fFlightDestinationX - posX;
            double dToDestY = m_fFlightDestinationY - posY;
            double dToDestZ = m_fFlightDestinationZ - posZ;
            double dToDestDotProduct = dToDestX * dToDestX + dToDestY * dToDestY + dToDestZ * dToDestZ;
             
            dToDestDotProduct = (double)MathHelper.sqrt_double( dToDestDotProduct );
 
            if( isCourseTraversable( dToDestX, dToDestY, dToDestZ, dToDestDotProduct) )
            { 
                float fFlightSpeed = m_fCurrentFlightSpeed + FLY_TO_POINT_BASE_SPEED;
                 
                if( fFlightSpeed > FLY_TO_POINT_MAX_SPEED )
                {
                    fFlightSpeed = FLY_TO_POINT_MAX_SPEED;
                }
                 
                motionX = (dToDestX / dToDestDotProduct) * fFlightSpeed;
                motionY = (dToDestY / dToDestDotProduct) * fFlightSpeed;
                motionZ = (dToDestZ / dToDestDotProduct) * fFlightSpeed;
                             
                float f = (float)(Math.atan2( motionZ, motionX ) * 180.0D / Math.PI) - 90.0F;
                float f1 = MathHelper.wrapAngleTo180_float( f - rotationYaw );
                //m_edDinoAgent.moveForward = 0.5F;
                rotationYaw += f1;
            }
             
        }
         
         
    }
     
    /*
    * True if the ghast has an unobstructed line of travel to the waypoint.
    */
   private boolean isCourseTraversable(double _X, double _Y, double _Z, double Dot )
   {
       double d4 = ( _X - posX) / Dot;
       double d5 = ( _Y - posY) / Dot;
       double d6 = ( _Z - posZ) / Dot;
       AxisAlignedBB axisalignedbb = boundingBox.copy();
 
       for (int i = 1; (double)i < Dot; ++i)
       {
           axisalignedbb.offset(d4, d5, d6);
 
           if ( worldObj.getCollidingBoundingBoxes( this, axisalignedbb ).isEmpty() == false)
           {
               return false;
           }
       }
 
       return true;
   }
 
     
    public boolean FlyToPoint( float _X, float _Y, float _Z, float _fSpeed )
    {
        if( this.worldObj.isAirBlock( (int)_X, (int)_Y, (int)_Z ) == false  )
        {
            return false;
        }
         
        m_fFlightDestinationX = _X;
        m_fFlightDestinationY = _Y;
        m_fFlightDestinationZ = _Z;
        m_fCurrentFlightSpeed = _fSpeed;
         
        return true;
    }
 
    public boolean FlyToPoint( Vec3 _vPoint, float _fSpeed )
    {
        if( _vPoint == null )
        {
            return false;
        }
         
        boolean bResult = FlyToPoint( (float)_vPoint.xCoord, (float)_vPoint.yCoord, (float)_vPoint.zCoord, _fSpeed );
         
        return bResult;
    }
     
    // =====================
    // ACCESSORS & MODIFIERS
    // =====================
     
    public void SetInWater( boolean _bInWater )
    {
        this.inWater = _bInWater;       
         
    }
     
    public void SetAirborne( boolean _bAirborne )
    {
        this.isAirBorne = _bAirborne;
    }

	@Override
	public void writeSpawnData(ByteBuf buffer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readSpawnData(ByteBuf additionalData) {
		// TODO Auto-generated method stub
		
	}
     
}