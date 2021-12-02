// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private final WPI_TalonSRX LEFT_FRONT_MOTOR;
  private final WPI_VictorSPX LEFT_BACK_MOTOR;

  private final WPI_TalonSRX RIGHT_FRONT_MOTOR;
  private final WPI_VictorSPX RIGHT_BACK_MOTOR;
  
  private final SpeedControllerGroup LEFT_MOTORS;
  private final SpeedControllerGroup RIGHT_MOTORS;

  private final DifferentialDrive Diffdrive;
  
  public Drivetrain() {
    LEFT_FRONT_MOTOR = new WPI_TalonSRX(2);
    LEFT_BACK_MOTOR = new WPI_VictorSPX(1);
    LEFT_MOTORS = new SpeedControllerGroup(LEFT_FRONT_MOTOR, LEFT_BACK_MOTOR);

    RIGHT_FRONT_MOTOR = new WPI_TalonSRX(3);
    RIGHT_BACK_MOTOR = new WPI_VictorSPX(4);
    RIGHT_MOTORS = new SpeedControllerGroup(RIGHT_FRONT_MOTOR, RIGHT_BACK_MOTOR);

    Diffdrive = new DifferentialDrive(LEFT_MOTORS, RIGHT_MOTORS);



  }
  public void drive(double speed, double rotation){
    Diffdrive.arcadeDrive(speed, rotation);

  }
  public void stop(){
    Diffdrive.arcadeDrive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
