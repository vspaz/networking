package gzipping;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GzipFiles {
    public final static int THREAD_COUNT = 4;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(GzipFiles.THREAD_COUNT);
        List<String> files = new ArrayList<>();
        String path = Paths.get(".").toAbsolutePath().normalize().toString();
        files.add(path + "/digest/foo.txt");
        files.add(path + "/digest/bar.txt");
        for (String filePath : files) {
            File file = new File(filePath);
            if (file.exists()) {
                Runnable task = new GzipRunnable(file);
                pool.submit(task);
            }
        }
        pool.shutdown();
    }
}
