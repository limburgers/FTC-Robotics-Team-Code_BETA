package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public abstract class CommonOpMode extends LinearOpMode {
    protected DcMotor leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor;

    protected DcMotor LLiftMotor, RLiftMotor;

    protected Gamepad gamepad;

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();

        leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
        leftBackMotor = hardwareMap.get(DcMotor.class, "leftBackMotor");
        rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");
        rightBackMotor = hardwareMap.get(DcMotor.class, "rightBackMotor");
        LLiftMotor = hardwareMap.get(DcMotor.class, "LLiftMotor");
        RLiftMotor = hardwareMap.get(DcMotor.class, "RLiftMotor");

        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        rightBackMotor.setDirection(DcMotor.Direction.REVERSE);
        RLiftMotor.setDirection(DcMotor.Direction.REVERSE);

        LLiftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RLiftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        LLiftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RLiftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        LLiftMotor.setPower(0.5);
        RLiftMotor.setPower(0.5);

        gamepad = gamepad1;

        gamepad.reset();
        gamepad.rumble(500);

        /*
        leftFrontMotor.setPower(0.5);
        Thread.sleep(1000);
        leftFrontMotor.setPower(0);
        leftBackMotor.setPower(0.5);
        Thread.sleep(1000);
        leftBackMotor.setPower(0);
        rightFrontMotor.setPower(0.5);
        Thread.sleep(1000);
        rightFrontMotor.setPower(0);
        rightBackMotor.setPower(0.5);
        Thread.sleep(1000);
        rightBackMotor.setPower(0);
        */

        while(opModeIsActive()) {
            telemetry.addData("Left Lift Pos: ", LLiftMotor.getCurrentPosition());
            telemetry.addData("Right Lift Pos: ", RLiftMotor.getCurrentPosition());

            telemetry.update();

            runner();
        }
    }

    protected abstract void runner();
}
