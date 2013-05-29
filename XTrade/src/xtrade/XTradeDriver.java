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
        newXTrade.fetchStock();
        
        //display all stocks' price
        newXTrade.displayStock();
        
        //update the stock price of "google"
        newXTrade.updateStock("google",2000.0);
        
        //display the stock price of "google"
        newXTrade.displayStock("google");
        
        
        
   
        //initialize all user data
        newXTrade.fetchUser();
        
        //display all user data
        newXTrade.displayUser();

        //update user "jason" with 2000 credit
        newXTrade.updateUser("jason",2000.0);
        
        //display user "jason"
        newXTrade.displayUser("jason");

    }
}
