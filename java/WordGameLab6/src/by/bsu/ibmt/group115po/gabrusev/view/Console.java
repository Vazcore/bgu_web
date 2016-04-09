/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.view;

import java.util.Scanner;

/**
 *
 * @author Alexey
 */
public class Console {
    
    public static int drawMenu(Scanner sc, boolean progress)
    {
        System.out.println("======== Menu ===========");
        System.out.println("1.  Next word");
        if (progress)
        {
            System.out.println("2.  Try to guess again");
        }
        System.out.println("0.  Exit");
        System.out.print("Your choice: ");
        return Integer.parseInt(sc.nextLine());        
    }
    
    public static String askGuessWord(Scanner sc)
    {
        System.out.print("Type correct word: ");
        return sc.nextLine().toLowerCase();
    }
    
    public static void looseMsg(Scanner sc)
    {
        System.out.println("You Loose!");
        System.out.println("==================");
        System.out.println("Press any key");
        sc.nextLine();
    }
    
    public static void winMsg(Scanner sc)
    {
        System.out.println("You Win!");
        System.out.println("==================");
        System.out.println("Press any key");
        sc.nextLine();
    }
    
}
