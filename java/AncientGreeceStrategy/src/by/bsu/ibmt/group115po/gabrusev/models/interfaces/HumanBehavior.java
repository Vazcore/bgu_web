/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.models.interfaces;

import by.bsu.ibmt.group115po.gabrusev.models.Fortune;
import by.bsu.ibmt.group115po.gabrusev.models.God;
import by.bsu.ibmt.group115po.gabrusev.models.GodEntity;
import by.bsu.ibmt.group115po.gabrusev.models.HumanEntity;

/**
 *
 * @author USER
 */
public interface HumanBehavior {    
    public abstract boolean pray(HumanEntity h, GodEntity god); 
    public abstract void gatherTax(HumanEntity h, Fortune f);
    public abstract GodEntity getGod();
    public abstract GodEntity setGod(GodEntity god);
}
