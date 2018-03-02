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
    boolean isFinished = false;
    int count;

    public MiddleToSwitchTurn() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
        Robot.driveTrain.resetEncoders();
        Robot.driveTrain.stopMotors();
        count = 0;
    }
    protected void execute() {
        isFinished = false;
        if(Robot.driveTrain.getRightDistance() <= Robot.position.centerToSide && count < 20) {
            Robot.driveTrain.teleopControl(-1,0);
            count++;
        } else  {
            isFinished = true;
        }
    }
    protected boolean isFinished() {
        return isFinished;
    }
    protected void end() {}
    protected void interrupted() {}
}
