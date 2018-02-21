package org.usfirst.frc.team1701.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class CrossPlatformZone extends Command{
    boolean isFinshed = false;

    public CrossPlatformZone() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
        Robot.driveTrain.resetEncoders();
    }
    protected void execute() {
        if(Robot.driveTrain.getRightDistance() < Robot.position.crossPlatformZone) {
            Robot.driveTrain.teleopControl(-Robot.position.autonomousSpeed,0);
        } else  {
            isFinshed = true;
        }
    }
    protected boolean isFinished() {
        return isFinshed;
    }
    protected void end() {}
    protected void interrupted() {}
}
