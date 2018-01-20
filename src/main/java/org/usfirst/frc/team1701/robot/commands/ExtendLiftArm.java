/**
 * commands/ExtendArmClamp.java
 *
 * @author Noah Husby
 * @since 1/13/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class ExtendLiftArm extends Command {
  private boolean isFinished = true;

  public ExtendLiftArm() {
  }
  //It needs to use the liftarm to do anything.
  protected void initalize() {}

  protected void execute() {
    Robot.liftArm.extendArm();
  }
  //Extend the arm. Simple as that. ^^

  protected boolean isFinished() {
    return isFinished;
  }

  protected void end() {}

  protected void interrupted() {}
}
