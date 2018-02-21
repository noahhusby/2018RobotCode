package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class StopClimb extends Command {
    public StopClimb() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
    }
    protected void execute() {
        Robot.liftArm.stopLiftArm();
    }
    protected boolean isFinished() {
        return true;
    }
    protected void end() {}
    protected void interrupted() {}
}
