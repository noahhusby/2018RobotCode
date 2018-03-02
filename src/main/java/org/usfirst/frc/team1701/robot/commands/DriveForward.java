<<<<<<< HEAD
/**
=======
/*
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * DriveForward.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
<<<<<<< HEAD

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1701.robot.commands.Auto.DriveForwardCommand;

=======
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1701.robot.commands.Auto.DriveForwardCommand;
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
public class DriveForward extends CommandGroup {
    public DriveForward() {
        addSequential(new DriveForwardCommand());
    }
}
