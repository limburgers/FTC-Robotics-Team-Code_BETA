package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

public abstract class CommonOpMode extends LinearOpMode {
    protected DcMotor leftFrontMotor;
    protected DcMotor leftBackMotor;
    protected DcMotor rightFrontMotor;
    protected DcMotor rightBackMotor;

    protected Gamepad gamepad;

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();

        leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
        leftBackMotor = hardwareMap.get(DcMotor.class, "leftBackMotor");
        rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");
        rightBackMotor = hardwareMap.get(DcMotor.class, "rightBackMotor");

        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);

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
            telemetry.addData("IsOpModeActive", true);

            telemetry.update();

            runner();
        }
    }

    protected abstract void runner();
}
