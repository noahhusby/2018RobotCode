package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class EndClimb extends Command{
    private boolean isFinished = true;

    public EndClimb() {
        requires(Robot.winch);
    }
    protected void initalize()
    {

    }
    protected void execute()
    {
        Robot.winch.winchEnd();
    }
    protected boolean isFinished()
    {
        return isFinished;
    }
    protected void end() {}
    protected void interrupted() {}
}
