<<<<<<< HEAD
/**
=======
/*
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * LowGear.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1701.robot.OI;
import org.usfirst.frc.team1701.robot.Robot;

public class LowGear extends Command {
    public LowGear() {
        requires(Robot.driveTrain);
    }

    protected void initialize() {
    }
=======
import org.usfirst.frc.team1701.robot.Robot;

class LowGear extends Command {
    @SuppressWarnings("unused")
    public LowGear() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {}
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
    protected void execute() {
        Robot.driveTrain.setLowGear();
    }
    protected boolean isFinished() {
        return true;
    }
    protected void end() {}
    protected void interrupted() {}
}
