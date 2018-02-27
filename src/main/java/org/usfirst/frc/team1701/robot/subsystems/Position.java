package org.usfirst.frc.team1701.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
@SuppressWarnings("unused")
public class Position extends Subsystem {
    /*
     * Minimum and maximum traveling distance for wrist and arm
     */
    public final double armSafetyMin = 98;
    public final double armSafetyMax = 2202;
    public final double wristSafetyMin = 0;
    public final double wristSafetyMax = 0;

    /*
     * Wrist values for positions
     */
    public final double wristStow = -201;
    public final double wristGrab = 1119;
    public final double wristScale = 911;
    public final double wristClimb = 1289;
    public final double wristSwitch = -1512;
    public final double wristSwitchShoot = 461;

    /*
     * Arm value for positions
     */
    public final double armGrab = 120;
    public final double armScale = 2145;
    public final double armClimb = 2396;
    public final double armSwitch = 1373;
    public final double armSwitchShoot = 563;

    /*
     * Values for autonomous
     */
    public final double wallToCube = 2;
    public final double centerToSide = 5.00;
    public final double turnToSwitch = 4.2;
    public final double turnToSwitchRight = 3.8;
    public final double wallToScale = 22.75;
    public final double wallToPlatformZone = 15.69;
    public final double scaleReverse = 0.31;
    public final double autonomousSpeed = 0.90;
    public final double crossPlatformZone = 13.93;
    public final double platformToScale = 2.1;
    public final double leftAngle = 81;
    public final double rightAngle = 81;
    public final double slightLeftAngle = 20;
    public final double slightRightAngle = 19;
    public boolean brakeReleased = false;
    @Override
    protected void initDefaultCommand() {}
}
