package object;

import java.io.*;
/**
 *
 * @author chenliang
 */
public class Transaction implements Serializable{
    private String userName;
    private String symbol;
    private int shares;

    /*
     * Transaction constructor
     */
    public Transaction(String userName,String symbol,int shares)
    {
        setUserName(userName);
        setSymbol(symbol);
        setShares(shares);
      
    }
    
    
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the shares
     */
    public int getShares() {
        return shares;
    }

    /**
     * @param shares the shares to set
     */
    public void setShares(int shares) {
        this.shares = shares;
    }
    
    
}
