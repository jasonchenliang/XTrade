package server;

/**
 *
 * @author chenliang
 */
import impl.XTrade;
import api.XTradeAPI;
import java.rmi.*;
import java.rmi.registry.*;

public class Server {
    private static final int PORT = 1099;
    private static Registry registry;

    public static void startRegistry() throws RemoteException {
        // create in server registry
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
 

        
        
        
        //initialize 
        XTrade newXTradeImpl=new XTrade();
        
        newXTradeImpl.fetchStock();       
        newXTradeImpl.fetchUser();        
        newXTradeImpl.fetchTransaction();
        

    
    }
}