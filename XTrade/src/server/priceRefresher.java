/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import impl.XTrade;

import java.util.logging.Level;
import java.util.logging.Logger;
import stockData.StockData;

/**
 *
 * @author Swordghost
 */
public class priceRefresher implements Runnable {
    private int interval;

    

    
    public priceRefresher(int secs)
    {
        this.interval=secs;
   
    }
    
    
    
    public void run()
    {


        while(true)
        {
            StockData.getInstance().refresh();
            StockData.getInstance().save();
 	  
           try {
     
                   Thread.sleep(interval*1000);
        
                } catch (InterruptedException ex) 
                    {
                        Logger.getLogger(priceRefresher.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
        }
        
}
