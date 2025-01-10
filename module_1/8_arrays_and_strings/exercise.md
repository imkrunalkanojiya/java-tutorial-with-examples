# Lab Exercises

## 1. Matrix Addition and Subtraction (2D Arrays for Beat Mixing)

Imagine your DJ app has a matrix of soundwaves, and you want to mix two soundwave tracks together (addition) or subtract some effects (subtraction).

```java
public class SoundMatrix {
    public static void main(String[] args) {
        int[][] sound1 = { 
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9}
        };
        
        int[][] sound2 = { 
            {9, 8, 7}, 
            {6, 5, 4}, 
            {3, 2, 1}
        };

        int[][] addition = new int[3][3];
        int[][] subtraction = new int[3][3];

        // Adding and subtracting the sound matrices
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                addition[i][j] = sound1[i][j] + sound2[i][j];
                subtraction[i][j] = sound1[i][j] - sound2[i][j];
            }
        }

        System.out.println("Mixed Sound (Addition):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(addition[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nSubtracted Sound (Subtraction):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(subtraction[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

---

## 2. String Reversal and Palindrome Checker (Reverse Tracks & Hidden Patterns)

What if you could play a track backward and see if it still has a secret pattern (a palindrome)?

```java
import java.util.Scanner;

public class DJStringMix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input track name
        System.out.print("Enter a track name: ");
        String track = sc.nextLine();

        // Reverse the track name
        String reversedTrack = new StringBuilder(track).reverse().toString();
        System.out.println("Reversed track: " + reversedTrack);

        // Check if it's a palindrome (same backward and forward)
        if (track.equalsIgnoreCase(reversedTrack)) {
            System.out.println("This track is a **PALINDROME**! 🔥");
        } else {
            System.out.println("This track is NOT a palindrome.");
        }
    }
}
```

---

## 3. String Comparison using `equals()` and `compareTo()` (Track Comparison)

Let’s compare two track names to see if they are the same or which comes first alphabetically (because every DJ set has to be sorted!).

```java
public class TrackComparison {
    public static void main(String[] args) {
        String track1 = "Summer Vibes";
        String track2 = "Night Party";
        
        // Comparing track names using equals()
        if (track1.equals(track2)) {
            System.out.println("The tracks are identical!");
        } else {
            System.out.println("The tracks are different.");
        }

        // Comparing track names using compareTo()
        int result = track1.compareTo(track2);
        if (result < 0) {
            System.out.println(track1 + " comes before " + track2);
        } else if (result > 0) {
            System.out.println(track1 + " comes after " + track2);
        } else {
            System.out.println("The tracks are the same!");
        }
    }
}
```

---

## Conclusion

In our DJ Music Mixer App, arrays are our soundwave mixing boards, and strings are our track names that we remix, reverse, and compare. Whether it's mixing sound matrices, checking for hidden patterns in track names, or comparing beats, the DJ in you can now groove with Java's Arrays and Strings! 🎧🔥

