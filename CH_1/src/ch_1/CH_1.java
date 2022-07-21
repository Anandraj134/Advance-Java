/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ch_1;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author anand
 */
public class CH_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        try {
            InetAddress ip = InetAddress.getByName("www.google.com");
            System.out.println("The Host Address is " + ip.getHostAddress());
            System.out.println("The Host name is " + ip.getHostName());

        } catch (UnknownHostException ue) {
            System.out.println("Website not found");
        }
    }

}
