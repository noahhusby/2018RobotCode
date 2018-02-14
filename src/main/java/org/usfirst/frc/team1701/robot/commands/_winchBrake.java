package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class _winchBrake extends Command {
    protected void execute() {
        RobotMap.winch1.stopMotor();
        RobotMap.winch2.stopMotor();
        RobotMap.winch3.stopMotor();
        //Robot.liftArm.enableWinchBrake();

    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
