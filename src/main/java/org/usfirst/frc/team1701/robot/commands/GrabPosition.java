/**
 * GrabPosition.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class GrabPosition extends CommandGroup {

    public GrabPosition() {

        addSequential(new StowPosition());
        addSequential(new GrabPositionArm());
        //addSequential(new GrabPositionWrist());
    }

}


