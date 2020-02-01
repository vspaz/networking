package gzipping;

import java.io.*;
import java.util.zip.*;

public class GzipRunnable implements Runnable {

    private final File input;

    public GzipRunnable(File input) {
        this.input = input;
    }

    @Override
    public void run() {
        if (!input.getName().endsWith(".gz")) {
            File out = new File(input.getParent(), input.getName() + ".gz");
            if (!out.exists()) {
                try (
                    InputStream in = new BufferedInputStream(new FileInputStream(input));
                    OutputStream output = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(out)));

                ) {
                    int b;
                    while ((b = in.read()) != -1) {
                        output.write(b);
                    }
                }
                catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }
}
