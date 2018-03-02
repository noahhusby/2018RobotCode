<<<<<<< HEAD
/**
=======
/*
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * StowPosition.java
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
=======
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35

public class StowPosition extends Command{
    public StowPosition() {
        requires(Robot.liftArm);
    }
<<<<<<< HEAD
    private boolean isFinshed;
    protected void initialize() {}
    protected void execute() {
        Robot.liftArm.disableWristBrake();
        isFinshed = false;
        Robot.liftArm.setGrabber(true);

        if(Robot.liftArm.getWristAngle() > Robot.position.wristStow + 50)
        {
            Robot.liftArm.setWrist(0.75);
        }
        else if(Robot.liftArm.getWristAngle() < Robot.position.wristStow - 50)
        {
            Robot.liftArm.setWrist(-0.75);
        }
        else
        {
            isFinshed = true;
=======
    private boolean isFinished;
    protected void initialize() {}
    protected void execute() {
        Robot.liftArm.disableWristBrake();
        isFinished = false;
        Robot.liftArm.setGrabber(true);
        if(Robot.liftArm.getWristAngle() > Robot.position.wristStow + 50) {
            Robot.liftArm.setWrist(0.75);
        } else if(Robot.liftArm.getWristAngle() < Robot.position.wristStow - 50) {
            Robot.liftArm.setWrist(-0.75);
        } else {
            isFinished = true;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
            Robot.liftArm.stopWrist();
        }
    }
    protected boolean isFinished() {
<<<<<<< HEAD
        return isFinshed;
=======
        return isFinished;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
    }
    protected void end() {
        Robot.liftArm.enableWristBrake();
    }
    protected void interrupted() {}
}
