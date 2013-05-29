package xtrade;

/**
 *
 * @author chenliang
 */
public class Stock {
    
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
    public Stock(String newName, double newPrice)
    {
         this.setName(newName);
         this.setPrice(newPrice);
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
    
}
