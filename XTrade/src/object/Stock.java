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
     * Stock constructor with parameters
     */
    public Stock(String symbol, String name, double price) {
        this.symbol=symbol;
        this.name=name;
        this.price=price;
        this.shareBalance=STARTBALANCE;
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
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the shareBalance
     */
    public int getShareBalance() {
        return shareBalance;
    }

    /**
     * @param shareBalance the shareBalance to set
     */
    public void setShareBalance(int shareBalance) {
        this.shareBalance = shareBalance;
    }
          
    @Override
    public String toString(){
        
        return (this.getSymbol()+","+this.getName()+","+Double.toString(this.getPrice())+","+Integer.toString(this.getShareBalance()));
    }
    
}