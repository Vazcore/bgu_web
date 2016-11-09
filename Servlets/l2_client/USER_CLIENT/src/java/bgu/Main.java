/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bgu;

import javax.ejb.EJB;




/**
 *
 * @author vazco
 */
public class Main {

    @EJB
    private static EJB_MODULERemote eJB_MODULE;
    
    public static void main(String[] args) {
        //System.out.println("Hola");
        System.out.println(eJB_MODULE.getUserInfo("Ivanov"));
        
        eJB_MODULE.addStudent("Habruseu", "IBMT", "pv1_15po");
        eJB_MODULE.deleteStud("Ivanov");
        
        System.out.println(eJB_MODULE.getUserInfo("Habruseu"));
    }
    
}
