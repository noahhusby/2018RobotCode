package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class RetractLiftArm extends Command{
    private boolean isFinished = true;

    public RetractLiftArm() {
        requires(Robot.liftArm);
    }
    protected void initalize()
    {

    }
    protected void execute()
    {
        Robot.liftArm.retractArm();
    }
    protected boolean isFinished()
    {
        return isFinished;
    }
    protected void end() {}
    protected void interrupted() {}

}
