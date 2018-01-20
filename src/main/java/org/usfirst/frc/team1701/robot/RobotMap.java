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
import edu.wpi.first.wpilibj.SpeedControllerGroup; // SpeedControllerGroup, DoubleSolenoid and DigitalOutput: replaced wildcard import with absolute imports.
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class RobotMap {
  /*
   * Create all static variables, most (exception of logger) filled
   * by the init() method below.
   */
  private static final Logger logger = LogManager.getLogger();
  public static WPI_TalonSRX _leftFrontMotor;
  public static WPI_TalonSRX _leftMiddleMotor;
  public static WPI_TalonSRX _leftBackMotor;
  public static WPI_TalonSRX _rightFrontMotor;
  public static WPI_TalonSRX _rightMiddleMotor;
  public static WPI_TalonSRX _rightBackMotor;
  public static WPI_TalonSRX climbMotor;
  public static WPI_TalonSRX winch1;
  public static WPI_TalonSRX winch2;
  public static SpeedControllerGroup _leftMotors;
  public static SpeedControllerGroup _rightMotors;
  public static DifferentialDrive driveTrain;
  public static DoubleSolenoid liftArm;
  public static DoubleSolenoid armClamp;
  public static DigitalOutput hook;
  public static AHRS _navx;
  public static int encPidIdx;
  /*
   * Initialize the public values above.
   */
  public static void init() {
    logger.info("RobotMap initializing DriveTrain values.");
    _leftFrontMotor = new WPI_TalonSRX(1);
    _leftBackMotor = new WPI_TalonSRX(3);
    _leftMiddleMotor = new WPI_TalonSRX(5);
    _rightFrontMotor = new WPI_TalonSRX(2);
    _rightBackMotor = new WPI_TalonSRX(4);
    _rightMiddleMotor = new WPI_TalonSRX(6);
    /*
     * Encoder PID index.
     * @value 0 for primary closed-loop, 1 for cascaded closed-loop.
     */
    encPidIdx = 0; // Where is this used? DriveTrain.java, The DriveTrain Nick!
    /*
     * Initialize all non-drivetrain motors.
     */
    climbMotor = new WPI_TalonSRX(5);
    winch1 = new WPI_TalonSRX(6);
    winch2 = new WPI_TalonSRX(7);
    liftArm = new DoubleSolenoid(0, 0, 1);
    armClamp = new DoubleSolenoid(0, 2, 3);
    hook = new DigitalOutput(0);
    /*
     * Create 6-wheel drivetrain object using DifferentialDrive and SpeedControllerGroups.
     */
    _leftMotors = new SpeedControllerGroup(_leftFrontMotor, _leftBackMotor, _leftMiddleMotor);
    _rightMotors = new SpeedControllerGroup(_rightFrontMotor, _rightBackMotor, _rightMiddleMotor);
    driveTrain = new DifferentialDrive(_leftMotors, _rightMotors);
    /*
     * Instantiate NavX.
     */
    logger.info("RobotMap initializing NavX.");
    _navx = new AHRS(SerialPort.Port.kUSB);
  }
}
