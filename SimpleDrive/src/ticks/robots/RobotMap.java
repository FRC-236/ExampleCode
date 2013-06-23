package ticks.robots;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static class Joysticks {
        public static final int leftStickUSB = 1, rightStickUSB = 2, gamePadUSB = 3;
        public static final int joystickYAxis = 1;
    }
    public static class PWM {
        public static final int leftDrive = 1, rightDrive = 2;
        public static final int elevatorMotor = 3;
    }
    
    public static class DIO {
        public static final int elev_enc_A = 1, elev_enc_B = 2;
    }
   
}
