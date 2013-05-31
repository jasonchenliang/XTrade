package impl;

import api.XTradeAPI;
import java.rmi.*;
import java.rmi.server.*;

import object.User;
import object.Transaction;
import object.Stock;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author chenliang
 */
public class XTrade extends UnicastRemoteObject implements XTradeAPI{

    private static Date date=new Date();;
    private static DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static ArrayList<Stock> stockList = new ArrayList<>();
    private static ArrayList<User> userList= new ArrayList<>();
    private static ArrayList<Transaction> transactionList= new ArrayList<>();
   
    
    /*
     * Constructor of XTrade 
     */
    public XTrade() throws RemoteException
    {
        super();
    }
        
    /**
     * Test if connected.!!!
     */
    @Override
    public String hello() throws RemoteException
    {
        return("You are connected.");
    }
    
    
    /*
     * Return true if the stock exists.
     */
    @Override
    public boolean isStockExisted(String symbol) throws RemoteException
    {
        for(int i=0;i<stockList.size();i++)
       {
           if(stockList.get(i).getName().equalsIgnoreCase(symbol))
           {
               return true;
           }
       }
        
        return false;
    }
    
    /*
     * Return the stock object given the stock name
     */
    public Stock getStock(String symbol)
    {
         for(int i=0;i<stockList.size();i++)
        {
           if(stockList.get(i).getName().equalsIgnoreCase(symbol))
           {
               return stockList.get(i);
           }
        }
         return stockList.get(0);//should never execute this line.
    }
    
    /*
     * Display all Stocks' price
     */
    @Override
    public ArrayList<Stock> query()
    {
            return stockList;
    }
    
    /**
     *
     * @param symbol the name of the stock to query its price
     */
    @Override
    public Stock query(String symbol) throws RemoteException
    {
       if(isStockExisted(symbol))
       {
           return getStock(symbol);
       }
       else
       {   
           return null;
       }
    }
    
    /*
     * Pull the data from the web.
     * Should be implemented using the real data from the web.
     * HARD CODED some data thou.
     */
    public void fetchStock()
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
     * Update the stock price in the local file.
     */
    public void updateStock(String symbol, double price) throws RemoteException
    {
            getStock(symbol).setPrice(price);
            System.out.println("Stock price of ["+getStock(symbol).getName()+ "] is updated at "+dateFormat.format(date));
    }
    
    
     /*
     * Should Pull the data from the file.
     * HARD CODED some data thou.
     */
    public void fetchUser()
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
     * Display all User' cash balance
     */
    public void displayUser()
    {
        for(int i=0;i<userList.size();i++)
        {
            System.out.println(userList.get(i).getUserName()+": $"+userList.get(i).getCashBalance());
        }
    }
    
    
    /**
     *
     * @param userName the name of the User to query
     */
    public void displayUser(String userName)
    {
       if(isUserExisted(userName))
       {
           System.out.println(getUser(userName).getUserName()+": $"+getUser(userName).getCashBalance());
       }
       else
       {   
           System.out.println("User name ["+userName+"] is not found.");
       }
    }
    
    /*
     * Return true if user exists.
     */
    private boolean isUserExisted(String userName)
    {
        for(int i=0;i<userList.size();i++)
        {
            if(userList.get(i).getUserName().equalsIgnoreCase(userName))
            {
                return true;
            }
        }
        
        return false;
    }
    
    /*
     * Return the User object given the user name.
     */
    private User getUser(String userName)
    {
        for(int i=0;i<userList.size();i++)
        {
           if(userList.get(i).getUserName().equalsIgnoreCase(userName))
           {
               return userList.get(i);
           }
        }
        
        return userList.get(0);//should never execute this line.
    }
    
    
    /*
     * Update User after transaction
     */
    public void updateUser(String userName,double credit)
    {
        getUser(userName).setCashBalance(getUser(userName).getCashBalance()+credit);
        System.out.println("Cash balance of user ["+getUser(userName).getUserName()+ "] is updated at "+dateFormat.format(date));
    }
    
    
    /*
     * 
     */
    public void loginUser(String userName)
    {
        System.out.println("Welcome to XTrade!");
        
        if(!isUserExisted(userName))
        {
           userList.add(new User(userName));
        }
          
        displayUser(userName);
    }
      
    
     /*
     * Should pull the data from the file.
     * HARD CODED some data thou.
     */
    public void fetchTransaction()
    {
        Transaction newTransaction1 = new Transaction("Jason","google",1);
        Transaction newTransaction2 = new Transaction("Jason","amazon",1);
        Transaction newTransaction3 = new Transaction("Jason","tesla",1);
        
        transactionList.add(newTransaction1);
        transactionList.add(newTransaction2);
        transactionList.add(newTransaction3);
        
        System.out.println("All transaction records are updated at "+dateFormat.format(date));
    }
    
