package org.firstinspires.ftc.teamcode.opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp
public class Main extends LinearOpMode {
    ColorSensor testSensor;
    @Override
    public void runOpMode() throws InterruptedException {
         testSensor = hardwareMap.get(ColorSensor.class, "GetCol");
         waitForStart();
         while(!isStopRequested()) {
             telemetry.addData("R",testSensor.red());
             telemetry.addData("G",testSensor.green());
             telemetry.addData("B",testSensor.blue());
             telemetry.update();
         }
    }
}
