// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.TestCommand;
import frc.robot.commands.TurnDegrees;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {
  public final DriveSubsystem drive = new DriveSubsystem();
  public final XboxController controller = new XboxController(0);

  public RobotContainer() {
    configureButtonBindings();
  }

  public Command getAutonomousCommand() {
    return new DriveDistance(20, -0.5, drive);
  }

  private void configureButtonBindings() {
    SmartDashboard.putData("Drive distance", new DriveDistance(10, 0.5, drive));
    SmartDashboard.putData("Test", new TestCommand(drive));
    SmartDashboard.putData("Turn", new TurnDegrees(90, 0.5, drive));
  }
}
