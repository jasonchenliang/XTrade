package xtrade;

/**
 *
 * @author chenliang
 */
public class User {
    private String userName;
    private double cashBalance;

    /*
     * User constructor 
     */
    public  User(String userName)
    {
        setUserName(userName);
        setCashBalance(1000.0);
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
     * @return the cashBalance
     */
    public double getCashBalance() {
        return cashBalance;
    }

    /**
     * @param cashBalance the cashBalance to set
     */
    public void setCashBalance(double cashBalance) {
        this.cashBalance = cashBalance;
    }
}