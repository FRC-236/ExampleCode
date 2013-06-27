/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ticks.robots.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import ticks.robots.RobotMap;

/**
 * An example of a subsystem to control an elevator using closed-loop control
 * This example uses the WPILibj PID loop, and allows the pid tuning values to be adjusted
 * from the smartdashboard or other networktable client (LabView dashboard, tableviewer...)
 * @author Jared
 */
public class Elevator extends Subsystem implements PIDSource, PIDOutput{
    private SpeedController elevatorMotor;
    private Encoder elevatorEncoder;
    private PIDController pidController;
    
    public Elevator(){
        elevatorEncoder = new Encoder(RobotMap.DIO.elev_enc_A, 
                RobotMap.DIO.elev_enc_B);
        elevatorEncoder.setDistancePerPulse(1/256); //256 count encoder
        elevatorMotor = new Victor(RobotMap.PWM.elevatorMotor);
        pidController = new PIDController(0, 0, 0, this, this);
        pidController.enable();
        SmartDashboard.putData("Elevator PID", pidController);
    }
    public void setElevatorSetpoint(double setpoint){
        pidController.setSetpoint(setpoint);
    }
    
    public void closedLoopControl(){
        elevatorMotor.set(pidController.get());
    }
    
    public boolean onTarget(){
        int tolerance = 10; //how many counts the elevator can be off, and still
        //be considered on target
        boolean atSetpoint = 10 > Math.abs(tolerance-pidGet());
        return atSetpoint;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public double pidGet() {
        return elevatorEncoder.getDistance();
    }

    public void pidWrite(double output) {
        //we don't use the pid write output, as it forces us to only have
        //a pid loop control the elevator, so we can never have another method 
        //of control
    }
}
