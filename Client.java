
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        out.println("Hello from Client!");

        String reply = in.readLine();
        System.out.println("Server says: " + reply);

        s.close();
    }
}
