package org.usfirst.frc.team1701.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class TurnLeft extends Command {
    boolean isFinshed = false;

    public TurnLeft() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {

    }
    protected void execute() {
        if(Robot.driveTrain.getNavxAngle() < Robot.position.leftTurn - 10) {
            Robot.driveTrain.teleopControl(0,0.75);
        } else {
            isFinshed = true;
        }
    }
    protected boolean isFinished() {
        return isFinshed;
    }
    protected void end() {}
    protected void interrupted() {}
}
