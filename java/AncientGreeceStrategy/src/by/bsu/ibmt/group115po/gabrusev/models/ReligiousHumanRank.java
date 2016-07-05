/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.models;

import by.bsu.ibmt.group115po.gabrusev.models.interfaces.HumanBehavior;
import by.bsu.ibmt.group115po.gabrusev.utils.MLogger;
import java.io.Serializable;

/**
 *
 * @author USER
 */
public class ReligiousHumanRank implements HumanBehavior, Serializable{
  
    private GodEntity god = null;
    
    @Override
    public boolean pray(HumanEntity self, GodEntity god) {
        Fortune f = Fortune.instance;
        int points = f.getIntFortune();
        if (points % 2 == 0)
        {
            MLogger.log(self.getName(), "Uaaa. I've got " + points + " for spirit");
            self.setSpirit(points);
        }
        else
        {
            MLogger.log(self.getName(), "Uaaa. I've got " + points + " for money");
            self.setMoney(points);
        }
        return true;
    }

    @Override
    public GodEntity getGod() {        
        return god;
    }

    @Override
    public void gatherTax(HumanEntity self, Fortune f) {
        MLogger.info("I am not religious. I dont believe in gods");
        self.setMoney(0);
    }

    @Override
    public GodEntity setGod(GodEntity god) {
        MLogger.info("Now I believe in god - " + god.getName());
        this.god = god;
        return god;
    }
    
    
}
