package org.usfirst.frc.team1701.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Position extends Subsystem {

    /*
     * Wrist values for positions
     */
    public double wristStow = -44;
    public double wristGrab = 1119;
    public double wristScale = 911;
    public double wristClimb = 1317;
    public double wristSwitch = -1512;
    public double wristSwitchShoot = 461;

    /*
     * Arm value for positions
     */
    public double armGrab = 48;
    public double armScale = 1994;
    public double armClimb = 1645;
    public double armSwitch = 1185;
    public double armSwitchShoot = 224;

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
