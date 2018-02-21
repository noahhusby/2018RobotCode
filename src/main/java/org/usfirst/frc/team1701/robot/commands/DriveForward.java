/**
 * commands/DriveForward.java
 *
 * @author Nicholas Hubbard
 * @since 2018-01-31
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.Robot;

public class DriveForward extends Command {
  //distance to switch - length of robot / wheel circ
  //private double forwardDistance = (168 - 38) / (4 * Math.PI);
  private double forwardDistance = 11;

  private boolean isFinished = false;

  public DriveForward() {

  }
  protected void initialize() {
  }
  protected void execute() {

    SmartDashboard.putNumber("DT", Robot.driveTrain.getEncoderDistance());

    if(Robot.driveTrain.getRightDistance() < forwardDistance) {
      Robot.driveTrain.setLowGear();
      Robot.driveTrain.leftDriveControl(-0.6);
      Robot.driveTrain.rightDriveControl(0.6);
  }
    else {
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
