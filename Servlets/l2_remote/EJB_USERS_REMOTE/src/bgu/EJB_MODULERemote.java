/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bgu;



/**
 *
 * @author vazco
 */
@Remote
public interface EJB_MODULERemote {
    String getUserInfo(String fio);
    String addStudent(String fio, String department, String group);
    String deleteStud(String fio);
}
