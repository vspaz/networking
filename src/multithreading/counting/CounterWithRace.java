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
    System.out.println(counter.getCount()); // always gives an arbitrary number.

    SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
    Worker worker_3 = new Worker(synchronizedCounter);
    Worker worker_4 = new Worker(synchronizedCounter);

    worker_3.start();
    worker_4.start();

    try {
      worker_3.join();
      worker_4.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(synchronizedCounter.getCount());
  }
}
