package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.subsystems.LiftArm;

public class ReleaseArmClamp extends Command{
    private boolean isDone = true;

    public ReleaseArmClamp() {
        requires(Robot.liftArm);
    }
    //It needs liftArm to function
    protected void initalize()
    {

    }
    protected void execute()
    {
        Robot.liftArm.releaseArmClamp();
    }
    //Releases the clamp at the end of the arm
    protected boolean isFinished()
    {
        return isDone;
    }
    protected void end() {}
    protected void interrupted() {}
}
