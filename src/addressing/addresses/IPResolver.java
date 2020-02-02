package addresses;

import java.io.IOException;
import java.net.InetAddress;

public class IPResolver {
    public static void main(String[] args) {
        try {
            InetAddress ipAddress = InetAddress.getByName("www.google.com");
            System.out.println(ipAddress); // -> www.google.com/216.239.34.117
            for (InetAddress address : InetAddress.getAllByName("www.google.com")) {
                System.out.println(address); // -> www.google.com/216.58.208.36\nwww.google.com/2a00:1450:4016:804:0:0:0:2004

            }
            InetAddress localhost = InetAddress.getLocalHost(); // DELL/127.0.1.1
            System.out.println(localhost);

            byte[] address = {(byte) 216, (byte) 239, 34, 127}; // cast values > 127 to bytes.
            InetAddress name = InetAddress.getByAddress("www.default-domain-option.com", address);
            System.out.println(name);

            InetAddress google = InetAddress.getByName("www.google.de");
            System.out.println(google.isReachable(5));

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
