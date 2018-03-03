package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class ResetReleaseCube extends Command {
    public ResetReleaseCube() {
        requires(Robot.liftArm);
    }
    protected void initialize() {
    }
    protected void execute() {
        Robot.position.isReleasePressed = false;
        Robot.liftArm.setGrabber(false);
    }
    protected boolean isFinished() {
        return true;
    }
    protected void end() {}
    protected void interrupted() {}
}
