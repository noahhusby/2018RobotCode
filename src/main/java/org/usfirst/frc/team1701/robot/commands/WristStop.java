<<<<<<< HEAD
/**
=======
/*
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * WristStop.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
<<<<<<< HEAD

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class WristStop extends Command{
    protected void execute() {
        Robot.liftArm.stopWrist();
        Robot.liftArm.enableWristBrake();
=======
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
public class WristStop extends Command{
    protected void execute() {
        Robot.liftArm.stopWrist();
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
    }
    protected boolean isFinished() {
        return true;
    }
    protected void end() {}
    protected void interrupted() {}
}
