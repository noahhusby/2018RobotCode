/**
 * ReleaseAndPunch.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class ReleaseAndPunch extends Command {

    public ReleaseAndPunch() {
        requires(Robot.liftArm);
    }
    protected void initialize() {

    }
    protected void execute() {
        //RobotMap.cancelAll = true;
        Robot.liftArm.setGrabber(false);
        Robot.liftArm.extendPuncher();
        Timer.delay(0.5);
        Robot.liftArm.retractPuncher();

    }
    protected boolean isFinished() {
        return true;
    }
    protected void end() {

    }
    protected void interrupted() {}
}
