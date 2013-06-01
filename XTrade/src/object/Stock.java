package object;

import java.io.*;
/**
 *
 * @author chenliang
 */
public class Stock implements Serializable{
    
    private String symbol;
    private String name;
    private double price;
    private int shareBalance;
    private static final int STARTBALANCE=1000;
  
    /*
     * @param symbol symbol of the stock
     * @param name name of the stock
     * @param price price of the stock
     * Stock constructor with 3 parameters
     */
    public Stock(String symbol, String name, double price) {
        this.symbol=symbol;
        this.name=name;
        this.price=price;
        this.shareBalance=STARTBALANCE;
    }
    
        /*
     * @param symbol symbol of the stock
     * @param name name of the stock
     * @param price price of the stock
     * @param shareBalance shareBalance of the stock
     * Stock constructor with 4 parameters
     */
    public Stock(String symbol, String name, double price,int shareBalance) {
        this.symbol=symbol;
        this.name=name;
        this.price=price;
        this.shareBalance=shareBalance;
    }
    

    

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    public static int getSTARTBALANCE() {
        return STARTBALANCE;
    }
    
    
    
    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public synchronized void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the shareBalance
     */
    public synchronized int  getShareBalance() {
        return shareBalance;
    }

    /**
     * @param shareBalance the shareBalance to set
     */
    public synchronized void setShareBalance(int shareBalance) {
        this.shareBalance = shareBalance;
    }
          
    @Override
    public String toString(){
        
        return (this.getSymbol()+","+this.getName()+","+Double.toString(this.getPrice())+","+Integer.toString(this.getShareBalance()));
    }
    
}