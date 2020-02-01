package digestcallback;

import javax.xml.bind.DatatypeConverter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InstanceCallbackDigestUserInterface {
    private String filename;
    private byte[] digest;

    public InstanceCallbackDigestUserInterface(String filename) {
        this.filename = filename;
    }

    public void calculateDigest() {
        InstanceCallbackDigest cb = new InstanceCallbackDigest(filename, this);
        Thread t = new Thread(cb);
        t.start();
    }

    void recieveDigest(byte[] digest) {
        this.digest = digest;
        System.err.println(this);
    }

    @Override
    public String toString() {
        return filename + ":" + DatatypeConverter.printHexBinary(digest);
    }

    public static void main(String[] args) {
        List<String> files = new ArrayList<>();
        String path = Paths.get(".").toAbsolutePath().normalize().toString();
        files.add(path + "/digest/foo.txt");
        files.add(path + "/digest/bar.txt");

        for (String file : files) {
            InstanceCallbackDigestUserInterface digest = new InstanceCallbackDigestUserInterface(file);
            digest.calculateDigest();
        }
    }
}
