/**
 * subsystems/DriveTrain.java
 *
 * @author Steven Wall
 * @since 1/27/18
 * @license BSD-3-Clause
 */

package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;
import org.usfirst.frc.team1701.robot.subsystems.LiftArm;

public class ScalePosition extends Command {
    public ScalePosition() {
        requires(Robot.liftArm);
    }

    private boolean isFinshed;

    private void stowWrist() {

        Robot.liftArm.setArmClamp(true);

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
        if(Robot.liftArm.getWristAngle() > Robot.position.wristScale + 50)
        {
            Robot.liftArm.setWrist(0.50);
        }
        else if(Robot.liftArm.getWristAngle() < Robot.position.wristScale - 50)
        {
            Robot.liftArm.setWrist(-0.50);
        }
        else
        {
            Robot.liftArm.stopWrist();
            isFinshed = true;
        }
    }




    protected void initialize() {}
    protected void execute() {
        isFinshed = false;
        Robot.liftArm.setArmClamp(true);


        if(RobotMap.liftArmEncoder.getValue() - 497 > Robot.position.armScale + 40) {
            Robot.liftArm.setLiftArm(0.35);
            stowWrist();
        }
        else if(RobotMap.liftArmEncoder.getValue() - 497 < Robot.position.armScale - 40) {
            Robot.liftArm.setLiftArm(-0.35);
            stowWrist();
        }
        else {
            Robot.liftArm.setLiftArm(0);
            Robot.liftArm.stopLiftArm();
            grabWrist();
        }
    }
    protected boolean isFinished() {
        return isFinshed;
    }
    protected void end() {}
    protected void interrupted() {}
}