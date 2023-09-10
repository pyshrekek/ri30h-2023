package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystem.drive.BasicMecanum;

public class Robot extends Mechanism {
    BasicMecanum drivetrain = new BasicMecanum();
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
            lift.setState(Lift.LiftState.IDLE);
        } else if (gamepad.b) {
            lift.setState(Lift.LiftState.BOTTOM);
        } else if (gamepad.right_bumper) {
            lift.setState(Lift.LiftState.SCORING);
        }
    }
}
