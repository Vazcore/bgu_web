/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bgu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.ejb.Stateless;

/**
 *
 * @author vazco
 */
@Stateless
public class EJB_MODULE implements EJB_MODULERemote {
    
    private static final long serialVersionUID = 1L;
    
    private String fio;
    private String department;
    private String group;
    
    private static final ArrayList<User> users = new ArrayList<User>(Arrays.asList(
        new User("ivanov", "Marketing", "10"),
        new User("petrov", "Marketing", "10"),
        new User("sidorov", "Professor", "12"),
        new User("mishin", "Smith", "12"),
        new User("vasin", "Programmer", "14")
    ));
    
    @Override
    public String getUserInfo(String fio) {
        String res = "";
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
            User user = iterator.next();
            String name = user.getFio();
            if (name.equals(fio)) {
                res += user.getDepartment() + " " + user.getGroup() + "\n";
            }
        }
        return res;
    }

    @Override
    public String addStudent(String fio, String department, String group) {
        User student = new User(fio, department, group);
        users.add(student);
        return null;
    }

    @Override
    public String deleteStud(String fio) {

        for (Iterator<User> it =
                users.iterator(); it.hasNext();) {
            User st = it.next();
            String name = st.getFio();
            if (name.equals(fio)) {
                users.remove(st);
                break;
            }
        }
        return null;
    }
}
