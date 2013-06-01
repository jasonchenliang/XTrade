package api;

import java.rmi.*;
import java.util.ArrayList;
import object.Record;
import object.Stock;
import object.User;

/**
 *
 * @author chen liang
 */
public interface XTradeAPI extends Remote{

    public String hello() throws RemoteException;
    
    public String login(String userName) throws RemoteException;
    
    public String queryUser(String userName) throws RemoteException;
    
    public String queryStock(String symbol) throws RemoteException;
    
    public String queryRecord(String userName,String symbol) throws RemoteException;
    
    //client 1 updates
    public String update(String symbol, double price) throws RemoteException;
    
    //client 2 buys/sells
    public String buy(String symbol,String userName,int shares) throws RemoteException;
    
    public String sell(String symbol,String userName,int shares) throws RemoteException;
    
    //test API
    public ArrayList<User> getAllUser() throws RemoteException;
    
    public ArrayList<Stock> getAllStock() throws RemoteException;
    
    public ArrayList<Record> getAllRecord() throws RemoteException;
    
}