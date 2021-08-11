import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

class ThreadTest {

    private static class Ping extends TimerTask {
        public void run(){System.out.println("ping");}
    }
    private static class Pong extends TimerTask {
        public void run(){System.out.println("pong");}
    }
    public static void main(String[] args) throws IOException {
        Ping ping = new Ping();
        Pong pong = new Pong();
        Timer t = new Timer();
        t.scheduleAtFixedRate(ping, 0, 1000);
        t.scheduleAtFixedRate(pong, 500, 1000);

//        int i;
//        while ((i=System.in.read())!=13) {
//            System.out.println(i);
//        }
//        ping.cancel(); // canceled task
//        pong.cancel(); // t continues…
//        t.cancel(); // t is cancled

    }


}