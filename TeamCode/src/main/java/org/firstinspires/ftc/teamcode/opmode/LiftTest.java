package org.firstinspires.ftc.teamcode.opmode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystem.Lift;

@Config
@TeleOp(name="Lift Test")
public class LiftTest extends LinearOpMode {
    FtcDashboard dashboard = FtcDashboard.getInstance();
    MultipleTelemetry tele = new MultipleTelemetry(telemetry, dashboard.getTelemetry());

    @Override
    public void runOpMode() throws InterruptedException {
        Lift lift = new Lift();

        waitForStart();

        lift.init(hardwareMap);

        while(!isStopRequested() && opModeIsActive()) {
            lift.loop();
            tele.addData("Current pos", lift.getPos());
            tele.addData("Current setpoint", lift.getTarget());
        }
    }
}
