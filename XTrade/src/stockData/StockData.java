
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
import java.util.logging.Level;
import java.util.logging.Logger;
import object.*;

public class StockData {
    private static final StockData instance = new StockData();
    private static final String STOCKFILE="resource/stock.csv";
    private static final String USERFILE="resource/user.csv";
    private static final String RECORDFILE="resource/record.csv";
    private ArrayList<Stock> stockList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Record> recordList = new ArrayList<>();
    
    
    private StockData() {}
 
    public static StockData getInstance() {
        return instance;
    }

    public ArrayList<Stock> getStockList() {
        return stockList;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public ArrayList<Record> getRecordList() {
        return recordList;
    }
    
    
    
    
    private Stock getStockfromCSV(String inputline) {
        Stock newStock = null;
        if (inputline != null) {
            String[] stockString = inputline.split(",");

            if (stockString != null) {
                if (stockString.length == 4) {
                    Double price = Double.parseDouble(stockString[2]);
                    int qty = Integer.parseInt(stockString[3]);
                    if (!(stockString[0].equalsIgnoreCase(stockString[1])
                            && price == 0.0)) {
                        newStock = new Stock(stockString[0], stockString[1],
                                price, qty);
                    }
                }
            }

        }
        return newStock;
    }
    
     private User getUserfromCSV(String inputline) {
        User newUser = null;
        if (inputline != null) {
            String[] userString = inputline.split(",");

            if (userString != null) {
                if (userString.length == 2) {
                    Double balance = Double.parseDouble(userString[1]);
                    newUser = new User(userString[0], balance);
                }
            }
        }
        return newUser;
    }
       
     private Record getRecordfromCSV(String inputline) {
        Record newRecord = null;
        if (inputline != null) {
            
            String[] recordString = inputline.split(",");
           
            if (recordString != null) {
                if (recordString.length == 3) {
                    int share = Integer.parseInt(recordString[2]);
                    newRecord = new Record(recordString[0], recordString[1],share);
                }
            }
        }
        return newRecord;
    }
    
    
    public void printList() {
        System.out.println("stock list size:"+stockList.size());
        for (Stock s : stockList) {
            System.out.println(s);
        }
         System.out.println("user list size:"+userList.size());
        for (User u : userList) {
            System.out.println(u);
        }
         System.out.println("record list size:"+recordList.size());
        for (Record r : recordList) {
            System.out.println(r);
        }
    }

    public Stock querybyurl(String stockSymbol) {
        try {
            Stock newStock = null;
            URL oracle = new URL("http://finance.yahoo.com/d/quotes.csv?s="
                    + stockSymbol + "&f=snl1&e=.csv");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));

            String inputLine;

            if ((inputLine = in.readLine()) != null) {
                //decorate inputline with starting balance
                inputLine = inputLine + "," + Integer.toString(Stock.getSTARTBALANCE());
                newStock = getStockfromCSV(inputLine);
            }

            return newStock;
        } catch (MalformedURLException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
   
    public void save(){
        
    }
    
    public void load(){
        
    }
    
    public void populateStockList() {
        String csvFile = STOCKFILE;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        boolean arrayEmptied = false;
        Stock tempStock = null;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                if (!arrayEmptied) {
                    stockList.clear();
                    arrayEmptied = true;
                }
                if ((tempStock = getStockfromCSV(line)) != null) {
                    stockList.add(tempStock);
                }
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
    
    public void populateUserList() {
        String csvFile = USERFILE;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        boolean arrayEmptied = false;
        User tempUser = null;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                if (!arrayEmptied) {
                    userList.clear();
                    arrayEmptied = true;
                }
                if ((tempUser = getUserfromCSV(line)) != null) {
                    userList.add(tempUser);
                }
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
    
    
    public void populateRecordList() {
        String csvFile = RECORDFILE;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        boolean arrayEmptied = false;
        Record tempRecord = null;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                
                if (!arrayEmptied) {
                    recordList.clear();
                    arrayEmptied = true;
                }
                if ((tempRecord = getRecordfromCSV(line)) != null) {
                    recordList.add(tempRecord);
                    
                }
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


