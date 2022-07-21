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
public class Client {

    public static void main(String args[]) throws Exception {
//        Socket s = new Socket("192.168.137.223", 8888);
        Socket s = new Socket("localhost", 8888);

        PrintStream printSocket = new PrintStream(s.getOutputStream());
        Scanner kbscanner = new Scanner(System.in);
        Scanner socketScanner = new Scanner(s.getInputStream());
        String clientStr, kbstr;

        while (true) {
            kbstr = kbscanner.nextLine();
            printSocket.println(kbstr);
            if (kbstr.equals("exit")) {
                break;
            }
            clientStr = socketScanner.nextLine();
            System.out.println("Message from Server :- " + clientStr);
        }

        s.close();
        kbscanner.close();
        socketScanner.close();
        printSocket.close();
    }
}
