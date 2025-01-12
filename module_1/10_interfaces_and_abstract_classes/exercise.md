# Lab Time 🎛️

## Create an Abstract Class & Implement Its Methods:

```java
abstract class Animal {
    abstract void makeSound();  // Abstract method
    void eat() {  // Concrete method
        System.out.println("This animal is eating.");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("The dog barks!");
    }
}

public class TestAnimal {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();  // Calls the subclass implementation
        dog.eat();        // Calls the concrete method from the abstract class
    }
}
```

---

## Implement Multiple Interfaces in a Single Class:

```java
interface Driver {
    void drive();
}

interface Mechanic {
    void fixCar();
}

class TaxiDriver implements Driver, Mechanic {
    public void drive() {
        System.out.println("Driving the taxi!");
    }

    public void fixCar() {
        System.out.println("Fixing the taxi.");
    }
}

public class TestTaxiDriver {
    public static void main(String[] args) {
        TaxiDriver driver = new TaxiDriver();
        driver.drive();
        driver.fixCar();
    }
}
```

---

## The Big Picture 🎸

Abstract classes give you a halfway-done blueprint, allowing you to provide common functionality while leaving the final touches to subclasses. Interfaces, on the other hand, are like signed contracts—"I promise to do this, but I’ll do it my way!" With interfaces, you can achieve multiple inheritance, allowing classes to play multiple roles.

With these tools, your Java code will be flexible, organized, and ready to scale like a pro!
