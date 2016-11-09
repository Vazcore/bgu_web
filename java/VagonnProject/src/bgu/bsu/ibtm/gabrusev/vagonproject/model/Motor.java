/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bgu.bsu.ibtm.gabrusev.vagonproject.model;

/**
 *
 * @author USER
 */
public class Motor {
    private String type = "parovoi";
    private int power;
    private boolean running = false;
    
    public Motor(String t, int p)
    {
        this.type = t;
        this.power = p;
    }
    
    public Motor(int p)
    {
        this.power = p;
    }
    
    public boolean on()
    {
        this.running = true;
        return this.running;
    }
    
    public boolean off()
    {
        this.running = false;
        return this.running;
    }
    
}
