/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.utils;

import java.util.Date;
import javax.sound.midi.Soundbank;

/**
 *
 * @author Alexey
 */
public class Logger {
    public static void log(String who, String text)
    {
        System.out.println("Log #" + System.currentTimeMillis());
        System.out.println(who + " say: ");
        System.out.println(text);
        System.out.println("===================================");
    }
    
    public static void info(String info) {
        System.out.println("Info Log:");
        System.out.println(info);
        System.out.println("===================================");
    }
}
