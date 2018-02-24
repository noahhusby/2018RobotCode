.. java:import:: edu.wpi.first.wpilibj IterativeRobot

.. java:import:: edu.wpi.first.wpilibj.command Command

.. java:import:: edu.wpi.first.wpilibj.command Scheduler

.. java:import:: edu.wpi.first.wpilibj.livewindow LiveWindow

.. java:import:: edu.wpi.first.wpilibj.smartdashboard SendableBuilder

.. java:import:: edu.wpi.first.wpilibj.smartdashboard SmartDashboard

.. java:import:: edu.wpi.first.wpilibj.smartdashboard SendableChooser

.. java:import:: org.usfirst.frc.team1701.robot.subsystems DriveTrain

.. java:import:: org.usfirst.frc.team1701.robot.subsystems LiftArm

.. java:import:: org.usfirst.frc.team1701.robot.subsystems Vision

.. java:import:: org.usfirst.frc.team1701.robot.commands AutonomousCommand

.. java:import:: org.usfirst.frc.team1701.robot.commands DriveForward

Robot
=====

.. java:package:: org.usfirst.frc.team1701.robot
   :noindex:

.. java:type:: public class Robot extends IterativeRobot

Fields
------
autoProgram
^^^^^^^^^^^

.. java:field::  SendableChooser autoProgram
   :outertype: Robot

autonomousCode
^^^^^^^^^^^^^^

.. java:field::  Command autonomousCode
   :outertype: Robot

driveTrain
^^^^^^^^^^

.. java:field:: public static DriveTrain driveTrain
   :outertype: Robot

liftArm
^^^^^^^

.. java:field:: public static LiftArm liftArm
   :outertype: Robot

oi
^^

.. java:field:: public static OI oi
   :outertype: Robot

vision
^^^^^^

.. java:field:: public static Vision vision
   :outertype: Robot

Methods
-------
autonomousInit
^^^^^^^^^^^^^^

.. java:method:: public void autonomousInit()
   :outertype: Robot

autonomousPeriodic
^^^^^^^^^^^^^^^^^^

.. java:method:: public void autonomousPeriodic()
   :outertype: Robot

disabledInit
^^^^^^^^^^^^

.. java:method:: public void disabledInit()
   :outertype: Robot

disabledPeriodic
^^^^^^^^^^^^^^^^

.. java:method:: public void disabledPeriodic()
   :outertype: Robot

robotInit
^^^^^^^^^

.. java:method:: public void robotInit()
   :outertype: Robot

teleopInit
^^^^^^^^^^

.. java:method:: public void teleopInit()
   :outertype: Robot

teleopPeriodic
^^^^^^^^^^^^^^

.. java:method:: public void teleopPeriodic()
   :outertype: Robot

testPeriodic
^^^^^^^^^^^^

.. java:method:: public void testPeriodic()
   :outertype: Robot

