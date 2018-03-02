<<<<<<< HEAD
/**
=======
/*
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * ScalePosition.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
<<<<<<< HEAD

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ScalePosition extends CommandGroup {
    public ScalePosition() {

=======
import edu.wpi.first.wpilibj.command.CommandGroup;
public class ScalePosition extends CommandGroup {
    public ScalePosition() {
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
        addSequential(new StowPosition());
        addSequential(new ScalePositionArm());
    }
}
