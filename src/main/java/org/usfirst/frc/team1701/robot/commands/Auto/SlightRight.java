package org.usfirst.frc.team1701.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class SlightRight extends Command{
<<<<<<< HEAD
    boolean isFinshed = false;
    public double navxStart;
=======
    private boolean isFinshed = false;
    private double navxStart;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35

    public SlightRight() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
        navxStart = Robot.driveTrain.getNavxAngle();
    }
    protected void execute() {
        if(Robot.driveTrain.getNavxAngle() > navxStart - Robot.position.slightRightAngle) {
            Robot.driveTrain.teleopControl(0,-0.75);
        } else {
            isFinshed = true;
        }
    }
    protected boolean isFinished() {
        return isFinshed;
    }
    protected void end() {
        Robot.driveTrain.resetEncoders();
    }
    protected void interrupted() {}
}
