/**
 * subsystems/DriveTrain.java
 *
 * @author Noah Husby
 * @since 1/7/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1701.robot.RobotMap;
import org.usfirst.frc.team1701.robot.commands.TeleopDrive;
import com.kauailabs.navx.frc.AHRS;
public class DriveTrain extends PIDSubsystem {
  /*
   * Set of motors.
   */
  private final WPI_TalonSRX left_1 = RobotMap._leftFrontMotor;
  private final WPI_TalonSRX left_2 = RobotMap._leftBackMotor;
  private final WPI_TalonSRX right_1 = RobotMap._rightFrontMotor;
  private final WPI_TalonSRX right_2 = RobotMap._rightBackMotor;
  /*
   * Set of encoders.
   */
  private final WPI_TalonSRX leftEncTalon = left_1;
  private final WPI_TalonSRX rightEncTalon = right_1;
  /*
   * Drivetrain gear shifters.
   */
  private final DoubleSolenoid driveShift = RobotMap.driveShift;
  /*
   * NavX. 
   */
  private final AHRS navx = RobotMap._navx;
  /*
   * Special math stuffs.
   */
  private final int encPidIdx = RobotMap.encPidIdx;
  private final int rawToRotation = 22000;


  /*
   * Motor state variables.
   */
  private boolean reversed = false;
  private boolean deadStick = false;
  public boolean autoGear = false;

  public DriveTrain() {
    super(0.03,0,0);
    this.setInputRange(-180,180);
    this.setOutputRange(-1,1);
    this.setAbsoluteTolerance(2);
    this.getPIDController().setContinuous(true);
  }

  /**
   * Sets angle for robot to turn to using PIDSubsystem
   * @param startAngle angle to turn to
   */
  public void setAngle(double startAngle) {
    this.setSetpoint(startAngle);
  }

  public void startPID() {
    this.getPIDController().enable();
  }

  public void stopPID() {
    this.getPIDController().disable();
  }




  /**
   * Return left distance.
   * @return double of left side distance.
   */
  public double getLeftDistance() {
    return -leftEncTalon.getSelectedSensorPosition(encPidIdx) / rawToRotation;
  }
  /**
   * Reset left side encoder.
   */
  public void resetLeftEncoder() {
    leftEncTalon.setSelectedSensorPosition(0, encPidIdx, 0);
  }
  /**
   * Stop all motors.
   */
  public void stopMotors()
  {
    right_1.stopMotor();
    right_2.stopMotor();
    left_1.stopMotor();
    left_2.stopMotor();
  }
  /**
   * Get right side distance.
   * @return double of right side distance.
   */
  public double getRightDistance() {
    return rightEncTalon.getSelectedSensorPosition(encPidIdx) / rawToRotation;
  }
  /**
   * Reset right side encoder.
   */
  public void resetRightEncoder() {
    rightEncTalon.setSelectedSensorPosition(0, encPidIdx, 0);
  }
  /**
   * Run both left side motors at specified speed.
   * @param inputSpeed -1 to 1; full reverse to full speed ahead.
   */
  public void leftDriveControl(double inputSpeed) {
    left_1.set(inputSpeed);
    left_2.set(inputSpeed);
  }
  /**
   * Run both right side motors at specified speed.
   * @param inputSpeed -1 to 1; full reverse to full speed ahead.
   */
  public void rightDriveControl(double inputSpeed) {
    right_1.set(inputSpeed);
    right_2.set(inputSpeed);
  }
  /**
   * Reset both encoders on the robot.
   */
  public void resetEncoders() {
      resetLeftEncoder();
      resetRightEncoder();
  }
  /**
   * Checks navX for pitch, so we can do precise turns
   * @return navX Pitch
   */
  public double getNavxAngle()
  {
    return -navx.getAngle();
  }
  /**
   * Checks current reverse boolean
   * @return State of reversed
   */
  public boolean getReverse() {
    return reversed;
  }
  /**
   * Initialize teleoperated control.
   * @param forwardsBackwardsAxis See DifferentialDrive.arcadeDrive.
   * @param turningAxis See DifferentialDrive.arcadeDrive.
   */
  public void teleopControl(double forwardsBackwardsAxis, double turningAxis) {
    if (reversed) {
      forwardsBackwardsAxis *= -1;
    }
    RobotMap.driveTrain.arcadeDrive(forwardsBackwardsAxis, turningAxis);
  }
  /**
   * Initialize the default command for this subsystem.
   */
  public void initDefaultCommand() {
      setDefaultCommand(new TeleopDrive());
  }

  /**
   * Checks current state of drive train gear
   * @return "High Gear" if true, and "Low Gear" if false;
   */
  public String getGear() {
    if(driveShift.get() == DoubleSolenoid.Value.kForward) return "High Gear";
    if(driveShift.get() == DoubleSolenoid.Value.kReverse) return "Low Gear";
    return null;
  }
  /**
   * Set high gear shift.
   */
  public void setHighGear() {
    driveShift.set(DoubleSolenoid.Value.kForward);
  }
  /**
   * Set low gear shift
   */
  public void setLowGear() {
    driveShift.set(DoubleSolenoid.Value.kReverse);
  }

  /**
   * Sets the drive train's thrust to move in the opposite direction
   * @param reversedValue Enables/Disables reversed status
   */
  public void setReverse(boolean reversedValue) {
      this.reversed = reversedValue;
  }

  /**
   * Enables/Disables auto gear. This is helpful for a manual switch where you can turn auto gear on and off
   * @param value Sets state of auto gear
   */
  public void setAutoGear(boolean value) {
    this.autoGear = value;
  }

  /**
   * Automatically shifts the gear after a set distance from when the drive stick last went to dead stick
   * @param tInput Forward/Backwards Speed from Joystick
   * @param deadConst The value that sets where and when dead stick should enable. BY DEFAULT: 0.1 or -10 % to 10%
   * @param encoderValue The raw input that will deliver the current distance
   * @param distanceTrigger The value that determines the distance that high gear is set
   */
  public void autoGear(double tInput, double deadConst, double encoderValue, double distanceTrigger) {
    if(autoGear) {


      if (tInput > 0) {
        if (deadConst >= tInput) {
          this.deadStick = true;
          resetEncoders();
          setLowGear();
        } else if (deadConst <= tInput) {
          this.deadStick = false;
        }
      } else {
        if (-deadConst <= tInput) {
          this.deadStick = true;
          resetEncoders();
          setLowGear();
        } else if (-deadConst >= tInput) {
          this.deadStick = false;
        }
      }
      if(encoderValue > distanceTrigger) {
        setHighGear();
      }
    }
  }

  /**
   * Checks current deadStick boolean that is determine by autoGear()
   * @return Checks weather the thrust joystick is moving or not
   */
  public boolean getDeadStick() {
    return this.deadStick;
  }



  @Override
  protected double returnPIDInput() {
    return -navx.getAngle();
  }

  @Override
  protected void usePIDOutput(double output) {
    teleopControl(0,output);
  }
}
