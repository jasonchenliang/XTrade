package client;

/**
 *
 * @author chenliang
 */
import api.XTradeAPI;
import java.io.*;
import java.rmi.registry.*;
import java.util.Scanner;

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
            System.out.println("Pleaese login:");
        
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
                System.out.println("Hints: client1 \n1. update symbol price\n2. query symbol"
                + "\n3. queryUser username\n4. man(show the commands)\n5. quit");
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
                 System.out.println("Hints: client1 \n1. update symbol price\n2. query symbol"
                + "\n3. queryUser username\n4. man(show the commands)\n5. quit");
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
                    System.out.println(remoteXTrade.update(Com[1], price));
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



