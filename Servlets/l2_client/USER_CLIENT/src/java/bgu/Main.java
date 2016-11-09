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
    private static NewSessionBeanRemote newSessionBean;

    
    
    public static void main(String[] args) {
        //System.out.println("Hola");
        System.out.println(newSessionBean.getUserInfo("Ivanov"));        
        newSessionBean.addStudent("Habruseu", "IBMT", "pv1_15po");
        newSessionBean.deleteStud("Ivanov");
        
        System.out.println(newSessionBean.getUserInfo("Habruseu"));
    }
    
}
