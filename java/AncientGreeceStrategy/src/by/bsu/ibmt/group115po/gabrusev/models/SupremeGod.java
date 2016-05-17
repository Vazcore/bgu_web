/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.models;

import by.bsu.ibmt.group115po.gabrusev.utils.Logger;

/**
 *
 * @author Alexey
 */
public class SupremeGod extends GodEntity {
    public SupremeGod(String name, int age, Power power, int points)
    {
        super(name, age, power, points);
        this.setBehaviour(new SupremeRank());
    }
    
    @Override
    public void introduce()
    {
        Logger.log(this.getName(), "Hail silly mortal creratures. You should fear me I am a Supreme God " + this.getName());
        Logger.log(this.getName(), "I live in this world " + this.getAge() + " years!!!");
        Logger.log(this.getName(), "I have power - " + this.getPower().getName());
        Logger.log(this.getName(), "I can take immortality from God");
    }
}
