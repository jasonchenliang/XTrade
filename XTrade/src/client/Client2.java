


package client;

/**
 *
 * @author chenliang
 */
import api.XTradeAPI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.ConnectException;
import java.rmi.registry.*;

public class Client2 {
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;

    public static void main(String[] args)  throws Exception{
        
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
        //new XTradeAPI instance 
        XTradeAPI remoteXTrade = (XTradeAPI) registry.lookup(XTradeAPI.class.getSimpleName());
        
        System.out.println(remoteXTrade.hello()+": 2");
        
        
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
                System.out.println("Client2 Command List:\n1. buy symbol stock_num"
                    + "\n2. sell symbol stock_num\n3. query symbol\n"
                    + "4. queryRecord symbol\n5. man(show the commands)\n6. quit");
        
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
                 System.out.println("Client2 Command List:\n1. buy symbol stock_num"
                    + "\n2. sell symbol stock_num\n3. query symbol\n"
                    + "4. queryRecord symbol\n5. man\n6. quit");
            }
            else if(Com.length == 2 && Com[0].equalsIgnoreCase("query")){
                System.out.println(remoteXTrade.queryStock(Com[1]));
            }
            else if(Com.length == 2 && Com[0].equalsIgnoreCase("queryRecord")){
                System.out.println(remoteXTrade.queryRecord(loginCom[1],Com[1]));
            }
            else if(Com.length == 3 && Com[0].equalsIgnoreCase("buy")){
                try{
                    int buy_shares = Integer.parseInt(Com[2]);
                    System.out.println(remoteXTrade.buy(Com[1],loginCom[1], buy_shares));
                }
                catch(NumberFormatException e){
                    System.out.println("Invalid price!");
                    
                } 
                
            }
            else if(Com.length == 3 && Com[0].equalsIgnoreCase("sell")){
                try{
                    int sell_shares = Integer.parseInt(Com[2]);
                    System.out.println(remoteXTrade.sell(Com[1],loginCom[1], sell_shares));
                }
                catch(NumberFormatException e){
                    System.out.println("Invalid Share Number!");
                    
                } 
            }
            else
            {
                System.out.println("Syntax error");
            }
        }
        
    }
}
