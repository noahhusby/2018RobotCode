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
  private final DoubleSolenoid armClamp = RobotMap.armClamp;
  private final DigitalOutput Hook = RobotMap.hook;
  private final WPI_TalonSRX wrist = RobotMap.wrist;
  private final WPI_TalonSRX winch1 = RobotMap.winch1;
  private final WPI_TalonSRX winch2 = RobotMap.winch2;
  private final int encPidIdx = RobotMap.encPidIdx;
  private final double WHEEL_CIRCUMFERENCE = 3.9 * Math.PI;
  private final int PULSES_PER_ROTATION = 1440;
  private final double DIST_ADJUST_CONST = 1052.6;

  private final WPI_TalonSRX wristEnc = wrist;
  private final WPI_TalonSRX winchEnc1 = winch1;
  private final WPI_TalonSRX winchEnc2 = winch2;

  public double getArmAngle(){
    double winchEnc1Value = winchEnc1.getSelectedSensorPosition(encPidIdx);
    double winchEnc2Value = winchEnc2.getSelectedSensorPosition(encPidIdx);
    return (winchEnc1Value+winchEnc2Value)/2;
  }
  public void resetArmAngle()
  {
    winchEnc1.setSelectedSensorPosition(0,encPidIdx,0);
    winchEnc2.setSelectedSensorPosition(0,encPidIdx,0);
  }
  public void setArmAngle(double rotations){
    while(rotations != getArmAngle())
    {
      if(rotations > getArmAngle())
      {
        winchEnc1.set(1);
      }
      else if(rotations < getArmAngle())
      {
        winchEnc2.set(-1);
      }
    }
  }
  public double getWristAngle(){
    return wristEnc.getSelectedSensorPosition(encPidIdx); // In Rotations
  }
  public void resetWristAngle() {
    wristEnc.setSelectedSensorPosition(0,encPidIdx,0);
  }
  public void setWristAngle(double rotations){
    /**
     * Very much not tested... Just a birth child of my brain and IntelliJ
     * Im sure someone is going to want this in degrees and not rotations...
     */
    while(rotations != wristEnc.getSelectedSensorPosition(encPidIdx))
    {
      if(rotations > wristEnc.getSelectedSensorPosition(encPidIdx))
      {
        wrist.set(1);
      }
      else if(rotations < wristEnc.getSelectedSensorPosition(encPidIdx))
      {
        wrist.set(-1);
      }
    }
  }

  public void setClamp(boolean clamp) {
    if(clamp) {
      armClamp.set(DoubleSolenoid.Value.kForward);
    }
    else {
     armClamp.set(DoubleSolenoid.Value.kReverse);
    }
  }

  public void engageHook(){

      Hook.set(true);
      //We need to make a delay to allow the hook to stop after it reaches where it needs to be so we dont break the motor
  }

  public void initDefaultCommand() {}
}
