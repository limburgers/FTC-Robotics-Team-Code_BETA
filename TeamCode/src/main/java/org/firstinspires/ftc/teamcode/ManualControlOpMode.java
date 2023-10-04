package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Driving OpMode")
public class ManualControlOpMode extends CommonOpMode {
    final double CURVE = 2.5;
    final double TURN_MAX = 0.5;
    @Override
    public void runner() {
        double lx = gamepad.left_stick_x < 0 ? -(Math.pow(-gamepad.left_stick_x, CURVE)) : Math.pow(gamepad.left_stick_x, CURVE);
        double ly = gamepad.left_stick_y < 0 ? -(Math.pow(-gamepad.left_stick_y, CURVE)) : Math.pow(gamepad.left_stick_y, CURVE);
        double rx = (gamepad.right_stick_x < 0 ? -(Math.pow(-gamepad.right_stick_x, CURVE)) : Math.pow(gamepad.right_stick_x, CURVE)) * TURN_MAX;

        leftFrontMotor.setPower(-lx - ly - rx);
        leftBackMotor.setPower(lx - ly - rx);
        rightFrontMotor.setPower(-lx + ly - rx);
        rightBackMotor.setPower(lx + ly - rx);
    }
}
