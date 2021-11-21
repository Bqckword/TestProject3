package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveDistance extends CommandBase {
    private final double distance;
    private final double speed;
    private final DriveSubsystem train;

    public DriveDistance(double distance, double speed, DriveSubsystem train) {
        this.distance = distance;
        this.speed = speed;
        this.train = train;
        addRequirements(train);
    }

    @Override public void initialize() {
        train.arcadeDrive(0, 0);
        train.resetEncoders();
    }

    @Override public void execute() {
        // System.out.println("Executing arcadeDrive()");
        train.arcadeDrive(speed, 0);
    }

    @Override public void end(boolean interrupted) {
      train.arcadeDrive(0, 0);
    }

    @Override public boolean isFinished() {
        return Math.abs(train.getAverageDistance()) >= distance;
    }
}