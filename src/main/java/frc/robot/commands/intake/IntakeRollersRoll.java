/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ImpiLib2020;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeRollersRoll extends CommandBase {

	private final IntakeSubsystem intakeSubsystem;
	private final DoubleSupplier leftSpeed;
	private final DoubleSupplier rightSpeed;

	public IntakeRollersRoll(IntakeSubsystem intakeSubsystem, DoubleSupplier leftSpeed, DoubleSupplier rightSpeed) {
		this.intakeSubsystem = intakeSubsystem;
		this.leftSpeed = leftSpeed;
		this.rightSpeed = rightSpeed;
		addRequirements(intakeSubsystem);
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		intakeSubsystem.rollersRoll(ImpiLib2020.parseJoystick(leftSpeed.getAsDouble() - rightSpeed.getAsDouble()));
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
