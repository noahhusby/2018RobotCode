/**
 * subsystems/DriveTrain.java
 *
 * <p>Created by Noah Husby on 1/7/2018.
 *
 * <p>Copyright (c) 2018 Team 1701 (Robocubs) All rights reserved.
 *
 * <p>Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met:
 *
 * <p>Redistributions of source code must retain the above copyright notice, this list of conditions
 * and the following disclaimer.
 *
 * <p>Redistributions in binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other materials provided with
 * the distribution.
 *
 * <p>Neither the name of the project's author nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written permission.
 *
 * <p>THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.usfirst.frc.team1701.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1701.robot.RobotMap;
import org.usfirst.frc.team1701.robot.commands.TeleopDrive;

public class DriveTrain extends Subsystem {

  private final WPI_TalonSRX left_1 = RobotMap._leftFrontMotor;
  private final WPI_TalonSRX left_2 = RobotMap._leftBackMotor;
  private final WPI_TalonSRX left_3 = RobotMap._leftMiddleMotor;
  private final WPI_TalonSRX right_1 = RobotMap._rightFrontMotor;
  private final WPI_TalonSRX right_2 = RobotMap._rightBackMotor;
  private final WPI_TalonSRX right_3 = RobotMap._rightMiddleMotor;

  private final WPI_TalonSRX leftEncTalon = left_3;
  private final WPI_TalonSRX rightEncTalon = right_3;

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
    left_3.set(inputSpeed);
  }

  public void rightDriveControl(double inputSpeed) {
    right_1.set(inputSpeed);
    right_2.set(inputSpeed);
    right_3.set(inputSpeed);
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
