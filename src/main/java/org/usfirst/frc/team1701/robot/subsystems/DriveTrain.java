/**
 * subsystems/DriveTrain.java
 *
 * @author Noah Husby
 * @since 1/7/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import org.usfirst.frc.team1701.robot.RobotMap;
import org.usfirst.frc.team1701.robot.commands.TeleopDrive;
// Currently we do not implement PIDOutput; it is in an infancy stage in this current setup.
// I have left some PID methods down below. - Nick, 2018-01-23 20:54
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
   * Special math stuffs.
   */
  private final int encPidIdx = RobotMap.encPidIdx;
  private final double WHEEL_CIRCUMFERENCE = 3.9 * Math.PI;
  private final int PULSES_PER_ROTATION = 1440;
  private final double DIST_ADJUST_CONST = 1052.6;
  private double rate;
  /*
   * Motor state variables.
   */
  private boolean reversed = true;
  private boolean precise = false;
  /*
   * PID controller.
   */
  private PIDController pid;
  /**
   * Set up PID controller. This **must** be done before anything else.
   * @param kP Given constant for P in PID.
   * @param kI Given constant for I in PID.
   * @param kD Given constant for D in PID.
   * @param kF Given constant.
   * @param kS PID source.
   * @param kO PID output.
   */
  public void setupPID(double kP, double kI, double kD, double kF, PIDSource kS, PIDOutput kO) {
    pid = new PIDController(kP, kI, kD, kF, kS, kO);
    pid.setInputRange(-180, 180);
    pid.setOutputRange(-.5, .5);
    pid.setAbsoluteTolerance(2.0);
    pid.setContinuous(true);
    pid.enable();
  }
  /**
   * Turn PID to a specific angle.
   * @param angle The angle to turn to.
   */
  public void turn(double angle) {
    pid.setSetpoint(angle);
  }
  /**
   * Get PID.
   * @return PIDController
   */
  public PIDController getPID() {
    return pid;
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
}
