/**
 * Climb.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class Climb extends Command {

    public Climb() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
    }
    protected void execute() {
        Robot.liftArm.disableWristBrake();
        Robot.liftArm.winchLowGear();
      Robot.liftArm.setLiftArm(1);
    }
    protected boolean isFinished() {
        return true;
    }
    protected void end() {
        //Robot.liftArm.stopLiftArm();
    }
    protected void interrupted() {
        Robot.liftArm.stopLiftArm();
    }
}
