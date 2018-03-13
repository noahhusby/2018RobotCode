/*
 * OI.java
 *
 * @author Noah Husby
 * @since 12/21/17
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team1701.robot.commands.*;
/*
 * This class sets up and enables the Joysticks and Buttons on your console.
 */
public class OI {
  /*
   * Create initial values.
   */

  public static JoystickButton grabCube;
  public static JoystickButton releaseCube;
  public static JoystickButton releasePunchCube;
  public static JoystickButton reverse;
  public static JoystickButton scalePosition;
  public static JoystickButton grabPosition;
  public static JoystickButton switchPosition;
  public static JoystickButton switchShootPosition;
  public static JoystickButton stowPosition;
  public static JoystickButton climbPosition;
  public static JoystickButton climb;
  public static JoystickButton manualWinchUp;
  public static JoystickButton manualWinchDown;
  public static JoystickButton manualWristUp;
  public static JoystickButton manualWristDown;
  public static JoystickButton gear;
  public static JoystickButton cancel;

  public static JoystickButton manualWristReset;

  public static Joystick operation;
  public static Joystick drive_FB;
  public static Joystick drive_T;
  /**
   * Instead of an init() function, we call this on OI startup.
   */
  public OI() {
    /*
     * Enable the physical joysticks.
     */
    operation = new Joystick(0);
    drive_FB = new Joystick(1); // Left
    drive_T = new Joystick(2); // Right
    /*
     * Assign commands to buttons.
     */
    releaseCube = new JoystickButton(operation, 4);
    releaseCube.whenPressed(new ReleaseCube());
    releaseCube.whenReleased(new ResetReleaseCube());
    releasePunchCube = new JoystickButton(operation, 2);
    releasePunchCube.whenPressed(new ReleaseAndPunch());
    grabCube = new JoystickButton(operation, 9);
    grabCube.whenPressed(new GrabCube());
    reverse = new JoystickButton(drive_FB, 6);
    reverse.whenPressed(new ReverseOn());
    reverse.whenReleased(new ReverseOff());
    scalePosition = new JoystickButton(operation, 16);
    scalePosition.whenPressed(new ScalePosition());
    grabPosition = new JoystickButton(operation, 12);
    grabPosition.whenPressed(new GrabPosition());
    switchPosition = new JoystickButton(operation, 8);
    switchPosition.whenPressed(new SwitchPosition());
    switchShootPosition = new JoystickButton(operation, 1);
    switchShootPosition.whenPressed(new SwitchShootPosition());
    stowPosition = new JoystickButton(operation, 14);
    stowPosition.whenPressed(new StowPosition());
    climbPosition = new JoystickButton(operation, 6);
    climbPosition.whenPressed(new ClimbPosition());
    climb = new JoystickButton(operation, 5);
    climb.whileHeld(new Climb());
    climb.whenReleased(new StopClimb());
    manualWinchUp = new JoystickButton(operation, 3);
    manualWinchUp.whileHeld(new WinchUp());
    manualWinchUp.whenReleased(new WinchStop());
    manualWinchDown = new JoystickButton(operation, 10);
    manualWinchDown.whileHeld(new WinchDown());
    manualWinchDown.whenReleased(new WinchStop());
    manualWristUp = new JoystickButton(operation, 7);
    manualWristUp.whenPressed(new WristDown());
    manualWristUp.whenReleased(new WristStop());
    manualWristDown = new JoystickButton(operation, 13);
    manualWristDown.whenPressed(new WristUp());
    manualWristDown.whenReleased(new WristStop());
    gear = new JoystickButton(drive_FB,3);
    gear.whenPressed(new AutoGear());
    gear.whenReleased(new LowGear());
    cancel = new JoystickButton(operation,17);
    cancel.whenPressed(new Cancel());
    //cancel.whenReleased(new UnCancel());

    manualWristReset = new JoystickButton(operation,15);
    manualWristReset.whenPressed(new ResetWrist());
  }
}