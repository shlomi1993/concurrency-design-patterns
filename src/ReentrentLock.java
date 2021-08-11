import java.util.concurrent.locks.ReentrantLock;

public class ReentrentLock implements Runnable {

    ReentrantLock W = new ReentrantLock();
    ReentrantLock R = new ReentrantLock();

    public void run() {
        boolean w = W.tryLock();
        boolean r = R.tryLock();
        try {
            if (w && r){
                // do the writing...
                // do some reading...
                // do more writing...
            } else{
                // try again later...
            }
        } finally{
            if(w) W.unlock();
            if(r) R.unlock();
        }
    }

}
