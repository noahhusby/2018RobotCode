.. java:import:: edu.wpi.first.wpilibj DriverStation

.. java:import:: edu.wpi.first.wpilibj.command Command

.. java:import:: edu.wpi.first.wpilibj.smartdashboard SmartDashboard

.. java:import:: org.usfirst.frc.team1701.robot Robot

AutonomousCommand
=================

.. java:package:: org.usfirst.frc.team1701.robot.commands
   :noindex:

.. java:type:: public class AutonomousCommand extends Command

Constructors
------------
AutonomousCommand
^^^^^^^^^^^^^^^^^

.. java:constructor:: public AutonomousCommand()
   :outertype: AutonomousCommand

Methods
-------
end
^^^

.. java:method:: protected void end()
   :outertype: AutonomousCommand

   End the command.

execute
^^^^^^^

.. java:method:: protected void execute()
   :outertype: AutonomousCommand

   Execute the autonomous.

initialize
^^^^^^^^^^

.. java:method:: protected void initialize()
   :outertype: AutonomousCommand

   Initialize the autonomous command.

interrupted
^^^^^^^^^^^

.. java:method:: protected void interrupted()
   :outertype: AutonomousCommand

   End the command, the hard way.

isFinished
^^^^^^^^^^

.. java:method:: protected boolean isFinished()
   :outertype: AutonomousCommand

   Don't stop the party!

   :return: boolean

