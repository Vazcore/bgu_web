/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bgu.bsu.ibtm.gabrusev.vagonproject.model;

/**
 *
 * @author USER
 */
public class Vagon {
    public int inner_type = 1;
    private int number;
    private final double weight;
    private boolean locked = true;
    
    public Vagon(int n, double w)
    {
        this.number = n;
        this.weight = w;                
    }
    
    public boolean lock()
    {
        this.locked = true;
        return this.locked;
    }
    
    public boolean unlock()
    {
        this.locked = false;
        return this.locked;
    }
    
    public int getNumber()
    {
        return this.getNumber();
    }
    
    public boolean isLocked()
    {
        return this.locked;
    }
    
    public double getWeight()
    {
        return this.weight;
    }
}
