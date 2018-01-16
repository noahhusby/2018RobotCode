/**
 * subsystems/LiftArm.java
 *
 * <p>Created by Noah Husby on 1/10/2018.
 *
 * <p>Copyright (c) 2018 Team 1701 (Robocubs) All rights reserved.
 *
 * <p>Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met:
 *
 * <p>Redistributions of source code must retain the above copyright notice, this list of conditions
 * and the following disclaimer.
 *
 * <p>Redistributions in binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other materials provided with
 * the distribution.
 *
 * <p>Neither the name of the project's author nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written permission.
 *
 * <p>THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.usfirst.frc.team1701.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1701.robot.RobotMap;

public class LiftArm extends Subsystem {
  private final DoubleSolenoid liftArm = RobotMap.liftArm;
  private final DoubleSolenoid armClamp = RobotMap.armClamp;

  public void extendArm() {
    liftArm.set(DoubleSolenoid.Value.kForward);
  }
  /*public void retractArm()
  {
      liftArm.set(DoubleSolenoid.Value.kReverse);
  }
  */
  public void stopArm() {
    liftArm.set(DoubleSolenoid.Value.kOff);
  }

  public void grabArmClamp() {
    armClamp.set(DoubleSolenoid.Value.kForward);
  }

  public void releaseArmClamp() {
    armClamp.set(DoubleSolenoid.Value.kReverse);
  }

  public void initDefaultCommand() {}
}
