package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class robotMap {
    public static DcMotor frontLeftWheel = null;
    public static DcMotor rearLeftWheel = null;
    public static DcMotor frontRightWheel = null;
    public static DcMotor rearRightWheel = null;
    public static DcMotor leftElevator = null;
    public static DcMotor rightElevator = null;

    public static Servo leftRotate = null;
    public static Servo rightRotate = null;

    public robotMap(HardwareMap Init){
        frontLeftWheel = Init.get(DcMotor.class, "frontLeftWheel");
        rearLeftWheel = Init.get(DcMotor.class, "rearLeftWheel");
        frontRightWheel = Init.get(DcMotor.class, "frontRightWheel");
        rearRightWheel = Init.get(DcMotor.class, "rearRightWheel");
        leftElevator = Init.get(DcMotor.class, "leftElevator");
        rightElevator = Init.get(DcMotor.class, "rightElevator");

        leftRotate = Init.get(Servo.class, "leftRotate");
        rightRotate = Init.get(Servo.class, "rightRotate");

        frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        rearRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        rightElevator.setDirection(DcMotorSimple.Direction.REVERSE);

        leftElevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftElevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftElevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        rightElevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightElevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightElevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
