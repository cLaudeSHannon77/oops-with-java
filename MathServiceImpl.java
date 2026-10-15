
import java.rmi.*;
import java.rmi.server.*;

public class MathServiceImpl extends UnicastRemoteObject
        implements MathService {

    public MathServiceImpl() throws RemoteException {
        super();
    }

    public int addition(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

