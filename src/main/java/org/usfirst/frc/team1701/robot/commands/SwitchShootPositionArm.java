/**
 * SwitchShootPositionArm.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class SwitchShootPositionArm extends Command {
    public SwitchShootPositionArm() {
        requires(Robot.liftArm);
    }
    private boolean isFinished;
    private void stowWrist() {
        Robot.liftArm.setGrabber(true);
        if(Robot.liftArm.getWristAngle() > Robot.position.wristStow + 50) {
            Robot.liftArm.setWrist(0.50);
        } else if(Robot.liftArm.getWristAngle() < Robot.position.wristStow - 50) {
            Robot.liftArm.setWrist(-0.50);
        } else {
            Robot.liftArm.stopWrist();
        }
    }
    private void grabWrist() {
        if(Robot.liftArm.getWristAngle() > Robot.position.wristSwitchShoot + 50) {
            Robot.liftArm.setWrist(0.50);
        } else if(Robot.liftArm.getWristAngle() < Robot.position.wristSwitchShoot - 50) {
            Robot.liftArm.setWrist(-0.50);
        } else {
            Robot.liftArm.stopWrist();
            isFinished = true;
        }
    }
    protected void initialize() {}
    protected void execute() {
        Robot.liftArm.winchHighGear();
        Robot.liftArm.disableWristBrake();
        isFinished = false;
        Robot.liftArm.setGrabber(true);
        if(Robot.liftArm.getArmAngle()> Robot.position.armSwitchShoot + 40) {
            Robot.liftArm.setLiftArm(0.70);
            stowWrist();
        } else if(Robot.liftArm.getArmAngle()< Robot.position.armSwitchShoot - 40) {
            Robot.liftArm.setLiftArm(-0.70);
            stowWrist();
        } else {
            Robot.liftArm.stopLiftArm();
            grabWrist();
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
