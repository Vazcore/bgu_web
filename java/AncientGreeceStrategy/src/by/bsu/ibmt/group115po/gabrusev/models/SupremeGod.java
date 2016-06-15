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
public class SupremeGod extends GodEntity {
    public SupremeGod(String name, int age, Power power, int points)
    {
        super(name, age, power, points);
        this.setBehaviour(new SupremeRank());
        MLogger.debug("Supreme God " + name + " was created!");
    }
    
    @Override
    public void introduce()
    {
        MLogger.log(this.getName(), "Hail silly mortal creratures. You should fear me I am a Supreme God " + this.getName());
        MLogger.log(this.getName(), "I live in this world " + this.getAge() + " years!!!");
        MLogger.log(this.getName(), "I have power - " + this.getPower().getName());
        MLogger.log(this.getName(), "I can take immortality from God");
    }
    
}
