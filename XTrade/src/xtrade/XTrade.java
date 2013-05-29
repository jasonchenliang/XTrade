package xtrade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author chenliang
 */
public class XTrade {

    private static Date date=new Date();;
    private static DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static ArrayList<Stock> stockList = new ArrayList<>();
    private static ArrayList<User> userList= new ArrayList<>();        
  
    /*
     * Constructor of XTrade 
     */
    public static void XTrade()
    {
    }
    
    /*
     * Return true if the stock exists.
     */
    public boolean isStockExisted(String stockName)
    {
        for(int i=0;i<stockList.size();i++)
       {
           if(stockList.get(i).getName().equalsIgnoreCase(stockName))
           {
               return true;
           }
       }
        
        return false;
    }
    
    /*
     * Return the stock object given the stock name
     */
    public Stock getStock(String stockName)
    {
         for(int i=0;i<stockList.size();i++)
        {
           if(stockList.get(i).getName().equalsIgnoreCase(stockName))
           {
               return stockList.get(i);
           }
        }
         return stockList.get(0);
    }
    
    /*
     * Display all Stocks' price
     */
    public void displayStock()
    {
        for(int i=0;i<stockList.size();i++)
        {
            System.out.println(stockList.get(i).getName()+": $"+stockList.get(i).getPrice());
        }
    }
    
    /**
     *
     * @param stockName the name of the stock to query its price
     */
    public void displayStock(String stockName)
    {
       if(isStockExisted(stockName))
       {
           System.out.println(getStock(stockName).getName()+": $"+getStock(stockName).getPrice());
       }
       else
       {   
           System.out.println("Stock name ["+stockName+"] is not found.");
       }
    }
    
    /*
     * Pull the data from the web.
     * Should be implemented using the real data from the web.
     * HARD CODED some data thou.
     */
    public void fetchStock()
    {
        Stock newStock1 = new Stock("google",1000.00);
        Stock newStock2 = new Stock("amazon",800.00);
        Stock newStock3 = new Stock("tesla",500.00);
        
        stockList.add(newStock1);
        stockList.add(newStock2);
        stockList.add(newStock3);
        
        System.out.println("All stock prices are updated at "+dateFormat.format(date));
       
    }
    
    
    /*
     * Update the stock price in the local file.
     */
    public void updateStock(String stockName, double price)
    {
        if(isStockExisted(stockName))
        {
            getStock(stockName).setPrice(price);
            System.out.println("Stock price of ["+getStock(stockName).getName()+ "] is updated at "+dateFormat.format(date));
        }
        else
        {
            displayStock(stockName);//stock not found.
        }
    }
    
    
     /*
     * Pull the data from the file.
     * Should be implemented using the real data from the file.
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
               
        System.out.println("All user cash balance are updated at "+dateFormat.format(date));

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
    public boolean isUserExisted(String userName)
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
    public User getUser(String userName)
    {
        for(int i=0;i<userList.size();i++)
        {
           if(userList.get(i).getUserName().equalsIgnoreCase(userName))
           {
               return userList.get(i);
           }
        }
        
        return userList.get(0);
    }
    
    
    /*
     * Update User after transaction
     */
    public void updateUser(String userName,double credit)
    {
        if(isUserExisted(userName))
        {
            if((getUser(userName).getCashBalance()+credit)>=0)
            {
                   getUser(userName).setCashBalance(getUser(userName).getCashBalance()+credit);
                   System.out.println("Cash balance of user ["+getUser(userName).getUserName()+ "] is updated at "+dateFormat.format(date));
            }
            else
            {
                System.out.print("No sufficient fund for - ");
                displayUser(userName);
            }
        }
        else
        {
                displayUser(userName);//user not found
        }
    }
    
    
    
    
}
