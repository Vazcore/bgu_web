/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.models;

/**
 *
 * @author Alexey
 */
public class Power {
    private String name;
    private int value;
    
    public Power(String name, int v)
    {
        this.name = name;
        this.value = v;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setValue(int val)
    {
        this.value = val;
    }
    
    public int getValue()
    {
        return this.value;
    }
    
}
