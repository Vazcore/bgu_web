/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bgu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author Aliaksei_Habruseu
 */
@WebService(serviceName = "TranslateServise")
public class TranslateServise {
    
    private static Connection conn = null;
    private static Statement stmt = null;
    private static String dbURL ="jdbc:derby://localhost:1527/dictionary;user=alex;password=1234";
    private static String tableName = "translations";

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllWords")
    public ArrayList<String> getAllWords(@WebParam(name = "close") Boolean close) throws Exception {
        ArrayList<String> words = new ArrayList<String>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            int id = 1;
            while (results.next()) {
                words.add(id + "-" +results.getString("word") + "-" + results.getString("trans"));
            }
            if (close) {
                conn.close();
                stmt.close();
            }
        } catch(Exception ex) { System.out.println(ex.getMessage()); throw ex;}
        return words;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addWord")
    public Boolean addWord(@WebParam(name = "word") String word, @WebParam(name = "trans") String trans) {        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

            int id = this.getAllWords(false).size() + 1;            
            String query = "insert into " + tableName + " VALUES ("+id+",'"+word+"','"+trans+"')";            
            if (this.stmt == null) {
                conn = DriverManager.getConnection(dbURL);
                stmt = conn.createStatement();
            }
            boolean res = (this.stmt.executeUpdate(query) == 1);
            
            this.conn.close();
            this.stmt.close();
            
            return res;
            //return results == 1;
        } catch(Exception ex) { return false;  }        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "translate")
    public String translate(@WebParam(name = "word") String word) {
        
         try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

            int id = this.getAllWords(false).size() + 1;            
            String query = "select trans from " + tableName + " WHERE word=" + "'"+word+"'";            
            if (this.stmt == null) {
                conn = DriverManager.getConnection(dbURL);
                stmt = conn.createStatement();
            }
               
            ResultSet result = this.stmt.executeQuery(query);
            String trans;
            if (result.next()) trans = result.getString("trans");            
            else trans = " Unknown. Try to add this new word!";
            this.conn.close();
            this.stmt.close();
            
            return trans;
            //return results == 1;
        } catch(Exception ex) { return ex.getMessage();  }   
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getValutaList")
    public ArrayList<String> getValutaList() {
        ArrayList<String> valutas = new ArrayList<String>();            
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            String query = "select * from valuta";            
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
               
            ResultSet result = this.stmt.executeQuery(query);            
            while(result.next()) {
                valutas.add(result.getString("type"));
            }            
            this.conn.close();
            this.stmt.close();
            
            return valutas;
            //return results == 1;
        } catch(Exception ex) { return valutas;  }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getValuta")
    public double getValuta(@WebParam(name = "type") String type) {
        double val = 0;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            String query = "select * from valuta where type='" + type+"'";            
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
            
            ResultSet result = this.stmt.executeQuery(query);            
            if(result.next()) {
                val = result.getDouble("value");
            }            
            this.conn.close();
            this.stmt.close();
            
            return val;
            //return results == 1;
        } catch(Exception ex) { return -1;  }
    }
    
    
    
    
    
    
    
    
}
