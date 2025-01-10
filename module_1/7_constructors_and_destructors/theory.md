# Constructors and Destructors (Right & Left Brothers)

## 1. Constructor Types

Think of a constructor as the assembly process that puts your robot together the moment you create it! It’s a special method that initializes the robot’s parts, giving it life.

### Default Constructor

- This is like the factory making a basic robot with default settings. No special instructions are provided, so it just builds the most basic version of the robot.

- **Example**: You create a robot, and it has default arms, legs, and power settings (i.e., no fancy gadgets).

```java
class Robot {
    String name;
    int powerLevel;

    // Default constructor
    Robot() {
        name = "Generic Robot";
        powerLevel = 50;
        System.out.println("A default robot is created!");
    }
}
```

### Parameterized Constructor

- Now, imagine you want a custom-built robot—with special arms, legs, and advanced gadgets. You tell the factory exactly what you want by passing parameters to the constructor!

- **Example**: You want a robot named "RoboMax" with 100% power, so you give those details while creating the robot.

```java
class Robot {
    String name;
    int powerLevel;

    // Parameterized constructor
    Robot(String robotName, int power) {
        name = robotName;
        powerLevel = power;
        System.out.println(name + " is created with power level: " + powerLevel);
    }
}
```

---

## 2. Copy Constructor (Emulated in Java)

Imagine you have a robot, and now you want another robot just like it! Instead of going through the factory process again, you clone the robot. Java doesn't have a direct copy constructor like C++, but you can simulate it using a constructor that copies attributes from one object to another.

- **Example**: You’ve already got a robot called "RoboMax," and now you want to make "RoboClone."

```java
class Robot {
    String name;
    int powerLevel;

    // Parameterized constructor
    Robot(String robotName, int power) {
        name = robotName;
        powerLevel = power;
    }

    // Copy constructor emulation
    Robot(Robot originalRobot) {
        this.name = originalRobot.name;
        this.powerLevel = originalRobot.powerLevel;
        System.out.println("Cloning " + name + " with power level: " + powerLevel);
    }
}

public class RobotFactory {
    public static void main(String[] args) {
        Robot roboMax = new Robot("RoboMax", 100);
        Robot roboClone = new Robot(roboMax);  // Creating a copy of roboMax
    }
}
```

---

## 3. Constructor Overloading

Think of this as the factory being super flexible. You can provide different sets of instructions (i.e., parameters), and it knows exactly how to build the robot based on what you supply. This means you can overload constructors with different parameter types and counts.

- **Example**: You want to make different robots—one with a name only, another with both a name and power level, and maybe one without any specifications at all.

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
        powerLevel = 50;  // Default power level
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
        Robot genericRobot = new Robot();  // Default constructor
        Robot namedRobot = new Robot("SpeedyBot");  // Constructor with name
        Robot customizedRobot = new Robot("MegaBot", 100);  // Constructor with name and power level

        genericRobot.display();
        namedRobot.display();
        customizedRobot.display();
    }
}
```

---

## 4. Object Life Cycle and Garbage Collection

Now let’s talk about how robots live and die in the factory.

- **Object Life Cycle**:
  - When you create a robot (instantiate a class), it goes through a birth (i.e., constructor).
  - The robot lives its life in your program, doing tasks (calling methods).
  - Once it’s done and you don’t need the robot anymore, it should be recycled to free up space in the factory. This is handled by garbage collection in Java.

- **Garbage Collection**:
  - Robots don't hang around forever. The factory (Java's Garbage Collector) will clean up unused robots (objects) when they're no longer needed. You don’t have to worry about manually destroying objects, as Java takes care of that for you, unlike C++.

  ---

## 5. Bonus Concept: Destructor (No Explicit Destructor in Java)

Java doesn't have destructors like C++ because garbage collection automatically handles the destruction of objects when they're no longer referenced. However, you can override the `finalize()` method to execute some code before the object is destroyed, but it’s rarely used.