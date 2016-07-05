/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.controllers;

import by.bsu.ibmt.group115po.gabrusev.models.God;
import by.bsu.ibmt.group115po.gabrusev.models.GodEntity;
import by.bsu.ibmt.group115po.gabrusev.models.SupremeGod;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aliaksei_Habruseu
 */
public class EntityContainer {
    
    private static List<Object> objs = null;
    private static List<Integer> rels = null;
    private static List<Integer> gods_ids = null;
    private static List<Integer> human_ids = null;
    public static int[] god_rels = {0,1};
    public static int[] human_rels = {2};
    
    public static GodEntity current_god;
    public static int current_god_id;
    
    public static void updateData(List<Object> o, List<Integer> r)
    {
        objs = o;
        rels = r;
        gods_ids = getEntityIds(god_rels); 
        human_ids = getEntityIds(human_rels);
    }    
    
    
    public static List<Integer> getEntityIds(int[] entity_rels) 
    {       
        System.out.println(entity_rels.length);
        if (objs == null || rels == null) return null;        
        List<Integer> ids = new ArrayList<Integer>();        
        for (int i = 0; i < rels.size(); i++) {
            for (int j = 0; j < entity_rels.length; j++) {
                if (rels.get(i) == entity_rels[j])
                {
                    ids.add(i);
                    break;
                }
            }            
        }
        return ids;
    }
    
    public static int getClassId(int ch)
    {
        return rels.get(gods_ids.get(ch));
    }
    
    public static Object getGod(int ch)
    {
        return objs.get(gods_ids.get(ch));
    }
    
    public static Object getHuman(int ind)
    {
        return objs.get(ind);
    }
    
    public static int getHumanClassId(int ch)
    {
        return rels.get(human_ids.get(ch));
    }
    
    public static String[] getListNameOfGods() 
    {
       String[] names = new String[gods_ids.size()];
       
       int type;
        for (int i = 0; i < gods_ids.size(); i++) {
            type = rels.get(gods_ids.get(i));
            if (type == 0)
            {
                names[i] = ((God) objs.get(i)).getName();                
            }
            else {
                names[i] = ((SupremeGod) objs.get(i)).getName();                
            }
        }
        return names;
    }
    
}
