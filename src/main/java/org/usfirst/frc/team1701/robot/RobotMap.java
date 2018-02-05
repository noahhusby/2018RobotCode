/**
 * RobotMap.java
 *
 * @author Nicholas Hubbard
 * @since 1/3/19
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; // Replaced wildcard import.
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/

public class RobotMap {
  /*
   * Create all static variables, most (exception of logger) filled
   * by the init() method below.
   */
  //private static final Logger logger = LogManager.getLogger();
  public static WPI_TalonSRX _leftFrontMotor;
  public static WPI_TalonSRX _leftBackMotor;
  public static WPI_TalonSRX _rightFrontMotor;
  public static WPI_TalonSRX _rightBackMotor;
  public static WPI_TalonSRX wrist;
  public static WPI_TalonSRX winch1;
  public static WPI_TalonSRX winch2;
  public static SpeedControllerGroup _leftMotors;
  public static SpeedControllerGroup _rightMotors;
  public static DifferentialDrive driveTrain;
  public static DoubleSolenoid armClamp;
  public static DoubleSolenoid puncher;
  public static DoubleSolenoid driveShift;
  public static DoubleSolenoid winchShfit;
  public static DoubleSolenoid winchBrake;
  public static AHRS _navx;
  public static Spark _led0;
  public static Spark _led1;
  public static int encPidIdx;
  /*
   * Initialize the public values above.
   */
  public static void init() {
    _leftFrontMotor = new WPI_TalonSRX(0);
    _leftBackMotor = new WPI_TalonSRX(1);
    _rightFrontMotor = new WPI_TalonSRX(15);
    _rightBackMotor = new WPI_TalonSRX(14);
    /**
     * Encoder PID index.
     * @value 0 for primary closed-loop, 1 for cascaded closed-loop.
     */
    encPidIdx = 0;
    /*
     * Initialize all non-drivetrain motors/objects.
     */
    winch1 = new WPI_TalonSRX(13);
    winch2 = new WPI_TalonSRX(12);
    wrist = new WPI_TalonSRX(2);
    driveShift = new DoubleSolenoid(0,7,0);
    winchShfit = new DoubleSolenoid(0,6,1);
    armClamp = new DoubleSolenoid(0, 5, 2);
    puncher = new DoubleSolenoid(0,4,3);
    winchBrake = new DoubleSolenoid(1,7,0);
    /*
     * Create 4-wheel drivetrain object using DifferentialDrive and SpeedControllerGroups.
     */
    _leftMotors = new SpeedControllerGroup(_leftFrontMotor, _leftBackMotor);
    _rightMotors = new SpeedControllerGroup(_rightFrontMotor, _rightBackMotor);
    driveTrain = new DifferentialDrive(_leftMotors, _rightMotors);
    /**
     * Instantiate NavX.
     */
    _navx = new AHRS(SerialPort.Port.kUSB);
    /**
     * LED controllers, follows Spark motor controller pattern.
     * @see https://www.revrobotics.com/content/docs/REV-11-1105-UM.pdf, page 7
     */
    _led0 = new Spark(0);
    _led1 = new Spark(1);
  }
}
