package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;


public class GrabArmClamp extends Command{
    private boolean isDone = true;

    public GrabArmClamp() {
        requires(Robot.liftArm);
    }
    protected void initalize()
    {

    }
    protected void execute()
    {
        Robot.liftArm.grabArmClamp();
    }
    protected boolean isFinished()
    {
        return isDone;
    }
    protected void end() {}
    protected void interrupted() {}
}
