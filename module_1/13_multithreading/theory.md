# It’s Time to Double the Fun—Multiple Threads at Once!

Multithreading is like juggling multiple tasks at the same time. Instead of waiting for one task to complete, Java allows you to run several tasks in parallel using threads. Whether you’re cooking multiple dishes simultaneously or managing multiple user requests, multithreading is your go-to tool in Java!

---

## Introduction to Threads – Your Multiple Worker Bees! 🐝

A **thread** is a lightweight process that runs independently from other threads but shares the same memory. Think of threads like worker bees that can buzz around and work on different tasks simultaneously.

In Java, threads are represented by the `Thread` class, and we can create threads in two main ways:

- Extending the Thread Class
- Implementing the Runnable Interface

---

## Creating Threads – Two Ways to Do It!

### 1. Extending the Thread Class

When you extend the Thread class, you override its run() method to define the code that runs in the thread.

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();  // Creating a thread
        t1.start();  // Starting the thread
    }
}
```

### 2. Implementing the Runnable Interface

When you implement the Runnable interface, you pass the Runnable object to a Thread constructor, and then call start() on the thread.

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable thread is running: " + Thread.currentThread().getName());
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable);  // Creating a thread with Runnable
        t1.start();  // Starting the thread
    }
}
```

---

## Thread Life Cycle – From Birth to Termination!

A thread goes through various stages in its life cycle:

- **New**: The thread is created but not yet started.
- **Runnable**: The thread is ready to run but waiting for CPU time.
- **Running**: The thread is actively running.
- **Blocked**: The thread is waiting for a resource (like I/O or another thread).
- **Terminated**: The thread has completed its task.

---

## Synchronization – Keeping Things in Order!

When multiple threads share resources (like variables or objects), there’s a risk of data inconsistency. Thread synchronization ensures that only one thread can access a shared resource at a time. This is critical for avoiding thread interference.

### **Synchronized Methods**

A synchronized method ensures that only one thread can access it at a time.

```java
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class SyncExample {
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

### **Synchronized Blocks**

Instead of synchronizing an entire method, you can also synchronize a block of code for finer control.

```java
class SyncBlockExample {
    private final Object lock = new Object();
    private int counter = 0;

    public void increment() {
        synchronized (lock) {
            counter++;
        }
    }

    public int getCounter() {
        return counter;
    }
}
```

---

## Inter-Thread Communication – Threads Talking to Each Other!

Java provides methods like `wait()`, `notify()`, and `notifyAll()` for threads to communicate with each other, typically when working with shared resources.

`wait()`, `notify()`, and `notifyAll()`
- `wait()`: Makes the current thread wait until another thread calls `notify()` or `notifyAll()`.
- `notify()`: Wakes up one waiting thread.
- `notifyAll()`: Wakes up all waiting threads.

```java
class SharedResource {
    private int data = 0;
    private boolean produced = false;

    public synchronized void produce() throws InterruptedException {
        while (produced) {
            wait();
        }
        data++;
        System.out.println("Produced: " + data);
        produced = true;
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (!produced) {
            wait();
        }
        System.out.println("Consumed: " + data);
        produced = false;
        notify();
    }
}

public class InterThreadCommExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    resource.produce();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    resource.consume();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
```