package client;

/**
 *
 * @author chenliang
 */
import java.rmi.registry.*;
import xtrade.*;

public class Client1 {
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;

    public static void main(String[] args) throws Exception {
        registry = LocateRegistry.getRegistry(HOST, PORT);
        
        //new XTrade instance 
        XTrade remoteXTrade = (XTrade) registry.lookup(XTrade.class.getSimpleName());
        
        System.out.println(remoteXTrade.hello());
        
        System.out.println(remoteXTrade.isStockExisted("google"));
        
        System.out.println(remoteXTrade.query().size());

    }
}
