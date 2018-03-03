package org.usfirst.frc.team1701.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class WallToStraightSwitch extends Command {
    boolean isFinished = false;

    public WallToStraightSwitch() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
        Robot.driveTrain.resetEncoders();
    }
    protected void execute() {
        if(Robot.driveTrain.getRightDistance() < Robot.position.wallToStraightSwitch) {
            Robot.driveTrain.teleopControl(-Robot.position.autonomousSpeed,0);
        } else {
            isFinished = true;
        }
    }
    protected boolean isFinished() {
        return isFinished;
    }
    protected void end() {}
    protected void interrupted() {}

}
