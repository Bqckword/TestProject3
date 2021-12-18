package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TestCommand extends CommandBase {
    private final DriveSubsystem drive;

    public TestCommand(DriveSubsystem drive) {
        this.drive = drive;
    }

    @Override public void execute() {
        drive.arcadeDrive(0, 0.5);
    }
}
