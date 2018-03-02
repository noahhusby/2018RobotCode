<<<<<<< HEAD
/**
=======
/*
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * ReleaseCube.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
<<<<<<< HEAD

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class ReleaseCube extends Command{

    public ReleaseCube() {
        requires(Robot.liftArm);
    }
    protected void initialize() {
    }
=======
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
public class ReleaseCube extends Command{
    public ReleaseCube() {
        requires(Robot.liftArm);
    }
    protected void initialize() {}
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
    protected void execute() {
        Robot.liftArm.setGrabber(false);
    }
    protected boolean isFinished() {
        return true;
    }
    protected void end() {}
    protected void interrupted() {}
}
