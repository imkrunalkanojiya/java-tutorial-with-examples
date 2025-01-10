# Lab Exercise Examples

## Parameterized Constructor Example

```java
class Robot {
    String name;
    int powerLevel;

    // Parameterized constructor
    Robot(String robotName, int power) {
        name = robotName;
        powerLevel = power;
    }

    void display() {
        System.out.println(name + " has power level: " + powerLevel);
    }
}

public class RobotFactory {
    public static void main(String[] args) {
        Robot roboX = new Robot("RoboX", 90);  // Parameterized constructor
        roboX.display();  // Output: RoboX has power level: 90
    }
}
```

---

## Constructor Overloading Example

```java
class Robot {
    String name;
    int powerLevel;

    // Default constructor
    Robot() {
        name = "Unnamed Robot";
        powerLevel = 50;
    }

    // Constructor with only name
    Robot(String robotName) {
        name = robotName;
        powerLevel = 50;
    }

    // Constructor with name and power level
    Robot(String robotName, int power) {
        name = robotName;
        powerLevel = power;
    }

    void display() {
        System.out.println(name + " has power level: " + powerLevel);
    }
}

public class RobotFactory {
    public static void main(String[] args) {
        Robot defaultRobot = new Robot();  // Default constructor
        Robot namedRobot = new Robot("FastBot");  // Constructor with name
        Robot customizedRobot = new Robot("MegaBot", 100);  // Constructor with name and power

        defaultRobot.display();  // Output: Unnamed Robot has power level: 50
        namedRobot.display();    // Output: FastBot has power level: 50
        customizedRobot.display();  // Output: MegaBot has power level: 100
    }
}
```

---

## Summary

In this Robot Factory analogy, constructors are the assembly process that creates and customizes robots with specific instructions, while overloading allows flexibility to build robots in different ways. The factory ensures robots are recycled when they’re no longer needed, using garbage collection to handle destruction automatically.

Enjoy building your robot army!