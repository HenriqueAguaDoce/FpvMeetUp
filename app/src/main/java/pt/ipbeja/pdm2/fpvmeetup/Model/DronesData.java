package pt.ipbeja.pdm2.fpvmeetup.Model;

import pt.ipbeja.pdm2.fpvmeetup.R;

/**
 * Created by HenriqueAD on 14/01/2017.
 */

public class DronesData {

    public static String[] Parts = {
            "Drone",
            "Frame",
            "Flight Controller",
            "ESC",
            "Motors",
            "PCB",
            "Power Distribution Board",
            "Propellers",
            "FPV",
            "Transmitter",
            "Li-Po"
    };

    public static String[] Description = {
            "Synonymous with the term 'quadcopter' or 'UAV'. The term “drone” is generally reserved for unmanned aerial vehicles " +
                    "designed for military use. ",
            "A drone’s frame is synonymous with a human being’s skeleton – it helps bring together important components, " +
                    "as well as provide protection.",
            "The flight control board is the 'brain' of the quadcopter. It houses the sensors such as gyroscopes and accelerometers " +
                    "that determine how fast each of the quadcopter’s motors spin. Flight control boards range from simple to highly complex.",
            "Stands for 'Electronic Speed Controller', which is something that connects to the flight controller, motor, and battery, " +
                    "and helps mediate the speed by which the motors are rotating (you’ll learn a lot about these later on).",
            "The motors is the part of the drone that rotates the propellers. Larger UAVs typically use 'brushless' motors " +
                    "while smaller UAVs typically use 'brushed' motors (you’ll learn about the differences between the two later on).",
            "Stands for 'Printed Circuit Board'. This is a flat fiberglass part that has many different components soldered to it. ",
            "In order to power the different parts of an RC quadcopter, batter power must be shared, or 'split', " +
                    "to all those different devices. This is done with the help of a power distribution board. " +
                    "It takes the single negative and positive terminal from the drone’s battery and provides numerous other terminals " +
                    "(or connection points) throughout the drone so that other devices can receive power.",
            "A quadcopter has four propellers, two 'normal' propellers that spin counter-clockwise, and two 'pusher' " +
                    "propellers that spin clockwise. The pusher propellers will usually be labeled with an ‘R’ after the size. ",
            "Stands for 'First Person View'. This is when you’re able to see a live video feed of what you’re drone’s camera is seeing while it’s recording. ",
            "Radio control (often abbreviated to R/C or simply RC) is the use of radio signals to remotely control a device. " +
                    "Radio control is used for control of model vehicles from a hand-held radio transmitter. Industrial, military, " +
                    "and scientific research organizations make use of radio-controlled vehicles as well. ",
            "Stands for “Lithium Polymer”, which is pretty much the universal battery type used to power RC drones. " +
                    "The reason why is because they’re lightweight (they won’t weigh the drone down) and are capable of releasing a lot of current. "
    };

    public static Integer[] photos = {
        R.drawable.droneimg, R.drawable.frame, R.drawable.flightcontroller, R.drawable.esc, R.drawable.motor, R.drawable.pcb,
            R.drawable.pdb, R.drawable.props, R.drawable.fpvpack, R.drawable.transmitter , R.drawable.batteries
    };
}
