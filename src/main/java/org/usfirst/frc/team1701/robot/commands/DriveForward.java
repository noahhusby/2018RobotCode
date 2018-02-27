/**
 * DriveForward.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1701.robot.commands.Auto.DriveForwardCommand;
public class DriveForward extends CommandGroup {
    public DriveForward() {
        addSequential(new DriveForwardCommand());
    }
}
