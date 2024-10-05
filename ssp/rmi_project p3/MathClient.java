import java.rmi.*;

public class MathClient {
    public static void main(String[] args) {
        int a = 10, b = 5;
        
        try {
            System.setProperty("java.rmi.server.codebase", "http://172.16.32.253:8000/"); // Replace with your server's actual URL
            Maths m1 = (Maths) Naming.lookup("rmi://172.16.32.253:1900/jnec");
            
        
            int additionResult = m1.add(a, b);
            System.out.println("Addition of "+a+" and "+b+" : " + additionResult);
            
        
            int subtractionResult = m1.subtract(a, b);
            System.out.println("Subtraction of "+a+" and "+b+" : " + subtractionResult);
     
            int multiplicationResult = m1.multiply(a, b);
            System.out.println("Multiplication of "+a+" and "+b+" : " + multiplicationResult);
    
            int divisionResult = m1.divide(a, b);
            System.out.println("Division of "+a+" and "+b+" : " + divisionResult);
     
            double powerResult = m1.power(a, b);
            System.out.println(a+" to the power of "+b+" : " + powerResult);
            
        } catch (Exception e) {
            System.out.println("MathClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
