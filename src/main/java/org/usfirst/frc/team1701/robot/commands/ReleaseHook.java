/**
 * commands/ReleaseHook.java
 *
 * @author Noah Husby
 * @since 1/7/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class ReleaseHook extends Command {
  private boolean isDone = true;

  public ReleaseHook() {
    requires(Robot.hook);
  }
  //requires the hook to be able to access the hook
  protected void initalize() {}

  protected void execute() {
    Robot.hook.releaseHook();
  }
  //LAY WAY! DROP THE ANCHOR! SECURE THE SHIP
  //(Meaning release the hook)
  protected boolean isFinished() {
    return isDone;
  }

  protected void end() {}

  protected void interrupted() {}
}
