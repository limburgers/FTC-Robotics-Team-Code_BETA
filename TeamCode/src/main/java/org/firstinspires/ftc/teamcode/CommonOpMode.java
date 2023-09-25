package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public abstract class CommonOpMode extends LinearOpMode {

    @Override
    public void runOpMode() {
        waitForStart();

        while(opModeIsActive()) {
            runner();
        }
    }

    protected abstract void runner();
}
