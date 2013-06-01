package impl;

import api.XTradeAPI;
import java.rmi.*;
import java.rmi.server.*;

import object.User;
import object.Record;
import object.Stock;
import stockData.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author chenliang
 */
public class XTrade extends UnicastRemoteObject implements XTradeAPI{

    private static Date date=new Date();
    private static DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static ArrayList<Stock> stockList = new ArrayList<>();
    private static ArrayList<User> userList= new ArrayList<>();
    private static ArrayList<Record> recordList= new ArrayList<>();
   
    
    /*
     * Constructor of XTrade 
     */
    public XTrade() throws RemoteException
    {
        super();
    }
        
    /**
     * Test if connected.
     */
    @Override
    public String hello() throws RemoteException
    {
        return("You are connected");
    }
    

    /*
     * login using typed userName, if not found in the file, create new user and save
     */
    @Override
    public String login(String userName) throws RemoteException
    {
        for(int i=0;i<userList.size();i++)
        {
            if(userList.get(i).getUserName().equalsIgnoreCase(userName))
            {
                return("Welcome back to XTrade, "+userList.get(i).getUserName());
            }
        }
        
        User newUser=new User(userName);
        userList.add(newUser);
        StockData.getInstance().save();
        
        return("Welcome to XTrade, "+ newUser.getUserName());

    }
    
    
    /*
     * query user info: userName, cashBalance. If not found, create new user in the file
     * @param userName user's name to query
     */
    @Override
    public String queryUser(String userName) throws RemoteException
    {
        for(int i=0;i<userList.size();i++)
        {
            if(userList.get(i).getUserName().equalsIgnoreCase(userName))
            {
                return(userList.get(i).toString());
            }
        }
        
        User newUser=new User(userName);
        userList.add(newUser);
        StockData.getInstance().save();
        
        return(newUser.getUserName());
    }
    
    
    /*
     * Return the stock object with given symbol
     */
    @Override
    public String queryStock(String symbol) throws RemoteException
    {       
            for(int i=0;i<stockList.size();i++)
            {
                if(stockList.get(i).getSymbol().equalsIgnoreCase(symbol))
                {
                    return stockList.get(i).toString();
                }
            }
            
            Stock stock=StockData.getInstance().querybyurl(symbol);
            
            if(stock!=null)
            {       
                stockList.add(stock);
                StockData.getInstance().save();
                return stock.toString();
            }
            else
            {
                return ("Sorry, no stock symbol found.");
            }                        
    }
    
    
    
    
    /*
     * Return the record of given userName and stock symbol
     * @param userName the name of the user
     * @param symbol the stock symbol
     */
    @Override
    public String queryRecord(String userName,String symbol) throws RemoteException
    {
        for(int i=0;i<recordList.size();i++)
        {
            if(recordList.get(i).getUserName().equalsIgnoreCase(userName))
            {
                if(recordList.get(i).getSymbol().equalsIgnoreCase(symbol))
                {
                    return recordList.get(i).toString();
                }
            }
        }
        
        return("Record does not exist.");
    }
    
    
    
    
    
    /*
     * Client 1 updates the price of a stock
     * @symbol the symbol to update
     * @price the price to set
     */
    @Override
    public String update(String symbol, double price) throws RemoteException
    {
            
    }
    
    
    
          /*
    //client 2 buys/sells
    public String buy(String symbol,String userName,int shares) throws RemoteException
    {
        
    }
    
    public String sell(String symbol,String userName,int shares) throws RemoteException
    {
        
    }
    
    
    
    
    
    
    */

    /*
     * Pull the data from the web.
     * Should be implemented using the real data from the web.
     * HARD CODED some data thou.
     */
    public void loadStock()
    {
        Stock newStock1 = new Stock("GOOG","google",1000.00);
        Stock newStock2 = new Stock("AMZN","amazon",800.00);
        Stock newStock3 = new Stock("TSLA","tesla",500.00);
        
        stockList.add(newStock1);
        stockList.add(newStock2);
        stockList.add(newStock3);
        
        System.out.println("All stock prices are updated at "+dateFormat.format(date));
       
    }
    
    
     /*
     * Should Pull the data from the file.
     * HARD CODED some data thou.
     */
    public void loadUser()
    {
                
        User newUser1 = new User("Terry");
        User newUser2 = new User("Ben");
        User newUser3 = new User("Jason");
        
        userList.add(newUser1);
        userList.add(newUser2);
        userList.add(newUser3);
               
        System.out.println("All users' cash balance are updated at "+dateFormat.format(date));

    }
    

     /*
     * Should pull the data from the file.
     * HARD CODED some data thou.
     */
    public void loadRecord()
    {
        Record newTransaction1 = new Record("Jason","goog",1);
        Record newTransaction2 = new Record("Jason","amzn",1);
        Record newTransaction3 = new Record("Jason","tsla",1);
        
        recordList.add(newTransaction1);
        recordList.add(newTransaction2);
        recordList.add(newTransaction3);
        
        System.out.println("All transaction records are updated at "+dateFormat.format(date));
    }

    
}