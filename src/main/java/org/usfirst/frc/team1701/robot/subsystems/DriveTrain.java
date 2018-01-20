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
import org.usfirst.frc.team1701.robot.RobotMap;
import org.usfirst.frc.team1701.robot.commands.TeleopDrive;

public class DriveTrain extends Subsystem {

  private final WPI_TalonSRX left_1 = RobotMap._leftFrontMotor;
  private final WPI_TalonSRX left_2 = RobotMap._leftBackMotor;
  private final WPI_TalonSRX right_1 = RobotMap._rightFrontMotor;
  private final WPI_TalonSRX right_2 = RobotMap._rightBackMotor;

  private final WPI_TalonSRX leftEncTalon = left_1;
  private final WPI_TalonSRX rightEncTalon = right_2;

  private final int encPidIdx = RobotMap.encPidIdx;
  private final double WHEEL_CIRCUMFERENCE = 3.9 * Math.PI;
  private final int PULSES_PER_ROTATION = 1440;
  private final double DIST_ADJUST_CONST = 1052.6;

  public int getLeftVelocity() {
    return leftEncTalon.getSelectedSensorVelocity(encPidIdx);
  }

  public double getLeftDistance() {
    return leftEncTalon.getSelectedSensorPosition(encPidIdx)
        * WHEEL_CIRCUMFERENCE
        / DIST_ADJUST_CONST;
  }

  public void resetLeftEncoder() {
    leftEncTalon.setSelectedSensorPosition(0, encPidIdx, 0);
  }

  public int getRightVelocity() {
    return rightEncTalon.getSelectedSensorVelocity(encPidIdx);
  }

  public double getRightDistance() {
    return rightEncTalon.getSelectedSensorPosition(encPidIdx)
        * WHEEL_CIRCUMFERENCE
        / DIST_ADJUST_CONST;
  }

  public void resetRightEncoder() {
    rightEncTalon.setSelectedSensorPosition(0, encPidIdx, 0);
  }

  public void leftDriveControl(double inputSpeed) {
    left_1.set(inputSpeed);
    left_2.set(inputSpeed);

  }

  public void rightDriveControl(double inputSpeed) {
    right_1.set(inputSpeed);
    right_2.set(inputSpeed);

  }

  public void resetEncoders()
  {
      resetLeftEncoder();
      resetRightEncoder();
  }

  private boolean reversed = true;
  private boolean precise = false;

  public void setPrecise(boolean precise) {
    this.precise = precise;
  }

  public void toggleReversed() {
    if (reversed) {
      reversed = false;
    } else {
      reversed = true;
    }
  }

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

  public void initDefaultCommand() {
    setDefaultCommand(new TeleopDrive());
  }
}
