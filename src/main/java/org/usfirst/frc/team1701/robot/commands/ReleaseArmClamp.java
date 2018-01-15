package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.subsystems.LiftArm;

public class ReleaseArmClamp extends Command{
    private boolean isDone = true;

    public ReleaseArmClamp() {
        requires(Robot.liftArm);
    }

    protected void initalize()
    {

    }
    protected void execute()
    {
        Robot.liftArm.releaseArmClamp();
    }
    protected boolean isFinished()
    {
        return isDone;
    }
    protected void end() {}
    protected void interrupted() {}
}
