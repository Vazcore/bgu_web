/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.models;

/**
 *
 * @author USER
 */
public class Fortune {
    
    public static Fortune instance = new Fortune();
    
    private Fortune() {}
    
    public  Fortune getIntFortune()
    {
        return this.instance;
    }
    
    public int initStream(HumanEntity human, GodEntity god)
    {        
        return god.getPoints();
    }
}
