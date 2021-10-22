package urls;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DataReader {
  public static void main(String[] args) {
    try {
      URL url = new URL("https://example.com");
      InputStream in = url.openStream();
      int contents;
      while ((contents = in.read()) != -1) {
        System.out.write(contents);
      }
      in.close();
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
