/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.utils;

import by.bsu.ibmt.group115po.gabrusev.models.God;
import by.bsu.ibmt.group115po.gabrusev.models.Power;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Aliaksei_Habruseu
 */
public class Saver {
    
    public static void save(Object obj, String filename) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.close();
    }
    
    public static Object load(String  filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readObject();        
        ois.close();
        return obj;
    }
    
    public static void serialize(Object obj, String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeUTF(obj.toString());
        oos.close();
    }
    
    public static Object createObject(String str) {
        String[] types = str.split(";");
        Map<String, String> map = new HashMap<String, String>();        
        String[] propval = new String[2];
        Object obj = null;
        for (int i = 0; i < types.length; i++) {
            propval = types[i].split(":");
            map.put(propval[0], propval[1]);
        }
        
        if (map.get("class") == "God") {
            Power power = new Power(map.get("power"),  Integer.parseInt(map.get("power_value")));
            obj = new God(map.get("name"), Integer.parseInt(map.get("age")), power, Integer.parseInt(map.get("points")));
        }
        
        return obj;
    }
    
    public static Object deserialize(String fileName) throws IOException,
            ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        String str = ois.readUTF();        
        ois.close();
        return createObject(str);
    }
}
