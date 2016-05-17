/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duckproject.models;

/**
 *
 * @author Alexey
 */
public class MallardDuck extends Duck {
    
    public MallardDuck()
    {
        this.flyBehavior = new FlyWithWings();
    }
    
    @Override
    public void display()
    {
        System.out.println("I am a Mallard Duck.");
    }
}
