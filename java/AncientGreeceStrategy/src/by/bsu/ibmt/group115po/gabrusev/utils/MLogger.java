/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.utils;

import java.util.Date;
import javax.sound.midi.Soundbank;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/**
 *
 * @author Alexey
 */
public class MLogger {
    
    private static Logger logger = Logger.getRootLogger();    
    
    public static void setLevel(String type) {
        BasicConfigurator.configure();
        Level lvl = null;
        if (type == "info")
          lvl = Level.INFO;
        else if (type == "warning")
            lvl = Level.WARN;
        else if (type == "debug")
            lvl = Level.DEBUG;
        else
            lvl = Level.INFO;
        logger.setLevel(lvl);
    }
    
    public static void log(String who, String text)
    {        
        System.out.println("Log #" + System.currentTimeMillis());
        String log = who + " say: \n" + text;
        System.out.println(log);        
        System.out.println("===================================");
        logger.warn(log);
    }
    
    public static void info(String info) {
        System.out.println("Info Log:");
        System.out.println(info);
        System.out.println("===================================");        
        logger.info(info);
    }
    
    public static void debug(String text) {
        System.out.println("===================================");
        logger.debug(text);
    }
}
