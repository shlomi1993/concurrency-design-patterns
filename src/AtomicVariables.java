import java.util.concurrent.atomic.AtomicInteger;

class Count {
    AtomicInteger count = new AtomicInteger(0);
    public void setCount(int x) { count.set(x); }
    public int getCount() { return count.get(); }
    public void update() { count.incrementAndGet(); } // ++count
}

class CountUpdater implements Runnable {
    Count c;
    public CountUpdater(Count c) { this.c = c; }
    public void run() {
        for (int i=0;i<100000000; c.update(),i++);
    }
}

class AtomicVariables {
    public static void main(String[] args) throws InterruptedException {
        Count c=new Count();
        c.setCount(0);
        CountUpdater ca=new CountUpdater(c);
        Thread t=new Thread(ca);
        Thread t1=new Thread(ca);
        long time=System.currentTimeMillis();
        t.start();
        t1.start();
        t.join();
        t1.join();
        System.out.println(c.getCount());
        long duration=(System.currentTimeMillis()-time)/1000;
        System.out.println(duration);
    }
}