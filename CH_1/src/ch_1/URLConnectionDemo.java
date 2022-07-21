/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch_1;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author anand
 */
public class URLConnectionDemo {
    public static void main(String args[]) throws MalformedURLException, IOException{
        URL obj = new URL("https://www.gtu.ac.in/");
        URLConnection conn = obj.openConnection();
        int l = conn.getContentLength();
        System.out.println("Length of content :- " + l);
        if(l ==0){
            System.out.println("Content not available");
            return;
        }
        else{
            int ch;
            InputStream in = conn.getInputStream();
            while((ch = in.read()) != -1)
                System.out.print((char)ch);
        }
        
    }
    
}
