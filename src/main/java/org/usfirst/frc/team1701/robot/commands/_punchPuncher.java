package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.RobotMap;

public class _punchPuncher extends Command {
    protected void execute() {
        RobotMap.puncher.set(DoubleSolenoid.Value.kForward);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
