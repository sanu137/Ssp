import java.rmi.*;
import java.rmi.registry.*;

public class MathServer {

    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.codebase", "http://172.16.32.253:8000/"); // Replace with your server's actual URL
            Maths obj = new MathsOper();
            LocateRegistry.createRegistry(1900);
            Naming.rebind("rmi://172.16.32.253:1900/jnec", obj); // Corrected URL format
            System.out.println("MathServer is running...");
        } catch (Exception e) {
            System.out.println("MathServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
