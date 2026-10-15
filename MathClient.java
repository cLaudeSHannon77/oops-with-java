
import java.rmi.registry.*;

public class MathClient {
    public static void main(String[] args) {
        try {
            Registry registry =
                    LocateRegistry.getRegistry("localhost", 1099);

            MathService obj =
                    (MathService) registry.lookup("MathService");

            System.out.println("Addition: " + obj.addition(10, 5));
            System.out.println("Subtraction: " + obj.subtraction(10, 5));
            System.out.println("Multiplication: " + obj.multiply(10, 5));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

