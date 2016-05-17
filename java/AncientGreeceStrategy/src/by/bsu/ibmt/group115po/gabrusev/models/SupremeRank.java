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
public class SupremeRank implements GodBehavior{
    @Override
    public void atack(GodEntity cr, GodEntity g)
    {
        int hit = cr.getAge() + cr.getPoints() + cr.getPower().getValue() * cr.getImmortalityValue();
        g.setPoints(g.getPoints() - hit);
        Logger.info(cr.getName() + " hits " + g.getName() + " with " + hit + " points!");
    }
    
    @Override
    public void takeImmortality(GodEntity g1, GodEntity g2)
    {
        Logger.log(g1.getName(), "I'll take your immortality, " + g2.getName());
        // if god points are too low
        if (g2.getPoints() <= 0) 
        {
            if (g2.getImmortalityValue() <= 0)
            {
                Logger.log(g2.getName(), "I'm already mortal :=(");
                return;
            }
            // God can do this
            g2.setBehaviour(new MortalRank());            
            // increase immortality power from defeated God
            g1.setImmortalityValue(g1.getImmortalityValue() + g2.getImmortalityValue());   
            // take immortality power
            g2.setImmortalityValue(0);
            
            Logger.info(g1.getName() + " took immortality from " + g2.getName());
            Logger.log(g1.getName(), "I became stronger, ha-ha");
        }
        else 
        {
            Logger.log(g2.getName(), "You cant take it from me!!!!!!!");
        }
    }
}
