/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duckproject;

import duckproject.models.Duck;
import duckproject.models.MallardDuck;

/**
 *
 * @author Alexey
 */
public class DuckProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
    }
    
}
