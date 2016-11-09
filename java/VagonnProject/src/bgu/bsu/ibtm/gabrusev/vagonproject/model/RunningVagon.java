/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bgu.bsu.ibtm.gabrusev.vagonproject.model;

import bgu.bsu.ibtm.gabrusev.vagonproject.view.Dispetcher;

/**
 *
 * @author USER
 */
public class RunningVagon extends Vagon{
    public int inner_type = 2;
    private final int max_speed;
    private Motor motor;
    private boolean moving = false;
    
    public RunningVagon(int n, double w, int speed, Motor m) 
    {
        super(n, w);
        this.max_speed = speed;
        this.motor = m;
    }
    
    public RunningVagon(int n, double w) 
    {
        super(n, w);
        this.max_speed = 0;
        this.motor = null;
    }
    
    public boolean start()
    {
        if (this.motor == null)
        {
            Dispetcher.inform("You cant run vagon without motor, silly!!!");
            return false;
        }
        this.moving = true;
        return this.moving;
    }
    
    public boolean stop()
    {
        this.moving = false;
        return this.moving;
    }
    
    public int getMaxSpeed()
    {
        return this.max_speed;
    }

    @Override
    public String toString() {
        return "" + this.getNumber();
    }
    
    
}
