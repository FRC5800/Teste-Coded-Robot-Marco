// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveManually;

/** Add your docs here. */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //speed
  public static double speed = 0.5;
  //left:
  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.leftMasterPort);
  public WPI_TalonSRX leftSlave = new WPI_TalonSRX(RobotMap.leftSlavePort);
  //right
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.rightMasterPort);
  public WPI_TalonSRX rightSlave = new WPI_TalonSRX(RobotMap.rightSlavePort);

  //Instanciando differencial Drive
  public DifferentialDrive m_drive = new DifferentialDrive(leftMaster, rightMaster);

  public DriveTrain(){
//follow
rightSlave.follow(rightMaster);
leftSlave.follow(leftMaster);
  }
 
  // manualDrive()
  //aqui tu vai estar passando os valores do controle manaual
  //move seria o stick no eixo y e turn eixo x
  public void manualDrive(double move, double turn){
    if(move < 0.10) move = 0.0;
    if(turn < 0.10) turn = 0.0;
    m_drive.arcadeDrive(move * speed, turn * speed);

  }
  public void timedDrive(double t_move, double t_turn){
    m_drive.arcadeDrive(t_move * speed, t_turn * speed);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveManually());
    
  }
}
