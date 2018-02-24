.. java:import:: com.ctre.phoenix.motorcontrol.can WPI_TalonSRX

.. java:import:: edu.wpi.first.wpilibj DoubleSolenoid

.. java:import:: edu.wpi.first.wpilibj.command PIDSubsystem

.. java:import:: edu.wpi.first.wpilibj.drive DifferentialDrive

.. java:import:: org.usfirst.frc.team1701.robot RobotMap

.. java:import:: org.usfirst.frc.team1701.robot.commands TeleopDrive

.. java:import:: com.kauailabs.navx.frc AHRS

DriveTrain
==========

.. java:package:: org.usfirst.frc.team1701.robot.subsystems
   :noindex:

.. java:type:: public class DriveTrain extends PIDSubsystem

Constructors
------------
DriveTrain
^^^^^^^^^^

.. java:constructor:: public DriveTrain()
   :outertype: DriveTrain

Methods
-------
getAutoGear
^^^^^^^^^^^

.. java:method:: public boolean getAutoGear()
   :outertype: DriveTrain

   Get the state of the the auto gear

   :return: this.autoGear

getEncoderDistance
^^^^^^^^^^^^^^^^^^

.. java:method:: public double getEncoderDistance()
   :outertype: DriveTrain

getLeftDistance
^^^^^^^^^^^^^^^

.. java:method:: public double getLeftDistance()
   :outertype: DriveTrain

   Return left distance.

   :return: double of left side distance.

getLeftVelocity
^^^^^^^^^^^^^^^

.. java:method:: public int getLeftVelocity()
   :outertype: DriveTrain

   Return left velocity.

   :return: int of left side velocity.

getPrecise
^^^^^^^^^^

.. java:method:: public boolean getPrecise()
   :outertype: DriveTrain

   Return boolean of precise mode.

   :return: boolean of precise mode.

getReverse
^^^^^^^^^^

.. java:method:: public boolean getReverse()
   :outertype: DriveTrain

   Get status of reverse mode.

   :return: boolean of reverse mode

getRightDistance
^^^^^^^^^^^^^^^^

.. java:method:: public double getRightDistance()
   :outertype: DriveTrain

   Get right side distance.

   :return: double of right side distance.

getRightVelocity
^^^^^^^^^^^^^^^^

.. java:method:: public int getRightVelocity()
   :outertype: DriveTrain

   Get right velocity.

   :return: int of right side velocity.

initDefaultCommand
^^^^^^^^^^^^^^^^^^

.. java:method:: public void initDefaultCommand()
   :outertype: DriveTrain

   Initialize the default command for this subsystem.

leftDriveControl
^^^^^^^^^^^^^^^^

.. java:method:: public void leftDriveControl(double inputSpeed)
   :outertype: DriveTrain

   Run both left side motors at specified speed.

   :param inputSpeed: -1 to 1; full reverse to full speed ahead.

resetEncoders
^^^^^^^^^^^^^

.. java:method:: public void resetEncoders()
   :outertype: DriveTrain

   Reset both encoders on the robot.

resetLeftEncoder
^^^^^^^^^^^^^^^^

.. java:method:: public void resetLeftEncoder()
   :outertype: DriveTrain

   Reset left side encoder.

resetRightEncoder
^^^^^^^^^^^^^^^^^

.. java:method:: public void resetRightEncoder()
   :outertype: DriveTrain

   Reset right side encoder.

returnPIDInput
^^^^^^^^^^^^^^

.. java:method:: protected double returnPIDInput()
   :outertype: DriveTrain

   Get the PID input from the navX.

rightDriveControl
^^^^^^^^^^^^^^^^^

.. java:method:: public void rightDriveControl(double inputSpeed)
   :outertype: DriveTrain

   Run both right side motors at specified speed.

   :param inputSpeed: -1 to 1; full reverse to full speed ahead.

setAutoGear
^^^^^^^^^^^

.. java:method:: public void setAutoGear(boolean autoGear)
   :outertype: DriveTrain

   Set state of autoGear

   :param autoGear: Set Boolean

setAutoGearInputRange
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setAutoGearInputRange(double minInput, double maxInput)
   :outertype: DriveTrain

   Sets the maximum and minimum input range for useAutoGear()

   :param minInput: Minimum input range; negative
   :param maxInput: Maximum input range; positive

setAutoGearPercent
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setAutoGearPercent(double gearPercentCap)
   :outertype: DriveTrain

   Sets the percent of both negative and forward thrust where high/low gear is activated

   :param gearPercentCap: Percent Cap 0 - 100%

setHighGear
^^^^^^^^^^^

.. java:method:: public void setHighGear()
   :outertype: DriveTrain

   Set high gear shift

setLowGear
^^^^^^^^^^

.. java:method:: public void setLowGear()
   :outertype: DriveTrain

   Set low gear shift

setPrecise
^^^^^^^^^^

.. java:method:: public void setPrecise(boolean precise)
   :outertype: DriveTrain

   Set precise mode.

   :param precise: boolean of precise mode.

setReverse
^^^^^^^^^^

.. java:method:: public void setReverse(boolean reverse)
   :outertype: DriveTrain

   Set status of reverse mode.

   :param reverse: Reverse mode; true or false.

teleopControl
^^^^^^^^^^^^^

.. java:method:: public void teleopControl(double forwardsBackwardsAxis, double turningAxis)
   :outertype: DriveTrain

   Initialize teleoperated control.

   :param forwardsBackwardsAxis: See DifferentialDrive.arcadeDrive.
   :param turningAxis: See DifferentialDrive.arcadeDrive.

turn
^^^^

.. java:method:: public void turn(double angle)
   :outertype: DriveTrain

   Turn PID to a specific angle.

   :param angle: The angle to turn to.

useAutoGear
^^^^^^^^^^^

.. java:method:: public void useAutoGear(double fbInput)
   :outertype: DriveTrain

   Will change gear based on speed input

   :param fbInput: live speed value

usePIDOutput
^^^^^^^^^^^^

.. java:method:: protected void usePIDOutput(double output)
   :outertype: DriveTrain

   Use PID output from navX.

