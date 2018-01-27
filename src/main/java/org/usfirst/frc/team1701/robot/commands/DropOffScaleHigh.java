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

public class DropOffScaleHigh extends Command{
    private int x = 0;
    private int scaleHighHeight;
    //the angle that the scale needs to be for the box to be successfully dropped off

    protected void initalize() {
    }

    protected void execute() {

        //Between the two ===========================================================================

        while(x == 0) {
            if (Robot.liftArm.getArmAngle() > scaleHighHeight && Robot.liftArm.getArmAngle() != scaleHighHeight) {
                RobotMap.winch1.set(1);
                RobotMap.winch2.set(1);

            } else if (Robot.liftArm.getArmAngle() < scaleHighHeight && Robot.liftArm.getArmAngle() != scaleHighHeight){
                RobotMap.winch1.set(0);
                RobotMap.winch2.set(0);

            } else {
                //when the arm is at the scale height needed
                x = 1;
            }

        }
        //===========================================================================================
        //Above is to get the arm at the right height to do stuff, does not have anything to do with the wrist angle. Yet.

    }

    public boolean isFinished(){
        return false;
    }
}
