package counting;

public class CounterWithRace {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Worker worker_1 = new Worker(counter);
        Worker worker_2 = new Worker(counter);

        worker_1.start();
        worker_2.start();

        try {
            worker_1.join();
            worker_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCount());  // always gives an arbitrary number.
    }
}
