package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class StowPosition extends Command{
    public StowPosition() {
        requires(Robot.liftArm);
    }
    private boolean isFinshed;
    protected void initialize() {}
    protected void execute() {
        isFinshed = false;
        Robot.liftArm.setGrabber(true);

        if(Robot.liftArm.getWristAngle() > Robot.position.wristStow + 50)
        {
            Robot.liftArm.setWrist(0.50);
        }
        else if(Robot.liftArm.getWristAngle() < Robot.position.wristStow - 50)
        {
            Robot.liftArm.setWrist(-0.50);
        }
        else if(Robot.liftArm.getWristAngle() > Robot.position.wristStow - 50 && Robot.liftArm.getWristAngle() < Robot.position.wristStow + 50)
        {
            isFinshed = true;
            Robot.liftArm.stopWrist();
        }
    }
    protected boolean isFinished() {
        return isFinshed;
    }
    protected void end() {}
    protected void interrupted() {}
}
