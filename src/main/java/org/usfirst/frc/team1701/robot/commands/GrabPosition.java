package org.usfirst.frc.team1701.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;
import org.usfirst.frc.team1701.robot.subsystems.Position;

public class GrabPosition extends Command {
    public GrabPosition() {
        requires(Robot.liftArm);
    }

    private boolean isFinshed;

    private void stowWrist() {

        Robot.liftArm.setArmClamp(true);

        if(Robot.liftArm.getWristAngle() > Robot.position.wristStow + 50)
        {
            Robot.liftArm.setWrist(0.50);
        }
        else if(Robot.liftArm.getWristAngle() < Robot.position.wristStow - 50)
        {
            Robot.liftArm.setWrist(-0.50);
        }
        else
        {
            Robot.liftArm.stopWrist();
        }
    }

    private void grabWrist() {
        if(Robot.liftArm.getWristAngle() > Robot.position.wristGrab + 50)
        {
            Robot.liftArm.setWrist(0.50);
        }
        else if(Robot.liftArm.getWristAngle() < Robot.position.wristGrab - 50)
        {
            Robot.liftArm.setWrist(-0.50);
        }
        else
        {
            Robot.liftArm.stopWrist();
            Robot.liftArm.setArmClamp(false);
            isFinshed = true;
        }
    }




    protected void initialize() {}
    protected void execute() {
        isFinshed = false;

        if(RobotMap.liftArmEncoder.getValue() - 497 > Robot.position.armGrab + 40) {
            Robot.liftArm.setLiftArm(0.35);
            stowWrist();
        }
        else if(RobotMap.liftArmEncoder.getValue() - 497 < Robot.position.armGrab - 40) {
            Robot.liftArm.setLiftArm(-0.35);
            stowWrist();
        }
        else {
            Robot.liftArm.stopLiftArm();
            grabWrist();
        }
    }
    protected boolean isFinished() {
        return isFinshed;
    }
    protected void end() {}
    protected void interrupted() {}
}

