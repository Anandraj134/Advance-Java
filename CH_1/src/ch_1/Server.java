/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch_1;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author anand
 */
public class Server {
    public static void main(String args[]) throws Exception{
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("Waiting for Connection......");
        Socket s = ss.accept();
        System.out.println("Connection Established");
        
        PrintStream printSocket = new PrintStream(s.getOutputStream());
        Scanner kbscanner = new Scanner(System.in);
        Scanner socketScanner = new Scanner(s.getInputStream());
        String clientStr, kbstr;
        
        while(true)
        {
            clientStr = socketScanner.nextLine();
            if(clientStr.equals("exit"))
                break;
            System.out.println("Message from client :- " + clientStr);
            kbstr = kbscanner.nextLine();
            printSocket.println(kbstr);
        }
        
        ss.close();
        s.close();
        kbscanner.close();
        socketScanner.close();
        printSocket.close();
    }
}
