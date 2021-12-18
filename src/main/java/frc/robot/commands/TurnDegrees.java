package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TurnDegrees extends CommandBase {
    private final double degrees;
    private final double speed;
    private final DriveSubsystem drive;

    public TurnDegrees(double degrees, double speed, DriveSubsystem drive) {
        this.degrees = degrees;
        this.speed = speed;
        this.drive = drive;
        addRequirements(drive);
    }

    @Override public void initialize() {
        drive.arcadeDrive(0, 0); // Tell motors to stop
        drive.resetEncoders();
    }

    @Override public void execute() {
        drive.arcadeDrive(0, speed);
    }

    @Override public void end(boolean interrupted) {
        drive.arcadeDrive(0, 0);
    }

    @Override public boolean isFinished() {
      /* Need to convert distance travelled to degrees. The Standard
         Romi Chassis found here, https://www.pololu.com/category/203/romi-chassis-kits,
         has a wheel placement diameter (149 mm) - width of the wheel (8 mm) = 141 mm
         or 5.551 inches. We then take into consideration the width of the tires.
      */
      double inchPerDegree = Math.PI * 5.551 / 360;
      // Compare distance travelled from start to distance based on degree turn
      return getAverageTurningDistance() >= (inchPerDegree * degrees);
    }
  
    private double getAverageTurningDistance() {
      double leftDistance = Math.abs(drive.getLeftDistance());
      double rightDistance = Math.abs(drive.getRightDistance());
      return (leftDistance + rightDistance) / 2.0;
    }
}