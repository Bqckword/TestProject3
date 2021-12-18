package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.MiniBotChallengeComplete;
import frc.robot.commands.TurnDegrees;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {
  public final DriveSubsystem drive = new DriveSubsystem();
  public final XboxController controller = new XboxController(0);

  public RobotContainer() {
    configureButtonBindings();
  }

  public void doMiniBotChallenge() {
    new MiniBotChallengeComplete().schedule();
  }

  private void configureButtonBindings() {
    SmartDashboard.putData("Drive distance", new DriveDistance(10, 0.5, drive));
    SmartDashboard.putData("Turn", new TurnDegrees(90, 0.5, drive));
  }
}
