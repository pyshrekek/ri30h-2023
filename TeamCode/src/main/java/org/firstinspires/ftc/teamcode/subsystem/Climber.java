package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.hardware.lynx.LynxModule;

public class Climber extends Mechanism {
    private DcMotorEx climb;

    // constants
    private static final int kP = 1;

    @Override
    public void init(HardwareMap hwMap) {
        for (LynxModule module : hwMap.getAll(LynxModule.class)) {
            module.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }
        this.climb = hwMap.get(DcMotorEx.class, "climber");
    }

    public void moveClimber(Gamepad gamepad) {
        climb.setPower(gamepad.right_stick_y);
    }

}
