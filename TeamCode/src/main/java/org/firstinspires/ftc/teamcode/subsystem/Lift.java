package org.firstinspires.ftc.teamcode.subsystem;


import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.util.PIDController;

@Config
public class Lift extends Mechanism {
    DcMotorEx[] motors = new DcMotorEx[2];
    ElapsedTime timer = new ElapsedTime();
    PIDController controller = new PIDController(kP, kI, kD);

    public static double kP = 0;
    public static double kI = 0;
    public static double kD = 0;

    public static double bottom = 0;
    public static double up = 300;

    public static double target = 0;
    public double power;

    private static final double WHEEL_RADIUS = 1.37795;
    private static final double GEAR_RATIO = 1.0;
    private static final double TICKS_PER_REV = 145.1;

    @Override
    public void init(HardwareMap hwMap) {
        motors[0] = hwMap.get(DcMotorEx.class, "left");
        motors[1] = hwMap.get(DcMotorEx.class, "right");
        motors[0].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motors[1].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motors[0].setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motors[1].setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motors[0].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motors[1].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motors[0].setDirection(DcMotorSimple.Direction.FORWARD);
        motors[1].setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setTargetPosition(double pos) {
        target = pos;
    }

    public void loop() {
        controller.setSetpoint(target);
        power = controller.calculate(motors[0].getCurrentPosition());
        motors[0].setPower(power);
        motors[1].setPower(power);
    }

    public double ticksToInches(double ticks) {
        return 2 * Math.PI * WHEEL_RADIUS * GEAR_RATIO * ticks / TICKS_PER_REV;
    }

    public double getPos() {
        return motors[0].getCurrentPosition();
    }

    public double getPosInches() {
        return ticksToInches(getPos());
    }
}
