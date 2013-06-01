package client;

/**
 *
 * @author chenliang
 */
import api.XTradeAPI;
import java.rmi.registry.*;

public class Client1 {
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;

    public static void main(String[] args) throws Exception {
        registry = LocateRegistry.getRegistry(HOST, PORT);
        
        //new XTradeAPI instance 
        XTradeAPI remoteXTrade = (XTradeAPI) registry.lookup(XTradeAPI.class.getSimpleName());
        
        System.out.println(remoteXTrade.hello()+": 1");
        
        System.out.println("query symbol google: "+remoteXTrade.isStockExisted("google"));
        System.out.println("query symbol goog: "+remoteXTrade.isStockExisted("goog"));

        System.out.println(remoteXTrade.query().size());
    }
}
