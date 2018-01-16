/**
 * commands/GrabArmClamp.java
 *
 * @author Noah Husby
 * @since 1/7/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class GrabArmClamp extends Command {
  private boolean isDone = true;

  public GrabArmClamp() {
    requires(Robot.liftArm);
  }
  //it needs liftarm to work because the armClamp is inside of liftarm.
  protected void initalize() {}

  protected void execute() {
    Robot.liftArm.grabArmClamp();
  }
  //Closes the Clamp at the end of the arm.
  protected boolean isFinished() {
    return isDone;
  }

  protected void end() {}

  protected void interrupted() {}
}
