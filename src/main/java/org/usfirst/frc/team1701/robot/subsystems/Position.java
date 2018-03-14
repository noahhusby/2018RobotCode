package org.usfirst.frc.team1701.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Position extends Subsystem {

    /*
     * Wrist values for positions
     */
    public double wristStow = -44;
    public double wristGrab = 1119;
    public double wristScale = 911;
    public double wristClimb = 1289;
    public double wristSwitch = -1512;
    public double wristSwitchShoot = 461;

    /*
     * Arm value for positions
     */
    public double armGrab = 275;
    public double armScale = 2400;
    public double armClimb = 2396;
    public double armSwitch = 1373;
    public double armSwitchShoot = 563;

    /*
     * Values for autonomous
     */
    public double wallToCubeRight = 0.1;
    public double wallToCubeLeft = 0.1;
    public double centerToSide = 5.00;
    public double turnToSwitch = 4.2;
    public double turnToSwitchRight = 4.4;
    public double wallToScale = 22.75;
    public double wallToPlatformZone = 15.69;
    public double scaleReverse = 0.31;
    public double autonomousSpeed = 0.90;
    public double crossPlatformZone = 13.93;
    public double platformToScale = 2.1;
    public double leftAngle = 81;
    public double rightAngle = 81;
    public double slightLeftAngle = 45;
    public double slightRightAngle = 30;
    public double wallToStraightSwitch = 7;

    public boolean isReleasePressed = false;



    @Override
    protected void initDefaultCommand() {

    }
}
