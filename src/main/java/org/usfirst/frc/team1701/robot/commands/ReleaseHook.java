package org.usfirst.frc.team1701.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class ReleaseHook extends Command{
    private boolean isDone = true;

    public ReleaseHook() {
        requires(Robot.hook);
    }
    protected void initalize()
    {

    }
    protected void execute()
    {
        Robot.hook.releaseHook();
    }
    protected boolean isFinished()
    {
        return isDone;
    }
    protected void end() {}
    protected void interrupted() {}
}

