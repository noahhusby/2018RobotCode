/**
 * subsystems/Winch.java
 *
 * @author Noah Husby
 * @since 1/16/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1701.robot.RobotMap;

public class Winch extends Subsystem {

  public void winchStart() {
    RobotMap.winch1.set(.5);
    RobotMap.winch2.set(.5);
  }

  public void winchEnd() {
    RobotMap.winch1.set(0);
    RobotMap.winch2.set(0);
  }

  public void initDefaultCommand() {}
}
