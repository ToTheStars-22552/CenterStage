package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "slaban op")
public class OpMode extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        robotMap Robot = new robotMap(hardwareMap);

        waitForStart();
        if (isStopRequested()) return;
        while (opModeIsActive()) {
            double y = gamepad1.left_stick_y;
            double x = -gamepad1.left_stick_x * 1.1;
            double rx = -gamepad1.right_stick_x;
            double rt = gamepad1.right_trigger;
            double lt = gamepad1.left_trigger;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double rearLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double rearRightPower = (y + x - rx) / denominator;

            Robot.frontLeftWheel.setPower(frontLeftPower * 0.5);
            Robot.rearLeftWheel.setPower(rearLeftPower * 0.5);
            Robot.frontRightWheel.setPower(frontRightPower * 0.5);
            Robot.rearRightWheel.setPower(rearRightPower * 0.5);

            if((y!=0 || x!=0 || rx!=0) && rt!=0){
                Robot.frontLeftWheel.setPower(frontLeftPower);
                Robot.rearLeftWheel.setPower(rearLeftPower);
                Robot.frontRightWheel.setPower(frontRightPower);
                Robot.rearRightWheel.setPower(rearRightPower);
            }

            /*if(gamepad1.a){
                Robot.leftElevator.setTargetPosition(1000);
                Robot.rightElevator.setTargetPosition(1000);
                Robot.leftElevator.setPower(1);
                Robot.rightElevator.setPower(1);
                Robot.leftElevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                Robot.rightElevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }*/

            if(lt!=0){
                Robot.leftElevator.setPower(lt);
                Robot.rightElevator.setPower(lt);
            }

            telemetry.addData("ticks elevator: ", Robot.leftElevator.getCurrentPosition());
            telemetry.addData("ticks elevator: ", Robot.rightElevator.getCurrentPosition());
            telemetry.update();
        }
    }
}

