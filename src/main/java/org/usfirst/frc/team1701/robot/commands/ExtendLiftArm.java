package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class ExtendLiftArm extends Command {
    private boolean isFinished = true;

    public ExtendLiftArm() {
        requires(Robot.liftArm);
    }
    protected void initalize()
    {

    }
    protected void execute()
    {
        Robot.liftArm.extendArm();
    }
    protected boolean isFinished()
    {
        return isFinished;
    }
    protected void end() {}
    protected void interrupted() {}

}
