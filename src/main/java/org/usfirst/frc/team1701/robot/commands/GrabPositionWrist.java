/**
 * GrabPositionWrist.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class GrabPositionWrist extends Command{
    boolean isFinished= false;

    public GrabPositionWrist() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
    }
    protected void execute() {
        Robot.liftArm.disableWristBrake();
        isFinished = false;
        if(Robot.liftArm.getWristAngle() > Robot.position.wristGrab + 50)
        {
            Robot.liftArm.setWrist(0.50);
        }
        else if(Robot.liftArm.getWristAngle() < Robot.position.wristGrab - 50)
        {
            Robot.liftArm.setWrist(-0.50);
        }
        else
        {
            isFinished = true;
            Robot.liftArm.stopWrist();
            Robot.liftArm.setGrabber(false);
        }
    }
    protected boolean isFinished() {
        return isFinished;
    }
    protected void end() {
        Robot.liftArm.enableWristBrake();
    }
    protected void interrupted() {}
}
