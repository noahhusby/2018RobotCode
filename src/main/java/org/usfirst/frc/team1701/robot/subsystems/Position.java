package org.usfirst.frc.team1701.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Position extends Subsystem {

    public double armSafety = 0;
    public double wristSafety = 0;

    public double wristStow = -172;
    public double wristGrab = 1084;
    public double wristScale = 911;
    public double wristSwitch = -1512;

    public double armGrab = 292;
    public double armScale = 2374;
    public double armSwitch = 1602;


    public double liftArmMax = 0;
    public double liftArmMin = 1437;



    @Override
    protected void initDefaultCommand() {

    }
}
