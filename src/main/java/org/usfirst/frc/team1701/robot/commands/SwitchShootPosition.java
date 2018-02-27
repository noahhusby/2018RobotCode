/*
 * SwitchShootPosition.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class SwitchShootPosition extends CommandGroup {
    public SwitchShootPosition() {
        addSequential(new StowPosition());
        addSequential(new SwitchShootPositionArm());
    }
}
