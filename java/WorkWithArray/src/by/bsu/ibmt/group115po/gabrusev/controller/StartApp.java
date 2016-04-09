
package by.bsu.ibmt.group115po.gabrusev.controller;

import by.bsu.ibmt.group115po.gabrusev.model.CustomArray;
import by.bsu.ibmt.group115po.gabrusev.view.Console;
import java.util.Random;
import java.util.Scanner;

/**
 * Description: Work with 1-d array
 * @version 0.0.1
 * @author Alexey Gabrusev 
 * group: PVO15
 * date: 09.04.2016
 */

public class StartApp {
    public static void main(String[] args) {
        
        int choice;
        boolean array_ready = false;
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int r_from = -100;
        int r_to = 50;
        // value added to array
        int v;
        CustomArray arr = null;
        int max;
        int sum;
        
        do
        {
            Console.printMenu(array_ready);
            choice = Console.askChoice(sc);
            if (choice == 1 || choice == 2)
            {
                int size = Console.askArraySize(sc);
                arr = new CustomArray(size);
                for (int i = 0; i < size; i++)
                {
                    if (choice == 1)
                    {
                        v = Console.askForNewValue(sc, i+1);
                    }
                    else
                    {
                        v = r.nextInt((r_to-r_from) + 1) + r_from;
                    }
                    arr.setElementByIndex(i, v);
                }
                array_ready = true;
                Console.printArray(arr, sc);
            }
            
            else if(choice == 3 && array_ready && arr != null)
            {
                CustomArray substracted_array = arr.substractElementsBetweenPositive();
                if (substracted_array.getSize() == 0)
                {
                    Console.errorZeroSize(sc);
                }
                else
                {
                    max = substracted_array.findAbsMax();
                    sum = substracted_array.getSum();
                    Console.printResult(max, sum);
                    Console.printArray(substracted_array, sc);
                }                
            }
            
        }
        while(choice != 0);
        
    }
}
