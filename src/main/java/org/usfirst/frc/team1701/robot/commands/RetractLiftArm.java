/**
 * commands/RetractLiftArm.java
 *
 * @author Noah Husby
 * @since 1/7/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class RetractLiftArm extends Command {
  private boolean isFinished = true;

  public RetractLiftArm() {
    requires(Robot.winch);
  }

  protected void initalize() {}

  protected void execute() {
    Robot.winch.winchStart();
  }
  //**NOTE WE STILL NEED TO HAVE AN END FOR THE WINCH SO WE DONT BREAK IT
  //Otherwise this is the winch beginning, allowing the arm to retract
  protected boolean isFinished() {
    return isFinished;
  }

  protected void end() {}

  protected void interrupted() {}
}
