import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteImplementation extends UnicastRemoteObject implements RemoteInterface {
    public RemoteImplementation() throws RemoteException {
        super();
    }

    @Override
    public int addNumbers(int a, int b) throws RemoteException {
        return a + b;
    }
}

