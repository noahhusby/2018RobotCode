/**
 * TurnToSwitch.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class TurnToSwitchRight extends Command {
    boolean isFinshed = false;

    public TurnToSwitchRight() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
        Robot.driveTrain.resetEncoders();
    }
    protected void execute() {
        if(Robot.driveTrain.getRightDistance() < Robot.position.turnToSwitchRight) {
            Robot.driveTrain.teleopControl(-Robot.position.autonomousSpeed,0);
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
