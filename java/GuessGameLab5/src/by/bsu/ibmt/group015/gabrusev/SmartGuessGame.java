/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group015.gabrusev;

import java.util.Random;
import java.util.Scanner;

/**
 * Description: The program is basically a `guess number` game
 * @version 0.0.1
 * @author Alexey Gabrusev 
 * group: PVO15
 * date: 15.03.2016
 */

class GuessGame
{
    private int guesses = 0;
    private int guess = 0;
    private int max_guesses;
    private boolean with_guesses = true;
    private int max_range = 10;
    private int win_number;
    private int total_games_played = 0;
    
    public void setGuesses(int guesses)
    {
        this.guesses = guesses;
    }
    
    public void setWithGuesses(boolean with)
    {
        this.with_guesses = with;
    }
    
    public void setMaxGuesses(int max)
    {
        this.max_guesses = max;
    }
    
    public int getGuesses()
    {
        return this.guesses;
    }
    
    public int getMaxGuesses()
    {
        return this.max_guesses;
    }
    
    public boolean getWithGuesses()
    {
        return this.with_guesses;
    }
    
    public int read(String prompt_text)
    {
        // ask user to type equation arguments
        System.out.print(prompt_text + ": ");
        // creation an object of the class Scanner
        Scanner reader = new Scanner(System.in);
        // read input
        return reader.nextInt();
    }
    
    private void printOptions()
    {
        System.out.println("Welcome to Guess Number Game");
        System.out.println("-----------------");
        System.out.println("Menu");
        System.out.println("1: Start New Game");
        if (this.total_games_played > 0)
            System.out.println("2: Try previous game again");        
        System.out.println("-----------------");
        System.out.println("0: Exit");
    }
    
    private boolean initParams()
    {
       
        int max_guesses = this.read("Enter amount of guesses");
        this.max_guesses = max_guesses;        
        this.max_range = this.read("Enter a max range");        
        // user should pick number less than or equal max range
        do
        {
            this.win_number = this.read("Enter guess number");
        }
        while(this.win_number > this.max_range);
        
        this.resetParams();        
        return true;
    }
    
    private void resetParams()
    {        
        // init guesses with 0
        this.guesses = 0;
        // init user current guess number        
        this.guess = 0;      
    }
    
    private int getHalf(int from, int to)
    {
        return from + Math.round((Math.abs(to-from)) / 2);
    }
    
    private boolean start()
    {
        int from = 0;
        int to = this.max_range;        
        
        while (true)
        {
            if (this.with_guesses && this.guesses >= this.max_guesses)
            {
                return false;
            }
            this.guess = this.getHalf(from ,to);
            this.guesses++;
            
            // quit game
            if (this.guess == -1)
            {
                return false;
            }
            
            System.out.println("Silly computer is thinking about number - " + this.guess);
            
            if (this.guess == this.win_number)
            {
                return true;
            }
            else if (this.guess < this.win_number)
            {
                System.out.println("Computer\'s number " +this.guess+ " is smaller.");
                from = this.guess; 
            }
            else
            {
                System.out.println("Computer\'s number " +this.guess+ " is bigger.");
                to = this.guess;
            }            
        }        
    }
    
    private void printStatistics()
    {
        if (this.guess != this.win_number)
        {
            System.out.println("You lose");
        }
        else
        {
            System.out.println("You win");
        }
        // printing rest
        System.out.println("Total guesses: " + this.guesses);
        System.out.println("Win number: " + this.win_number);
    }
    
    public void startGame()
    {
        int choice = 1;
        do
        {
            this.printOptions();
            choice = this.read("Your choice");
            if (choice == 1)
            {
                if (this.initParams())
                {
                    // starting game
                    this.start();
                    // printing statistic
                    this.printStatistics();
                    // increase total games 
                    this.total_games_played++;
                } 
            }
            else if (choice == 2 && this.total_games_played > 0)
            {
                // repeat previous game
                this.resetParams();        
                // starting game
                this.start();
                // printing statistic
                this.printStatistics();
                // increase total games 
                this.total_games_played++;
            }
        }
        while(choice != 0);
    }
}

public class SmartGuessGame {
    
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
