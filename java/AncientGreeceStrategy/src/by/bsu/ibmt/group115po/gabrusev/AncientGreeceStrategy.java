/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev;

import by.bsu.ibmt.group115po.gabrusev.controllers.EntityContainer;
import by.bsu.ibmt.group115po.gabrusev.utils.MLogger;
import by.bsu.ibmt.group115po.gabrusev.utils.Saver;
import by.bsu.ibmt.group115po.gabrusev.controllers.GameBehaviour;
import by.bsu.ibmt.group115po.gabrusev.models.Human;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexey
 */
public class AncientGreeceStrategy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        // Setting logger Level
        MLogger.setLevel("debug");   
        GameBehaviour.coreInit();
        
//       List<Object> objs = new ArrayList<Object>();    
//       List<Integer> relations = new ArrayList<Integer>();
//       Saver.load(objs, relations);
//       EntityContainer.updateData(objs, relations);       
//        //System.out.println(relations);
//       List<Integer> human_ids = EntityContainer.getEntityIds(EntityContainer.human_rels);
//       Human h = (Human)EntityContainer.getHuman(2);
//        System.out.println(EntityContainer.getHumanClassId(0));
        
    }
    
}
