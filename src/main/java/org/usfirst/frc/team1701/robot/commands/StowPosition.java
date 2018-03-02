/**
 * StowPosition.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class StowPosition extends Command{
    public StowPosition() {
        requires(Robot.liftArm);
    }
    private boolean isFinshed;
    protected void initialize() {}
    protected void execute() {
        Robot.liftArm.disableWristBrake();
        isFinshed = false;
        Robot.liftArm.setGrabber(true);

        if(Robot.liftArm.getWristAngle() > Robot.position.wristStow + 50)
        {
            Robot.liftArm.setWrist(0.75);
        }
        else if(Robot.liftArm.getWristAngle() < Robot.position.wristStow - 50)
        {
            Robot.liftArm.setWrist(-0.75);
        }
        else
        {
            isFinshed = true;
            Robot.liftArm.stopWrist();
        }
    }
    protected boolean isFinished() {
        return isFinshed;
    }
    protected void end() {
        Robot.liftArm.enableWristBrake();
    }
    protected void interrupted() {}
}
