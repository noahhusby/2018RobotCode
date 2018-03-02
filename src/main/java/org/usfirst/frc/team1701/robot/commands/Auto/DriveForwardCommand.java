/**
 * commands/DriveForwardCommand.java
 *
 * @author Nicholas Hubbard
 * @since 2018-01-31
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands.Auto;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.Robot;

public class DriveForwardCommand extends Command {
  //distance to switch - length of robot / wheel circ
  //private double forwardDistance = (168 - 38) / (4 * Math.PI);
  private double forwardDistance = 11;

  private boolean isFinished = false;

  public DriveForwardCommand() {

  }
  protected void initialize() {
  }
  protected void execute() {

    if(Robot.driveTrain.getRightDistance() < forwardDistance) {
      Robot.driveTrain.setLowGear();
      Robot.driveTrain.leftDriveControl(-0.6);
      Robot.driveTrain.rightDriveControl(0.6);
  } else {
      Robot.driveTrain.stopMotors();
      isFinished = true;
    }
  }
  protected boolean isFinished() {
    return isFinished;
  }
  protected void end() {
    Robot.driveTrain.stopMotors();
  }
  protected void interrupted() {
    Robot.driveTrain.stopMotors();
  }
}
