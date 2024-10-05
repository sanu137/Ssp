import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class MathsOper extends UnicastRemoteObject implements Maths {

    MathsOper() throws RemoteException {
        super();
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new IllegalArgumentException("Division by zero");
        }
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}
