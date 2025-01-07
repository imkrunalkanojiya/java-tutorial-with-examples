# Control Flow Statements: The Map to Navigate Your Code

Control flow statements are like the **GPS** of your program. They decide where your code will go next based on conditions, loops, and switches! 🚗💨

---

## If-Else Statements: Java’s Decision Maker

The **if-else** statement is Java’s way of asking **“What’s next?”** and deciding which path to take based on some condition.
- **If statement** : It checks if something is **true** and executes a block of code if it is.
- **Else statement** : If the **if condition** is **false**, the **else** block will execute.

Think of it like a game where you **choose your own adventure**:

```java
int age = 20;

if (age >= 18) {
    System.out.println("You’re an adult!");
} else {
    System.out.println("You’re a minor.");
}
```

If `age` is 18 or more, you'll get "You’re an adult!". Otherwise, it says, "You’re a minor." 🤔

---

## Switch-Case Statements: The Menu of Options

When you have **multiple choices** and want to select between them, the **switch-case** is the perfect tool. It’s like flipping through a **menu** and choosing what to do next based on your selection.

```java
int day = 3;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    default:
        System.out.println("Weekend");
}
```

Here, the `switch` statement checks the value of `day`. Since `day` is 3, it prints "Wednesday". If there’s no match, it goes to the `default` case.

---

## Loops: Repeat After Me!

Loops are like your infinite playlist. You want to keep playing the same song over and over until you decide to stop!

### For Loop: The All-Star Repeater 🔁
This loop is your counting buddy. You specify how many times you want to repeat an action.

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);  // Will print 1, 2, 3, 4, 5
}
```

You start with `i = 1`, and keep incrementing `i` until it hits 5. Once `i` reaches 6, the loop stops.

### While Loop: The "While It’s True" Loop 🕺
This loop keeps dancing until the `condition is false`. It keeps going as long as something is true.

```java
int i = 1;
while (i <= 5) {
    System.out.println(i);  // Will print 1, 2, 3, 4, 5
    i++;
}
```

As long as `i` is 5 or less, it keeps running! Once `i` is 6, the loop stops.

### Do-While Loop: The "I’ll Run at Least Once" Loop 🎉
This loop `always runs` at least once before checking the condition. It’s like a `party` that starts before anyone can even think of leaving!

```java
int i = 1;
do {
    System.out.println(i);  // Will print 1, 2, 3, 4, 5
    i++;
} while (i <= 5);
```

---

## Break and Continue Keywords: The Party Mood Changers

**1. Break** : Stops the loop or switch-case right away. It’s like hitting the pause button and exiting.
```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break;  // Stop the loop when i is 5
    }
    System.out.println(i);  // Prints 1, 2, 3, 4
}
```

**2. Continue** : Skips the current iteration and jumps to the next one. It’s like skipping a song in your playlist.
```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue;  // Skip when i is 3
    }
    System.out.println(i);  // Prints 1, 2, 4, 5
}
```
