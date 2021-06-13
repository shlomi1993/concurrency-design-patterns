import java.util.function.Consumer;
import java.util.function.Function;

public class CFuture<V> {

    V value;
    Runnable r;

    public static <V> CFuture<V> supplyAsync(Callable<V> c) {
        CFuture<V> cf = new CFuture<>();
        new Thread(()->cf.set(c.call())).start();
        return cf;
    }

    private void set(V v) {
        if (value != v) value = v;
        r.run();
    }

    public <R> CFuture<R> thenApply(Function<V, R> function) {
        CFuture<R> cfr = new CFuture<>();
        r = ()->cfr.set(function.apply(value));
        return cfr;
    }

    public void thenAccept(Consumer<V> c) {
        r = ()->c.accept(value);    // Only define it at the moment, not necessarily run it.
    }

}