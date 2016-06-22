/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev;

import by.bsu.ibmt.group115po.gabrusev.utils.MLogger;
import by.bsu.ibmt.group115po.gabrusev.utils.Saver;
import controllers.GameBehaviour;
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
        
        
        //Saver.loadInts("rels.bin");
    }
    
}
