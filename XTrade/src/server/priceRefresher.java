/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import impl.XTrade;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import stockData.StockData;

/**
 *
 * @author Swordghost
 */
public class priceRefresher implements Runnable {
    private int interval;
    private XTrade instance;
    private static DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    

    
    public priceRefresher(int secs, XTrade instance)
    {
        this.interval=secs;
        this.instance=instance;
    }
    
    
    
    public void run()
    {


        while(true)
        {
            StockData.getInstance().refresh();
            StockData.getInstance().save();
 	    instance.setLastUpdateTime(dateFormat.format(new Date()));
            instance.setUpdatedby("Yahoo Stock Quote");
           try {
     
                   Thread.sleep(interval*1000);
        
                } catch (InterruptedException ex) 
                    {
                        Logger.getLogger(priceRefresher.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
        }
        
}
