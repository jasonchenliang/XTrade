/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockData;

import object.Stock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class StockDataTest {
    
    public StockDataTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class StockData.
     */
    

    /**
     * Test of printStockList method, of class StockData.
     */
    

    /**
     * Test of refreshSingle method, of class StockData.
     */
    @Test
    public void testRefreshSingle() throws Exception {
        System.out.println("refreshSingle");
        String stockSymbol = "goog";
        StockData instance = StockData.getInstance();
       
        Stock result = instance.refreshSingle(stockSymbol);
//        System.out.println(result);
    }

    /**
     * Test of populateListfromFile method, of class StockData.
     */
    @Test
    public void testPopulateListfromFile() {
        System.out.println("populateListfromFile");
        StockData instance = StockData.getInstance();
        instance.populateListfromFile();
        instance.printStockList();
    }
}