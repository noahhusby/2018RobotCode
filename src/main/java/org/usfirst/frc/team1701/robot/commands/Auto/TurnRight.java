/**
 * TurnRight.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class TurnRight extends Command {
    boolean isFinshed = false;
    public double navxStart;

    public TurnRight() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
        navxStart = Robot.driveTrain.getNavxAngle();
    }
    protected void execute() {
        if(Robot.driveTrain.getNavxAngle() > navxStart - 90) {
            Robot.driveTrain.teleopControl(0,-0.75);
        } else {
            isFinshed = true;
        }
    }
    protected boolean isFinished() {
        return isFinshed;
    }
    protected void end() {}
    protected void interrupted() {}
}
