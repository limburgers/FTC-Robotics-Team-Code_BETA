package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public abstract class CommonOpMode extends LinearOpMode {
    protected DcMotor leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor;

    protected DcMotor LLiftMotor, RLiftMotor;
    protected Servo bigArm;

    protected double servoPos = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();

        leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
        leftBackMotor = hardwareMap.get(DcMotor.class, "leftBackMotor");
        rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");
        rightBackMotor = hardwareMap.get(DcMotor.class, "rightBackMotor");
        LLiftMotor = hardwareMap.get(DcMotor.class, "LLiftMotor");
        RLiftMotor = hardwareMap.get(DcMotor.class, "RLiftMotor");
        bigArm = hardwareMap.get(Servo.class, "bigArm");

        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        rightBackMotor.setDirection(DcMotor.Direction.REVERSE);
        RLiftMotor.setDirection(DcMotor.Direction.REVERSE);
        bigArm.setDirection(Servo.Direction.REVERSE);

        LLiftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RLiftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        LLiftMotor.setTargetPosition(0);
        RLiftMotor.setTargetPosition(0);

        LLiftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RLiftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        LLiftMotor.setPower(0.5);
        RLiftMotor.setPower(0.5);

        gamepad1.reset();
        gamepad1.rumble(500);

        while(opModeIsActive()) {
            telemetry.addData("Left Lift Pos: ", LLiftMotor.getCurrentPosition());
            telemetry.addData("Right Lift Pos: ", RLiftMotor.getCurrentPosition());
            telemetry.addData("ServoPos: ", servoPos);

            telemetry.update();

            runner();
        }
    }

    protected abstract void runner();
}
