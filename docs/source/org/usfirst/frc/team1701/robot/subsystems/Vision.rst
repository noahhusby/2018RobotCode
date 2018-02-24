.. java:import:: edu.wpi.first.networktables NetworkTable

.. java:import:: edu.wpi.first.networktables NetworkTableEntry

.. java:import:: edu.wpi.first.networktables NetworkTableInstance

.. java:import:: edu.wpi.first.wpilibj.command Subsystem

Vision
======

.. java:package:: org.usfirst.frc.team1701.robot.subsystems
   :noindex:

.. java:type:: public class Vision extends Subsystem

Methods
-------
getHorizontalOffset
^^^^^^^^^^^^^^^^^^^

.. java:method:: public double getHorizontalOffset()
   :outertype: Vision

   Get horizontal offset.

   :return: double of horizontal offset

getTarget
^^^^^^^^^

.. java:method:: public boolean getTarget()
   :outertype: Vision

   Get targeting status.

   :return: boolean: true if target found, false if not

getTargetArea
^^^^^^^^^^^^^

.. java:method:: public double getTargetArea()
   :outertype: Vision

   Get targeting area.

   :return: double of area.

getTargetSkew
^^^^^^^^^^^^^

.. java:method:: public double getTargetSkew()
   :outertype: Vision

   Get target skew.

   :return: double of skew.

getVerticalOffset
^^^^^^^^^^^^^^^^^

.. java:method:: public double getVerticalOffset()
   :outertype: Vision

   Get vertical offset.

   :return: double of vertical offset.

initDefaultCommand
^^^^^^^^^^^^^^^^^^

.. java:method:: public void initDefaultCommand()
   :outertype: Vision

   Initialize default command. Currently nothing.

setCameraMode
^^^^^^^^^^^^^

.. java:method:: public void setCameraMode(Number mode)
   :outertype: Vision

   Set camera mode.

   :param mode: processing is 0, driver camera is 1

setLedMode
^^^^^^^^^^

.. java:method:: public void setLedMode(Number mode)
   :outertype: Vision

   Set LED mode.

   :param mode: 0 for on, 1 for off, 2 for blink

setPipeline
^^^^^^^^^^^

.. java:method:: public void setPipeline(Number pipeline)
   :outertype: Vision

   Set the pipeline.

   :param pipeline: Pipeline number, ranges from 0 to 9

