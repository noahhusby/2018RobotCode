package org.usfirst.frc.team1701.robot;
import com.ctre.phoenix.motorcontrol.can.*;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class RobotMap {
    private static final Logger logger = LogManager.getLogger();
    // Create motor configuration.
    public static WPI_TalonSRX _leftFrontMotor;
    public static WPI_TalonSRX _leftMiddleMotor;
    public static WPI_TalonSRX _leftBackMotor;
    public static WPI_TalonSRX _rightFrontMotor;
    public static WPI_TalonSRX _rightMiddleMotor;
    public static WPI_TalonSRX _rightBackMotor;
    public static WPI_TalonSRX climbMotor;
    public static WPI_TalonSRX winch;
    public static SpeedControllerGroup _leftMotors;
    public static SpeedControllerGroup _rightMotors;
    public static DifferentialDrive driveTrain;
    public static DoubleSolenoid liftArm;
    public static DoubleSolenoid armClamp;
    public static DigitalOutput hook;


    // NavX initializer.
    public static AHRS _navx;
    public static void init() {
        logger.info("RobotMap initializing DriveTrain values.");
        _leftFrontMotor = new WPI_TalonSRX(1);
        _rightFrontMotor = new WPI_TalonSRX(2);
        _leftBackMotor = new WPI_TalonSRX(3);
        _rightBackMotor = new WPI_TalonSRX(4);
        _leftMiddleMotor = new WPI_TalonSRX(5);
        _rightMiddleMotor = new WPI_TalonSRX(6);

        climbMotor = new WPI_TalonSRX(5);
        winch = new WPI_TalonSRX(6);
        liftArm = new DoubleSolenoid(0,0,1);
        armClamp = new DoubleSolenoid(0,2,3);
        hook = new DigitalOutput(0);

        _leftMotors = new SpeedControllerGroup(_leftFrontMotor, _leftBackMotor, _leftMiddleMotor);
        _rightMotors = new SpeedControllerGroup(_rightFrontMotor, _rightBackMotor, _rightMiddleMotor);
        driveTrain = new DifferentialDrive(_leftMotors, _rightMotors);


        logger.info("RobotMap initializing NavX.");
        _navx = new AHRS(SerialPort.Port.kUSB);
    }
}

