/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bgu;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author vazco
 */

public class WebDbClient {

    public static void main(String[] args) {
        DatabaseService service = new DatabaseService();        
        
        ArrayList<String> names = service.getSmartPeopleNames(25);
        for (int i =0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
        
    }
    
}
