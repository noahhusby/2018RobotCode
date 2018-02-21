package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ScalePosition extends CommandGroup {
    public ScalePosition() {

        addSequential(new StowPosition());
        addSequential(new ScalePositionArm());
    }
}
