package org.firstinspires.ftc.teamcode.paladins.geofferys;

import org.firstinspires.ftc.teamcode.paladins.common.PaladinsOpMode;
import org.firstinspires.ftc.teamcode.paladins.geofferys.TheGeoffDrive;
import org.firstinspires.ftc.teamcode.paladins.tasks.BaseTask;
import org.firstinspires.ftc.teamcode.paladins.tasks.Task;

public class TheGeoffDriveTask extends BaseTask implements Task {

    private final TheGeoffDrive drive;
    private final double LeftSpeed;
    private final double RightSpeed;
    private final double Liftpower;

    // Variables to usable in auto and different tasks
    public TheGeoffDriveTask(PaladinsOpMode opMode, double time, TheGeoffDrive drive, double LeftSpeed, double RightSpeed, double liftpower) {
        super(opMode, time);
        this.drive = drive;
        this.LeftSpeed = LeftSpeed;
        this.RightSpeed = RightSpeed;
        this.Liftpower = 0;

//        drive.setEncoder(false);
    }

    @Override
    public void init() {
        super.init();
 //       drive.setEncoder(false);
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
