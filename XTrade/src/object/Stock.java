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
  
    /*
     * Stock constructor without parameter
     */
    public Stock()
    {
        
    }

    /*
     * @param newName name of the stock
     * @param newPrice price of the stock
     * Stock constructor with parameters
     */
    public Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
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
    
    public String toString(){
        
        return (this.symbol+","+this.name+","+Double.toString(this.price));
    }
          
            

    
}
