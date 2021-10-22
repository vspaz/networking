package simplethreading;

// can be replaced with new Thread(() -> System.out.println("In worker"));
class Worker extends Thread {
  @Override
  public void run() {
    System.out.println("In worker");
  }
}

public class SimpleThread {
  public static void main(String[] args) {
    Worker worker = new Worker();
    worker.start();
    Thread.yield();
    System.out.println("In main thread");
    try {
      worker.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
