package digestcallback;

import javax.xml.bind.DatatypeConverter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CallbackDigestNotifiable {
    public static void recieveDigest(byte[] digest, String name) {
        System.out.println(name + ":" + DatatypeConverter.printHexBinary(digest));
    }

    public static void main(String[] args) {
        List<String> files = new ArrayList<>();
        String path = Paths.get(".").toAbsolutePath().normalize().toString();
        files.add(path + "/digest/foo.txt");
        files.add(path + "/digest/bar.txt");

        for (String file : files) {
            CallbackDigest cbDigest = new CallbackDigest(file);
            Thread worker = new Thread(cbDigest);
            worker.start();
        }
    }
}
