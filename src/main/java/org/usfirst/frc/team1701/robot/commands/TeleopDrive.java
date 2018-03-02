<<<<<<< HEAD
/**
=======
/*
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * commands/TeleopDrive.java
 *
 * @author Noah Husby
 * @since 1/7/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
<<<<<<< HEAD

import com.sun.javafx.geom.transform.SingularMatrixException;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Timer;
=======
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.OI;
import org.usfirst.frc.team1701.robot.Robot;
<<<<<<< HEAD
import org.usfirst.frc.team1701.robot.RobotMap;

public class TeleopDrive extends Command {

  public TeleopDrive() {
    requires(Robot.driveTrain);
  }
  protected void initialize() {
  }
  protected void execute() {

    SmartDashboard.putBoolean("Reversed", Robot.driveTrain.getReverse());
    SmartDashboard.putNumber("Arm",Robot.liftArm.getArmAngle());
    SmartDashboard.putNumber("Wrist", Robot.liftArm.getWristAngle());

    if(Robot.liftArm.getCubeSensor())
    {
      Robot.liftArm.setGrabber(true);
    }


=======
public class TeleopDrive extends Command {
  public TeleopDrive() { requires(Robot.driveTrain); }
  protected void initialize() {}
  protected void execute() {
    SmartDashboard.putBoolean("Reversed", Robot.driveTrain.getReverse());
    SmartDashboard.putNumber("Arm", Robot.liftArm.getArmAngle());
    SmartDashboard.putNumber("Wrist", Robot.liftArm.getWristAngle());
    if(Robot.liftArm.getCubeSensor()) {
      Robot.liftArm.setGrabber(true);
    }
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
    double deadConst = .10;
    double fBInput = checkDeadZone(OI.drive_FB.getY(), deadConst);
    double tInput = -1 * checkDeadZone(OI.drive_T.getX(), deadConst);
    Robot.driveTrain.teleopControl(fBInput, tInput);
<<<<<<< HEAD

=======
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
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
