/**
 * subsystems/Hook.java
 *
 * @author Noah Husby
 * @since 1/16/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1701.robot.RobotMap;

public class Hook extends Subsystem {

  public void releaseHook() {
    RobotMap.hook.set(true);
  }

  public void initDefaultCommand() {}
}
