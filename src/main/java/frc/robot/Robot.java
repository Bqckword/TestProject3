package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.ControllerDrive;
import frc.robot.commands.DriveDistance;

public class Robot extends TimedRobot {
  private RobotContainer robotContainer = new RobotContainer();

  @Override public void robotInit() {
      
  }

  @Override public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override public void disabledInit() {

  }

  @Override public void disabledPeriodic() {

  }

  @Override public void autonomousInit() {
    new DriveDistance(25, 1, robotContainer.drive).schedule();
    // PIDController
  }

  @Override public void autonomousPeriodic() {

  }

  @Override public void teleopInit() {
      
  }

  @Override public void teleopPeriodic() {
      // new ControllerDrive().schedule();
      robotContainer.drive.tankDrive(robotContainer.controller.getY(), robotContainer.controller.getX());
  }

  @Override public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override public void testPeriodic() {

  }
}
