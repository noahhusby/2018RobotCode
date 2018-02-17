package org.usfirst.frc.team1701.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Position extends Subsystem {

    public double armSafety = 0;
    public double wristSafety = 0;


    public double grabArm = 0;
    public double grabWrist = 0;

    public double liftArmMax = 0;
    public double liftArmMin = 1437;



    @Override
    protected void initDefaultCommand() {

    }
}
