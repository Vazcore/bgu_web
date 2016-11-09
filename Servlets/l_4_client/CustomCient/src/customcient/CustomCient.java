/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author USER
 */
public class CustomCient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("http://localhost:8088/?param=Morgen");
        URLConnection conn = url.openConnection();
        String websiteAddress = url.getHost();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length","" + Integer.toString("param=Morgen".getBytes().length));
        conn.setUseCaches(false);
        Socket clientSocket = new Socket(websiteAddress, 8088);
        BufferedReader in= new BufferedReader (new InputStreamReader(conn.getInputStream()));
        String str;

        while(true)
        {
            str=in.readLine();
            break;
        }

        in.close();
        System.out.println("got from server: "+str);
        clientSocket.close();
    }
    
}
