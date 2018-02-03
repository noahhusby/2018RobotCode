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

public class DropOffScaleHigh extends Command {
    public double scaleHighHeight = 0.0; // This is the number that the arm angle is at when it has reached the scale height.
    public double currentHeight; // This is the current height.
    protected void initialize() {
        currentHeight = Robot.liftArm.getArmAngle();
    }
    protected void execute() {
        do {
            currentHeight = Robot.liftArm.getArmAngle();
            RobotMap.winch1.set(1);
            RobotMap.winch2.set(1);
        } while (currentHeight < scaleHighHeight);
        // Use the winch to stop the lift.
    }

    @Override
    protected boolean isFinished() {
        return false;
    }


}