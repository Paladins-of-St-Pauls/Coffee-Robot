package org.firstinspires.ftc.teamcode.paladins.geofferys;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.paladins.common.PaladinsOpMode;
import org.firstinspires.ftc.teamcode.paladins.common.TankDrive;
import org.firstinspires.ftc.teamcode.paladins.geofferys.TheGeoffConfiguration;
import org.firstinspires.ftc.teamcode.paladins.tasks.TankDriveEncTask;
import org.firstinspires.ftc.teamcode.paladins.tasks.Task;

import java.util.ArrayDeque;

@Disabled
@Autonomous(name = "TheGeoffAutonomous")
public class TheGeoffAutonomous extends PaladinsOpMode {
    private TheGeoffConfiguration config;
    private TheGeoffDrive drive;
    private ArrayDeque<Task> tasks = new ArrayDeque<>();

    @Override
    protected void onInit() {
        config = TheGeoffConfiguration.newConfig(hardwareMap, telemetry);
        // Config for auto before start
        drive = new TheGeoffDrive(this, gamepad1, config.LeftMotor, config.RightMotor, config.LiftMotor);
        drive.setCountsPerCm(config.countsPerCm);
        config.LeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        config.RightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        // Tells Robot to go forward
        tasks.add(new TheGeoffDriveTask(this, 0.5, drive, 0.2, 0.2, 0));
        tasks.add(new TheGeoffDriveTask(this, 20, drive, 0.5, 0.5, 0));
        tasks.add(new TheGeoffDriveTask(this, 10, drive,0,0,1));
    }
    // If no more task finis
    @Override
    protected void activeLoop() throws InterruptedException {
        Task currentTask = tasks.peekFirst();
        if (currentTask == null) {
            return;
        }
        // If task finish move to next task
        currentTask.run();
        if (currentTask.isFinished()) {
            tasks.removeFirst();
            //No more task stop robot
        }
        if (tasks.isEmpty()) {
            drive.setPower(0, 0);
            drive.update();
        }
    }
}