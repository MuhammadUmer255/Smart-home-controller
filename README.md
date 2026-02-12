# Smart Home Controller

The Smart Home Controller is a Java-based desktop application developed using Object-Oriented Programming (OOP) principles and Java Swing GUI. This project simulates a smart home environment where users can add, control, and manage different smart devices such as Lights and Thermostats through an interactive graphical interface.

# Features

Add and remove smart devices dynamically

Control device states (ON/OFF)

Adjust brightness for lights (0–100%)

Set temperature for thermostats (15°C–30°C)

Real-time status updates in the GUI

Simple and user-friendly interface

# OOP Concepts Implemented

This project strongly demonstrates core OOP principles:

Encapsulation – Device attributes are private and accessed through getters and setters.

Inheritance – Light and Thermostat inherit from the abstract SmartDevice class.

Abstraction – SmartDevice defines a common blueprint and enforces implementation of getStatus().

Polymorphism – All devices are handled using the SmartDevice reference type.

# Class Structure

1️ SmartDevice (Abstract Class)

Attributes: name, isOn

Methods: toggle(), getStatus()

2️ Light (Extends SmartDevice)

Attribute: brightness

Methods: getBrightness(), setBrightness(), getStatus()

3️ Thermostat (Extends SmartDevice)

Attribute: temperature

Methods: getTemperature(), setTemperature(), getStatus()

4️ SmartHomeController (Main Class)

Manages GUI components

Handles device addition, removal, and control

Maintains device list using ArrayList

# Technologies Used

Java

Java Swing (GUI)

OOP Design Principles

# How to Run

Open the project in any Java IDE (e.g., IntelliJ, Eclipse, NetBeans).

Run the SmartHomeController class.

Use the GUI to add and manage devices.

# Future Enhancements

Save & load device states

Add more smart devices (Fan, AC, Security Camera)

Improve UI design

Database integration
