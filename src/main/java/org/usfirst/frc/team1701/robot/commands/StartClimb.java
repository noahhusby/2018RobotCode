package org.usfirst.frc.team1701.robot.commands;

import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.OI;
import edu.wpi.first.wpilibj.command.Command;


public class StartClimb extends Command {
    private boolean isFinished = true;

    public StartClimb() {
        requires(Robot.climbMotors);
    }
    protected void initalize()
    {

    }
    protected void execute()
    {
        Robot.climbMotors.climbStart();
    }
    protected boolean isFinished()
    {
        return isFinished;
    }
    protected void end() {}
    protected void interrupted() {}
}
