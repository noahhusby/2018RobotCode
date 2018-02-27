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
  public static Joystick drive_FB;
  public static Joystick drive_T;

  /**
   * Instead of an init() function, we call this on OI startup.
   */
  public OI() {
    //logger.info("Assigning joystick values...");
    /*
     * Enable the physical joysticks.
     */
    Joystick operation = new Joystick(0);
    drive_FB = new Joystick(1); // Left
    drive_T = new Joystick(2); // Right
    Joystick testButton = new Joystick(3);
    /*
     * Assign commands to buttons.
     */
    JoystickButton releaseCube = new JoystickButton(operation, 4);
    releaseCube.whenPressed(new ReleaseCube());
    JoystickButton releasePunchCube = new JoystickButton(operation, 3);
    releasePunchCube.whenPressed(new ReleaseAndPunch());
    JoystickButton grabCube = new JoystickButton(operation, 6);
    grabCube.whenPressed(new GrabCube());
    JoystickButton reverse = new JoystickButton(operation, 7);
    reverse.whenPressed(new ToggleReverse());
    JoystickButton scalePosition = new JoystickButton(operation, 8);
    scalePosition.whenPressed(new ScalePosition());
    JoystickButton grabPosition = new JoystickButton(operation, 10);
    grabPosition.whenPressed(new GrabPosition());
    JoystickButton switchPosition = new JoystickButton(drive_FB, 2);
    switchPosition.whenPressed(new SwitchPosition());
    JoystickButton switchShootPosition = new JoystickButton(operation, 1);
    switchShootPosition.whenPressed(new SwitchShootPosition());
    JoystickButton stowPosition = new JoystickButton(drive_FB, 1);
    stowPosition.whenPressed(new StowPosition());
    JoystickButton climbPosition = new JoystickButton(testButton, 1);
    climbPosition.whenPressed(new ClimbPosition());
    JoystickButton climb = new JoystickButton(operation, 2);
    climb.whenPressed(new Climb());
    climb.whenReleased(new StopClimb());
    JoystickButton manualWinchUp = new JoystickButton(drive_FB, 5);
    manualWinchUp.whenPressed(new WinchUp());
    manualWinchUp.whenReleased(new WinchStop());
    JoystickButton manualWinchDown = new JoystickButton(drive_FB, 6);
    manualWinchDown.whenPressed(new WinchDown());
    manualWinchDown.whenReleased(new WinchStop());
    JoystickButton manualWristUp = new JoystickButton(drive_FB, 3);
    manualWristUp.whenPressed(new WristUp());
    manualWristUp.whenReleased(new WristStop());
    JoystickButton manualWristDown = new JoystickButton(drive_FB, 4);
    manualWristDown.whenPressed(new WristDown());
    manualWristDown.whenReleased(new WristStop());
  }
}
