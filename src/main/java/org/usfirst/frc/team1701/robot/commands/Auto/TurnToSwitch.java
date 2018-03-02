<<<<<<< HEAD
/**
=======
/*
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * TurnToSwitch.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands.Auto;
<<<<<<< HEAD

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class TurnToSwitch extends Command {
    boolean isFinshed = false;

=======
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
public class TurnToSwitch extends Command {
    private boolean isFinished = false;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
    public TurnToSwitch() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
        Robot.driveTrain.resetEncoders();
    }
    protected void execute() {
        if(Robot.driveTrain.getRightDistance() < Robot.position.turnToSwitch) {
            Robot.driveTrain.teleopControl(-Robot.position.autonomousSpeed,0);
        } else  {
<<<<<<< HEAD
            isFinshed = true;
        }
    }
    protected boolean isFinished() {
        return isFinshed;
=======
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
