/*
 * AutoGear.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
@SuppressWarnings("unused")
public class AutoGear extends Command {
    public AutoGear() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {}
    protected void execute() {}
    protected boolean isFinished() {
        return true;
    }
    protected void end() {}
    protected void interrupted() {}
}
