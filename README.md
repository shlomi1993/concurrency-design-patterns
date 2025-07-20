# Concurrency Design Patterns

This repository contains basic implementations of Concurrency Design Patterns -- Design Patterns that solves problems arises when programming a multi-threaded or asynchronous prorams.

## The Design Pattrns and Other Solutions:

1. <b>AtomicVariables</b> - Actually this is not a design pattern but a solution that allows to deal with race condition problems. Atomic variables are Java variables that every action on them is atomic and therefore cannot be divided into different threads.

2. <b>Double-Check-Locking</b> - Creating a pure singleton in a multi-threaded program.

3. <b>ForkJoinPool</b> - A kind of thread pool that is useful for recursive calculations in a multi-threaded program.

4. <b>GuardedSuspension</b> - A design that ensures that a certain action will be performed only after performing another action, for example, perform "victory dance" only after "victory".

5. <b>ReentrentLock</b> -  Actually this is not a design pattern but a useful Java solution for non-blocking locks. ReentrantLock allows threads to enter into the lock on a resource more than once. to read more go to: https://www.geeksforgeeks.org/reentrant-lock-java/

6. <b>ThreadSafeContainers</b> - Java containers that wraps a Java Data-Structure to make it useful in a multi-threaded program.

7. <b>Timer</b> - A useful Java tool to synchronize operations between differenct threads ("Ping-Pong" example).

8. <b>Completable Future</b> - read here: https://www.javatpoint.com/completablefuture-in-java


## IDE and Tools

1. JetBrains IntelliJ IDEA
2. Notepad++.
