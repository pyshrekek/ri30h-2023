package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot extends Mechanism {
    Climber climber = new Climber();
    Intake intake = new Intake();
    Lift lift = new Lift();

    public void init(HardwareMap hwMap) {
        climber.init(hwMap);
        intake.init(hwMap);
        lift.init(hwMap);
    }

    public void loop(Gamepad gamepad) {

    }
}
