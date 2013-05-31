
package stockData;

/**
 *
 * @author Terry Liu
 * 
 * Under construction
 */ 
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import object.Stock;

public class StockData {
    private static final StockData instance = new StockData();
    private static final String stockFile="c:/stock.csv";
    private static final String userFile="user.csv";
    private ArrayList<Stock> stockList = new ArrayList<>();
    
    private StockData() {}
 
    public static StockData getInstance() {
        return instance;
    }
    
    private Stock getStockfromCSV(String inputline) {
        Stock newStock = null;
        if (inputline != null) {
            String[] stockString = inputline.split(",");

            if (stockString != null) {
                if (stockString.length == 3) {
                    Double price = Double.parseDouble(stockString[2]);

                    if (!(stockString[0].equalsIgnoreCase(stockString[1]) && 
price == 0.0)) {
                        newStock = new Stock(stockString[0], stockString[1], 
price);
                    }
                }
            }

        }
        return newStock;
    }
    
    public void printStockList()
    {
        System.out.println(stockList.size());
        for (Stock s:stockList)
        {
            System.out.println(s);
        }
    }
    
    
    public Stock refreshSingle(String stockSymbol) throws Exception {
        Stock newStock = null;
        URL oracle = new URL("http://finance.yahoo.com/d/quotes.csv?s=" + 
stockSymbol + "&f=snl1&e=.csv");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        if ((inputLine = in.readLine()) != null) {
            newStock = getStockfromCSV(inputLine);
        }
        return newStock;
    }
    
    public void populateListfromFile()
    {
        String csvFile = stockFile;
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
 	boolean arrayEmptied=false;
        Stock tempStock=null;
        try {
 
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
                if (!arrayEmptied)
                {
                    stockList.clear();
                    arrayEmptied=true;
                }
		if ((tempStock = getStockfromCSV(line))!=null)
                  stockList.add(tempStock);
                
		}
 
	} catch (FileNotFoundException e) {
		System.out.println("File not found!");
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    }
}


