package server;

/**
 *
 * @author chenliang
 */

import java.rmi.*;
import java.rmi.registry.*;
import impl.XTrade;
import api.XTradeAPI;
import stockData.*;

public class Server {
    private static final int PORT = 1099;
    private static Registry registry;
    private static final int REFRESH_SECS=120;
    
    public static void startRegistry() throws RemoteException {
        registry = java.rmi.registry.LocateRegistry.createRegistry(PORT);
    }

    public static void registerObject(String name, Remote remoteObj)
        throws RemoteException, AlreadyBoundException {
        registry.bind(name, remoteObj);
        System.out.println("Registered: " + name + " -> " +
            remoteObj.getClass().getName() + "[" + remoteObj + "]");
    }

    
    
    public static void main(String[] args) throws Exception {
        
        startRegistry();
        
        registerObject(XTradeAPI.class.getSimpleName(), new XTrade());
 

        
        
        
        //initialize XTrade
        XTrade newXTrade=new XTrade();

        StockData.getInstance().printList();
        
        Thread refresher = new Thread(new priceRefresher(REFRESH_SECS));
		refresher.start();
               
      
    
    }
}