package api;

import java.rmi.*;
import java.util.ArrayList;
import object.*;

/**
 *
 * @author chen liang
 */
public interface XTradeAPI extends Remote{

    public String hello() throws RemoteException;
                
    public boolean isStockExisted(String stockName) throws RemoteException;

    public ArrayList<Stock> query() throws RemoteException;
    
    public Stock query(String stockName) throws RemoteException;
    
    
}