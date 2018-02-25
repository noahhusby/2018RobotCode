package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ClimbPosition extends CommandGroup{
    public ClimbPosition() {
        addSequential(new StowPosition());
        addSequential(new ClimbPositionArm());
    }
}