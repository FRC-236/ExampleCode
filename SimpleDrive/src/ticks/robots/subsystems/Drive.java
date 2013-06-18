/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ticks.robots.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import ticks.robots.OI;
import ticks.robots.RobotMap;
import ticks.robots.commands.CommandBase;
import ticks.robots.commands.TeleopDrive;

/**
 *
 * @author Jared
 */
public class Drive extends Subsystem {
    private RobotDrive drive;
    private Victor leftDrive, rightDrive;
    
    public Drive(){
      leftDrive = new Victor(RobotMap.PWM.leftDrive);
      rightDrive = new Victor(RobotMap.PWM.rightDrive);
      drive = new RobotDrive(leftDrive, rightDrive);
    }
    
    public void teleopDrive(){
        drive.tankDrive(CommandBase.oi.getUSBDevice(OI.StickType.kLeftJoystick), 
                RobotMap.Joysticks.joystickYAxis, 
                CommandBase.oi.getUSBDevice(OI.StickType.kRightJoystick), 
                RobotMap.Joysticks.joystickYAxis);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new TeleopDrive());
    }
}