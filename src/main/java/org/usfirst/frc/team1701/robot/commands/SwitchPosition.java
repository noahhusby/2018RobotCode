package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SwitchPosition extends CommandGroup {
    public SwitchPosition() {

        addSequential(new StowPosition());
        addSequential(new SwitchPosition());
    }
}
