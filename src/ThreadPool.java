import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

interface Executor {
    void execute(Runnable r);
}

class DirectExecutor implements Executor {
    public void execute(Runnable r) { r.run(); }
}

class ThreadPerTaskExecutor implements Executor {
    public void execute(Runnable r) { new Thread(r).start(); }
}

class PooledThread extends Thread {
    Runnable task;
    Object lock;
    boolean terminated = false;

    public void assignTask(Runnable r) {
        task = r;
//        unSuspendMe();
    }

    public void run() {
        while (!terminated) {
            task.run();
//            suspendMe();
        }
    }
}