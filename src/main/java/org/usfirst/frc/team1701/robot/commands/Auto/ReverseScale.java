/**
 * ReverseScale.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands.Auto;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
public class ReverseScale extends Command {
    boolean isFinished = false;
    public ReverseScale() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
        Robot.driveTrain.resetEncoders();
    }
    protected void execute() {
        if(Robot.driveTrain.getRightDistance() < Robot.position.scaleReverse) {
            Robot.driveTrain.teleopControl(-Robot.position.autonomousSpeed,0);
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
