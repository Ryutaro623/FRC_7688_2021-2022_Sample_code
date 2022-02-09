// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  /**Left Front Bottom */
  private final WPI_TalonSRX LFBmotor;
  private final WPI_VictorSPX LFTmotor;
  private final WPI_VictorSPX LBBmotor;
  private final WPI_VictorSPX LBTmotor;

  private final WPI_TalonSRX RFTmotor;
  private final WPI_VictorSPX RFBmotor;
  private final WPI_VictorSPX RBTmotor;
  private final WPI_VictorSPX RBBmotor;
  
  private final MotorControllerGroup LEFT_MOTORS;
  private final MotorControllerGroup RIGHT_MOTORS;

  private final DifferentialDrive Diffdrive;
  private final Encoder leftencoder;
  private final Encoder rightencoder;
  
  public Drivetrain() {
    leftencoder = new Encoder(Constants.LEFT_ENCODER[0],Constants.LEFT_ENCODER[1],true);
    rightencoder = new Encoder(Constants.RIGHT_ENCODER[0],Constants.RIGHT_ENCODER[1],false);

    LFBmotor = new WPI_TalonSRX(Constants.LEFT_FRONT_BOTTOM_MOTOR);
    LFTmotor = new WPI_VictorSPX(Constants.LEFT_FRONT_TOP_MOTOR);
    LBBmotor = new WPI_VictorSPX(Constants.LEFT_BACK_BOTTOM_MOTOR);
    LBTmotor = new WPI_VictorSPX(Constants.LEFT_BACK_TOP_MOTOR);

    LEFT_MOTORS = new MotorControllerGroup(LFBmotor, LFTmotor,LBTmotor,LBBmotor);

    RFTmotor = new WPI_TalonSRX(Constants.RIGHT_FRONT_TOP_MOTOR);
    RFBmotor = new WPI_VictorSPX(Constants.RIGHT_FRONT_BOTTOM_MOTOR);
    RBBmotor = new WPI_VictorSPX(Constants.RIGHT_BACK_BOTTOM_MOTOR);
    RBTmotor = new WPI_VictorSPX(Constants.RIGHT_BACK_TOP_MOTOR);


    RIGHT_MOTORS = new MotorControllerGroup(RFTmotor, RFBmotor, RBBmotor,RBTmotor);

    RIGHT_MOTORS.setInverted(true);


    Diffdrive = new DifferentialDrive(LEFT_MOTORS, RIGHT_MOTORS);

    leftencoder.setDistancePerPulse(Constants.DISTENCEPERPULS);
    rightencoder.setDistancePerPulse(Constants.DISTENCEPERPULS);



  }
  public void reset_Encoder(){
    leftencoder.reset();
    rightencoder.reset();
  }

  public double get_average_distance(){
    return ((leftencoder.getDistance()+rightencoder.getDistance())/2);

  }
  public double Diff_distance(){
    return leftencoder.getDistance()-rightencoder.getDistance();
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
