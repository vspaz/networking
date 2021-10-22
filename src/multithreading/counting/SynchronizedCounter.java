package counting;

public class SynchronizedCounter extends Counter {

  public SynchronizedCounter() {
    super();
  }

  @Override
  public synchronized int getCount() {
    // should be also synchronized not to occasionally return the stale value!!!
    return count;
  }

  @Override
  public synchronized void increment() {
    count++;
  }
}
