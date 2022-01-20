package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableRegistry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.MiniBotChallengeComplete;
import frc.robot.commands.TurnDegrees;
import frc.robot.subsystems.DriveSubsystem;

// RobotContainer -> Robot -> Main

// Runtime error 
// Compilation error -- IDE 
public class RobotContainer {
  private final DriveSubsystem drive = new DriveSubsystem();
  public final XboxController controller = new XboxController(0);

  public RobotContainer() {
    configureButtonBindings();
  }

  public void doMiniBotChallenge() {
    new MiniBotChallengeComplete(drive).schedule();
  }

  private void configureButtonBindings() {  
    // SmartDashboard.puitData("dsad", RoboRIO.getWhatever())
    SmartDashboard.putData("Drive distance", new DriveDistance(10, 0.5, drive));
    SmartDashboard.putData("Turn", new TurnDegrees(90, 0.5, drive));
  }
}