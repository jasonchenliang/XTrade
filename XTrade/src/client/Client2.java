package client;

/**
 *
 * @author chenliang
 */
import api.XTradeAPI;
import java.rmi.registry.*;

public class Client2 {
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;

    public static void main(String[] args) throws Exception {
        registry = LocateRegistry.getRegistry(HOST, PORT);
        
        //new XTradeAPI instance 
        XTradeAPI remoteXTrade = (XTradeAPI) registry.lookup(XTradeAPI.class.getSimpleName());
        
        System.out.println("client2 is conected.");

    }
}
