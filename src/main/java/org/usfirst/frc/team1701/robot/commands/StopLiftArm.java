package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class StopLiftArm extends Command{
    private boolean isFinished = true;

    public StopLiftArm() {
        requires(Robot.liftArm);
    }
    protected void initalize()
    {

    }
    protected void execute()
    {
        Robot.liftArm.stopArm();
    }
    protected boolean isFinished()
    {
        return isFinished;
    }
    protected void end() {}
    protected void interrupted() {}

}
