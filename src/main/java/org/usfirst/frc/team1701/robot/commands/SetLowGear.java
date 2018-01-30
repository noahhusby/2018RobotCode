package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1701.robot.OI;
import org.usfirst.frc.team1701.robot.Robot;

public class SetLowGear extends Command {
    public SetLowGear() {
        requires(Robot.driveTrain);
    }

    protected void initialize() {

    }

    protected void execute() {
        Robot.driveTrain.setAutoGear(false);
        Robot.driveTrain.setLowGear();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
