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

/**
 *
 * @author vazco
 */
@WebService(serviceName = "DatabaseService")
public class DatabaseService {
    
    private static Connection conn = null;
    private static Statement stmt = null;
    private static String dbURL ="jdbc:derby://localhost:1527/bgu;user=alex;password=1234";
    private static String tableName = "users";    

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAge")
    public ArrayList<String> getSmartPeopleNames(@WebParam(name = "age") int age) {
        ArrayList<String> names = new ArrayList<String>();        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName + " where age=" + age + " and mark > 4");
            while(results.next()) {
                System.out.println(results.getString(2));
                //names.add(dbURL)
            }
            conn.close();
            stmt.close();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return names;
    }
}
