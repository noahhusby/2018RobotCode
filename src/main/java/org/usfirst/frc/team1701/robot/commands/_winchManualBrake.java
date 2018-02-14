package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class _winchManualBrake extends Command {


        protected void execute() {
            Robot.liftArm.enableWinchBrake();

        }

        protected boolean isFinished() {
            return true;
        }

        protected void end() {}

        protected void interrupted() {}



}
