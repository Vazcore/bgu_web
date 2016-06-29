/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.models;

import by.bsu.ibmt.group115po.gabrusev.controllers.GameBehaviour;
import by.bsu.ibmt.group115po.gabrusev.utils.MLogger;

/**
 *
 * @author USER
 */
public class Human extends HumanEntity implements Runnable{
    
    public Human(String name, int age, String city, float money, int spirit)
    {
        super(name, age, city, money, spirit);
    }
    
    public void introduce()
    {
        MLogger.info("Hey, " + this.getName() + " is here, poor farmer from " + this.getCity());
    }   


    @Override
    public void run() {
        Fortune f = Fortune.instance;
        while(GameBehaviour.game_running)
        {
            this.pray(this.getGod());            
        }        
    }
    
    
    
}
