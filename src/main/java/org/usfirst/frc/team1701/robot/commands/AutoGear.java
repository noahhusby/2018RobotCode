/*
 * AutoGear.java
 *
 * @author Noah Husby and Nicholas Hubbard
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

@SuppressWarnings("unused")
public class AutoGear extends Command {
    private DriverStation ds = DriverStation.getInstance();
    private boolean isFinished = false;
    private double speedAt = 0.60;
    private DoubleSolenoid.Value status = RobotMap.driveShift.get();
    private double currentAverage;
    public AutoGear() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
        if(ds.isAutonomous()) {
            end(); // Do absolutely nothing. End the command now. We do not want to change gears in autonomous!
        }
        currentAverage = (RobotMap._leftFrontMotor.get() + RobotMap._leftBackMotor.get() + RobotMap._rightFrontMotor.get() + RobotMap._rightBackMotor.get()) / 4;
    }
    protected void execute() {
        if(currentAverage >= speedAt && status != DoubleSolenoid.Value.kForward) {
            RobotMap.driveShift.set(DoubleSolenoid.Value.kForward);
        } else {
            end(); // Do absolutely nothing. End the command now. We do not want to change gears.
        }
        isFinished = true;
    }
    protected boolean isFinished() {
        return isFinished;
    }
    protected void end() {}
    protected void interrupted() {}
}
