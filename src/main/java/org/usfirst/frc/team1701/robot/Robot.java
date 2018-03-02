<<<<<<< HEAD
/**
 * Robot.java
 *
 * @author Noah Husby
 * @since 12/21/17
=======
/*  __ ______ ___  __
 * /_ |____  / _ \/_ |
 *  | |   / / | | || |
 *  | |  / /| | | || |
 *  | | / / | |_| || |
 *  |_|/_/   \___/ |_|
 *
 * Team 1701 The Robocubs
 *
 * @author Noah Husby and Nicholas Hubbard
 * @created 01-06-2018
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.command.Command;
=======
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc.team1701.robot.commands.DriveForward;
import org.usfirst.frc.team1701.robot.subsystems.*;
import org.usfirst.frc.team1701.robot.commands.AutonomousCommand;
<<<<<<< HEAD
import org.usfirst.frc.team1701.robot.commands.Auto.DriveForwardCommand;

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

=======
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
/*
 * The VM on the RoboRIO is automatically configured to run this class. If you change the name of
 * this class or the package, change it in Gradle and here.
 */
<<<<<<< HEAD
=======
@SuppressWarnings({"ALL", "unused"})
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
public class Robot extends IterativeRobot {
  /*
   * Initialize the various subsystems on the robot.
   */
  private SendableChooser<CommandGroup> autoProgram;
<<<<<<< HEAD
  public static SendableChooser<Number> autonomousLocation;
  public static OI oi;
=======
  private static OI oi;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
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
    autoProgram.addObject("Forward Autonomous", new DriveForward());
    SmartDashboard.putData("Autonomous Mode Chooser", autoProgram);
<<<<<<< HEAD
    autonomousLocation = new SendableChooser<>();
    autonomousLocation.addObject("Left",1);
    autonomousLocation.addDefault("Middle",2);
    autonomousLocation.addObject("Right",3);
=======
    SendableChooser<Number> autonomousLocation = new SendableChooser<>();
    autonomousLocation.addObject("Left", 1);
    autonomousLocation.addDefault("Middle", 2);
    autonomousLocation.addObject("Right", 3);
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
    SmartDashboard.putData("Autonomous Location Chooser", autonomousLocation);
    SmartDashboard.putBoolean("Reversed", false);
    SmartDashboard.putString("Current Gear","");
    SmartDashboard.putBoolean("Init",false);
    SmartDashboard.putNumber("Arm",0);
<<<<<<< HEAD

=======
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
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
    CommandGroup auto = autoProgram.getSelected();
    auto.start();
  }
<<<<<<< HEAD

  /*
   * This function is called periodically during autonomous mode.
   */

=======
  /*
   * This function is called periodically during autonomous mode.
   */
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }
  /*
   * This function is called on start of teleop.
   */
<<<<<<< HEAD
  public void teleopInit() {
  }
=======
  public void teleopInit() {}
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
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
