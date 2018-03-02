/**
 * WinchStop.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class WinchStop extends Command {
    protected void execute() {
        Robot.liftArm.stopLiftArm();
    }
    protected boolean isFinished() {
        return true;
    }
    protected void end() {}
    protected void interrupted() {}
}
