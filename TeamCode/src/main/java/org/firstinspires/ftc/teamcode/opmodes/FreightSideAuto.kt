package org.firstinspires.ftc.teamcode.opmodes

import com.amarcolini.joos.command.RobotOpMode
import com.amarcolini.joos.command.WaitCommand
import com.amarcolini.joos.geometry.Pose2d
import com.amarcolini.joos.util.deg
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import org.firstinspires.ftc.teamcode.MainRobot
import org.firstinspires.ftc.teamcode.components.Vision

@Autonomous(name = "Freight Side", group = "Auto")
class FreightSideAuto : RobotOpMode<MainRobot>() {
    private lateinit var vision: Vision


    override fun preInit() {
        initialize<MainRobot>()

//        robot.schedule(robot.arm.tipper.setPosition(0.0))
//        vision = Vision(hardwareMap)
    }

    override fun preStart() {
        // TODO figure out timing here. Do we do with math? Do we hardcode cycles?

//        val intakeCommand = robot.arm.intake.intake()
//        for (i in 0..5) {
//            val (loc, coord) = vision.getPosition()
//
//            val level = loc.toLevel()
//            RobotTelemetry.addLine("Height: $level")
//            RobotTelemetry.addLine("Coord: $coord")
//        }

//        val dropCommand =
//            SequentialCommand(
//                true,
//                robot.arm.goToPosition(level),
//                robot.arm.tipper.setPosition(Tipper.TipperPosition.TIPPED),
//                WaitCommand(0.5),
//                robot.arm.tipper.setPosition(Tipper.TipperPosition.SECOND_TILT),
//                robot.arm.goToPosition(Arm.Position.FLOOR)
//            )
//
//        val hubPoint = Pose2d(-10.90, 40.50, (-90).deg)
//        val startPoint = Pose2d(13.0, 65.0, (-90).deg)
//        val depotPoint = Pose2d(47.0, 63.87, (-180).deg)
//
//        robot.drive.localizer.poseEstimate = startPoint
//
//        val initToHub = robot.drive.trajectoryBuilder(startPoint, (-137).deg)
//            .splineToLinearHeading(hubPoint, (-122).deg)
//            .build()
//
//        val toDepot = robot.drive.trajectoryBuilder(hubPoint, 93.deg)
//            .splineToLinearHeading(Pose2d(-6.11, 63.62, (-180).deg), 14.deg)
//            .splineToLinearHeading(depotPoint, 356.deg)
//            .build()
//
//        val toHub = robot.drive.trajectoryBuilder(depotPoint, 356.deg)
//            .splineToLinearHeading(Pose2d(-6.11, 63.62, (-180).deg), 14.deg)
//            .splineToLinearHeading(hubPoint, (-122).deg)
//            .build()
//
//        // create a command that goes to the depot and then to hub and then repeats until there are 5 seconds left
//        val auto = SequentialCommand(
//            true,
//            robot.drive.followTrajectory(initToHub),
//            dropCommand,
//            robot.drive.followTrajectory(toDepot),
//            intakeCommand,
//            robot.drive.followTrajectory(toHub),
//            dropCommand,
//            robot.drive.followTrajectory(toDepot)
//        )
//
//        robot.schedule(auto)

        val firstLeg = WaitCommand(2.0).onExecute {
            robot.drive.setDrivePower(robot.gyroNormalize(Pose2d(1.0, 0.0, 0.deg)))
        }.onEnd { robot.drive.setDrivePower(Pose2d(0.0, 0.0, 0.deg)) }

        robot.schedule(firstLeg)
    }
}