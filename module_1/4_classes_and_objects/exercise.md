# Lab Exercise: Time to Get Your Hands Dirty with Code!

## Student Class (Attributes + Method):

Let’s create a class called Student! It will have two cool attributes: `name` and `age`. Plus, write a method that shows off these details like a student introducing themselves at the first day of school 📚.

```java
class Student {
    // Attributes
    String name;
    int age;

    // Method to display student details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        // Create a Student object
        Student student1 = new Student();

        // Set attributes
        student1.name = "Alice";
        student1.age = 20;

        // Display details
        student1.displayDetails();
    }
}
```

### Explanation
- The class `Student` has two attributes: `name` and `age`.
- The method `displayDetails()` prints the values of these attributes.
- A `Student` object is created, its attributes are set, and the details are displayed.

---

## Constructor Overloading:

Give your class multiple constructors like a Swiss army knife! One constructor might take both a name and age, while another might only take the name, setting a default age. Flex that overloading power 💪!

```java
class Student {
    String name;
    int age;

    // Constructor with two parameters
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overloaded constructor with only one parameter (name)
    Student(String name) {
        this.name = name;
        this.age = 18; // Default age
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        // Creating objects using both constructors
        Student student1 = new Student("Bob", 22);
        Student student2 = new Student("Charlie");

        // Display details
        student1.displayDetails();
        student2.displayDetails();
    }
}
```

### Explanation
- Two constructors are defined: one takes both `name` and `age`, and the other takes only `name` and assigns a default `age`.
- We create two `Student` objects, one with both parameters and one using the overloaded constructor.

---

## Getters & Setters for Encapsulation:

Want to keep things locked down like a pro? Use getters and setters to protect your class’s precious attributes. These are the security guards of your code that allow controlled access to `name` and `age`, ensuring your data stays in tip-top shape! 👮‍♂️

```java
class Student {
    private String name;
    private int age;

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        if(age > 0) {  // Adding a basic validation check
            this.age = age;
        } else {
            System.out.println("Age must be positive!");
        }
    }

    public static void main(String[] args) {
        // Create a Student object
        Student student1 = new Student();

        // Using setters to assign values
        student1.setName("Diana");
        student1.setAge(21);

        // Using getters to retrieve and print values
        System.out.println("Student Name: " + student1.getName());
        System.out.println("Student Age: " + student1.getAge());
    }
}
```

### Explanation
- The `name` and `age` attributes are private to protect them from direct access.
- Getters and setters allow controlled access and modification of the attributes.
- The setter for `age` has a validation check to ensure the age is positive.
