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
    public double wristStow = -201;
    public double wristGrab = 1119;
    public double wristScale = 911;
    public double wristSwitch = -1512;
    public double wristSwitchShoot = 461;

    /*
     * Arm value for positions
     */
    public double armGrab = 125;
    public double armScale = 2145;
    public double armSwitch = 1373;
    public double armSwitchShoot = 563;

    /*
     * Values for autonomous
     */
    public double wallToCube = 2;
    public double centerToSide = 5.1;
    public double turnToSwitch = 5.1;
    public double wallToScale = 22.75;
    public double wallToPlatformZone = 15.69;
    public double scaleReverse = 0.31;
    public double autonomousSpeed = 0.90;
    public double crossPlatformZone = 13.93;
    public double platformToScale = 2.1;


    @Override
    protected void initDefaultCommand() {

    }
}
