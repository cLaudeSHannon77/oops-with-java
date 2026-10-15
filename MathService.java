
import java.rmi.*;

public interface MathService extends Remote {
    int addition(int a, int b) throws RemoteException;
    int subtraction(int a, int b) throws RemoteException;
    int multiply(int a, int b) throws RemoteException;
}
