.. java:import:: com.ctre.phoenix.motorcontrol.can WPI_TalonSRX

.. java:import:: edu.wpi.first.wpilibj DoubleSolenoid

.. java:import:: edu.wpi.first.wpilibj.command Subsystem

.. java:import:: org.usfirst.frc.team1701.robot RobotMap

LiftArm
=======

.. java:package:: org.usfirst.frc.team1701.robot.subsystems
   :noindex:

.. java:type:: public class LiftArm extends Subsystem

Methods
-------
getArmAngle
^^^^^^^^^^^

.. java:method:: public double getArmAngle()
   :outertype: LiftArm

   Return arm angle.

   :return: arm angle as double

getWristAngle
^^^^^^^^^^^^^

.. java:method:: public double getWristAngle()
   :outertype: LiftArm

   Return wrist angle.

   :return: wrist angle as double.

initDefaultCommand
^^^^^^^^^^^^^^^^^^

.. java:method:: public void initDefaultCommand()
   :outertype: LiftArm

resetArmAngle
^^^^^^^^^^^^^

.. java:method:: public void resetArmAngle()
   :outertype: LiftArm

   Reset the arm angle.

resetWristAngle
^^^^^^^^^^^^^^^

.. java:method:: public void resetWristAngle()
   :outertype: LiftArm

   Reset the wrist angle.

setArmAngle
^^^^^^^^^^^

.. java:method:: public void setArmAngle(double rotations)
   :outertype: LiftArm

   Set the arm angle

   :param rotations: the number of rotations.

setArmClamp
^^^^^^^^^^^

.. java:method:: public void setArmClamp(boolean clamp)
   :outertype: LiftArm

   Set the clamp position.

   :param clamp: true for enabled, false for disabled.

setWristAngle
^^^^^^^^^^^^^

.. java:method:: public void setWristAngle(double rotations)
   :outertype: LiftArm

   Set the wrist angle.

   :param rotations: Wrist angle to set to.

