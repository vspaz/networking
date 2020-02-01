package digest;

import java.io.*;
import java.security.*;
import javax.xml.bind.*;

public class DigestRunnable implements Runnable {

    private String filename;

    public DigestRunnable(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in, sha);
            while (din.read() != -1);
            din.close();
            byte[] digest = sha.digest();

            String result = filename + ":" + DatatypeConverter.printHexBinary(digest);
            System.out.println(result);
        } catch (IOException | NoSuchAlgorithmException ex) {
            System.err.println(ex);
        }
    }
}
