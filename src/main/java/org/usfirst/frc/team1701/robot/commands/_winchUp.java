package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class _winchUp extends Command {
    protected void execute() {
        Robot.liftArm.disableWinchBrake();
        RobotMap.winch1.set(0.5);
        RobotMap.winch1.set(0.5);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
