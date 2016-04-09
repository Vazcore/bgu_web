
package by.bsu.ibmt.group115po.gabrusev.controller;

import by.bsu.ibmt.group115po.gabrusev.model.Words;
import by.bsu.ibmt.group115po.gabrusev.view.WordConsole;
import by.bsu.ibmt.group115po.gabrusev.view.Console;
import java.util.Scanner;

/**
 * Description: Anagrams Game
 * @version 0.0.1
 * @author Alexey Gabrusev 
 * group: PVO15
 * date: 09.04.2016
 */

public class StartApp {
    public static void main(String[] args) {
        
        Words words = new Words();
        Scanner sc = new Scanner(System.in);
        
        int choice;
        boolean progress = false;
        String word;
        
        do
        {
            choice = Console.drawMenu(sc, progress);
            if (choice == 1)
            {
                WordConsole.printWord(words.getNextMixedWord());                                
            }
            
            if(choice == 1 || choice == 2)
            {
                word = Console.askGuessWord(sc);
                if (!words.checkWord(word))
                {
                    Console.looseMsg(sc);
                    progress = true;
                }
                else
                {
                    Console.winMsg(sc);
                    progress = false;
                }
            }
        }
        while(choice != 0);
    }
}
