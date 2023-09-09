package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public final class Intake extends Mechanism {
    // 2 color sensors - One for color of gamepiece, One to detect if one is in
    // One Motor intake
    int currPassed = 0;
    enum Colors{
        GREEN,
        PURPLE,
        YELLOW,
        WHITE
    }

    Colors[] storedPixels = {};
    ColorSensor Point0,Point1;
    DcMotor intake;
    final int maxVel = 100;
    double powerVal = 0;

    public void init(HardwareMap hwMap) {
        intake = hwMap.get(DcMotor.class, "intake");
        Point0 = hwMap.get(ColorSensor.class, "GetCol");
        Point1 = hwMap.get(ColorSensor.class, "IncrementPasses");
    }

    //This will literally only happen when there is more than 1 Pixel in the intake
    public void checkPassing() {
        if(Point1.red() < 15 &&Point1.green() < 15 && Point1.blue() < 15) {
            System.out.println("NOTHING FOUND" + "NULL");
        } else {
            storedPixels[currPassed-1] = processColor(Point1.red(),Point1.green(), Point1.blue());
        }
    }

    Colors processColor(int r, int g, int b) {

        return Colors.WHITE;
    }



    // The following 2 methods either turn the intake on or off (Use it with conjunction to the amount of pixels in the bot
    public void Activate(double p) {
        powerVal = p;
    }
    public void Deactivate(double p) {
        powerVal = p;
    }

    // increases the amount of pixels currently stored in the robot, the maximum of pixels can be changed so that you can more easily test things out
    public void incrementAmount() {
        currPassed++;
    }
    // Clears the amount of pixels stored, so that you can intake more
    public void clearAmount() {
        currPassed = 0;
    }
}
