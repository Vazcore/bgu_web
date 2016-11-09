/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customserver;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executors;

/**
 *
 * @author USER
 */
public class CustomServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InetSocketAddress addr = new InetSocketAddress(8088);
        HttpServer server = HttpServer.create(addr, 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
        System.out.println("Server is listening on port 8088" );
    }   
    
}

class Param {
    String param;
    String value;

    public Param(String param, String value) {
        this.param = param;
        this.value = value;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}


class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.set("Content-Type", "text/html");
        exchange.sendResponseHeaders(200, 0);
        
        // URI
        URI requestedUri = exchange.getRequestURI();
        String query = requestedUri.getRawQuery();
        
        ArrayList<Param> allParams = new ArrayList<Param>();
        
        String param[]=null;
        if (query != null) {
            String pairs[] = query.split("[&]");
            for (String pair : pairs) {
                param = pair.split("[=]");
                allParams.add(new Param(param[0], param[1]));
            }
        }       
        
        String s = "<html><head><title>My WebSite</title></head><body><div><img width='200px' src='http://www.vectorsland.com/imgd/l12866-java-eps-logo-99090.png'></div>";
        s += "Welcome!";
        if(allParams.size() > 0 && this.findParamByName("name", allParams) != null)
        {
            s += "<h1 style='color: green'> Guten Morgen, sir!</h1><p>Age:"+param[1]+"</p>";
        } 
        else if(this.findParamByName("speed", allParams) != null && this.findParamByName("time", allParams) != null) {
            String speedString = this.findParamByName("speed", allParams).value;
            String timeString = this.findParamByName("time", allParams).value; 
            double speed  = Double.parseDouble(speedString) * Double.parseDouble(timeString);
            s += "<h3>Distance: "+  speed  +" km per hour</h3>";
        }
        else if (this.findParamByName("create_page", allParams) != null) {
            this.createWebPage(this.findParamByName("create_page", allParams).value, "Some text");
        }
        else if(this.findParamByName("read_page", allParams) != null) {
            s = this.readFile(this.findParamByName("read_page", allParams).value + ".html");
        }
        else {
            s += "<h1>Current date:</h1> " +(new Date());        
        }         
        s += "</body></html>";
        OutputStream responseBody = exchange.getResponseBody();
        
        
        responseBody.write(s.getBytes());
        responseBody.close();
    }
    
    public Param findParamByName(String name, ArrayList<Param> params) {
        for (int i = 0; i < params.size(); i++) {
            if (params.get(i).param.equals(name)) return params.get(i);
        }
        return null;
    }
    
    public boolean createWebPage(String filename, String body) {
        try{
            PrintWriter writer = new PrintWriter(filename + ".html", "UTF-8");
            writer.println("<!DOCTYPE html>");
            writer.println("<html><head><title>Page</title></head><body>");
            writer.println(body);
            writer.println("</body></html>");
            writer.close();
            return true;
        } catch (Exception e) {
           return false;
        }
    }
    
    public String readFile(String filename) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String line;
        String res = "";
        while((line = in.readLine()) != null)
        {
            res += line;
        }
        in.close();
        return res;
    }
}
