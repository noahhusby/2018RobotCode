/**
 * subsystems/LiftArm.java
 *
 * @author Noah Husby & Steven Wall
 * @since 1/16/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1701.robot.RobotMap;

public class LiftArm extends Subsystem {
  private final DoubleSolenoid liftArm = RobotMap.liftArm;
  private final DoubleSolenoid armClamp = RobotMap.armClamp;
  private final DigitalOutput Hook = RobotMap.hook;

  public void getArmAngle(){

  }
  public void setArmAngle(){

  }
  public void getWristAngle(){

  }
  public void setWristAngle(){

  }
  public void closeClamp(){

  }
  public void openClamp(){

  }
  public void engageHook(){

      Hook.set(true);
      //We need to make a delay to allow the hook to stop after it reaches where it needs to be so we dont break the motor
  }

  public void initDefaultCommand() {}
}
