package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake extends Mechanism {
    DcMotorEx motor;
    public double power = 0;

    public void init(HardwareMap hwMap) {
        motor = hwMap.get(DcMotorEx.class, "intakeMotor");
    }

    public void loop() {
        motor.setPower(power);
    }

    public void setPower(double newPower) {
        power = newPower;
    }
}
