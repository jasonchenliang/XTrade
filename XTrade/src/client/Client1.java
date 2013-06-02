package client;

/**
 *
 * @author chenliang
 */
import api.XTradeAPI;
import java.io.*;
import java.rmi.registry.*;
import java.util.Scanner;
import object.Stock;

public class Client1 {
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;
    private Scanner in ;
    
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws Exception {
        
        
       if (args.length == 0)
        {
            registry = LocateRegistry.getRegistry(HOST, PORT);
        }
        else if (args.length == 1)
        {
            registry = LocateRegistry.getRegistry(args[0], PORT);        
        }
        else
            System.out.println("you can only imput one arguments as server IP Address.");
        
       
            //System.out.println("the server Ip Address "+ HOST +"does not correct!" );
            
        
        //new XTradeAPI instance 
        
         XTradeAPI remoteXTrade = (XTradeAPI) registry.lookup(XTradeAPI.class.getSimpleName());
       
        System.out.println(remoteXTrade.hello()+": 1");
    
        boolean flag1 = true;
        boolean flag2 = true;
        String inputline = new String();
        String[] loginCom = new String[5];
        String[] Com = new String[5];
        
        
        while(flag1 == true){
            System.out.println("Client1, pleaese type command - user username - to login:");
        
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br= new BufferedReader(isr);
            inputline = br.readLine();
            loginCom = inputline.split(" ");
            if(loginCom.length == 1 && loginCom[0].equalsIgnoreCase("quit")){
                flag2 = false;
                flag1 = false;
            }
            else if(loginCom.length == 2 || "user".equals(loginCom[0])){
                System.out.println(remoteXTrade.login(loginCom[1]));
                System.out.println("\nClient1 Command List:"
                         + "\n> UPDATE <SYMBOL> <PRICE>"
                         + "\n   ---update the stock price"
                         + "\n> QUERYUSER <USERNAME>"
                         + "\n   ---Search the user balance"
                         + "\n> QUERY <SYMBOL>"
                         + "\n   ---search stock infomation"
                         + "\n> STOCKLIST [SYMBOL]"
                         + "\n   ---show all track stocks in market"
                         + "\n> MAN"
                         + "\n   ---show the command list"
                         + "\n> QUIT");
                
                flag1 = false;     
            }  
            else 
            {
                System.out.println("Syntax error (Hints: user ***)! OR type quit");
            }      
        }
        
        while(flag2 == true)
        {           
            System.out.print("\nXTrade > ");
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br= new BufferedReader(isr);
            inputline = br.readLine();
            Com = inputline.split(" ");            
            if(Com.length == 1 && Com[0].equalsIgnoreCase("quit")){
                flag2 = false;
            }
            else if(Com.length == 1 && Com[0].equalsIgnoreCase("man")){
                 
                System.out.println("\nClient1 Command List:"
                         + "\n> UPDATE <SYMBOL> <PRICE>"
                         + "\n   ---update the stock price"
                         + "\n> QUERYUSER <USERNAME>"
                         + "\n   ---Search the user balance"
                         + "\n> QUERY <SYMBOL>"
                         + "\n   ---search stock infomation"
                         + "\n> STOCKLIST [SYMBOL]"
                         + "\n   ---show all track stocks in market"
                         + "\n> MAN"
                         + "\n   ---show the command list"
                         + "\n> QUIT");                
            }
            else if(Com.length == 1 && Com[0].equalsIgnoreCase("stocklist")){
                for(Stock s:remoteXTrade.getAllStock())
                {
                    System.out.println(s.toString());
                }
            }
            else if(Com.length == 2 && Com[0].equalsIgnoreCase("query")){
                System.out.println(remoteXTrade.queryStock(Com[1]));
            }
            else if(Com.length == 2 && Com[0].equalsIgnoreCase("queryUser")){
                
                    System.out.println(remoteXTrade.queryUser(Com[1]));
                
            }
            else if(Com.length == 3 && Com[0].equalsIgnoreCase("update")){
                try{
                    Double price = Double.parseDouble(Com[2]);
                    if(price < 0)
                    {
                        System.out.println("The number you input cannot be negative!\n");
                    }
                    else
                    {
                        System.out.println(remoteXTrade.update(Com[1], price));
                    }
                }
                catch(NumberFormatException e){
                    System.out.println("Invalid price!");
                    
                } 
            }
            else
            {
                System.out.println("Syntax error");
            }
        }
        
        
    
    }
}



