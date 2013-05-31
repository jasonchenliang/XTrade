package object;

import java.io.*;
/**
 *
 * @author chenliang
 */
public class User implements Serializable{
    private String userName;
    private double cashBalance;

    /*
     * User constructor 
     */
    public  User(String newUserName)
    {
        this.setUserName(newUserName);
        this.setCashBalance(1000.0);
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
