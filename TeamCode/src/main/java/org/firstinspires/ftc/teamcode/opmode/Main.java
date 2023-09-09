package org.firstinspires.ftc.teamcode.opmode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystem.Lift;

@Config
@TeleOp(name = "TestIntakeColorSensor")
public class Main extends LinearOpMode {
    ColorSensor testSensor;
    Lift lift = new Lift();
    @Override
    public void runOpMode() throws InterruptedException {
        // BLYAAAATTTTTZZZ NAHOYYY OK SUKA COLOR SENSOR BLYAT
         testSensor = hardwareMap.get(ColorSensor.class, "GetCol");

        ElapsedTime time = new ElapsedTime();
         waitForStart();

        lift.init(hardwareMap);
         while(!isStopRequested()) {
             lift.loop();
             telemetry.addData("Time", time.time());
             telemetry.addData("R",testSensor.red());
             telemetry.addData("G",testSensor.green());
             telemetry.addData("B",testSensor.blue());
             telemetry.addData("liftPos", lift.getPos());
             telemetry.update();
         }
    }
}
