package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class Cancel extends Command {
    public Cancel() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {}
    protected void execute() {
        RobotMap.cancelAll = true;
    }
    protected boolean isFinished() {
        return true;
    }
    protected void end() {}
    protected void interrupted() {}
}
