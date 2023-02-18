package org.firstinspires.ftc.teamcode.paladins.geofferys;

import org.firstinspires.ftc.teamcode.paladins.common.PaladinsOpMode;
import org.firstinspires.ftc.teamcode.paladins.cortana.CortanaDrive;
import org.firstinspires.ftc.teamcode.paladins.tasks.BaseTask;
import org.firstinspires.ftc.teamcode.paladins.tasks.Task;

public class TheGeoffDriveTask extends BaseTask implements Task {

    private final CortanaDrive drive;
    private final double LeftSpeed;
    private final double RightSpeed;

    public TheGeoffDriveTask(PaladinsOpMode opMode, double time, CortanaDrive drive, double LeftSpeed, double RightSpeed) {
        super(opMode, time);
        this.drive = drive;
        this.LeftSpeed = LeftSpeed;
        this.RightSpeed = RightSpeed;


        drive.setEncoder(false);
    }

    @Override
    public void init() {
        super.init();
        drive.setEncoder(false);
    }

    @Override
    public void run() {
        drive.setPower(LeftSpeed, RightSpeed);
        drive.update();
        if (isFinished()) {
            drive.setPower(0, 0);
            drive.update();
            return;
        }

    }

}
