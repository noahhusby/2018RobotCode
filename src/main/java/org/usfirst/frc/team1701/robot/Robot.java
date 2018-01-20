/**
 * Robot.java
 *
 * @author Noah Husby
 * @since 12/21/17
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team1701.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1701.robot.subsystems.Hook;
import org.usfirst.frc.team1701.robot.subsystems.LiftArm;

/*
 * The VM on the RoboRIO is automatically configured to run this class. If you change the name of
 * this class or the package, change it in Gradle and here.
 */
public class Robot extends IterativeRobot {
  /*
   * Initialize the various subsystems on the robot.
   */
  public static OI oi;
  public static DriveTrain driveTrain;
  public static LiftArm liftArm;
  public static Winch winch;
  public static Hook hook;
  public static GrabArmClamp grabArmClamp;
  public static ReleaseArmClamp releaseArmClamp;
  /*
   * This function is run when the robot is first started up.
   */
  public void robotInit() {
    RobotMap.init(); // Initialize our RobotMap.    // Initialize our subsystems.
    driveTrain = new DriveTrain();
    oi = new OI(); // If you move this... you're gonna have a bad time
  }
  /*
   * This function is called when the robot has been disabled.
   */
  public void disabledInit() {}
  /*
   * Periodically run this when the robot is disabled.
   */
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }
  /*
   * This function is called when autonomous mode is started.
   */
  public void autonomousInit() {
  }
  /*
   * This function is called periodically during autonomous mode.
   */

  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }
  /*
   * This function is called on start of teleop.
   */
  public void teleopInit() {
  }
  /*
   * This function is called periodically during teleop.
   */
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }
  /*
   * This function is called periodically during test mode.
   */
  public void testPeriodic() {}
}
