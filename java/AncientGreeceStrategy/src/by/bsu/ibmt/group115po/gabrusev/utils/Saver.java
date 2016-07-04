/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.utils;

import by.bsu.ibmt.group115po.gabrusev.models.God;
import by.bsu.ibmt.group115po.gabrusev.models.Power;
import by.bsu.ibmt.group115po.gabrusev.models.SupremeGod;
import by.bsu.ibmt.group115po.gabrusev.controllers.GameBehaviour;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Aliaksei_Habruseu
 */
public class Saver {
    
    private static String f_data = "data.bin";
    private static String f_rels = "rels.bin";    
    
    public static void save(List<Object> objs, List<Integer> relations) throws FileNotFoundException, IOException {
        saveData(objs, f_data);        
        saveInt(relations, f_rels);
    }
    
    public static boolean saveData(List<Object> objs, String filename) throws FileNotFoundException, IOException 
    {
        FileOutputStream fos = new FileOutputStream(filename);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        for (int i = 0; i < objs.size(); i++) {
            oos.writeObject(objs.get(i));
        }        
        oos.close();
        MLogger.info("Total object were saved: " + objs.size());
        return true;
    }
    
    public static boolean saveInt(List<Integer> objs, String filename) throws FileNotFoundException, IOException 
    {        
        FileOutputStream fos = new FileOutputStream(filename);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        for (int i = 0; i < objs.size(); i++) {
            oos.writeInt(objs.get(i));
        }        
        oos.close();
        return true;
    }
    
    public static String[] getRelations()
    {
        String[] relations = new String[5];
        relations[0] = "God";
        relations[1] = "SupremeGod";
        relations[2] = "Human";
        relations[3] = "ReligiousHuman";
        relations[4] = "OraculHuman";
        
        return relations;
    }
    
    public static List<Integer> loadRelations(List<Integer>relations) throws FileNotFoundException, IOException
    {
        FileInputStream fis = new FileInputStream(f_rels);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        int id;
        
        try 
        {
            while(true) 
            {
                id = ois.readInt();                
                relations.add(id);                 
            }
        } catch(EOFException e) {
            ois.close();
            return relations;
        } catch(Exception e) {
            System.err.println(e);
        }
        
        return relations;
    }
    
    public static void loadInts(String filename) throws FileNotFoundException, IOException
    {
        FileInputStream fis = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        
        try 
        {
            while(true) 
            {
                System.out.println(ois.readInt());
            }
        } catch(EOFException e) {
            ois.close();
        } catch(Exception e) {
            System.err.println(e);
        } 
    }
    
    public static boolean load(List<Object>objs, List<Integer>relations) throws FileNotFoundException, IOException, ClassNotFoundException {        
        FileInputStream fis = new FileInputStream(f_data);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);      
        Object obj = null;
        try {
            while (true) {       
                obj = ois.readObject();
                objs.add(obj);
            }
        } catch(EOFException e) {
            ois.close();
        } catch(IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
        return true;
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
    
    public static boolean removeData() 
    {
        removeFile(f_data);
        removeFile(f_rels);
        return true;
    }
    
    public static boolean removeFile(String filename) 
    {        
        try
        {
            File file = new File(filename);
            return (file.delete());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
