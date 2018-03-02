<<<<<<< HEAD
/**
=======
/*
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * subsystems/DriveTrain.java
 *
 * @author Noah Husby
 * @since 1/27/18
 * @license BSD-3-Clause
 */

package org.usfirst.frc.team1701.robot.commands;
<<<<<<< HEAD

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;
import org.usfirst.frc.team1701.robot.subsystems.LiftArm;

public class GrabPositionArm extends Command {
    public GrabPositionArm() {
        requires(Robot.liftArm);
    }

    private boolean isFinished;


=======
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

class GrabPositionArm extends Command {
    public GrabPositionArm() {
        requires(Robot.liftArm);
    }
    private boolean isFinished;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
    protected void initialize() {}
    protected void execute() {
        Robot.liftArm.disableWristBrake();
        Robot.liftArm.winchHighGear();
        isFinished = false;
        Robot.liftArm.setGrabber(true);
<<<<<<< HEAD

        if(Robot.liftArm.getArmAngle()> Robot.position.armGrab + 100) {
            Robot.liftArm.setLiftArm(0.90); }
        else if(Robot.liftArm.getArmAngle()< Robot.position.armGrab - 100) {
            Robot.liftArm.setLiftArm(-0.90);
        }
        else {
            Robot.liftArm.stopLiftArm();
            Robot.liftArm.disableWristBrake();
            if(Robot.liftArm.getWristAngle() > Robot.position.wristGrab + 50)
            {
                Robot.liftArm.setWrist(0.50);
            }
            else if(Robot.liftArm.getWristAngle() < Robot.position.wristGrab - 50)
            {
                Robot.liftArm.setWrist(-0.50);
            }
            else
            {
                isFinished = true;
                Robot.liftArm.stopWrist();
                Robot.liftArm.setGrabber(false);
            }
=======
        if(Robot.liftArm.getArmAngle()> Robot.position.armGrab + 100) {
            Robot.liftArm.setLiftArm(0.90);
        } else if(Robot.liftArm.getArmAngle()< Robot.position.armGrab - 100) {
            Robot.liftArm.setLiftArm(-0.90);
        } else {
            Robot.liftArm.stopLiftArm();
            Robot.liftArm.disableWristBrake();
            Robot.liftArm.grabCube();
            isFinished = true;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
        }
    }
    protected boolean isFinished() {
        return isFinished;
    }
    protected void end() {
        Robot.liftArm.enableWristBrake();
    }
    protected void interrupted() {}
}