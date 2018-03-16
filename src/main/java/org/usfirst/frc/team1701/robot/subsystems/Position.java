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
    public double armGrab = 35;
    public double armScale = 2160;
    public double armClimb = 2156;
    public double armSwitch = 1133;
    public double armSwitchShoot = 323;

    /*
     * Values for autonomous
     */

    public double autonomousSpeed = 0.90;
    public double wallToStraightSwitch = 7;

    public boolean isReleasePressed = false;



    @Override
    protected void initDefaultCommand() {

    }
}
