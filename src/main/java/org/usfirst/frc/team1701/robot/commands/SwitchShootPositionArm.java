/*
 * SwitchShootPositionArm.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

class SwitchShootPositionArm extends Command {
    public SwitchShootPositionArm() {
        requires(Robot.liftArm);
    }
    private boolean isFinished;
    protected void initialize() {}
    protected void execute() {
        Robot.liftArm.winchHighGear();
        Robot.liftArm.disableWristBrake();
        isFinished = false;
        Robot.liftArm.setGrabber(true);
        if(Robot.liftArm.getArmAngle()> Robot.position.armSwitchShoot + 40) {
            Robot.liftArm.setLiftArm(0.70);
            Robot.liftArm.stowWrist();
        } else if(Robot.liftArm.getArmAngle()< Robot.position.armSwitchShoot - 40) {
            Robot.liftArm.setLiftArm(-0.70);
            Robot.liftArm.stowWrist();
        } else {
            Robot.liftArm.stopLiftArm();
            Robot.liftArm.grabWrist();
            isFinished = true;
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
