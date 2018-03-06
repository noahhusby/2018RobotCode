/**
 * Robot.java
 *
 * @author Noah Husby
 * @since 12/21/17
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team1701.robot.commands.AutoCommandGroup;
import org.usfirst.frc.team1701.robot.subsystems.*;

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
  private DriverStation ds = DriverStation.getInstance();
  private String gameCode = "";
  public static SendableChooser<Number> autonomousLocation;
  public static SendableChooser<Number> action;
  public static OI oi;
  public static DriveTrain driveTrain;
  public static LiftArm liftArm;
  public static Vision vision;
  public static Position position;
  /*
   * This function is run when the robot is first started up.
   */
  public void robotInit() {
    RobotMap.init(); // Initialize our RobotMap.
    driveTrain = new DriveTrain();
    vision = new Vision();
    liftArm = new LiftArm();
    position = new Position();
    oi = new OI();
    autonomousLocation = new SendableChooser<>();
    autonomousLocation.addObject("Left",1);
    autonomousLocation.addObject("Left-Switch",4);
    autonomousLocation.addDefault("Middle",2);
    autonomousLocation.addObject("Right-Switch",5);
    autonomousLocation.addObject("Right",3);
    SmartDashboard.putData("Autonomous Location", autonomousLocation);
    action = new SendableChooser<>();
    action.addDefault("Defualt Autonomous", 1);
    action.addObject("Forward Autonomous", 2);
    SmartDashboard.putData("Autonomous Chooser",action);
    SmartDashboard.putBoolean("Reversed", false);
    SmartDashboard.putString("Current Gear","");
    SmartDashboard.putNumber("Arm",0);
    SmartDashboard.putBoolean("Arm Down", false);
    SmartDashboard.putNumber("D", 0);

    vision.setPIPMode(2);
    driveTrain.resetEncoders();


  }
  /*
   * This function is called when the robot has been disabled.
   */
  public void disabledInit() {

  }
  /*
   * Periodically run this when the robot is disabled.
   */
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
    while(gameCode.length() < 2) {
      gameCode = ds.getGameSpecificMessage();
      Timer.delay(0.5);
    }
  }
  /*
   * This function is called when autonomous mode is started.
   */
  public void autonomousInit() {
    if(gameCode.length() == 3) {
      CommandGroup autonomousCommand = new AutoCommandGroup(gameCode,action.getSelected(),autonomousLocation.getSelected());
      autonomousCommand.start();
    }
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
