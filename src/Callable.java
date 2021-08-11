interface Callable<V> {
    V call() throws Exception;
}

class Worker { }

class MyCallable implements Callable<Worker> {

    @Override
    public Worker call() throws Exception {
        Thread.sleep(4000);
        return new Worker();
    }
}