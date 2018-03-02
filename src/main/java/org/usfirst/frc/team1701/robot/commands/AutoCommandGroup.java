/**
 * commands/AutoCommandGroup.java
 *
 * @author Noah Husby
 * @since 12/29/17
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/
import org.usfirst.frc.team1701.robot.commands.Auto.*;

public class AutoCommandGroup extends CommandGroup {
  //private static final Logger logger = LogManager.getLogger();

    /**
     * distance = wheel_circumference * wheel_rotations
     * wheel_rotations = distance / wheel_circumference
     *
     * wheel_circumference = 4 * pi
     * distance = X - 38 (Robot Length)
     */
  private static char switchPosition;
  private static char scalePosition;
  public AutoCommandGroup(String gameCode) {
      switchPosition = gameCode.charAt(0);
      scalePosition = gameCode.charAt(1);
      double autoLocation = SmartDashboard.getNumber("Autonomous Location Chooser", 2);
          if(autoLocation == 1) {
              switch(scalePosition) {
                  case 'L':
                      addSequential(new WallToScale());
                      addSequential(new StowPosition());
                      addSequential(new TurnLeft());
                      addSequential(new ScalePosition());
                      addSequential(new ReverseScale());
                      addSequential(new ReleaseAndPunch());
                      break;
                  case 'R':
                      addSequential(new WallToPlatformZone());
                      addParallel(new StowPosition());
                      addSequential(new TurnRight());
                      addSequential(new CrossPlatformZone());
                      addSequential(new TurnLeft());
                      addParallel(new ScalePosition());
                      addSequential(new PlatformToScale());
                      addSequential(new ReleaseAndPunch());
                      break;
              }
          } else if (autoLocation == 2) {
              switch(switchPosition) {
                  case 'L':
                      addSequential(new WallToMiddle());
                      addSequential(new StowPosition());
                      addSequential(new SlightLeft());
                      addSequential(new SwitchPosition());
                      addSequential(new TurnToSwitch());
                      addSequential(new ReleaseAndPunch());
                      break;
                  case 'R':
                      addSequential(new WallToMiddle());
                      addSequential(new StowPosition());
                      addSequential(new SlightRight());
                      addSequential(new SwitchPosition());
                      addSequential(new TurnToSwitchRight());
                      addSequential(new ReleaseAndPunch());
                      break;
              }
          } else if (autoLocation == 3) {

          }
      }
  }



