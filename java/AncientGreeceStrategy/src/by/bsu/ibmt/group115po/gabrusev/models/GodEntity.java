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
public abstract class GodEntity extends Creature {
    private Power power;
    private int immortalityValue = 1;
    private GodBehavior rankingBehaviour;
    private int points;
    
    public GodEntity(String name, int age, Power power, int points)
    {
        super(name, age);
        this.power = power;
        this.points = points;
    }
    
    public int getImmortalityValue()
    {
        return this.immortalityValue;
    }
    
    public void setImmortalityValue(int v)
    {
        this.immortalityValue = v;
    }
    
    public int getPoints()
    {
        return this.points;
    }
    
    public void setPoints(int p)
    {
        this.points = p;
    }
    
    public void setBehaviour(GodBehavior b)
    {
        this.rankingBehaviour = b;
    }
    
    public Power getPower()
    {
        return this.power;
    }
    
    public void setPower(Power p)
    {
        this.power = p;
    }
    
    public void atack(GodEntity cr)
    {
        Logger.log(this.getName(), "I will kill you, " + cr.getName());
        rankingBehaviour.atack(this, cr);
    }
    
    public void takeImmortality(GodEntity cr)
    {
        rankingBehaviour.takeImmortality(this, cr);
    }
    
}
