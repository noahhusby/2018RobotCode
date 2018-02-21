package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SwitchShootPosition extends CommandGroup {
    public SwitchShootPosition() {

        addSequential(new StowPosition());
        addSequential(new SwitchShootPositionArm());
    }
}
