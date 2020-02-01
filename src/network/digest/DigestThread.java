package digest;

import java.io.*;
import java.security.*;
import javax.xml.bind.*;

public class DigestThread extends Thread {
    private String fileName = "";

    public DigestThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(fileName);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in, sha);
            while (din.read() != -1);  // read in the whole file.
            din.close();
            String result = fileName + ":" + DatatypeConverter.printHexBinary(sha.digest());
            System.out.println(result);
        } catch (IOException | NoSuchAlgorithmException e) {
            System.err.println(e);
        }
    }
}
