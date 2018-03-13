package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class UnCancel extends Command {
    public UnCancel() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {}
    protected void execute() {
        //RobotMap.cancelAll = false;
    }
    protected boolean isFinished() {
        return true;
    }
    protected void end() {}
    protected void interrupted() {}
}
