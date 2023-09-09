package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public final class Intake {
    // 2 color sensors - One for color of gamepiece, One to detect if one is in
    // One Motor intake
    int currPassed = 0;

    final int maxVel = 100;
    double powerVal = 0;

    public Intake(HardwareMap hardwareMap, Telemetry telemetry) {

    }


    public void Activate(double p) {
        powerVal = p;
    }

    public void Deactivate(double p) {
        powerVal = p;
    }


    public void incrementAmount() {
        currPassed++;
    }
    public void clearAmount() {
        currPassed = 0;
    }




}
