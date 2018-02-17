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
    public int scaleHighHeight = 0; // This is the number that the arm angle is at when it has reached the scale height.
    public int currentHeight; // This is the current height.
    public int minHeight = 2; //this is the bottom of the wrist fold in zone
    public int maxHeight = 5; //this is the top of the wrist fold in zone
    private AnalogInput liftArm = RobotMap.liftArmEncoder;
    protected void initialize() {
    }
    protected void execute() {
        do {
            currentHeight = liftArm.getValue();
            while(true) {
                RobotMap.winch1.set(0.45);
                RobotMap.winch2.set(0.45);
                RobotMap.winch3.set(0.45);
                if (currentHeight > minHeight && Robot.liftArm.getArmAngle() > maxHeight){
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