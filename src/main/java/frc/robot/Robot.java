// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

import com.ctre.phoenix6.unmanaged.Unmanaged;


public class Robot extends TimedRobot {
  CANSparkFlex vorflex = new CANSparkFlex(21, MotorType.kBrushless);
  XboxController CONTROLLER = new XboxController(0);
  
  @Override
  public void robotInit() {
    Unmanaged.setPhoenixDiagnosticsStartTime(-1);
  }

  @Override
  public void teleopPeriodic() {
    if (CONTROLLER.getAButton()) {
      vorflex.setVoltage(50.0 / 100 * 12);
    } else {
      vorflex.setVoltage(0);
    }
  }
}