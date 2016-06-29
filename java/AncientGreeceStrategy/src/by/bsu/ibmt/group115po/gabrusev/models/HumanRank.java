/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.models;

import by.bsu.ibmt.group115po.gabrusev.models.interfaces.HumanBehavior;
import by.bsu.ibmt.group115po.gabrusev.utils.MLogger;

/**
 *
 * @author USER
 */
public class HumanRank implements HumanBehavior{

    @Override
    public void pray(HumanEntity self, GodEntity god) {
        
    }

    @Override
    public GodEntity getGod() {
        MLogger.info("I am not religious. I dont believe in gods");
        return null;
    }

    @Override
    public void gatherTax(HumanEntity self, Fortune f) {
        MLogger.info("I am not religious. I dont believe in gods");
        self.setTax(0);
    }

    @Override
    public GodEntity setGod(GodEntity god) {
        MLogger.info("I dont believe in gods");
        return null;
    }
    
    
}
