/**
 * ScalePosition.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class ScalePosition extends CommandGroup {
    public ScalePosition() {
        addSequential(new StowPosition());
        addSequential(new ScalePositionArm());
    }
}
