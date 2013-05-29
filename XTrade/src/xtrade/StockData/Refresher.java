/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xtrade.StockData;

/**
 *
 * @author Terry Liu
 * 
 * Under construction
 */ 
import java.net.*;
import java.io.*;

public class Refresher {
    public void refresh() throws Exception{
        URL oracle = new URL("http://finance.yahoo.com/d/quotes.csv?s=goog&f=sl1d1t1c1ohgv&e=.csv");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();   
    
}
}


