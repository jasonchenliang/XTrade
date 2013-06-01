package client;

/**
 *
 * @author chenliang
 */
import api.XTradeAPI;
import java.rmi.registry.*;
import object.Record;
import object.Stock;
import object.User;

public class Client1 {
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;

    public static void main(String[] args) throws Exception {
        registry = LocateRegistry.getRegistry(HOST, PORT);
        
        //new XTradeAPI instance 
        XTradeAPI remoteXTrade = (XTradeAPI) registry.lookup(XTradeAPI.class.getSimpleName());
        
        
        
        for(User u:remoteXTrade.getAllUser())
        {
            System.out.println(u.toString());
        }

        for(Stock s:remoteXTrade.getAllStock())
        {
            System.out.println(s.toString());
        }
        
        for(Record r:remoteXTrade.getAllRecord())
        {
            System.out.println(r.toString());
        }
        
        
        
    }
}
