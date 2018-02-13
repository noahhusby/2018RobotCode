/**
 * commands/AutonomousClamp.java
 *
 * @author Steven Wall
 * @since 02/13/2018
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.Robot;



/*
N      N
N N    N
N  N   N
N   N  N
N    N N  O T E

This is purely a backup in case the vision somehow isn't finished in time. Also note that this is a work in progress
and is not supposed to work properly until it is finished. Once done, it should fulfill merely the get past the line
requirement of autonomous

-Steven






 */
public class AutonomousBackup extends Command {
        //private static final Logger logger = LogManager.getLogger();

        /**
         * distance = wheel_circumference * wheel_rotations
         * wheel_rotations = distance / wheel_circumference
         *
         * wheel_circumference = 4 * pi
         * distance = X - 38 (Robot Length)
         */

        private static String gameCode;
        private static Double defaultPosition = 2.0;

        private static final double robotPosition = SmartDashboard.getNumber("Position", defaultPosition);
        private static  char switchPosition;
        private static boolean targets = Robot.vision.getTarget();
        private static double allienceToLineDistance = 10.35;

  /*
   Booleans to check current states of autonomous
   */

        private static boolean forwardState;
        private static boolean turnState;
        private static boolean dropState;


        public AutonomousBackup() {
            requires(Robot.driveTrain);
        }

        /**
         * Resets the states, so that autonomous knows where its at.
         */
        private void initilaizeStates() {
            forwardState = false;
            turnState = false;
            dropState = false;
        }
        /** Initialize the autonomous command. */
        protected void initialize() {
            gameCode = DriverStation.getInstance().getGameSpecificMessage();
            if (gameCode == null) {
                gameCode = "LRL";
            }
            switchPosition  = gameCode.charAt(0);
            initilaizeStates();
        }
        /** Execute the autonomous. */
        protected void execute() {
            //logger.warn("Autonomous command started! May the force be with you.");
            // This is how we figure out what to do. It's a bit rough at best.

            switch(switchPosition) {
                case 'L':
                    if (robotPosition == 1) {
                        if(!forwardState && !turnState && !dropState)
                        {
                            forwardState = true;
                        }

                        if(Robot.driveTrain.getEncoderDistance() < allienceToLineDistance && forwardState)
                        {
                            Robot.driveTrain.setLowGear();
                            Robot.driveTrain.leftDriveControl(0.75);
                            Robot.driveTrain.rightDriveControl(0.75);
                        }
                        else if(forwardState)
                        {
                            Robot.driveTrain.stopMotors();
                            forwardState = false;
                        }
                        //Have robot drive straight **NO VISION INVOLVED


                    }
                case 'R':
                    if (robotPosition == 3) {
                        // Take control of right side of switch.

                        /*
                         * Checks if any autonomous has started yet
                         */
                        if(!forwardState && !turnState && !dropState)
                        {
                            forwardState = true;
                        }
//CODE TAKEN FROM OTHER AUTON BUT WITHOUT VISION
                        if(Robot.driveTrain.getEncoderDistance() < allienceToLineDistance && forwardState)
                        {
                            Robot.driveTrain.setLowGear();
                            Robot.driveTrain.leftDriveControl(0.75);
                            Robot.driveTrain.rightDriveControl(0.75);
                        }
                        else if(forwardState)
                        {
                            Robot.driveTrain.stopMotors();
                            forwardState = false;
                        }
                    }
                default:
                    // Attempt to cross autonomous line.
            }

        }

        /**
         * Don't stop the party!
         *
         * @return boolean
         */
        protected boolean isFinished() {
            return false;
        }
        /** End the command. */
        protected void end() {
            //logger.info("Halt! We are the Knights Who Say Ni! Bring us some shrubbery to continue.");
            //logger.warn("Just kidding; returning control to user.");
        }
        /** End the command, the hard way. */
        protected void interrupted() {
            //logger.info("Halt! We are the Knights Who Say Ni! Bring us some shrubbery to continue.");
            //logger.warn("Just kidding; returning control to user.");
        }
    }


