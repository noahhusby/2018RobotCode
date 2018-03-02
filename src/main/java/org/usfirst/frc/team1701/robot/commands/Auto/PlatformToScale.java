<<<<<<< HEAD
/**
=======
/*
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * PlatformToScale.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands.Auto;
<<<<<<< HEAD

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class PlatformToScale extends Command {
    boolean isFinshed = false;

=======
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
public class PlatformToScale extends Command {
    private boolean isFinished = false;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
    public PlatformToScale() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
        Robot.driveTrain.resetEncoders();
    }
    protected void execute() {
        if(Robot.driveTrain.getRightDistance() < Robot.position.platformToScale) {
            Robot.driveTrain.teleopControl(-Robot.position.autonomousSpeed,0);
<<<<<<< HEAD
        } else  {
            isFinshed = true;
        }
    }
    protected boolean isFinished() {
        return isFinshed;
=======
        } else {
            isFinished = true;
        }
    }
    protected boolean isFinished() {
        return isFinished;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
    }
    protected void end() {}
    protected void interrupted() {}
}
