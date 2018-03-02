<<<<<<< HEAD
/**
=======
/*
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * SwitchPositionArm.java
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

public class SwitchPositionArm extends Command {
    public SwitchPositionArm() {
        requires(Robot.liftArm);
    }

    private boolean isFinshed;

    private void stowWrist() {

        Robot.liftArm.setGrabber(true);

        if(Robot.liftArm.getWristAngle() > Robot.position.wristStow + 50)
        {
            Robot.liftArm.setWrist(0.50);
        }
        else if(Robot.liftArm.getWristAngle() < Robot.position.wristStow - 50)
        {
            Robot.liftArm.setWrist(-0.50);
        }
        else
        {
            Robot.liftArm.stopWrist();
        }
    }
    private void grabWrist() {
        if(Robot.liftArm.getWristAngle() > Robot.position.wristSwitch + 50)
        {
            Robot.liftArm.setWrist(0.50);
        }
        else if(Robot.liftArm.getWristAngle() < Robot.position.wristSwitch - 50)
        {
            Robot.liftArm.setWrist(-0.50);
        }
        else
        {
            Robot.liftArm.stopWrist();
            isFinshed = true;
        }
    }
=======
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

class SwitchPositionArm extends Command {
    public SwitchPositionArm() {
        requires(Robot.liftArm);
    }
    private boolean isFinished;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
    protected void initialize() {}
    protected void execute() {
        Robot.liftArm.disableWristBrake();
        Robot.liftArm.winchHighGear();
<<<<<<< HEAD
        isFinshed = false;
        Robot.liftArm.setGrabber(true);

        if(Robot.liftArm.getArmAngle()> Robot.position.armSwitch + 40) {
            Robot.liftArm.setLiftArm(0.90);
            stowWrist();
        }
        else if(Robot.liftArm.getArmAngle()< Robot.position.armSwitch - 40) {
            Robot.liftArm.setLiftArm(-0.90);
            stowWrist();
        }
        else {
            Robot.liftArm.stopLiftArm();
            grabWrist();
        }
    }
    protected boolean isFinished() {
        return isFinshed;
=======
        isFinished = false;
        Robot.liftArm.setGrabber(true);
        if(Robot.liftArm.getArmAngle()> Robot.position.armSwitch + 40) {
            Robot.liftArm.setLiftArm(0.90);
            Robot.liftArm.stowWrist();
        } else if(Robot.liftArm.getArmAngle()< Robot.position.armSwitch - 40) {
            Robot.liftArm.setLiftArm(-0.90);
            Robot.liftArm.stowWrist();
        } else {
            Robot.liftArm.stopLiftArm();
            Robot.liftArm.grabWrist();
            isFinished = true;
        }
    }
    protected boolean isFinished() {
        return isFinished;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
    }
    protected void end() {
        Robot.liftArm.enableWristBrake();
    }
    protected void interrupted() {}
}
