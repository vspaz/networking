package counting;

public class SynchronizedCounter extends Counter {

    public SynchronizedCounter() {
        super();
    }

    public synchronized void increment() {
        count++;
    }
}
