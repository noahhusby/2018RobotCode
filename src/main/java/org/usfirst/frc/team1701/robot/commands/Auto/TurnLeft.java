<<<<<<< HEAD
/**
=======
/*
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * TurnLeft.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands.Auto;
<<<<<<< HEAD

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class TurnLeft extends Command {
    boolean isFinshed = false;

    public double navxStart;

=======
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
public class TurnLeft extends Command {
    private boolean isFinished = false;
    private double navxStart;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
    public TurnLeft() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
        navxStart = Robot.driveTrain.getNavxAngle();
    }
    protected void execute() {
        if(Robot.driveTrain.getNavxAngle() < navxStart + Robot.position.leftAngle) {
            Robot.driveTrain.teleopControl(0,0.75);
        } else {
<<<<<<< HEAD
            isFinshed = true;
        }
    }
    protected boolean isFinished() {
        return isFinshed;
=======
            isFinished = true;
        }
    }
    protected boolean isFinished() {
        return isFinished;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
    }
    protected void end() {
        Robot.driveTrain.resetEncoders();
    }
    protected void interrupted() {}
}
