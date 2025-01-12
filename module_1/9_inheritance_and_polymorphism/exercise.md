# Lab Time 🎛️

Let’s put this theory into action with a simple example that demonstrates inheritance, method overriding, runtime polymorphism, and the use of the `super` keyword.

```java
class Parent {
    // Parent constructor
    Parent() {
        System.out.println("Parent constructor is called.");
    }

    // Method to override
    void display() {
        System.out.println("Display method in Parent");
    }
}

class Child extends Parent {
    // Child constructor
    Child() {
        super();  // Call Parent's constructor
        System.out.println("Child constructor is called.");
    }

    @Override
    void display() {
        super.display();  // Call Parent's display method
        System.out.println("Display method in Child");
    }
}

public class TestInheritance {
    public static void main(String[] args) {
        // Runtime Polymorphism
        Parent obj = new Child();  // Parent reference, Child object
        obj.display();  // Child's display method is called with super involved
    }
}
```

---

## Encore! 🎸

Inheritance and polymorphism give Java the magic to create family legacies and unique talents in child classes. With method overriding and dynamic binding, Java keeps things flexible and surprising. And whenever a child class needs to borrow something from the parent class, `super` is right there to help.

Keep the family groove going—inherit, override, and call on super like a pro!
