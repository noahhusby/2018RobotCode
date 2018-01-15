package org.usfirst.frc.team1701.robot.commands;

import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.OI;
import edu.wpi.first.wpilibj.command.Command;


public class StartClimb extends Command {
    private boolean isFinished = true;

    public StartClimb() {
        requires(Robot.winch);
    }
    //needs winch to work
    protected void initalize()
    {

    }
    protected void execute()
    {
        Robot.winch.winchStart();
    }
    //Similar to the retractarm, we dont have an end for the winch yet
    protected boolean isFinished()
    {
        return isFinished;
    }
    protected void end() {}
    protected void interrupted() {}
}
