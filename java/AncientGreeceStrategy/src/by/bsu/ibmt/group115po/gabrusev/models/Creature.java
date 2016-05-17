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
public abstract class Creature {
   
    private String name;
    private int age;
    
    public Creature(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    
    public abstract void introduce();
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName() 
    {
        return this.name;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    
    public int getAge() 
    {
        return this.age;
    }
    
}
