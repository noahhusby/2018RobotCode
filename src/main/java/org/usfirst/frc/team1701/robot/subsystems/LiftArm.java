/**
 * subsystems/LiftArm.java
 *
 * @author Noah Husby
 * @since 1/16/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1701.robot.RobotMap;

public class LiftArm extends Subsystem {
  private final DoubleSolenoid liftArm = RobotMap.liftArm;
  private final DoubleSolenoid armClamp = RobotMap.armClamp;

  public void extendArm() {
    liftArm.set(DoubleSolenoid.Value.kForward);
  }
  /*public void retractArm()
  {
      liftArm.set(DoubleSolenoid.Value.kReverse);
  }
  */
  public void stopArm() {
    liftArm.set(DoubleSolenoid.Value.kOff);
  }

  public void grabArmClamp() {
    armClamp.set(DoubleSolenoid.Value.kForward);
  }

  public void releaseArmClamp() {
    armClamp.set(DoubleSolenoid.Value.kReverse);
  }

  public void initDefaultCommand() {}
}
