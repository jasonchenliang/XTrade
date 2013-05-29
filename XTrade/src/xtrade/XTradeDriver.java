package xtrade;

/**
 *
 * @author chenliang
 */
public class XTradeDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        XTrade newXTrade =new XTrade();
        
        //initialize all stock price data
        newXTrade.update();
        
        //display all stocks' price
        newXTrade.display();
        
        //update the stock price of "google"
        newXTrade.update("google",2000.0);
        
        //display the stock price of "google"
        newXTrade.display("amazon");


    }
}
