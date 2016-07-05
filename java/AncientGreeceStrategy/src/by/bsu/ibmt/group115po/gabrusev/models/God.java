/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.models;

import by.bsu.ibmt.group115po.gabrusev.utils.MLogger;

/**
 *
 * @author Alexey
 */
public class God extends GodEntity{
    
    public final int rel = 0;
    
    public God(String name, int age, Power power, int points)
    {
        super(name, age, power, points);
        this.setBehaviour(new CasualRank());
        MLogger.debug("God " + name + " was created!");
    }
    
    @Override
    public void introduce()
    {
        MLogger.log(this.getName(), "Hail mortal creratures I am a God " + this.getName());
        MLogger.log(this.getName(), "I live in this world " + this.getAge() + " years!!!");
        MLogger.log(this.getName(), "I have power - " + this.getPower().getName());
    }
    
    @Override
    public String toString() {
        return "" + this.rel;
    }

    
}
