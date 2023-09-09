package org.firstinspires.ftc.teamcode.opmode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystem.Lift;

@Config
@TeleOp(name = "TestIntakeColorSensor")
public class Main extends LinearOpMode {
    FtcDashboard dashboard = FtcDashboard.getInstance();
    MultipleTelemetry tele = new MultipleTelemetry(telemetry, dashboard.getTelemetry());

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
             tele.addData("Time", time.time());
             tele.addData("R",testSensor.red());
             tele.addData("G",testSensor.green());
             tele.addData("B",testSensor.blue());
             tele.addData("liftPos", lift.getPos());
             tele.update();
         }
    }
}
