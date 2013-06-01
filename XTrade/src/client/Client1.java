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
        
        
        System.out.println("----------------------------------");
        
        for(User u:remoteXTrade.getAllUser())
        {
            System.out.println(u.toString());
        }
        
        System.out.println("----------------------------------");

        for(Stock s:remoteXTrade.getAllStock())
        {
            System.out.println(s.toString());
        }
        System.out.println("----------------------------------");

        for(Record r:remoteXTrade.getAllRecord())
        {
            System.out.println(r.toString());
        }
        
        System.out.println("----------------------------------");
        
        
        System.out.println(remoteXTrade.hello()+": 1");
               
        System.out.println(remoteXTrade.login("jason"));
        
        System.out.println(remoteXTrade.queryUser("johndoe"));
        
        System.out.println(remoteXTrade.login("johndoe"));
        
        System.out.println(remoteXTrade.update("goog", 200));
                        
        System.out.println(remoteXTrade.sell("goog","jason",1));
        
        System.out.println(remoteXTrade.buy("tsla","jason",1));
        
        System.out.println(remoteXTrade.queryStock("s"));
        
        System.out.println("----------------------------------");

        for(User u:remoteXTrade.getAllUser())
        {
            System.out.println(u.toString());
        }
        
        System.out.println("----------------------------------");

        for(Stock s:remoteXTrade.getAllStock())
        {
            System.out.println(s.toString());
        }
        System.out.println("----------------------------------");

        for(Record r:remoteXTrade.getAllRecord())
        {
            System.out.println(r.toString());
        }
        
        System.out.println("----------------------------------");
        
    }
}
