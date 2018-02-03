package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class PickUpCube extends Command {

    private double floor; //the height the arm needs to be at in order to be at the floor
    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected void execute() {
        Robot.liftArm.setArmClamp(false);//open the clamp before the arm begins to move to ensure that it will stay open
        if(Robot.liftArm.getArmAngle() > floor){
            RobotMap.winch1.set(1);//set it to the floor, may be negative or powsitive - that is an unknown right now
            RobotMap.winch2.set(1);
        }else{
            RobotMap.winch1.set(0);//keep the arm at the floor level
            RobotMap.winch2.set(0);
        }


        /*WE NEED TO PUT A DELAY IN HERE FOR THE ARMCLAMP TO OPEN BEFORE CLOSING


        Also, maybe we should consider a proximity sensor for the interior of the clamp to ensure we don't have
        issues with the clamp closing too early
         */

        Robot.liftArm.setArmClamp(true);
    }

    public boolean isFinished(){
        return false;
    }
}
