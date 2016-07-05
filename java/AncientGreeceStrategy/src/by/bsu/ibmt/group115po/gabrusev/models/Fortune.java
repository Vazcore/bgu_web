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
    
    private Fortune() {}
    
    public int getIntFortune()
    {
        Random rand = new Random();
        return rand.nextInt((1000 - 0) + 1) + 0;
    }
    
    public int initStream(HumanEntity human, GodEntity god)
    {        
        return god.getPoints();
    }
}
