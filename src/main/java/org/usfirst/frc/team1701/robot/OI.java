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
  /**
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
   */
  public static JoystickButton _winchUp;
  public static JoystickButton _winchDown;
  public static JoystickButton _wristRight;
  public static JoystickButton _wristLeft;
  public static JoystickButton _lowGear;
  public static JoystickButton _highGear;
  public static JoystickButton _winchGearShiftLow;
  public static JoystickButton _winchGearShiftHigh;
  public static JoystickButton _puncher;
  public static JoystickButton _clamp;
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
    /**
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
     */
    _winchUp = new JoystickButton(drive_FB,5);
    _winchUp.whenPressed(new _winchUp());
    _winchUp.whenReleased(new _winchBrake());
    _winchDown = new JoystickButton(drive_FB, 6);
    _winchDown.whenPressed(new _winchDown());
    _winchDown.whenReleased(new _winchBrake());
    _wristRight = new JoystickButton(drive_FB,3);
    _wristRight.whenPressed(new _wristRight());
    _wristRight.whenReleased(new _wristBrake());
    _wristLeft = new JoystickButton(drive_FB,4);
    _wristLeft.whenPressed(new _wristLeft());
    _wristLeft.whenReleased(new _wristBrake());
    _lowGear = new JoystickButton(drive_FB,1);
    _lowGear.whenPressed(new _setLowGear());
    _highGear = new JoystickButton(drive_FB,2);
    _highGear.whenPressed(new _setHighGear());
    _winchGearShiftLow = new JoystickButton(operation,1);
    _winchGearShiftLow.whenPressed(new _setWinchLowGear());
    _winchGearShiftHigh = new JoystickButton(operation,2);
    _winchGearShiftHigh.whenPressed(new _setWinchHighGear());
    _puncher = new JoystickButton(operation,3);
    _puncher.whenPressed(new _punchPuncher());
    _puncher.whenReleased(new _notPunchPuncher());
    _clamp = new JoystickButton(operation,9);
    _clamp.whenPressed(new _doClamp());
    _clamp.whenReleased(new _stopDoingClamp());




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
