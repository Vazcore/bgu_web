/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duckproject.models;

import duckproject.models.FlyBehavior;

/**
 *
 * @author Alexey
 */
public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly()
    {
        System.out.println("I can fly with wings!!!");
    }
}
