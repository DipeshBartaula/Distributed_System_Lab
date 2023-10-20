import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            // Lookup the remote object by its name in the RMI registry
            RemoteInterface remoteObj = (RemoteInterface) Naming.lookup("RemoteObject");
            
            // Invoke the remote method
            int result = remoteObj.addNumbers(10, 20);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

