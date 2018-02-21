/**
 * Robot.java
 *
 * @author Noah Husby
 * @since 12/21/17
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc.team1701.robot.subsystems.*;
import org.usfirst.frc.team1701.robot.commands.AutonomousCommand;
import org.usfirst.frc.team1701.robot.commands.DriveForward;

/*
  _____   ________  ________    _____
 / __  \ |\_____  \|\   __  \  / __  \
|\/_|\  \ \|___/  /\ \  \|\  \|\/_|\  \
\|/ \ \  \    /  / /\ \  \\\  \|/ \ \  \
     \ \  \  /  / /  \ \  \\\  \   \ \  \
      \ \__\/__/ /    \ \_______\   \ \__\
       \|__||__|/      \|_______|    \|__|

  Team 1701 The Robocubs
  Code by Noah Husby and Nick Hubbard
 */

/*
 * The VM on the RoboRIO is automatically configured to run this class. If you change the name of
 * this class or the package, change it in Gradle and here.
 */
public class Robot extends IterativeRobot {
  /*
   * Initialize the various subsystems on the robot.
   */
  private SendableChooser<CommandGroup> autoProgram;
  public static SendableChooser<Number> autonomousLocation;
  private Command autonomousCode;
  public static OI oi;
  public static DriveTrain driveTrain;
  public static LiftArm liftArm;
  public static Vision vision;
  public static Lights lights;
  public static Position position;
  /*
   * This function is run when the robot is first started up.
   */
  public void robotInit() {
    RobotMap.init(); // Initialize our RobotMap.
    driveTrain = new DriveTrain();
    lights = new Lights();
    vision = new Vision();
    liftArm = new LiftArm();
    position = new Position();
    oi = new OI();
    autoProgram = new SendableChooser<>();
    autoProgram.addDefault("Default Autonomous", new AutonomousCommand());
    //autoProgram.addObject("Forward Autonomous", new DriveForward());
    SmartDashboard.putData("Autonomous Mode Chooser", autoProgram);
    autonomousLocation = new SendableChooser<>();
    autonomousLocation.addObject("Left",1);
    autonomousLocation.addDefault("Middle",2);
    autonomousLocation.addObject("Right",3);
    SmartDashboard.putData("Autonomous Location Chooser", autonomousLocation);
    SmartDashboard.putBoolean("Reversed", false);
    SmartDashboard.putNumber("Arm", 0);
    SmartDashboard.putNumber("Wrist",0);
    SmartDashboard.putNumber("DLeft",0);
    SmartDashboard.putNumber("DRight",0);
    SmartDashboard.putNumber("NVAngle", 0);
    SmartDashboard.putNumber("NVYaw", 0);



    vision.setPIPMode(2);
    driveTrain.resetEncoders();
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
    AutonomousCommand auto = new AutonomousCommand();
    auto.start();
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
