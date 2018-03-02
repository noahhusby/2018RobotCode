<<<<<<< HEAD
/**
=======
/*
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
 * subsystems/LiftArm.java
 *
 * @author Noah Husby & Steven Wall
 * @since 1/16/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.subsystems;
<<<<<<< HEAD
import com.ctre.phoenix.motorcontrol.NeutralMode;
=======
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;
=======
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;
@SuppressWarnings("unused")
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
public class LiftArm extends Subsystem {
  /*
   * Hardware references.
   */
  private final AnalogInput liftArmEncoder = RobotMap.liftArmEncoder;
  private final WPI_TalonSRX wrist = RobotMap.wrist;
  private final WPI_TalonSRX winch1 = RobotMap.winch1;
  private final WPI_TalonSRX winch2 = RobotMap.winch2;
  private final WPI_TalonSRX wristEncoder = wrist;
  private final DoubleSolenoid grabber = RobotMap.grabber;
  private final DoubleSolenoid winchBrake = RobotMap.winchBrake;
  private final DoubleSolenoid winchShift = RobotMap.winchShift;
  private final DoubleSolenoid puncher = RobotMap.puncher;
  private final DoubleSolenoid wristBrake = RobotMap.wristBrake;
  /*
   * Value references.
   */
  private final int encPidIdx = RobotMap.encPidIdx;
  /**
   * Sets the winches to brake mode
   */
<<<<<<< HEAD
=======
  @SuppressWarnings("WeakerAccess")
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
  public void enableWinchBrake() {
    winchBrake.set(DoubleSolenoid.Value.kForward);
  }
  /**
   * Disables winch brake
   */
<<<<<<< HEAD
=======
  @SuppressWarnings("WeakerAccess")
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
  public void disableWinchBrake() {
    winchBrake.set(DoubleSolenoid.Value.kReverse);
  }
  /**
   * Enables wrist brake
   */
  public void enableWristBrake()
  {
      wristBrake.set(DoubleSolenoid.Value.kForward);
  }
  /**
   * Disables wrist brake
   */
  public void disableWristBrake()
  {
      wristBrake.set(DoubleSolenoid.Value.kReverse);
  }
  /**
   * Sets winch gear to low
   */
  public void winchLowGear()
  {
    winchShift.set(DoubleSolenoid.Value.kReverse);
  }
  /**
   * Sets winch gear to high
   */
  public void winchHighGear()
  {
    winchShift.set(DoubleSolenoid.Value.kForward);
  }
  /**
   * Return arm angle.
   * @return arm angle as double
   */
  public double getArmAngle() {
    return liftArmEncoder.getValue();
  }
  /**
   * Return wrist angle.
   * @return wrist angle as double.
   */
  public double getWristAngle() {
    return wristEncoder.getSelectedSensorPosition(encPidIdx);
  }
  /**
   * Set the clamp position.
   * @param State true for enabled, false for disabled.
   */
  public void setGrabber(boolean State) {
    if(State) {
      grabber.set(DoubleSolenoid.Value.kReverse);
    } else {
     grabber.set(DoubleSolenoid.Value.kForward);
    }
  }

  /**
   * Sets speed of the arm, as well as disabling the brake
   * @param input -1 to 1 as speed for the arm
   */
  public void setLiftArm(double input) {
    disableWinchBrake();
    winch1.set(input);
    winch2.set(input);

  }
  /**
   * Disables wrist motors, enables winch brake
   */
  public void stopLiftArm()
  {
    winch1.stopMotor();
    winch2.stopMotor();
    Timer.delay(0.05);
    enableWinchBrake();
  }
  /**
   * Pushes puncher out to push cube
   */
  public void extendPuncher() {
    puncher.set(DoubleSolenoid.Value.kForward);
  }
  /**
   * Pulls puncher into normal state
   */
  public void retractPuncher()
  {
    puncher.set(DoubleSolenoid.Value.kReverse);
  }
  /**
   * Stops the wrist motor, automatically enables wrist brake
   */
  public void stopWrist()
  {
    wrist.stopMotor();
  }
  /**
   * Sets speed of wrist motor, automatically disables brake
   * @param speed to set wrist motor
   */
  public void setWrist(double speed) {
    wrist.set(speed);
  }
  /**
   * Gets the current state of switches on grabber
   * @return Boolean of CubeSensor
   */
  public boolean getCubeSensor()
  {
    return RobotMap.cubeSensor.get();
  }
  public double checkArmZone(double speed) {
    if(Robot.position.armSafetyMin >= Robot.liftArm.getArmAngle()) {
      return 0;
    }

    if(Robot.position.armSafetyMax <= Robot.liftArm.getArmAngle()) {
      return 0;
    }
    return speed;
  }
<<<<<<< HEAD
=======

  /**
   * Stow the arm in the correct position.
   */
  public void stowWrist() {
    Robot.liftArm.setGrabber(true);
    if(Robot.liftArm.getWristAngle() > Robot.position.wristStow + 50) {
      Robot.liftArm.setWrist(0.50);
    } else if(Robot.liftArm.getWristAngle() < Robot.position.wristStow - 50) {
      Robot.liftArm.setWrist(-0.50);
    } else {
      Robot.liftArm.stopWrist();
    }
  }

  /**
   * Grab the wrist? IDK.
   */
  public void grabWrist() {
    if (Robot.liftArm.getWristAngle() > Robot.position.wristScale + 50) {
      Robot.liftArm.setWrist(0.50);
    } else if (Robot.liftArm.getWristAngle() < Robot.position.wristScale - 50) {
      Robot.liftArm.setWrist(-0.50);
    } else {
      Robot.liftArm.stopWrist();
    }
  }

  /**
   *
   */
  public void grabCube() {
    if (Robot.liftArm.getWristAngle() > Robot.position.wristGrab + 50) {
      Robot.liftArm.setWrist(0.50);
    } else if (Robot.liftArm.getWristAngle() < Robot.position.wristGrab - 50) {
      Robot.liftArm.setWrist(-0.50);
    } else {
      Robot.liftArm.stopWrist();
      Robot.liftArm.setGrabber(false);
    }
  }
>>>>>>> d8c94137a66a342903c541bf881dd28b67a06d35
  public void initDefaultCommand() {}
}
