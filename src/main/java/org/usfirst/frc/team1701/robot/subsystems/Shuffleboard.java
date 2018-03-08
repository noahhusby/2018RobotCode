/**
 * Shuffleboard.java
 *
 * @author Noah Husby
 * @since 3/8/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class Shuffleboard extends Subsystem {

    public static SendableChooser<Number> autonomousLocation;
    public static SendableChooser<Number> action;

    public static void init() {
        autonomousLocation = new SendableChooser<>();
        autonomousLocation.addObject("Left",1);
        autonomousLocation.addObject("Left-Switch",4);
        autonomousLocation.addDefault("Middle",2);
        autonomousLocation.addObject("Right-Switch",5);
        autonomousLocation.addObject("Right",3);
        SmartDashboard.putData("Autonomous Location", autonomousLocation);
        action = new SendableChooser<>();
        action.addDefault("Defualt Autonomous", 1);
        action.addObject("Forward Autonomous", 2);
        SmartDashboard.putData("Autonomous Chooser",action);
        SmartDashboard.putBoolean("Reversed", false);
        SmartDashboard.putString("Current Gear","");
        SmartDashboard.putNumber("Arm",0);
        SmartDashboard.putBoolean("Arm Down", false);
        SmartDashboard.putNumber("D", 0);
    }

    public static void updateDashboard() {
        SmartDashboard.putBoolean("Reversed", Robot.driveTrain.getReverse());
        SmartDashboard.putNumber("Arm",Robot.liftArm.getArmAngle());
        SmartDashboard.putNumber("Wrist", Robot.liftArm.getWristAngle());
        SmartDashboard.putBoolean("Arm Trigger", RobotMap.armSensor.get());
        SmartDashboard.putNumber("Drive Train", Robot.driveTrain.getRightDistance());

    }




    @Override
    protected void initDefaultCommand() {

    }
}
