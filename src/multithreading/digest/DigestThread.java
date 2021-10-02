package digest;

import javax.xml.bind.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
            while (din.read() != -1) ;  // read in the whole file.
            din.close();
            String result = fileName + ":" + DatatypeConverter.printHexBinary(sha.digest());
            System.out.println(result);
        } catch (IOException | NoSuchAlgorithmException e) {
            System.err.println(e);
        }
    }
}
