package multithreading.digest;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> files = new ArrayList<>();
    String path = Paths.get(".").toAbsolutePath().normalize().toString();
    files.add(path + "/digest/foo.txt");
    files.add(path + "/digest/bar.txt");
    for (String file : files) {
      Thread t = new DigestThread(file);
      t.start();
    }

    for (String file : files) {
      DigestRunnable digestRunnable = new DigestRunnable(file);
      Thread digestThread = new Thread(digestRunnable);
      digestThread.start();
    }
  }
}
