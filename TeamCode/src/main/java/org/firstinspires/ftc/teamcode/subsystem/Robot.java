package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot extends Mechanism {
    Drivetrain drivetrain = new Drivetrain();
//    Climber climber = new Climber();
    Intake intake = new Intake();
    Lift lift = new Lift();

    public void init(HardwareMap hwMap) {
        drivetrain.init(hwMap);
//        climber.init(hwMap);
        intake.init(hwMap);
        lift.init(hwMap);
    }

    public void loop(Gamepad gamepad) {
        drivetrain.loop(gamepad);
        lift.loop();
        intake.loop();

        intake.setPower(gamepad.right_trigger);
        if (gamepad.a) {
            lift.goUp();
            lift.setIdle();
        } else if (gamepad.b) {
            lift.goBottom();
            lift.setIntake();
        } else if (gamepad.right_bumper) {
            lift.setDeposit();
        }
    }
}
