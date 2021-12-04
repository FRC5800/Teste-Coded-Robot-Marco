// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;


public class DriveTimed extends Command {
  public DriveTimed() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double time = 3;
    double t_move;
    double t_turn;
    
    if (time < 2.0) {
      t_move = 1;
      t_turn = 0;
      Robot.m_drivetrain.timedDrive(t_move, t_turn);
    }else if(2.0 < time){

    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    double time = 3;
    if (time > 4.0){
      return true;
    }else{
      return false;
    }
    
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    DriveTrain.speed = 0;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {}
}
