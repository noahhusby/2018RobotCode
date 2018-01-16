/**
 * commands/StopLiftArm.java
 *
 * @author Noah Husby
 * @since 1/7/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class StopLiftArm extends Command {
  private boolean isFinished = true;

  public StopLiftArm() {
    requires(Robot.liftArm);
  }
  //requires liftArm to work
  protected void initalize() {}

  protected void execute() {
    Robot.liftArm.stopArm();
  }
  //To stop the arm from lifting anymore, we need stopArm
  protected boolean isFinished() {
    return isFinished;
  }

  protected void end() {}

  protected void interrupted() {}
}
