/**
 * subsystems/DriveTrain.java
 *
 * @author Steven Wall
 * @since 1/27/18
 * @license BSD-3-Clause
 */

package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;
import org.usfirst.frc.team1701.robot.subsystems.LiftArm;

public class ScalePosition extends Command {
    public double scaleHighHeight = 0.0; // This is the number that the arm angle is at when it has reached the scale height.
    public double currentHeight; // This is the current height.
    public double minHeight; //this is the bottom of the wrist fold in zone
    public double maxHeight; //this is the top of the wrist fold in zone
    protected void initialize() {
        currentHeight = Robot.liftArm.getArmAngle();
    }
    protected void execute() {
        do {
            currentHeight = Robot.liftArm.getArmAngle();
            while(true) {
                RobotMap.winch1.set(1);
                RobotMap.winch2.set(1);
                if (Robot.liftArm.getArmAngle() > minHeight && Robot.liftArm.getArmAngle() > maxHeight){
                    Robot.liftArm.setWristAngle(-.5);
                    //fold wrist in while winch activated and in between the min and max zones
                }else{
                    Robot.liftArm.setWristAngle(0);
                    //stop wrist from moving while outside of the zone, but continue to have the arm move
                }
            }
        } while (currentHeight < scaleHighHeight);
        // Use the winch to stop the lift.
    }

    @Override
    protected boolean isFinished() {
        return false;
    }


}