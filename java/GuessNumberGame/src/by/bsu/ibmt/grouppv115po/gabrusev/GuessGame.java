
package by.bsu.ibmt.grouppv115po.gabrusev;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alexey Gabrusev <alexgabrusev@gmail.com>
 */
public class GuessGame {
    private int guesses = 0;
    private int guess = 0;
    private int max_guesses;
    private boolean with_guesses = false;
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
        // ask user for playing with constraint - max amount of guesses
        int with_max = this.read("Play with max guesses? Yes(1)/No(0)");
        this.with_guesses = (with_max == 1) ? true : false;        
        if (this.with_guesses)
        {
            int max_guesses = this.read("Enter amount of guesses");
            this.max_guesses = max_guesses;
        }
        int max_range = this.read("Enter max value of range");
        this.resetParams();        
        return true;
    }
    
    private void resetParams()
    {
        this.max_range = max_range;   
        // init guesses with 0
        this.guesses = 0;
        // init user current guess number        
        this.guess = 0;
        // get win number
        Random r = new Random();
        int from = 1;
        int to = this.max_range;
        this.win_number = r.nextInt((to-from)+1) + from;
    }
    
    private boolean start()
    {        
        while (true)
        {
            if (this.with_guesses && this.guesses >= this.max_guesses)
            {
                return false;
            }
            this.guess = this.read("Enter number");
            this.guesses++;
            
            // quit game
            if (this.guess == -1)
            {
                return false;
            }
            
            if (this.guess == this.win_number)
            {
                return true;
            }
            else if (this.guess < this.win_number)
            {
                System.out.println("Your number is smaller. Try again or type -1 to quit");
            }
            else
            {
                System.out.println("Your number is bigger. Try again or type -1 to quit");
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
