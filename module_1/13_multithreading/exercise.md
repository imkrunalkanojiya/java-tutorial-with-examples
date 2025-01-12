# Lab Time

## Write a program that creates and runs multiple threads using the Thread class.

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is running");
    }
}

public class MultipleThreadsExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        
        t1.start();
        t2.start();
        t3.start();
    }
}
```

---

## Write a program to demonstrate thread synchronization using a synchronized block.

```java
class Counter {
    private int count = 0;

    public void increment() {
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}

public class SyncBlockExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.getCount());
    }
}
```

---

## Write a program to demonstrate inter-thread communication using `wait()`, `notify()`, and `notifyAll()`.

```java
class Buffer {
    private int value = 0;
    private boolean hasValue = false;

    public synchronized void produce(int newValue) throws InterruptedException {
        while (hasValue) {
            wait();
        }
        value = newValue;
        hasValue = true;
        System.out.println("Produced: " + value);
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while (!hasValue) {
            wait();
        }
        System.out.println("Consumed: " + value);
        hasValue = false;
        notifyAll();
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    buffer.produce(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    buffer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
```

---

Multithreading allows you to perform multiple tasks simultaneously, making your applications more efficient and responsive. With tools like synchronization and inter-thread communication, you can control how threads interact with each other, preventing chaos in your code.