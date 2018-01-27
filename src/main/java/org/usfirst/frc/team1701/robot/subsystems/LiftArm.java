/**
 * subsystems/LiftArm.java
 *
 * @author Noah Husby & Steven Wall
 * @since 1/16/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1701.robot.RobotMap;
public class LiftArm extends Subsystem {
  /*
   * Hardware references.
   */
  private final DoubleSolenoid armClamp = RobotMap.armClamp;
  private final DigitalOutput Hook = RobotMap.hook;
  private final WPI_TalonSRX wrist = RobotMap.wrist;
  private final WPI_TalonSRX winch1 = RobotMap.winch1;
  private final WPI_TalonSRX winch2 = RobotMap.winch2;
  /*
   * Value references.
   */
  private final int encPidIdx = RobotMap.encPidIdx;
  private final double WHEEL_CIRCUMFERENCE = 3.9 * Math.PI;
  private final int PULSES_PER_ROTATION = 1440;
  private final double DIST_ADJUST_CONST = 1052.6;
  private final WPI_TalonSRX wristEnc = wrist;
  private final WPI_TalonSRX winchEnc1 = winch1;
  private final WPI_TalonSRX winchEnc2 = winch2;
  /**
   * Return arm angle.
   * @return arm angle as double
   */
  public double getArmAngle() {
    return winchEnc1.getSelectedSensorPosition(encPidIdx);
  }
  /**
   * Reset the arm angle.
   */
  public void resetArmAngle() {
    winchEnc1.setSelectedSensorPosition(0,encPidIdx,0);
  }
  /**
   * Set the arm angle
   * @param rotations the number of rotations.
   */
  public void setArmAngle(double rotations) {
    while(rotations != getArmAngle()) {
      if(rotations > getArmAngle()) {
        winchEnc1.set(1);
      } else if(rotations < getArmAngle()) {
        winchEnc2.set(-1);
      }
    }
  }
  /**
   * Return wrist angle.
   * @return wrist angle as double.
   */
  public double getWristAngle() {
    return wristEnc.getSelectedSensorPosition(encPidIdx); // In Rotations
  }
  /**
   * Reset the wrist angle.
   */
  public void resetWristAngle() {
    wristEnc.setSelectedSensorPosition(0,encPidIdx,0);
  }
  /**
   * Set the wrist angle.
   * @param rotations Wrist angle to set to.
   */
  public void setWristAngle(double rotations) {
    /*
     * Very much not tested... Just a birth child of my brain and IntelliJ
     * I'm sure someone is going to want this in degrees and not rotations...
     */
    while(rotations != wristEnc.getSelectedSensorPosition(encPidIdx)) {
      if(rotations > wristEnc.getSelectedSensorPosition(encPidIdx)) {
        wrist.set(1);
      } else if(rotations < wristEnc.getSelectedSensorPosition(encPidIdx)) {
        wrist.set(-1);
      }
    }
  }
  /**
   * Set the clamp position.
   * @param clamp true for enabled, false for disabled.
   */
  public void setClamp(boolean clamp) {
    if(clamp) {
      armClamp.set(DoubleSolenoid.Value.kForward);
    } else {
     armClamp.set(DoubleSolenoid.Value.kReverse);
    }
  }
  /**
   * Enable the hook.
   */
  public void engageHook() {
      Hook.set(true);
      //We need to make a delay to allow the hook to stop after it reaches where it needs to be so we don't break the motor.
  }
  /**
   * Disable the hook.
   */
  public void disengageHook() {
    Hook.set(false);
  }
  public void initDefaultCommand() {}
}
