package frc.robot.commands.chassis.auto.paths;
import java.io.IOException;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.commands.chassis.auto.AutoFollowPath;
import frc.robot.commands.intake.IntakeRollersSetAuto;
import frc.robot.commands.shooter.ShooterShoot;
import frc.robot.commands.shooter.ShooterStop;
import frc.robot.subsystems.ChassisSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class AutoLeft8 extends SequentialCommandGroup {

	public AutoLeft8(ChassisSubsystem chassisSubsystem, IntakeSubsystem intakeSubsystem, ShooterSubsystem shooterSubsystem) throws IOException {
		super(
			new AutoFollowPath(chassisSubsystem, "output/left8-1.wpilib.json"),
			new ShooterShoot(shooterSubsystem, Constants.AUTO_SHOOT_SETPOINT),
			new WaitCommand(Constants.AUTO_SHOOT_DURATION),
            new ShooterStop(shooterSubsystem),
			new IntakeRollersSetAuto(intakeSubsystem, 1),
			new AutoFollowPath(chassisSubsystem, "output/left8-2.wpilib.json"),
			new WaitCommand(Constants.AUTO_INTAKE_MIN_DURATION),
			new IntakeRollersSetAuto(intakeSubsystem, 0),
			new AutoFollowPath(chassisSubsystem, "output/left8-3.wpilib.json"),
			new ShooterShoot(shooterSubsystem, Constants.AUTO_SHOOT_SETPOINT),
			new WaitCommand(Constants.AUTO_SHOOT_DURATION),
            new ShooterStop(shooterSubsystem)
		);
	}
}
