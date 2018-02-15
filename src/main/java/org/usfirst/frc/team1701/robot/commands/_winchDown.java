package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class _winchDown extends Command {
    protected void execute() {
        //Robot.liftArm.disableWinchBrake();
        RobotMap.winch1.set(-0.45);
        RobotMap.winch2.set(-0.45);
        RobotMap.winch3.set(-0.45);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
