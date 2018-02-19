package org.usfirst.frc.team1701.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Position extends Subsystem {

    /*
     * Minimum and maximum traveling distance for wrist and arm
     */
    public double armSafetyMin = 0;
    public double armSafetyMax = 0;
    public double wristSafetyMin = 0;
    public double wristSafetyMax = 0;

    /*
     * Wrist values for positions
     */
    public double wristStow = -172;
    public double wristGrab = 1084;
    public double wristScale = 911;
    public double wristSwitch = -1512;

    /*
     * Arm value for positions
     */
    public double armGrab = 292;
    public double armScale = 2374;
    public double armSwitch = 1602;

    @Override
    protected void initDefaultCommand() {

    }
}
