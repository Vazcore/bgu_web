/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duckproject.models;

import duckproject.models.FlyBehavior;
import duckproject.models.QuackBehavior;

/**
 *
 * @author Alexey
 */
public abstract class Duck {
    
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    
    public abstract void display();
    
    public void performFly() 
    {
        flyBehavior.fly();
    }
    
    public void setFlyBehavior(FlyBehavior fb)
    {
        flyBehavior = fb;
    }
    
}
