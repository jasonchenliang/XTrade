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
    private static ArrayList<Transaction> transactionList= new ArrayList<>();
    
  
    /*
     * Constructor of XTrade 
     */
    public static void XTrade()
    {
    }
    
    /*
     * Return true if the stock exists.
     */
    private boolean isStockExisted(String stockName)
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
    private Stock getStock(String stockName)
    {
         for(int i=0;i<stockList.size();i++)
        {
           if(stockList.get(i).getName().equalsIgnoreCase(stockName))
           {
               return stockList.get(i);
           }
        }
         return stockList.get(0);//should never execute this line.
    }
    
    /*
     * Display all Stocks' price
     */
    public void query()
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
    public void query(String stockName)
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
            getStock(stockName).setPrice(price);
            System.out.println("Stock price of ["+getStock(stockName).getName()+ "] is updated at "+dateFormat.format(date));
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
            System.out.println(transactionList.get(i).getUserName()+": "+transactionList.get(i).getStockName()+" * "+transactionList.get(i).getShares());
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
                System.out.println(transactionList.get(i).getUserName()+": "+transactionList.get(i).getStockName()+" * "+transactionList.get(i).getShares());
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
    private boolean hasEnoughStock(String userName,String stockName,int shares)
    {
        for(int i=0;i<transactionList.size();i++)
        {
            if(transactionList.get(i).getUserName().equalsIgnoreCase(userName)&&transactionList.get(i).getStockName().equalsIgnoreCase(stockName)&&transactionList.get(i).getShares()>=shares)
            {
              return true;
            }
        }
        return false;
    }
    
     /* 
     *Retrun ture if the user owns enough balance to buy that many of stocks
     */
    private boolean hasEnoughBalance(String userName,String stockName,int shares)
    {
        for(int i=0;i<transactionList.size();i++)
        {
            if(getStock(stockName).getPrice()*shares<=getUser(userName).getCashBalance())
            {
              return true;
            }
        }
        return false;
    }
    
    /*
     * Update transaction record
     */
    public void updateTransaction(String userName,String stockName,int shares)
    {
        for(int i=0;i<transactionList.size();i++)
        {
            if(transactionList.get(i).getUserName().equalsIgnoreCase(userName)&&transactionList.get(i).getStockName().equalsIgnoreCase(stockName))
            {
                transactionList.get(i).setShares(transactionList.get(i).getShares()+shares);
            }
        }
    }
    
    
   public void buy(String userName,String stockName,int shares)
   {
       if(isUserExisted(userName)&&isStockExisted(stockName))
       {
           if(hasEnoughBalance(userName,stockName,shares))
           {
              updateUser(userName,-shares*getStock(stockName).getPrice());
              updateTransaction(userName,stockName,shares);
           }
           else
           {
               System.out.println("No sufficient balance to buy: "+stockName+" * "+shares+" @ $"+getStock(stockName).getPrice());
           }
             
       }
       else
       {
           displayUser(userName);//user name is not found OR
           query(stockName);//stock name is not found
       }
       
   }
   
   
   public void sell(String userName,String stockName,int shares)
   {
       if(isUserExisted(userName)&&isStockExisted(stockName))
       {
           if(hasEnoughStock(userName,stockName,shares))
            {
                updateUser(userName,shares*getStock(stockName).getPrice());
                updateTransaction(userName,stockName,-shares);
            }
            else
            {
                System.out.println("No sufficient shares to sell: "+stockName+" * "+shares+" @ $"+getStock(stockName).getPrice());
            }
       }
       else
       {
           displayUser(userName);//user name is not found OR
           query(stockName);//stock name is not found
       }
     
   }
   
}
