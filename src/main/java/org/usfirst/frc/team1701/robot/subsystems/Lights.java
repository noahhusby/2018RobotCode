/**
 * subsystems/Lights.java
 *
 * @author Nicholas Hubbard
 * @since 2018-02-05
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import org.usfirst.frc.team1701.robot.RobotMap;
public class Lights extends Subsystem {
  private Spark led0 = RobotMap._led0;
  private Spark led1 = RobotMap._led1;
  /**
   * State of the LEDs running off of the Blinkin LED Driver (REV-11-1105-UM).
   * @see https://www.revrobotics.com/content/docs/REV-11-1105-UM.pdf page 14
   */
  public enum State {
    /**
     * Simple red.
     */
    RED(0.61),
    /**
     * Lawn clipping green.
     */
    GREEN(0.71),
    /**
     * Aqua blue.
     */
    BLUE(0.81)
  }
  /**
   * Set LED mode on controller 0.
   * @param color A reference to the State enum from above.
   */
  public void setLedModeA(double color) {
    led0.set(color);
  }
  /**
   * Set LED mode on controller 1.
   * @param color A reference to the State enum from above.
   */
  public void setLedModeB(double color) {
    led1.set(color);
  }
  /**
   * Set both LED modes.
   * @param color A reference to the State enum from above.
   */
  public void setLedModeBoth(double color) {
    led0.set(color);
    led1.set(color);
  }
  /**
   * Initialize default command.
   */
  protected void initDefaultCommand() {}
}