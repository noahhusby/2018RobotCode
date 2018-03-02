package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class ResetWrist extends Command {
    public ResetWrist() {
        requires(Robot.liftArm);
    }

    protected void initialize() {
    }
    protected void execute() {
        RobotMap.wrist.setSelectedSensorPosition(0,RobotMap.encPidIdx,0);
    }
    protected boolean isFinished() {
        return true;
    }
    protected void end() {}
    protected void interrupted() {}
}
