/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.control_panel;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ControlPanelSubsystem;


public class ControlPanelSpin extends InstantCommand {
	ControlPanelSubsystem controlPanelSubsystem;
	double speed;

	public ControlPanelSpin(ControlPanelSubsystem controlPanelSubsystem, double speed) {
		this.controlPanelSubsystem = controlPanelSubsystem;
		this.speed = speed;
		addRequirements(controlPanelSubsystem);
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
		controlPanelSubsystem.controlPanelSpin(speed);
	}
	
}
