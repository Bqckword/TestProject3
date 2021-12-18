package frc.robot.subsystems;

import static frc.robot.RobotConstants.COUNTS_PER_REVOLUTION;
import static frc.robot.RobotConstants.WHEEL_DIAMETER_INCH;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  private final Spark leftMotor = new Spark(0);
  private final Spark rightMotor = new Spark(1);

  private final Encoder leftEncoder = new Encoder(4, 5);
  private final Encoder rightEncoder = new Encoder(6, 7);

  private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotor, rightMotor);

  public DriveSubsystem() {
    leftEncoder.setDistancePerPulse((Math.PI * WHEEL_DIAMETER_INCH) / COUNTS_PER_REVOLUTION);
    rightEncoder.setDistancePerPulse((Math.PI * WHEEL_DIAMETER_INCH) / COUNTS_PER_REVOLUTION);
    resetEncoders();
  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    diffDrive.arcadeDrive(xSpeed, zRotation);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    diffDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public double getLeftDistance() {
    return leftEncoder.getDistance();
  }

  public double getRightDistance() {
    return rightEncoder.getDistance();
  }

  public double getAverageDistance() {
      return (getLeftDistance() + getRightDistance()) / 2.0;
  }
}
