package org.usfirst.frc.team1701.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
public class AutoGear extends Command {
    public AutoGear() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {}
    protected void execute() {
        Robot.driveTrain.setAutoGear(true);
    }
    protected boolean isFinished() {
        return true;
    }
    protected void end() {}
    protected void interrupted() {}
}
