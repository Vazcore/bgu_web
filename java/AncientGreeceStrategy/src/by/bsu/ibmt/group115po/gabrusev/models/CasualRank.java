/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.models;

import by.bsu.ibmt.group115po.gabrusev.models.interfaces.GodBehavior;
import by.bsu.ibmt.group115po.gabrusev.utils.Logger;

/**
 *
 * @author Alexey
 */
public class CasualRank implements GodBehavior{
    
    @Override
    public void atack(GodEntity cr, GodEntity g)
    {
        int hit = cr.getAge() + cr.getPoints() + cr.getPower().getValue();
        g.setPoints(g.getPoints() - hit);
        Logger.info(cr.getName() + " hits " + g.getName() + " with " + hit + " points!");
        
    }
    
    @Override
    public void takeImmortality(GodEntity cr, GodEntity g)
    {
        Logger.log(cr.getName(), "I can't do this. I am so weak");
    }
}
