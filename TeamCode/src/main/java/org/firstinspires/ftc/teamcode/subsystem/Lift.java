package org.firstinspires.ftc.teamcode.subsystem;


import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.util.PIDController;

@Config
public class Lift extends Mechanism {
    DcMotorEx[] motors = new DcMotorEx[1];
    Servo deposit;
    ElapsedTime timer = new ElapsedTime();
    PIDController controller = new PIDController(kP, kI, kD);

    public enum LiftState {
        BOTTOM,
        IDLE,
        SCORING
    }

    public static double kP = 0.01;
    public static double kI = 0;
    public static double kD = 0;
    public static double kG = 0;

    public static double bottom = 0;
    public static double up = 1100;
    public static double intakePos = .9;
    public static double idlePos = .5;
    public static double depositPos = 0;
    public static double currentPosDeposit;

    public static double target = 0;
    public static double power;

    private static final double WHEEL_RADIUS = 1.37795;
    private static final double GEAR_RATIO = 1.0;
    private static final double TICKS_PER_REV = 145.1;

    @Override
    public void init(HardwareMap hwMap) {
        motors[0] = hwMap.get(DcMotorEx.class, "lift");
        motors[0].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        motors[0].setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motors[0].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motors[0].setDirection(DcMotorSimple.Direction.FORWARD);

        deposit = hwMap.get(Servo.class, "deposit");
        currentPosDeposit = intakePos;
    }

    public void loop() {
        controller.setSetpoint(target);
        power = controller.calculate(motors[0].getCurrentPosition()) + kG;
        motors[0].setPower(power);
        deposit.setPosition(currentPosDeposit);

        System.out.println("setpoint: " + target);
        System.out.println("power: " + power);
        System.out.println("pos: " + motors[0].getCurrentPosition() );
    }

    public void goBottom() {
        target = bottom;
    }

    public void goUp() {
        target = up;
    }

    public double getTarget() {
        return target;
    }

    public void setIntake() {
        currentPosDeposit = intakePos;
    }

    public void setIdle() {
        currentPosDeposit = idlePos;
    }

    public void setDeposit() {
        currentPosDeposit = depositPos;
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
