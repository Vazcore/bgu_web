/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.grouppv115po.gabrusev;

/**
 *
 * @author alex
 */
public class StartApp {
    
    /**
     * @param args the command line arguments
    */
    public static void main (String[] args)
    {        
        // create object - GuessGame
        GuessGame game = new GuessGame();
        // start game
        game.startGame();
    }
}
