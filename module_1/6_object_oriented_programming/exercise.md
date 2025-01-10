# OOPs Exercise

## Single Inheritance Example

```java
class Hero {
    String name = "Generic Hero";
    void display() {
        System.out.println("I am a superhero!");
    }
}

class FlyingHero extends Hero {
    void fly() {
        System.out.println(name + " is flying!");
    }
}

public class Academy {
    public static void main(String[] args) {
        FlyingHero ironMan = new FlyingHero();
        ironMan.display();  // Inherited from Hero
        ironMan.fly();      // FlyingHero's own method
    }
}
```

---

## Multilevel Inheritance Example

```java
class Hero {
    String name = "Generic Hero";
}

class FlyingHero extends Hero {
    void fly() {
        System.out.println(name + " is flying!");
    }
}

class SuperFlyingHero extends FlyingHero {
    void shootLaser() {
        System.out.println(name + " is shooting lasers!");
    }
}

public class Academy {
    public static void main(String[] args) {
        SuperFlyingHero superman = new SuperFlyingHero();
        superman.fly();      // Inherited from FlyingHero
        superman.shootLaser(); // SuperFlyingHero's own method
    }
}
```

---

## Polymorphism (Method Overriding) Example

```java
class Hero {
    void fight() {
        System.out.println("Fighting with basic punches!");
    }
}

class FlyingHero extends Hero {
    @Override
    void fight() {
        System.out.println("Fighting with aerial kicks!");
    }
}

class Speedster extends Hero {
    @Override
    void fight() {
        System.out.println("Fighting with super speed!");
    }
}

public class Academy {
    public static void main(String[] args) {
        Hero genericHero = new Hero();
        Hero flyingHero = new FlyingHero();
        Hero speedster = new Speedster();
        
        genericHero.fight();  // Output: Fighting with basic punches!
        flyingHero.fight();   // Output: Fighting with aerial kicks!
        speedster.fight();    // Output: Fighting with super speed!
    }
}
```

---

In these examples, we’ve explored the OOP concepts of encapsulation, inheritance, polymorphism, and abstraction—all while running a superhero training academy. Each hero uses inheritance and method overriding to show their unique powers!