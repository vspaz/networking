package digest;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;

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
    }
}
