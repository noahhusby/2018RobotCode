/*
 * subsystems/DriveTrain.java
 *
 * @author Noah Husby
 * @since 1/7/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1701.robot.RobotMap;
import org.usfirst.frc.team1701.robot.commands.TeleopDrive;
import com.kauailabs.navx.frc.AHRS;
@SuppressWarnings("unused")
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
  /*
   * Motor state variables.
   */
  private boolean reversed = false;
  /*
   * Distance traveled.
   */
  public double distanceTraveled = (getLeftDistance() + getRightDistance()) / 2;
  /**
   * Return left distance.
   * @return double of left side distance.
   */
  public double getLeftDistance() {
    return -leftEncTalon.getSelectedSensorPosition(encPidIdx) / 22000;
  }
  /**
   * Reset left side encoder.
   */
  @SuppressWarnings("WeakerAccess")
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
    return rightEncTalon.getSelectedSensorPosition(encPidIdx) / 22000;
  }
  /**
   * Reset right side encoder.
   */
  @SuppressWarnings("WeakerAccess")
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
   * Set status of reverse mode.
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
}
