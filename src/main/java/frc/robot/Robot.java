// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
  CANSparkFlex shooter_21 = new CANSparkFlex(21, MotorType.kBrushless);
  CANSparkFlex shooter_22 = new CANSparkFlex(22, MotorType.kBrushless);
  CANSparkFlex hopper_23 = new CANSparkFlex(23, MotorType.kBrushless);
  CANSparkFlex hopper_24 = new CANSparkFlex(24, MotorType.kBrushless);
  XboxController CONTROLLER = new XboxController(0);

  double shooterSpeed = 60;
  double hopperSpeed = 20;

  @Override
  public void robotInit() {
    SmartDashboard.putNumber("ShooterSpeed", shooterSpeed);
    SmartDashboard.putNumber("HopperSpeed", hopperSpeed);
  }

  @Override
  public void teleopPeriodic() {
    shooterSpeed = SmartDashboard.getNumber("ShooterSpeed", shooterSpeed);
    hopperSpeed = SmartDashboard.getNumber("HopperSpeed", hopperSpeed);
    if (CONTROLLER.getAButton()) {
      shooter_21.setVoltage(-shooterSpeed / 100 * 12);
      shooter_22.setVoltage(shooterSpeed / 100 * 12);
    } else {
      shooter_21.setVoltage(0);
      shooter_22.setVoltage(0);
    }

    if (CONTROLLER.getBButton()) {
      hopper_23.setVoltage(-hopperSpeed / 100 * 12);
      hopper_24.setVoltage(hopperSpeed / 100 * 12);
    } else {
      hopper_23.setVoltage(0);
      hopper_24.setVoltage(0);
    }
  }
}