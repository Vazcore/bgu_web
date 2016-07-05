/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.models;

import by.bsu.ibmt.group115po.gabrusev.controllers.GameBehaviour;
import by.bsu.ibmt.group115po.gabrusev.models.interfaces.HumanBehavior;
import by.bsu.ibmt.group115po.gabrusev.utils.MLogger;

/**
 *
 * @author USER
 */
public class Human extends HumanEntity implements Runnable{
    
    public int time = 2000;
    public final int rel = 2;
    
    public Human(String name, int age, String city, float money, int spirit, HumanBehavior bh)
    {
        super(name, age, city, money, spirit);
        this.setBehavior(bh);
    }
    
    @Override
    public void introduce()
    {
        MLogger.info("Hey, " + this.getName() + " is here, poor farmer from " + this.getCity());
    }   


    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while((System.currentTimeMillis() - startTime) < this.time)
        {
            this.pray(this.getGod());            
        }        
    }

    @Override
    public String toString() {
        return "" + this.rel;
    }
    
    
}
