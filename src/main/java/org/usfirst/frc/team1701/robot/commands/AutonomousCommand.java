/**
 * commands/AutonomousClamp.java
 *
 * @author Nicholos Hubbard
 * @since 12/29/17
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/
import org.usfirst.frc.team1701.robot.Robot;
public class AutonomousCommand extends Command {
  //private static final Logger logger = LogManager.getLogger();
  private static final String gameCode = DriverStation.getInstance().getGameSpecificMessage();
  private static final String switchPosition = gameCode.substring(0, 1);
  private static final Double defaultPosition = 2.0;
  private static final double robotPosition = SmartDashboard.getNumber("Position", defaultPosition);
  private static boolean targets = Robot.vision.getTarget();
  public AutonomousCommand() {
    requires(Robot.driveTrain);
  }
  /** Initialize the autonomous command. */
  protected void initialize() {}
  /** Execute the autonomous. */
  protected void execute() {
    //logger.warn("Autonomous command started! May the force be with you.");
    // This is how we figure out what to do. It's a bit rough at best.
    switch(switchPosition) {
      case "L":
        if (robotPosition == 1 && targets) {

        }
      case "R":
        if (robotPosition == 3 && targets) {
          // Take control of right side of switch.
        }
      default:
        // Attempt to cross autonomous line.
    }
  }
  /**
   * Don't stop the party!
   *
   * @return boolean
   */
  protected boolean isFinished() {
    return false;
  }
  /** End the command. */
  protected void end() {
    //logger.info("Halt! We are the Knights Who Say Ni! Bring us some shrubbery to continue.");
    //logger.warn("Just kidding; returning control to user.");
  }
  /** End the command, the hard way. */
  protected void interrupted() {
    //logger.info("Halt! We are the Knights Who Say Ni! Bring us some shrubbery to continue.");
    //logger.warn("Just kidding; returning control to user.");
  }
}
