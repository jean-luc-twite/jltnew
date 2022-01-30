/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package orderpcapp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class OrderPcApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declare variable
          InetAddress addr =null;
        Socket socket =null;
        PrintWriter out = null;
        int option;
        String data=null,op ;
        //
        try{
            // create the adress
            addr = InetAddress.getLocalHost();
            System.out.println("address is :" + addr);
            //create the socket
            socket = new Socket(addr,9191);
            System.out.println("connected.." + socket);
            //create the streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            //call and invoke method get menus
            option = getOption();
            while(option != 4){
                switch(option){
                    case 1:
                        data ="A";
                        //CONATINATE
                        data = data + "#" + "1";
                        break;
                    case 2:
                        data ="B";
                        //CONATINATE
                        data = data + "#" + "2";

                        break;
                    case 3:
                        data ="C";
                        //CONATINATE
                      data = data + "#" + "3";

                        break;
                    default:
                        System.out.println( option + " is invalid ");
                }
                //send data to payment
                out.println(data);
               
                //display option again
                option = getOption();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                System.out.println("closing the Order...");
                socket.close();
            }catch(Exception ex ){
                ex.printStackTrace();
            }
        }
    }

    private static int getOption() {
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.println("please place the orders belows " + "\n" +
                "--------------------------------" + "\n" +
                "press 1--> for A" + "\n" +
                "press 2--> for B" + "\n" +
                "press 3--> for C" + "\n" +
                "press 4--> to exit the program" + "\n" +
                "your order?");
        option = sc.nextInt();

        return option;
    }
    
}
