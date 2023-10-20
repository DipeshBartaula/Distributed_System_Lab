import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {
    int addNumbers(int a, int b) throws RemoteException;
}