    /*
     * Display all transactions
     */
    public void displayTransaction()
    {
        for(int i=0;i<transactionList.size();i++)
        {
            System.out.println(transactionList.get(i).getUserName()+": "+transactionList.get(i).getSymbol()+" * "+transactionList.get(i).getShares());
        }
        
    }
    
    /* 
     * @param userName the name of user to query
     * Display transactions of the user
     */
    public void displayTransaction(String userName)
    {
        int count=0;
        for(int i=0;i<transactionList.size();i++)
        {
            if(transactionList.get(i).getUserName().equalsIgnoreCase(userName))
            {
                count++;
                System.out.println(transactionList.get(i).getUserName()+": "+transactionList.get(i).getSymbol()+" * "+transactionList.get(i).getShares());
            }
        }
        
        if(count==0)
        {
            System.out.println("["+userName+"] has no transaction record.");
        }
    }
    
    
    /* 
     *Retrun ture if the user owns at least that many shares of stock
     */
    private boolean hasEnoughStock(String userName,String symbol,int shares)
    {
        for(int i=0;i<transactionList.size();i++)
        {
            if(transactionList.get(i).getUserName().equalsIgnoreCase(userName)&&transactionList.get(i).getSymbol().equalsIgnoreCase(symbol)&&transactionList.get(i).getShares()>=shares)
            {
              return true;
            }
        }
        return false;
    }
    
     /* 
     *Retrun ture if the user owns enough balance to buy that many of stocks
     */
    private boolean hasEnoughBalance(String userName,String symbol,int shares) throws RemoteException
    {
        for(int i=0;i<transactionList.size();i++)
        {
            if(getStock(symbol).getPrice()*shares<=getUser(userName).getCashBalance())
            {
              return true;
            }
        }
        return false;
    }
    
    /*
     * Update transaction record
     */
    public void updateTransaction(String userName,String symbol,int shares)
    {
        for(int i=0;i<transactionList.size();i++)
        {
            if(transactionList.get(i).getUserName().equalsIgnoreCase(userName)&&transactionList.get(i).getSymbol().equalsIgnoreCase(symbol))
            {
                transactionList.get(i).setShares(transactionList.get(i).getShares()+shares);
            }
        }
    }
    
    
   public void buy(String userName,String symbol,int shares) throws RemoteException
   {
       if(isUserExisted(userName)&&isStockExisted(symbol))
       {
           if(hasEnoughBalance(userName,symbol,shares))
           {
              updateUser(userName,-shares*getStock(symbol).getPrice());
              updateTransaction(userName,symbol,shares);
           }
           else
           {
               System.out.println("No sufficient balance to buy: "+symbol+" * "+shares+" @ $"+getStock(symbol).getPrice());
           }
             
       }
       else
       {
           displayUser(userName);//user name is not found OR
           query(symbol);//stock name is not found
       }
       
   }
   
   
   public void sell(String userName,String symbol,int shares) throws RemoteException
   {
       if(isUserExisted(userName)&&isStockExisted(symbol))
       {
           if(hasEnoughStock(userName,symbol,shares))
            {
                updateUser(userName,shares*getStock(symbol).getPrice());
                updateTransaction(userName,symbol,-shares);
            }
            else
            {
                System.out.println("No sufficient shares to sell: "+symbol+" * "+shares+" @ $"+getStock(symbol).getPrice());
            }
       }
       else
       {
           displayUser(userName);//user name is not found OR
           query(symbol);//stock name is not found
       }
     
   }
   
}