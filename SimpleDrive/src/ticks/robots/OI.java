
package ticks.robots;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    Joystick leftStick = new Joystick(RobotMap.Joysticks.leftStickUSB);
    Joystick rightStick = new Joystick(RobotMap.Joysticks.rightStickUSB);
    Joystick gamePad = new Joystick(RobotMap.Joysticks.gamePadUSB);
    public static class StickType {
        public final int value;
        static final int kLeftJoystick_val = 0, kRightJoystick_val = 1, 
                kGamePad_val = 2;
        public static final StickType kLeftJoystick = new StickType(kLeftJoystick_val);
        public static final StickType kRightJoystick = new StickType(kRightJoystick_val);
        public static final StickType kGamePad = new StickType(kGamePad_val);
        private StickType(int value) {
            this.value = value;
        }
    }
    
    public Joystick getUSBDevice(StickType type){
        Joystick stick;
        switch (type.value) {
            case StickType.kLeftJoystick_val: stick = leftStick;
                break;
            case StickType.kRightJoystick_val: stick = rightStick;
                break;
            case StickType.kGamePad_val: stick = gamePad;
                break;
            default: System.out.print("Invalid Joystick assignment in OI.java");
                stick = null;
                break;
        }
        return stick;
    }
    
    
}

