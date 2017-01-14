package pt.ipbeja.pdm2.fpvmeetup.Model;

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
            "Power Distribution",
            "Propellers (PROPS)",
            "FPV",
            "Transmitter",
            "Li-Po"
    };

    public static String[] Description = {
            "Drone\n\nSynonymous with the term 'quadcopter' or 'UAV'. The term “drone” is generally reserved for unmanned aerial vehicles " +
                    "designed for military use. ",
            "Frame\n\nA drone’s frame is synonymous with a human being’s skeleton – it helps bring together important components, " +
                    "as well as provide protection.",
            "Flight Controller\n\nThe flight control board is the 'brain' of the quadcopter. It houses the sensors such as gyroscopes and accelerometers " +
                    "that determine how fast each of the quadcopter’s motors spin. Flight control boards range from simple to highly complex.",
            "ESC\n\nStands for 'Electronic Speed Controller', which is something that connects to the flight controller, motor, and battery, " +
                    "and helps mediate the speed by which the motors are rotating (you’ll learn a lot about these later on).",
            "Motors\n\nThe motors is the part of the drone that rotates the propellers. Larger UAVs typically use 'brushless' motors " +
                    "while smaller UAVs typically use 'brushed' motors (you’ll learn about the differences between the two later on).",
            "PCB\n\nStands for 'Printed Circuit Board'. This is a flat fiberglass part that has many different components soldered to it. ",
            "Power Distribution\n\nIn order to power the different parts of an RC quadcopter, batter power must be shared, or 'split', " +
                    "to all those different devices. This is done with the help of a power distribution board. " +
                    "It takes the single negative and positive terminal from the drone’s battery and provides numerous other terminals " +
                    "(or connection points) throughout the drone so that other devices can receive power.",
            "Propellers (PROPS)\n\nA quadcopter has four propellers, two 'normal' propellers that spin counter-clockwise, and two 'pusher' " +
                    "propellers that spin clockwise. The pusher propellers will usually be labeled with an ‘R’ after the size. ",
            "FPV\n\nStands for 'First Person View'. This is when you’re able to see a live video feed of what you’re drone’s camera is seeing while it’s recording. ",
            "Transmitter\n\nRadio control (often abbreviated to R/C or simply RC) is the use of radio signals to remotely control a device. " +
                    "Radio control is used for control of model vehicles from a hand-held radio transmitter. Industrial, military, " +
                    "and scientific research organizations make use of radio-controlled vehicles as well. ",
            "Li-Po\n\nStands for “Lithium Polymer”, which is pretty much the universal battery type used to power RC drones. " +
                    "The reason why is because they’re lightweight (they won’t weigh the drone down) and are capable of releasing a lot of current. "
    };
}
