package xtrade;

/**
 *
 * @author chenliang
 */
public class Transaction {
    private String userName;
    private String stockName;
    private int shares;

    /*
     * Transaction constructor
     */
    public Transaction(String userName,String stockName,int shares)
    {
        setUserName(userName);
        setStockName(stockName);
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
     * @return the stockName
     */
    public String getStockName() {
        return stockName;
    }

    /**
     * @param stockName the stockName to set
     */
    public void setStockName(String stockName) {
        this.stockName = stockName;
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
