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
public class HumanRank implements HumanBehavior, Serializable{

    @Override
    public boolean pray(HumanEntity self, GodEntity god) {
        MLogger.info("I am not religious. I dont believe in gods");
        return false;
    }

    @Override
    public GodEntity getGod() {
        MLogger.info("I am not religious. I dont believe in gods");
        return null;
    }

    @Override
    public void gatherTax(HumanEntity self, Fortune f) {
        MLogger.info("I am not religious. I dont believe in gods");
        self.setMoney(0);
    }

    @Override
    public GodEntity setGod(GodEntity god) {
        MLogger.info("I dont believe in gods");
        return null;
    }
    
    
}
