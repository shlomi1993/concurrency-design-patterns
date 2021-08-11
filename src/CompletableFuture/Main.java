public class Main {

    public static void main(String[] args) {

        // Part 1
//        ThreadPool tp = new ThreadPool();
//        Future<String> f = tp.submit(()->{
//            try { Thread.sleep(4000); }
//            catch (InterruptedException ignored) {}
//            return "42";
//        });
//        System.out.println(f.get());
        // Part 2
        CFuture.supplyAsync(()->{
            try { Thread.sleep(4000); }
            catch (InterruptedException ignored) {}
            return "42";
        }).thenApply(x->Integer.parseInt(x)).thenApply(x->2*x).thenAccept(x->System.out.println(x));
        System.out.println("Main is done.");
    }
}
