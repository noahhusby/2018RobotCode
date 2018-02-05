/**
 * OI.java
 *
 * @author Noah Husby
 * @since 12/21/17
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/
import org.usfirst.frc.team1701.robot.commands.*; // Should be eventually replaced with absolute imports.
/*
 * This class sets up and enables the Joysticks and Buttons on your console.
 */
public class OI {
  /*
   * Create initial values.
   */
  public static Joystick drive_FB;
  public static Joystick drive_T;
  public static Joystick operation;
  public static JoystickButton gearMode;
  public static JoystickButton resetGyro;
  public static JoystickButton preciseMode;
  public static JoystickButton turboMode;
  public static JoystickButton scaleHigh;
  public static JoystickButton scaleMedium;
  public static JoystickButton scaleLow;
  public static JoystickButton switchHigh;
  public static JoystickButton switchMeduim;
  public static JoystickButton switchLow;
  public static JoystickButton climber;
  public static JoystickButton hook;
  //private static final Logger logger = LogManager.getLogger();
  /**
   * Instead of an init() function, we call this on OI startup.
   */
  public OI() {
    //logger.info("Assigning joystick values...");
    /*
     * Enable the physical joysticks.
     */
    operation = new Joystick(0); // UHID device
    drive_FB = new Joystick(1); // Right
    drive_T = new Joystick(2); // Left
    /*
     * Assign commands to buttons.
     */
    gearMode = new JoystickButton(operation, 1);
    resetGyro = new JoystickButton(operation, 2);
    preciseMode = new JoystickButton(operation, 3);
    turboMode = new JoystickButton(operation, 4);
    //extendArm = new JoystickButton(operation, 5); //Placeholder Value... To Be Changed
    //extendArm.whenPressed(new ExtendLiftArm());
    //extendArm.whenReleased(new StopLiftArm());
    //retractArm = new JoystickButton(operation, 6); //Placeholder Value... To Be Changed
    //retractArm.whenPressed(new RetractLiftArm());
    //retractArm.whenReleased(new StopLiftArm());
    climber = new JoystickButton(operation, 5);
    climber.whenPressed(new StartClimb());
    climber.whenReleased(new EndClimb());
    hook = new JoystickButton(operation, 6);
    scaleHigh = new JoystickButton(operation,7);
    scaleHigh.whenPressed(new DropOffScaleHigh());
    scaleMedium = new JoystickButton(operation,8);
    switchHigh = new JoystickButton(operation,10);
    switchMeduim = new JoystickButton(operation,11);
    switchLow = new JoystickButton(operation,12);
    scaleLow = new JoystickButton(operation,13);


  }
  /*
   * Return an instance of the forwards/backwards joystick.
   */
  public Joystick getDrive_FB() {
    return drive_FB;
  }
  /*
   * Return an instance of the throttle joystick.
   */
  public Joystick getDrive_T() {
    return drive_T;
  }
  /*
   * Return an instance of the operation joystick.
   */
  public Joystick getOperation() {
    return operation;
  }
}
