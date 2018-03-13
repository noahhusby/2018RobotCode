/**
 * ReleaseCube.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class ReleaseCube extends Command{

    public ReleaseCube() {
        requires(Robot.liftArm);
    }
    protected void initialize() {
    }
    protected void execute() {
        //RobotMap.cancelAll = true;
        Robot.position.isReleasePressed = true;
        Robot.liftArm.setGrabber(false);

    }
    protected boolean isFinished() {
        return true;
    }
    protected void end() {
    }
    protected void interrupted() {}
}
