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

  public static JoystickButton grabCube;
  public static JoystickButton releaseCube;
  public static JoystickButton releasePunchCube;
  public static JoystickButton reverse;
  public static JoystickButton scalePosition;
  public static JoystickButton grabPosition;
  public static JoystickButton switchPosition;


  public static JoystickButton _winchUp;
  public static JoystickButton _winchDown;
  public static JoystickButton _wristRight;
  public static JoystickButton _wristLeft;
  public static JoystickButton _winchGearShiftLow;
  public static JoystickButton _winchGearShiftHigh;
  public static JoystickButton _manualBrake;

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
    drive_FB = new Joystick(1); // Left
    drive_T = new Joystick(2); // Right
    /*
     * Assign commands to buttons.
     */

    releaseCube = new JoystickButton(operation,4);
    releaseCube.whenPressed(new ReleaseCube());
    releasePunchCube = new JoystickButton(operation,3);
    releasePunchCube.whenPressed(new ReleaseAndPunch());
    grabCube = new JoystickButton(operation,6);
    grabCube.whenPressed(new GrabCube());
    reverse = new JoystickButton(operation, 7);
    reverse.whenPressed(new ToggleReverse());
    scalePosition = new JoystickButton(operation,8);
    scalePosition.whenPressed(new ScalePosition());
    grabPosition = new JoystickButton(operation,10);
    grabPosition.whenPressed(new GrabPosition());
    switchPosition = new JoystickButton(drive_FB,2);
    switchPosition.whenPressed(new SwitchPosition());



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


    _winchGearShiftLow = new JoystickButton(operation,1);
    _winchGearShiftLow.whenPressed(new _setWinchLowGear());
    _winchGearShiftHigh = new JoystickButton(operation,2);
    _winchGearShiftHigh.whenPressed(new _setWinchHighGear());


    _manualBrake = new JoystickButton(operation,5);
    _manualBrake.whenPressed(new _winchManualBrake());
    _manualBrake.whenReleased(new _winchUnBrake());






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
