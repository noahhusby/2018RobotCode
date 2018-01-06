package org.usfirst.frc.team1701.robot;
import com.ctre.phoenix.motorcontrol.can.*;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class RobotMap {
    private static final Logger logger = LogManager.getLogger();
    // Create motor configuration.
    public static WPI_TalonSRX _leftFrontMotor;
    public static WPI_TalonSRX _leftBackMotor;
    public static WPI_TalonSRX _rightFrontMotor;
    public static WPI_TalonSRX _rightBackMotor;
    // NavX initializer.
    public static AHRS _navx;
    public static void init() {
        logger.info("RobotMap initializing DriveTrain values.");
        _leftFrontMotor = new WPI_TalonSRX(1);
        _rightFrontMotor = new WPI_TalonSRX(2);
        _leftBackMotor = new WPI_TalonSRX(3);
        _rightBackMotor = new WPI_TalonSRX(4);
        logger.info("RobotMap initializing NavX.");
        _navx = new AHRS(SerialPort.Port.kUSB);
    }
}

