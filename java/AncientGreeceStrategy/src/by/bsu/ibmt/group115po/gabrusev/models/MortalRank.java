/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.models;

import by.bsu.ibmt.group115po.gabrusev.models.interfaces.GodBehavior;
import by.bsu.ibmt.group115po.gabrusev.utils.MLogger;

/**
 *
 * @author Alexey
 */
public class MortalRank implements GodBehavior{
    @Override
    public void atack(GodEntity g1, GodEntity g2)
    {
        MLogger.log(g1.getName(), "I am mortal now. I cant atack a God");
        MLogger.debug("Current object has Mortal rank. It can't atack God");
    }
    
    @Override
    public void takeImmortality(GodEntity g1, GodEntity g2)
    {
        MLogger.log(g1.getName(), "I am mortal now. I cant take immortality from God");
        MLogger.debug("Current object has Mortal rank. It can't take immortality");
    }
    
}
