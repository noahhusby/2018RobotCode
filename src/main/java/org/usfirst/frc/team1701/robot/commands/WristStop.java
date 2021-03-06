/**
 * WristStop.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class WristStop extends Command{
    protected void execute() {
        Robot.liftArm.stopWrist();
        Robot.liftArm.enableWristBrake();
    }
    protected boolean isFinished() {
        return true;
    }
    protected void end() {}
    protected void interrupted() {}
}
