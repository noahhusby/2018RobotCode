<<<<<<< HEAD
/**
=======
/*
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * SwitchPosition.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
<<<<<<< HEAD

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SwitchPosition extends CommandGroup {
    public SwitchPosition() {

=======
import edu.wpi.first.wpilibj.command.CommandGroup;
public class SwitchPosition extends CommandGroup {
    public SwitchPosition() {
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
        addSequential(new StowPosition());
        addSequential(new SwitchPositionArm());
    }
}
