/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.models;

import java.util.Random;

/**
 *
 * @author USER
 */
public class Fortune {
    
    public static Fortune instance = new Fortune();
    public static Random rand = new Random();
    
    private Fortune() {}
    
    public synchronized int getIntFortune(GodEntity god)
    {
        return rand.nextInt((1000 - 0) + 1) + 0;
    }
}
