package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class GrabPosition extends Command {

    public GrabPosition() {
        requires(Robot.liftArm);
    }

    protected void initialize() {

    }

    protected void execute() {
        if(Robot.liftArm.getArmAngle() <= Robot.position.grabArm) {
            Robot.liftArm.setLiftArm(0.65);
        }
        else if(Robot.liftArm.getArmAngle() >= Robot.position.grabArm)
        {
            Robot.liftArm.setLiftArm(-0.65);
        }





    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}

}

