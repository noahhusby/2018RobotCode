package org.usfirst.frc.team1701.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class Drive extends Command {
    boolean isFinished = false;
    double distance = 0;
    double currentSpeed;
    boolean setHighGear = false;

    public Drive(double distance,double speed) {
        requires(Robot.driveTrain);
        this.distance = distance;
        this.currentSpeed = speed;
    }
    public Drive(double distance, double speed, boolean setHighGear) {
        this.distance = distance;
        this.currentSpeed = speed;
        this.setHighGear = setHighGear;

    }
    protected void initialize() {
        Robot.driveTrain.resetEncoders();
    }
    protected void execute() {

        if(setHighGear) {
            Robot.driveTrain.setLowGear();
        } else {
            Robot.driveTrain.setHighGear();
        }

        if(Robot.driveTrain.getRightDistance() < distance) {
            Robot.driveTrain.teleopControl(-currentSpeed,0);
        } else {
            isFinished = true;
        }
    }
    protected boolean isFinished() {
        return isFinished;
    }
    protected void end() {}
    protected void interrupted() {}
}
