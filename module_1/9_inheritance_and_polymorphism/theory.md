# Inheritance and Polymorphism: The Family Reunion of Objects!

## 🎬 Scene 1: Inheritance – The Family Tree

Inheritance is like passing down family traits from parent to child. You inherit your mom's eyes and your dad's sense of humor, and in Java, a class (child) inherits properties and behaviors (methods) from another class (parent). It’s how we keep our code DRY (Don’t Repeat Yourself) and maintain that sweet flow of efficiency.

---

## Inheritance Types & Benefits – The Family Legacy

### **1. Single Inheritance** – Like a Single-Parent Household

- One parent, one child. The child inherits everything from one parent class, keeping things simple and direct.

```java
class Parent {
    void show() {
        System.out.println("I am the parent!");
    }
}

class Child extends Parent {
    // Child inherits everything from Parent
}
```

### **2. Multilevel Inheritance** – Generation to Generation

- This is like a grandparent passing down traits to a parent, and the parent passing them down to the child. It’s like that legendary recipe in your family!

```java
class Grandparent {
    void show() {
        System.out.println("I am the grandparent!");
    }
}

class Parent extends Grandparent {
    void show() {
        System.out.println("I am the parent!");
    }
}

class Child extends Parent {
    void show() {
        System.out.println("I am the child!");
    }
}
```

### **3. Hierarchical Inheritance** – One Parent, Many Kids

- Think of this like siblings sharing the same traits from one parent but adding their own twists.

```java
class Parent {
    void show() {
        System.out.println("I am the parent!");
    }
}

class Child1 extends Parent {
    void show() {
        System.out.println("I am the first child!");
    }
}

class Child2 extends Parent {
    void show() {
        System.out.println("I am the second child!");
    }
}
```

---

## Method Overriding – Same Name, Different Jam!

Let’s say the parent has a method that the child finds a little outdated, so the child says, "Let me remix that!" Method overriding allows the child class to provide its own version of a method that exists in the parent class. It’s like adding modern beats to a classic song.

```java
class Parent {
    void playMusic() {
        System.out.println("Playing classical music!");
    }
}

class Child extends Parent {
    @Override
    void playMusic() {
        System.out.println("Playing rock music!");
    }
}
```

---

## Dynamic Binding (Run-Time Polymorphism) – Surprise Me!

Dynamic binding is like a surprise party. You might invite different guests, but you don’t know who’ll actually show up until the event starts. In Java, this happens at runtime when a method is called based on the object type, not the reference type. In short, Java decides which version of the method (parent or child) to run during execution!

```java
class Parent {
    void playMusic() {
        System.out.println("Playing classical music!");
    }
}

class Child extends Parent {
    @Override
    void playMusic() {
        System.out.println("Playing rock music!");
    }
}

public class Test {
    public static void main(String[] args) {
        Parent obj = new Child();  // Parent reference, but Child object
        obj.playMusic();  // Surprise! Child's playMusic() is called.
    }
}
```

---

## The Super Keyword – Calling in the OG Parent!

Sometimes, the child class wants to borrow something directly from the parent. Whether it’s a method or the constructor itself, the super keyword allows the child class to call the parent’s version of the method or constructor. It’s like asking your parent, “How did you do that again?”

```java
class Parent {
    Parent() {
        System.out.println("Parent constructor called!");
    }

    void playMusic() {
        System.out.println("Playing classical music!");
    }
}

class Child extends Parent {
    Child() {
        super();  // Calls Parent's constructor
        System.out.println("Child constructor called!");
    }

    void playMusic() {
        super.playMusic();  // Calls Parent's playMusic() method
        System.out.println("Child is remixing this track!");
    }
}
```

---

## Method Hiding – Hidden Tracks!

In case of static methods, there’s no overriding. If a child class defines a method with the same signature as the parent’s static method, it doesn’t override the parent method—it hides it. It’s like discovering hidden tracks in your favorite album!

```java
class Parent {
    static void show() {
        System.out.println("Parent's static method");
    }
}

class Child extends Parent {
    static void show() {
        System.out.println("Child's static method");
    }
}
```
