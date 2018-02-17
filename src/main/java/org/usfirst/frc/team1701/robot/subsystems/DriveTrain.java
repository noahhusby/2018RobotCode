/**
 * subsystems/DriveTrain.java
 *
 * @author Noah Husby
 * @since 1/7/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.subsystems;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.RobotMap;
import org.usfirst.frc.team1701.robot.commands.TeleopDrive;
import com.kauailabs.navx.frc.AHRS;
public class DriveTrain extends Subsystem {
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
  private final double WHEEL_CIRCUMFERENCE = 3.9 * Math.PI;
  private final double DIST_ADJUST_CONST = 1052.6;
  private double autoGearPercent = 0.75;
  private double autoGearMinInputRange = -1;
  private double autoGearMaxInputRange = 1;

  /*
   * Motor state variables.
   */

  private boolean reversed = false;
  private boolean precise = false;
  private boolean autoGear = false;
  /**
   * Return left velocity.
   * @return int of left side velocity.
   */
  public int getLeftVelocity() {
    return leftEncTalon.getSelectedSensorVelocity(encPidIdx);
  }
  /**
   * Return left distance.
   * @return double of left side distance.
   */
  public double getLeftDistance() {
    return leftEncTalon.getSelectedSensorPosition(encPidIdx)
        * WHEEL_CIRCUMFERENCE
        / DIST_ADJUST_CONST;
  }
  /**
   * Reset left side encoder.
   */
  public void resetLeftEncoder() {
    leftEncTalon.setSelectedSensorPosition(0, encPidIdx, 0);
  }
  /**
   * Get right velocity.
   * @return int of right side velocity.
   */
  public int getRightVelocity() {
    return rightEncTalon.getSelectedSensorVelocity(encPidIdx);
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
    return rightEncTalon.getSelectedSensorPosition(encPidIdx)
        * WHEEL_CIRCUMFERENCE
        / 1.8;
  }

  public double getEncoderDistance()
  {
    return -leftEncTalon.getSelectedSensorPosition(encPidIdx);
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
   * Return boolean of precise mode.
   * @return boolean of precise mode.
   */
  public boolean getPrecise() {
    return precise;
  }
  /**
   * Set precise mode.
   * @param precise boolean of precise mode.
   */
  public void setPrecise(boolean precise) {
    this.precise = precise;
  }
  /**
   * Get status of reverse mode.
   * @return boolean of reverse mode
   */
  public boolean getReverse() {
    return reversed;
  }
  /**
   * Set status of reverse mode.
   * @param reverse Reverse mode; true or false.
   */
  public void toggleReverse() {
    this.reversed = !this.reversed;
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
    if (precise) {
      forwardsBackwardsAxis *= .5;
      turningAxis *= .75;
    }
    RobotMap.driveTrain.arcadeDrive(forwardsBackwardsAxis, turningAxis);
  }
  /**
   * Initialize the default command for this subsystem.
   */
  public void initDefaultCommand() {
      setDefaultCommand(new TeleopDrive());
  }
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
   * Set state of autoGear
   * @param autoGear Set Boolean
   */
  public void setAutoGear(boolean autoGear) {
    this.autoGear = autoGear;
  }
  /**
   * Will change gear based on speed input
   * @param fbInput live speed value
   */
  public void useAutoGear(double fbInput) {


    }

  /**
   * Sets the percent of both negative and forward thrust where high/low gear is activated
   * @param gearPercentCap Percent Cap 0 - 100%
   */
  public void setAutoGearPercent(double gearPercentCap) {
    this.autoGearPercent = gearPercentCap;
  }
  /**
   * Sets the maximum and minimum input range for useAutoGear()
   * @param minInput Minimum input range; negative
   * @param maxInput Maximum input range; positive
   */
  public void setAutoGearInputRange(double minInput, double maxInput) {
    this.autoGearMinInputRange = minInput;
    this.autoGearMaxInputRange = maxInput;
  }
  /**
   * Get the state of the the auto gear
   * @return this.autoGear
   */
  public boolean getAutoGear() {
    return this.autoGear;
  }
}
