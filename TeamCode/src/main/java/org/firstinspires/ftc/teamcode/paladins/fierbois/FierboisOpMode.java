package org.firstinspires.ftc.teamcode.paladins.fierbois;

import static java.lang.Boolean.TRUE;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.paladins.common.PaladinsOpMode;
import org.firstinspires.ftc.teamcode.paladins.mecanum.NormalisedMecanumDrive;

@TeleOp(name = "FierboisTeleOp")
public class FierboisOpMode extends PaladinsOpMode {
    private FierboisConfiguration config;
    private NormalisedMecanumDrive drive;

    @Override
    protected void onInit() {
        config = FierboisConfiguration.newConfig(hardwareMap, telemetry);

        drive = new NormalisedMecanumDrive(this, config.frontLeftMotor, config.frontRightMotor, config.backLeftMotor, config.backRightMotor, TRUE);
    }

    @Override
    protected void activeLoop() throws InterruptedException {

        float xx = 0;
        float yy = 0;

        if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
            xx = gamepad1.left_stick_x;
        } else {
            yy = gamepad1.left_stick_y;
        }

        if (!gamepad1.right_bumper) {
            xx = xx/2;
            yy = yy/2;
        }

            drive.setSpeedXYR(-yy, xx, -gamepad1.right_stick_x);
            drive.update();

//        DRIVER (GAMEPAD) 1 CONTROLS
//        drive.update();


    }
}