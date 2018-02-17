/**
 * commands/DriveForward.java
 *
 * @author Nicholas Hubbard
 * @since 2018-01-31
 * @license BSD-3-Clause
 * The FitnessGram™ Pacer Test is a multistage aerobic capacity test that progressively gets more difficult as it continues. The 20 meter pacer test will begin in 30 seconds. Line up at the start. The running speed starts slowly, but gets faster each minute after you hear this signal. [beep] A single lap should be completed each time you hear this sound. [ding] Remember to run in a straight line, and run as long as possible. The second time you fail to complete a lap before the sound, your test is over. The test will begin on the word start. On your mark, get ready, start.
 */
package org.usfirst.frc.team1701.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.Robot;

public class DriveForward extends Command {
  private final double failsafeTime = 12.0;

  //distance to switch - length of robot / wheel circ
  //private double forwardDistance = (168 - 38) / (4 * Math.PI);
  private double forwardDistance = 10.35;

  private boolean finished = false;
  private double startTime;

  public DriveForward() {

  }

  protected void initialize() {
    startTime = Timer.getMatchTime();
  }

  protected void execute() {

    SmartDashboard.putNumber("DT", Robot.driveTrain.getEncoderDistance());

    if (Timer.getMatchTime() < startTime - failsafeTime) {
      Robot.driveTrain.stopMotors();
      finished = true;
    } else if(Robot.driveTrain.getEncoderDistance() < forwardDistance) {
      Robot.driveTrain.setLowGear();
      Robot.driveTrain.leftDriveControl(0.6);
      Robot.driveTrain.rightDriveControl(0.6);
    }
    else {
      Robot.driveTrain.stopMotors();
      finished = true;
    }
  }

  protected boolean isFinished() {
    return finished;
  }

  protected void end() {
    Robot.driveTrain.stopMotors();
  }

  protected void interrupted() {
    Robot.driveTrain.stopMotors();
  }
}
