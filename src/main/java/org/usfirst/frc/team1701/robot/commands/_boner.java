package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class _boner extends Command {

    public boolean isFinshed = false;
    private double value = 40;

    public _boner() {
        requires(Robot.liftArm);
    }
    protected void execute() {

        isFinshed = false;

        if(RobotMap.liftArmEncoder.getValue() - 497 > SmartDashboard.getNumber("Ian",0) + 40) {
            Robot.liftArm.setLiftArm(0.35);
        }
        else if(RobotMap.liftArmEncoder.getValue() - 497 < SmartDashboard.getNumber("Ian",0) - 40) {
            Robot.liftArm.setLiftArm(-0.35);
        }
        else {
            Robot.liftArm.setLiftArm(0);
            Robot.liftArm.stopLiftArm();
            isFinshed = true;
        }

    }

    protected boolean isFinished() {
        return isFinshed;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
