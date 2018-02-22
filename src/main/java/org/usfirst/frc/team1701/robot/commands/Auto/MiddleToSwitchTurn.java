/**
 * MiddleToSwitchTurn.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class MiddleToSwitchTurn extends Command {
    boolean isFinshed = false;

    public MiddleToSwitchTurn() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
        Robot.driveTrain.resetEncoders();
        Robot.driveTrain.stopMotors();
    }
    protected void execute() {
        if(Robot.driveTrain.getRightDistance() < Robot.position.centerToSide) {
            Robot.driveTrain.teleopControl(-1,0);
        } else  {
            isFinshed = true;
        }
    }
    protected boolean isFinished() {
        return isFinshed;
    }
    protected void end() {}
    protected void interrupted() {}
}
