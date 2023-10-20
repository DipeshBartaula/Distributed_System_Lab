import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            RemoteInterface remoteObj = new RemoteImplementation();
            
            // Create and start the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);
            
            // Bind the remote object to the registry with the name "RemoteObject"
            Naming.rebind("RemoteObject", remoteObj);
            
            System.out.println("Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

