package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class _doClamp extends Command {
    public _doClamp() {
        requires(Robot.liftArm);
    }
    protected void execute() {
        Robot.liftArm.setArmClamp(true);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
