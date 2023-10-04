package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public abstract class CommonOpMode extends LinearOpMode {
    protected DcMotor leftFrontMotor;
    protected DcMotor leftBackMotor;
    protected DcMotor rightFrontMotor;
    protected DcMotor rightBackMotor;

    protected Gamepad gamepad;

    @Override
    public void runOpMode() {
        waitForStart();

        leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
        leftBackMotor = hardwareMap.get(DcMotor.class, "leftBackMotor");
        rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");
        rightBackMotor = hardwareMap.get(DcMotor.class, "rightBackMotor");

        gamepad = gamepad1;

        gamepad.reset();
        gamepad.rumble(500);

        while(opModeIsActive()) {
            telemetry.addData("IsOpModeActive", true);

            telemetry.update();

            runner();
        }
    }

    protected abstract void runner();
}
