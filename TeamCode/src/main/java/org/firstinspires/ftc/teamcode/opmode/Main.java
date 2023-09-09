package org.firstinspires.ftc.teamcode.opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "TestIntakeColorSensor")
public class Main extends LinearOpMode {
    ColorSensor testSensor;
    @Override
    public void runOpMode() throws InterruptedException {
        // BLYAAAATTTTTZZZ NAHOYYY OK SUKA COLOR SENSOR BLYAT
         testSensor = hardwareMap.get(ColorSensor.class, "GetCol");
        ElapsedTime time = new ElapsedTime();
         waitForStart();
         while(!isStopRequested()) {
             telemetry.addData("Time", time.time());
             telemetry.addData("R",testSensor.red());
             telemetry.addData("G",testSensor.green());
             telemetry.addData("B",testSensor.blue());
             telemetry.update();
         }
    }
}
