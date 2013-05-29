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
     * Display all stocks' price
     */
    public void display()
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
    public void display(String stockName)
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
    public void update()
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
    public void update(String stockName, double price)
    {
        if(isStockExisted(stockName))
        {
            getStock(stockName).setPrice(price);
            System.out.println("Stock price of ["+getStock(stockName).getName()+ "] is updated at "+dateFormat.format(date));
        }
        else
        {
            System.out.println("Stock name ["+stockName+"] is not found.");
        }
    }
    
    
}
