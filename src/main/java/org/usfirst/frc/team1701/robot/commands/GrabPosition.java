/**
 * GrabPosition.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;
import org.usfirst.frc.team1701.robot.subsystems.Position;

public class GrabPosition extends CommandGroup {

    public GrabPosition() {

        addSequential(new StowPosition());
        addSequential(new GrabPositionArm());
        //addSequential(new GrabPositionWrist());
    }

}


