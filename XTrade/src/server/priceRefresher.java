/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.logging.Level;
import java.util.logging.Logger;
import stockData.StockData;

/**
 *
 * @author Swordghost
 */
public class priceRefresher implements Runnable {
    public void run()
    {
        StockData.getInstance().refresh();
        try {
            Thread.sleep(2*60*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(priceRefresher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
