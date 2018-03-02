<<<<<<< HEAD
/**
=======
/*
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * CrossPlatformZone.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands.Auto;
<<<<<<< HEAD

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class CrossPlatformZone extends Command{
    boolean isFinished = false;

=======
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
public class CrossPlatformZone extends Command{
    private boolean isFinished = false;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
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
            isFinished = true;
        }
    }
    protected boolean isFinished() {
        return isFinished;
    }
    protected void end() {}
    protected void interrupted() {}
}
