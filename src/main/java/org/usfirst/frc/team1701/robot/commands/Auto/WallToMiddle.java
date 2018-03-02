/**
 * WallToMiddle.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.Robot;

public class WallToMiddle extends Command {

    boolean isFinshed = false;

    public WallToMiddle() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
        Robot.driveTrain.resetEncoders();
    }
    protected void execute() {
        isFinshed = false;
        if(Robot.driveTrain.getRightDistance() < Robot.position.wallToCube) {
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
