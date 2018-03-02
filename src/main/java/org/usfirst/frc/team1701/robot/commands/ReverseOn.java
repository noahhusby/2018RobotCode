package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class ReverseOn extends Command {
    public ReverseOn() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {

    }
    protected void execute() {
        Robot.driveTrain.setReverse(true);
    }
    protected boolean isFinished() {
        return true;
    }
    protected void end() {}
    protected void interrupted() {}
}
