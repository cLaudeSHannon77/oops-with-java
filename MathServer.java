
import java.rmi.registry.*;

public class MathServer {
    public static void main(String[] args) {
        try {
            MathServiceImpl obj = new MathServiceImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("MathService", obj);

            System.out.println("Server is ready...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

