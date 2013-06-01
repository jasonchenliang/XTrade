package object;

import java.io.*;
/**
 *
 * @author chenliang
 */
public class User implements Serializable{
    private String userName;
    private double cashBalance;
    private static final double STARTCASHBALANCE=1000.0;

    /*
     * User constructor with 1 parameter to set new user in the file
     */
    public  User(String newUserName)
    {
        this.userName=newUserName;
        this.cashBalance=STARTCASHBALANCE;
    }

    /*
     * User constructor with 2 parameters
     */
    public User(String userName,double cashBalance)
    {
        this.userName=userName;
        this.cashBalance=cashBalance;
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
    public synchronized double getCashBalance() {
        return cashBalance;
    }

    /**
     * @param cashBalance the cashBalance to set
     */
    public synchronized void setCashBalance(double cashBalance) {
        this.cashBalance = cashBalance;
    }
    
    @Override
    public String toString(){
        
        return (this.getUserName()+","+this.getCashBalance());
    }
}
