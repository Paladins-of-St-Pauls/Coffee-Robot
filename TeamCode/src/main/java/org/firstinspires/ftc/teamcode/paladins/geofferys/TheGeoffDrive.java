package org.firstinspires.ftc.teamcode.paladins.geofferys;

import android.annotation.SuppressLint;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.paladins.common.PaladinsComponent;
import org.firstinspires.ftc.teamcode.paladins.common.PaladinsOpMode;

/**
 * Created by Shaun on 2/07/2017.
 */

public class TheGeoffDrive extends PaladinsComponent {
    final private DcMotor LeftMotor;
    final private DcMotor RightMotor;
    final private DcMotor LiftMotor;
    private double LeftPower;
    private double RightPower;


    public TheGeoffDrive(PaladinsOpMode opMode, Gamepad gamepad1, DcMotor LeftMotor, DcMotor RightMotor, DcMotor LiftMotor) {
        super(opMode);

        // Variables for the motors
        this.LeftMotor = LeftMotor;
        this.RightMotor = RightMotor;
        this.LiftMotor = LiftMotor;
        LeftPower = 0;
        RightPower = 0;
    }
            // So both motor spins in the same direction
    public void setPower(double Left, double Right) {
        RightPower = -Right;

    }
        // Stop robot
    public void setToBrake() {
        RightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LiftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setToFloat() {
        LeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        RightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        LiftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

//    public void setEncoder(boolean encoder) {
 //      if (encoder)
 //         LeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
 //         RightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
 //         LeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
  //        RightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        } else {
//
 //       }

    /*
     * Update the motor power based on the gamepad state
     */
    @SuppressLint("DefaultLocale")
    public void update() {
        LeftMotor.setPower((LeftPower));
        RightMotor.setPower((RightPower));
    }

    public boolean isFinished() {
        return !(LeftMotor.isBusy() || RightMotor.isBusy());
    }

    public boolean targetPositionReached() {
        return (!LeftMotor.isBusy() || RightMotor.isBusy());
    }

    public void setTargetPosition(double LeftDistance, double RightDistance) {
        // Encoder task
        int newLeftTarget;
        int newRightTarget;
        newLeftTarget = LeftMotor.getCurrentPosition() + (int) LeftDistance;
        newRightTarget = RightMotor.getCurrentPosition() + (int) RightDistance;

        LeftMotor.setTargetPosition(newLeftTarget);
        RightMotor.setTargetPosition(newRightTarget);
        LeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void setCountsPerCm(double countsPerCm) {
    }
}
