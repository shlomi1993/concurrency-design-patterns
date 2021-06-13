public class ThreadPool {

    public void execute(Runnable r) {
        new Thread(r).start();
    }

    public <V> Future<V> submit(Callable<V> c) {
        Future<V> f = new Future<>();
        execute( ()->f.set(c.call()) );
        return f;
    }

}