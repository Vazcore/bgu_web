/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_client;

import bgu.EJB_MODULERemote;
import javax.ejb.EJB;



/**
 *
 * @author vazco
 */
public class Main {

    @EJB
    private static EJB_MODULERemote eJB_MODULE;


    
    /**
     * @param args the command line arguments
     */
    @EJB(mappedName="EJB_MODULERemote")
    public static void main(String[] args) {
        System.out.println("Hola");
    }
    
}
