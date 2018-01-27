/**
 * subsystems/DriveTrain.java
 *
 * @author Noah Husby
 * @since 1/7/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc.team1701.robot.RobotMap;
import org.usfirst.frc.team1701.robot.commands.TeleopDrive;
import com.kauailabs.navx.frc.AHRS;
public class DriveTrain extends PIDSubsystem {
  /*
   * Basic PID constructor for PIDSubsystem.
   */
  public DriveTrain() {
    super("DriveTrain", 0.03, 0.00,0.00);
    setInputRange(-180, 180);
    setOutputRange(-.5, .5);
    setAbsoluteTolerance(2.0);
    getPIDController().setContinuous(true);
    enable();
  }
  /*
   * Set of motors.
   */
  private final WPI_TalonSRX left_1 = RobotMap._leftFrontMotor;
  private final WPI_TalonSRX left_2 = RobotMap._leftBackMotor;
  private final WPI_TalonSRX right_1 = RobotMap._rightFrontMotor;
  private final WPI_TalonSRX right_2 = RobotMap._rightBackMotor;
  private final DifferentialDrive robotDrive = RobotMap.driveTrain;
  /*
   * Set of encoders.
   */
  private final WPI_TalonSRX leftEncTalon = left_1;
  private final WPI_TalonSRX rightEncTalon = right_1;
  /*
   * NavX.
   */
  private final AHRS navx = RobotMap._navx;
  /*
   * Special math stuffs.
   */
  private final int encPidIdx = RobotMap.encPidIdx;
  private final double WHEEL_CIRCUMFERENCE = 3.9 * Math.PI;
  private final int PULSES_PER_ROTATION = 1440;
  private final double DIST_ADJUST_CONST = 1052.6;
  /*
   * Motor state variables.
   */
<<<<<<< HEAD
  private boolean reversed = false;
  private boolean precise = false;
=======
  private boolean reversed = true;  private boolean precise = false;
>>>>>>> 2cf986159378ae4e52cae5f7c9c9d21376179bb8
  /**
   * Turn PID to a specific angle.
   * @param angle The angle to turn to.
   */
  public void turn(double angle) {
    getPIDController().setSetpoint(angle);
  }
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
   * Get right side distance.
   * @return double of right side distance.
   */
  public double getRightDistance() {
    return rightEncTalon.getSelectedSensorPosition(encPidIdx)
        * WHEEL_CIRCUMFERENCE
        / DIST_ADJUST_CONST;
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
  public void setReverse(boolean reverse) {
    this.reversed = reverse;
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
  /**
   * Get the PID input from the navX.
   */
  protected double returnPIDInput() {
    return navx.getAngle();
  }
  /**
   * Use PID output from navX.
   */
  protected void usePIDOutput(double output) {
    // I really don't know what to do here. Should I run the robot forward toward the target? idk. *Nick hit a stub
  }
}
