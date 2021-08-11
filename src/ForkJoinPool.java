import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// Fibonacci + Dynamic Programming:
public class Fib_DP { // without concurrency but with dynamic programming
    static HashMap<Integer, Integer> fibs = new HashMap<>();
    int num;

    public Fib_DP(int num) {
        this.num = num;
    }

    public int compute() { // a recursive task
        if (num <= 1)
            return num;
        if (fibs.get(num) != null)
            return fibs.get(num);
        Fib_DP fib1 = new Fib_DP(num - 1);
        Fib_DP fib2 = new Fib_DP(num - 2);
        int result = fib2.compute() + fib1.compute();
        fibs.put(num, result);
        return result;
    }
    // Run from main: System.out.println(new Fib_DP(2048).compute());
}

// Fibonacci + Fork-Join Pool (FJ Pool is idial
public class Fib_FJ extends RecursiveTask<Integer> {
    // with fork-join pool
    int num;

    public Fib_FJ(int num) {
        this.num = num;
    }

    @Override
    public Integer compute() { // a recursive task
        if (num <= 1)
            return num;
        Fib_FJ fib1 = new Fib_FJ(num - 1);
        fib1.fork();
        Fib_FJ fib2 = new Fib_FJ(num - 2);
        return fib2.compute() + fib1.join();
    }

    public static void main(String[] args) {
        Fib_FJ fib = new Fib_FJ(45);
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(fib));
    }
}