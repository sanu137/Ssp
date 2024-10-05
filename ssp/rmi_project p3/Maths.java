import java.rmi.*;

public interface Maths extends Remote {
    public int add(int n1, int n2) throws RemoteException;
    public int subtract(int n1, int n2) throws RemoteException;
    public int multiply(int n1, int n2) throws RemoteException;
    public int divide(int n1, int n2) throws RemoteException;
    public double power(double base, double exponent) throws RemoteException;
}
