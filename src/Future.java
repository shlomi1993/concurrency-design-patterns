public class Future<V> {

    V value;

    public synchronized void set(V v) {
        if (value != v) {
            value = v;
            notifyAll();
        }
    }

    public V get() {
        if (value == null) {
            synchronized(this) {
                try { if (value == null) wait(); }
                catch (InterruptedException ie) {}
            }
        }
        return value;
    }
}