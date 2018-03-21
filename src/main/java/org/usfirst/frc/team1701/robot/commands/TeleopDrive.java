/**
 * commands/TeleopDrive.java
 *
 * @author Noah Husby
 * @since 1/7/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.OI;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class TeleopDrive extends Command {

  public TeleopDrive() {
    requires(Robot.driveTrain);
  }
  protected void initialize() {
    Robot.driveTrain.stopPID();
    //Robot.driveTrain.setLowGear();
    Robot.driveTrain.setCoastMode();

  }
  protected void execute() {

    if(Robot.liftArm.getCubeSensor() && !Robot.position.isReleasePressed) {
      Robot.liftArm.setGrabber(true);
    }

    Robot.shuffleboard.updateDashboard();
    double deadConst = .10;
    double fBInput = 2 * checkDeadZone(OI.drive_FB.getY(), deadConst);
    double tInput =  -1 * 2 * checkDeadZone(OI.drive_T.getX(), deadConst);
    Robot.driveTrain.teleopControl(fBInput, tInput);
    Robot.driveTrain.autoGear(OI.drive_FB.getY(),deadConst,Robot.driveTrain.getRightDistance(),3);

  }
  protected boolean isFinished() {
    return false;
  }
  protected void end() {}
  protected void interrupted() {}
  private double checkDeadZone(double input, double deadConst) {
    if (input > 0) {
      if (deadConst >= input) {
        input = 0;
      }
    } else {
      if (-deadConst <= input) {
        input = 0;
      }
    }
    return input;
  }
}
