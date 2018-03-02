<<<<<<< HEAD
/**
=======
/*
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * WallToMiddle.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands.Auto;
<<<<<<< HEAD

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.Robot;

public class WallToMiddle extends Command {

    boolean isFinshed = false;

=======
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
public class WallToMiddle extends Command {
    private boolean isFinished = false;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
    public WallToMiddle() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
        Robot.driveTrain.resetEncoders();
    }
    protected void execute() {
<<<<<<< HEAD
        isFinshed = false;
        if(Robot.driveTrain.getRightDistance() < Robot.position.wallToCube) {
            Robot.driveTrain.teleopControl(-1,0);
        } else  {
            isFinshed = true;
        }
    }
    protected boolean isFinished() {
        return isFinshed;
=======
        isFinished = false;
        if(Robot.driveTrain.getRightDistance() < Robot.position.wallToCube) {
            Robot.driveTrain.teleopControl(-1,0);
        } else  {
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
