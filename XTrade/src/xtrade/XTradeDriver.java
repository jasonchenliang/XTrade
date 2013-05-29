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
        newXTrade.query();
        
        //update the stock price of "google"
        newXTrade.updateStock("google",2000.0);

        //initialize all user data
        newXTrade.fetchUser();
        
        //display all user data
        newXTrade.displayUser();
        
        //update user "jason" with 2000 credit
        newXTrade.updateUser("jason",2000.0);
        
        //login as new user "mike", $1000 will be credited
        newXTrade.loginUser("mike");        
        
        
        //initialize all transactions
        newXTrade.fetchTransaction();
        
        //display all transactions
        newXTrade.displayTransaction();
        
        newXTrade.sell("jason","google",1);
        
        //display all transactions - should be google*0
        newXTrade.displayTransaction();       
        
    }
}
