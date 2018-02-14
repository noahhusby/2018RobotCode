package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class _winchUnBrake extends Command{


        protected void execute() {
            Robot.liftArm.disableWinchBrake();

        }

        protected boolean isFinished() {
            return true;
        }

        protected void end() {}

        protected void interrupted() {}
    }

