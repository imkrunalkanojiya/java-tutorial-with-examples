# Lab Time

## Write a program that demonstrates the use of an ArrayList and LinkedList.

```java
import java.util.ArrayList;
import java.util.LinkedList;

public class ListLab {
    public static void main(String[] args) {
        // ArrayList example
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Tomato");
        arrayList.add("Potato");
        arrayList.add("Cucumber");
        System.out.println("ArrayList Elements: " + arrayList);

        // LinkedList example
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Lion");
        linkedList.add("Tiger");
        linkedList.add("Leopard");
        System.out.println("LinkedList Elements: " + linkedList);
    }
}
```

---

## Implement a program using HashSet to remove duplicate elements from a list.

```java
import java.util.HashSet;
import java.util.ArrayList;

public class SetLab {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");  // Duplicate

        // Remove duplicates using HashSet
        HashSet<String> set = new HashSet<>(list);
        System.out.println("Original List: " + list);
        System.out.println("Set with Duplicates Removed: " + set);
    }
}
```

---

## Write a program that demonstrates the use of a HashMap to store and retrieve key-value pairs.

```java
import java.util.HashMap;

public class MapLab {
    public static void main(String[] args) {
        HashMap<String, Integer> productPrices = new HashMap<>();
        productPrices.put("Laptop", 1200);
        productPrices.put("Phone", 800);
        productPrices.put("Tablet", 600);

        // Retrieve and display prices
        System.out.println("Price of Laptop: $" + productPrices.get("Laptop"));
        System.out.println("Price of Phone: $" + productPrices.get("Phone"));
        System.out.println("Price of Tablet: $" + productPrices.get("Tablet"));
    }
}
```

---

Java’s Collections Framework is a treasure trove of tools that simplify the management of groups of objects. Whether you're working with dynamic lists, ensuring unique elements in sets, or mapping data using key-value pairs, the framework offers flexible and efficient data handling mechanisms. So dive in and make your data dance!