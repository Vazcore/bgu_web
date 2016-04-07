package by.bsu.ibmt.grouppv115po.gabrusev;


import java.util.Random;
import java.util.Scanner;

/**
 * Description: Additional tasks for lab 3
 * @version 0.0.1
 * @author Alexey Gabrusev 
 * group: PVO15
 * date: 08.03.2016
 */

class GamesPack
{
    private final Scanner reader;
    
    public GamesPack(Scanner reader)
    {
        this.reader = reader;
    }
    
    public void reverse(String[] args)
    {
        if (args.length == 0)
        {
            System.out.println("No arguments!");            
        }
        else
        {
            for (int i = args.length-1; i >= 0; i--) 
            {
                System.out.println("Argument " + (i+1) + ": " + args[i]);
            }
        }
    }
    
    public void arg_math(String[] args)
    {
        if (args.length == 0)
        {
            System.out.println("No arguments!");
            return;
        }
        // sum
        int sum = 0;
        int multiply = 1;
        int max = Integer.parseInt(args[0]);
        int min = max;
        for (String arg : args) {
            int var = Integer.parseInt(arg);
            sum += var;
            multiply *= var;
            if (var > max)
            {
                max = var;
            }
            if (var < min)
            {
                min = var;
            }
        }
        
        // print out
        System.out.println("Sum: " + sum);
        System.out.println("Multiplication: " + multiply);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
    
    public boolean try_again()
    {
        System.out.println("----------------------------\n Try again? yes(1)/no=(0): ");
        try{
            int choice = this.reader.nextInt();
            if (choice == 1)
                return true;
        }
        catch(Exception e)
        {
            System.out.println("Invlid input \n " + e.getMessage());
            return false;
        }
       
        return false;
    }
    
    public void dice()
    {
        int from = 1; 
        int to = 6;
        Random r = new Random();
        // 1-s
        int d1 = r.nextInt((to-from)+1) + from;
        // 2-nd
        int d2 = r.nextInt((to-from)+1) + from;
        
        System.out.println("Your dice is " + (d1+d2));
    }
    
    public void pie_game()
    {
        String[] surpices = new String[5];
        surpices[0] = "You'll have a good day";
        surpices[1] = "You'll have a bad day";
        surpices[2] = "Dont eat too much today";
        surpices[3] = "Look back!!!!";
        surpices[4] = "Someone is following you. Be aware!";
        
        int from = 0; 
        int to = 4;
        Random r = new Random();
        int r_index = r.nextInt((to-from)+1) + from;
        System.out.println(surpices[r_index]);
        
    }
    
    public void dragon_game()
    {
        System.out.print("Enter dragon's age: ");
        int age = this.reader.nextInt();
        if (age <= 0)
        {
            System.out.println("This dragon is too young!");
            return;
        }
        Random r = new Random();
        int heads = 0;
        int max = 5;
        int min = 3;
        for (int i = 1; i <= age; i++)
        {
            if (i <= 100)
            {
                min = 3;                
            }
            else
            {
                min = 2;
                
            }
            heads += r.nextInt((max-min)+1) + min;
        }
        System.out.println("Dragon has: " + heads + " heads.");
    }
    
    public void get_mood()
    {
        String[] faces = new String[2];
        faces[0] = "\u2639";
        faces[1] = "\u263A";
        
        Random r = new Random();
        int min = 0;
        int max = faces.length-1;
        int mood_index = r.nextInt((max-min)+1) + min;
        
        System.out.println(faces[mood_index]);
    }
}

public class StartApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        // creation an object of the class Scanner
        Scanner reader = new Scanner(System.in);
        GamesPack g_pack = new GamesPack(reader);
        
       do
       {
           System.out.println("Menu \n 1: Reverse arguments \n 2: Math with arguments  \n 3: Dice game \n 4: Pie with suprise \n 5: Mood sensor \n 6: Dragon's heads \n ----------------------------- \n 0: Exit");           
           System.out.print("Your choice: ");           
            // read input
           choice = reader.nextInt();
           switch(choice)
           {
               case 1:
                   g_pack.reverse(args);                   
                   break;
               case 2:
                   g_pack.arg_math(args);                   
                   break;
               case 3:
                   g_pack.dice();
                   while(true)
                   {
                        if(!g_pack.try_again())
                           break;
                        g_pack.dice();
                   }
                   break;
               case 4:
                   g_pack.pie_game();
                   while(true)
                   {
                        if(!g_pack.try_again())
                           break;
                        g_pack.pie_game();
                   }
                   break;
                case 5:
                   g_pack.get_mood();
                   while(true)
                   {
                        if(!g_pack.try_again())
                           break;
                        g_pack.get_mood();
                   }
                   break;
                case 6:
                   g_pack.dragon_game();
                   while(true)
                   {
                        if(!g_pack.try_again())
                           break;
                        g_pack.dragon_game();
                   }
                   break;
                default:
                    System.out.println("No such option!");
                    break;
           }
       }
       while(choice != 0);
    }
    
}


