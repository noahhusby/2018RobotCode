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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.usfirst.frc.team1701.robot.commands.*;

public class OI {

  public static Joystick drive_FB;
  public static Joystick drive_T;
  public static Joystick operation;
  public static JoystickButton gearMode;
  public static JoystickButton resetGyro;
  public static JoystickButton preciseMode;
  public static JoystickButton turboMode;
  public static JoystickButton extendArm;
  public static JoystickButton retractArm;
  public static JoystickButton climber;
  public static JoystickButton hook;
  private static final Logger logger = LogManager.getLogger();

  public OI() {

    logger.info("Assigning joystick values...");
    //Assign joysticks addresses (from DriverStation)
    operation = new Joystick(0);
    drive_FB = new Joystick(1);
    drive_T = new Joystick(2);

    gearMode = new JoystickButton(operation, 1);
    resetGyro = new JoystickButton(operation, 2);
    preciseMode = new JoystickButton(operation, 3);
    turboMode = new JoystickButton(operation, 4);
    extendArm = new JoystickButton(operation, 5); //Placeholder Value... To Be Changed
    extendArm.whenPressed(new ExtendLiftArm());
    extendArm.whenReleased(new StopLiftArm());
    retractArm = new JoystickButton(operation, 6); //Placeholder Value... To Be Changed
    retractArm.whenPressed(new RetractLiftArm());
    retractArm.whenReleased(new StopLiftArm());
    climber = new JoystickButton(operation, 7);
    climber.whenPressed(new StartClimb());
    climber.whenReleased(new EndClimb());
    hook = new JoystickButton(operation, 8);
  }

  public Joystick getDrive_FB() {
    return drive_FB;
  }

  public Joystick getDrive_T() {
    return drive_T;
  }

  public Joystick getOperation() {
    return operation;
  }
}
