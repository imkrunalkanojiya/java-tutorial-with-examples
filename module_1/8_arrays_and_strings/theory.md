# Arrays and Strings with DJ Music Mixer App

## 1. One-Dimensional and Multidimensional Arrays

In our DJ app, think of `one-dimensional` arrays as simple soundtracks (just a line of music beats). On the other hand, `multidimensional` arrays are like more complex sound mixing tables, with rows and columns representing different channels of sound!

- **One-Dimensional Array**: Imagine this array as a single track in a music file.

```java
int[] beats = {1, 2, 3, 4, 5};  // A single line of beats
```

- **Multidimensional Array**: Think of this as a mixing board with multiple tracks playing together!

```java
int[][] soundMatrix = { 
  {1, 0, 1, 1},  // Channel 1
  {0, 1, 0, 1},  // Channel 2
  {1, 1, 0, 0}   // Channel 3
};
```

---

## 2. String Handling in Java: String Class, StringBuffer, StringBuilder

Let’s use String handling to manage the names of our music tracks, DJ sets, and lyrics. We can think of `String` as a static, read-only track, while `StringBuffer` and `StringBuilder` are remixable—letting us dynamically modify the track names or lyrics!

- **String**: This is like a static track name that cannot be changed after creation.

```java
String trackName = "Summer Vibes";
```

- **StringBuffer**: Think of this as a track you're remixing live, where you can change parts of it, like adding beats in between.

```java
StringBuffer remixTrack = new StringBuffer("Summer Vibes");
remixTrack.append(" Remix");  // Adds " Remix" to the original track name
```

- **StringBuilder**: This is also used for remixing, but it’s faster for large mixes. It’s perfect for those **quick DJ edits** while you're performing live.

```java
StringBuilder liveSet = new StringBuilder("Sunset Party");
liveSet.append(" Vol. 2");  // Adds " Vol. 2" to your live set title
```

---

## 3. Array of Objects

Our DJ app needs to handle playlists where each track is an object! We can create an array of tracks (objects) and manage each one as part of our set.

- **Example**: An array of DJ track objects.

```java
class Track {
    String name;
    int duration;  // Duration in seconds
    
    Track(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
}

public class DJMixer {
    public static void main(String[] args) {
        Track[] playlist = { 
            new Track("Summer Vibes", 240), 
            new Track("Beach Party", 300), 
            new Track("Night Lights", 180) 
        };
        
        for (Track track : playlist) {
            System.out.println("Playing track: " + track.name + " | Duration: " + track.duration + "s");
        }
    }
}
```

---

## 4. String Methods

Let’s apply some String methods on our tracks! We'll use `.length()`, `.charAt()`, and `.substring()` to mix and chop track names.

- **Length**: Checking how many characters a track name has.

```java
String track = "Summer Vibes";
System.out.println("Track length: " + track.length());  // Output: 12
```

- **charAt()**: Grabbing individual beats (characters) from the track.

```java
System.out.println("First character: " + track.charAt(0));  // Output: S
```

- **substring()**: Chopping up the track name to make a remix!

```java
String remix = track.substring(0, 6);  // Extracts "Summer"
System.out.println("Remix: " + remix);  // Output: Summer
```