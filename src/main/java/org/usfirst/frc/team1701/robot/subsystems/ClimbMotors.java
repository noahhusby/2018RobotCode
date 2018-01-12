package org.usfirst.frc.team1701.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1701.robot.RobotMap;
import edu.wpi.first.wpilibj.buttons.Button;


public class ClimbMotors extends Subsystem {


    public void climbStart() {
        RobotMap.climbMotor.set(-50);
    }



    public void initDefaultCommand() {}


}
