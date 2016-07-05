/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.models;

import by.bsu.ibmt.group115po.gabrusev.models.interfaces.HumanBehavior;

/**
 *
 * @author USER
 */
public abstract class HumanEntity extends Creature {
    
    private String city;
    private float money;
    private int spirit = 0;
    private HumanBehavior bh = null;
    
    public HumanEntity(String name, int age, String city, float money, int spirit) {
        super(name, age);
        this.city = city;
        this.money = money;
        this.spirit = spirit;
    }
    
    public String getCity()
    {
        return this.city;
    }
    
    public float getMoney()
    {
        return this.money;
    }
    
    public int getSpirit()
    {
        return this.spirit;
    }
    
    public void setBehavior(HumanBehavior bh)
    {
        this.bh = bh;
    }
    
    public boolean pray(GodEntity god)
    {
        return this.bh.pray(this, god);
    }
    
    public GodEntity getGod()
    {
        return bh.getGod();
    }
    
    public boolean setGod (GodEntity god)
    {
        this.bh.setGod(god);
        return true;
    }
    
    public void setMoney(float tax)
    {
        this.money = tax;
    }
    
    public void setSpirit(int s)
    {
        this.spirit = s;
    }
    
}
