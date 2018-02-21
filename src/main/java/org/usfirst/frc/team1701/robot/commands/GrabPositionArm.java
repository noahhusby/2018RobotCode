package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class GrabPositionArm extends Command{

    boolean isFinished = false;

    public GrabPositionArm() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
    }
    protected void execute() {
        isFinished = false;
        if(Robot.liftArm.getArmAngle()> Robot.position.armGrab + 10) {
            Robot.liftArm.setLiftArm(0.85);
        }
        else if(Robot.liftArm.getArmAngle() < Robot.position.armGrab - 10) {
            Robot.liftArm.setLiftArm(-0.85);
        }
        else {
            Robot.liftArm.stopLiftArm();
            isFinished = true;
        }
    }
    protected boolean isFinished() {
        return isFinished;
    }
    protected void end() {}
    protected void interrupted() {}
}
