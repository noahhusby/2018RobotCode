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
  public static JoystickButton stowPosition;
  public static JoystickButton manualWinchUp;
  public static JoystickButton manualWinchDown;
  public static JoystickButton manualWristUp;
  public static JoystickButton manualWristDown;


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
    stowPosition = new JoystickButton(drive_FB,1);
    stowPosition.whenPressed(new StowPosition());
    manualWinchUp = new JoystickButton(drive_FB,5);
    manualWinchUp.whenPressed(new WinchUp());
    manualWinchUp.whenReleased(new WinchStop());
    manualWinchDown = new JoystickButton(drive_FB, 6);
    manualWinchDown.whenPressed(new WinchDown());
    manualWinchDown.whenReleased(new WinchStop());
    manualWristUp = new JoystickButton(drive_FB,3);
    manualWristUp.whenPressed(new WristUp());
    manualWristUp.whenReleased(new WristStop());
    manualWristDown = new JoystickButton(drive_FB,4);
    manualWristDown.whenPressed(new WristDown());
    manualWristDown.whenReleased(new WristStop());

  }

}
