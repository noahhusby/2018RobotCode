/**
 * subsystems/LiftArm.java
 *
 * @author Noah Husby & Steven Wall
 * @since 1/16/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.subsystems;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;
public class LiftArm extends Subsystem {
  /*
   * Hardware references.
   */
  private final AnalogInput liftArmEncoder = RobotMap.liftArmEncoder;
  private final WPI_TalonSRX wrist = RobotMap.wrist;
  private final WPI_TalonSRX winch1 = RobotMap.winch1;
  private final WPI_TalonSRX winch2 = RobotMap.winch2;
  private final WPI_TalonSRX winch3 = RobotMap.winch3;
  private final WPI_TalonSRX wristEncoder = wrist;
  private final DoubleSolenoid armClamp = RobotMap.armClamp;
  private final DoubleSolenoid winchBrake = RobotMap.winchBrake;
  private final DoubleSolenoid winchShift = RobotMap.winchShift;
  private final DoubleSolenoid puncher = RobotMap.puncher;
  private final DoubleSolenoid wristBrake = RobotMap.wristBrake;
  /*
   * Value references.
   */
  private final int encPidIdx = RobotMap.encPidIdx;
  /**
   * Sets the winches to brake mode, using two different methods
   */
  public void enableWinchBrake() {
    //winch1.setNeutralMode(NeutralMode.Brake);
    //winch2.setNeutralMode(NeutralMode.Brake);
    winchBrake.set(DoubleSolenoid.Value.kForward);
  }
  public void disableWinchBrake() {
    //winch1.setNeutralMode(NeutralMode.Coast);
    //winch2.setNeutralMode(NeutralMode.Coast);
    winchBrake.set(DoubleSolenoid.Value.kReverse);
  }
  public void enableWristBrake()
  {
    wristBrake.set(DoubleSolenoid.Value.kForward);
  }
  public void disableWristBrake()
  {
    wristBrake.set(DoubleSolenoid.Value.kReverse);
  }
  public void winchLowGear()
  {
    winchShift.set(DoubleSolenoid.Value.kReverse);
  }
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
   * Set the arm angle
   * @param rotations the number of rotations.
   */
  public void setArmAngle(double rotations) {}
  /**
   * Return wrist angle.
   * @return wrist angle as double.
   */
  public double getWristAngle() {
    return wristEncoder.getSelectedSensorPosition(encPidIdx);
  }
  /**
   * Set the wrist angle.
   * @param rotations Wrist angle to set to.
   */
  public void setWristAngle(double aInput) {}
  /**
   * Set the clamp position.
   * @param clamp true for enabled, false for disabled.
   */
  public void setArmClamp(boolean clamp) {
    if(clamp) {
      armClamp.set(DoubleSolenoid.Value.kReverse);
    } else {
     armClamp.set(DoubleSolenoid.Value.kForward);
    }
  }
  public void setLiftArm(double input) {
    winch1.set(input);
    winch2.set(input);
    winch3.set(input);
  }

  public void stopLiftArm()
  {
    winch1.stopMotor();
    winch2.stopMotor();
    winch3.stopMotor();
  }
  public void extendPuncher() {
    puncher.set(DoubleSolenoid.Value.kForward);
  }
  public void retractPuncher()
  {
    puncher.set(DoubleSolenoid.Value.kReverse);
  }
  public void initDefaultCommand() {}
}
