/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xtrade.StockData;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Swordghost
 */
public class RefresherTest {
    
    public RefresherTest() {
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
     * Test of refresh method, of class Refresher.
     */
    @Test
    public void testRefresh() throws Exception {
        System.out.println("refresh");
        Refresher instance = new Refresher();
        instance.refresh();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}