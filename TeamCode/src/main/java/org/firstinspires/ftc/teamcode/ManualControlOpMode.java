package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

class CurvedGamepad {
    public double lx;
    public double ly;
    public double rx;

    final double CURVE = 2.5;
    final double TURN_MAX = 0.5;
    double servoPos = 0;

    public CurvedGamepad(Gamepad gamepad) {
        this.lx = gamepad.left_stick_x < 0 ? -(Math.pow(-gamepad.left_stick_x, CURVE)) : Math.pow(gamepad.left_stick_x, CURVE);
        this.ly = gamepad.left_stick_y < 0 ? -(Math.pow(-gamepad.left_stick_y, CURVE)) : Math.pow(gamepad.left_stick_y, CURVE);
        this.rx = (gamepad.right_stick_x < 0 ? -(Math.pow(-gamepad.right_stick_x, CURVE)) : Math.pow(gamepad.right_stick_x, CURVE)) * TURN_MAX;
    }
}

@TeleOp(name = "Driving OpMode")
public class ManualControlOpMode extends CommonOpMode {
    int lPos = 0;
    @Override
    public void runner() {
        CurvedGamepad cgp = new CurvedGamepad(gamepad1);
        CurvedGamepad cgp2 = new CurvedGamepad(gamepad2);

        double denominator = Math.max(Math.abs(cgp.ly) + Math.abs(cgp.lx) + Math.abs(cgp.rx), 1);

        leftFrontMotor.setPower((cgp.ly - cgp.lx - cgp.rx)/denominator);
        leftBackMotor.setPower((cgp.ly + cgp.lx - cgp.rx)/denominator);
        rightFrontMotor.setPower((cgp.ly + cgp.lx + cgp.rx)/denominator);
        rightBackMotor.setPower((cgp.ly - cgp.lx + cgp.rx)/denominator);

        if (gamepad2.left_stick_y > 0.1)
            lPos -= 2;

        if (gamepad2.left_stick_y < -0.1)
            lPos += 2;

        if (lPos < -835)
            lPos = -835;
        else if (lPos > 0)
            lPos = 0;

        LLiftMotor.setTargetPosition(lPos);
        RLiftMotor.setTargetPosition(lPos);

        if (gamepad.right_stick_y > 0.1)
            servoPos += 0.01;
        if (gamepad.right_stick_y < -0.1)
            servoPos -= 0.01;

        if (servoPos > 1)
            servoPos = 1;
        else if (servoPos < 0)
            servoPos = 0;

        bigArm.setPosition(servoPos);
    }
}
