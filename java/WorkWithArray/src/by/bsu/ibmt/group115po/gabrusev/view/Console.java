/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.view;

import by.bsu.ibmt.group115po.gabrusev.model.CustomArray;
import java.util.Scanner;

/**
 *
 * @author Alexey
 */
public class Console {
    
    public static void printMenu(boolean array_ready)
    {
        System.out.println("======== Menu ==========");
        System.out.println("1. Manualy filling array");
        System.out.println("2. Auto filling array");
        if (array_ready)
        {
            System.out.println("3. Task 5 - Calculate |max| and sum between first positive");
        }
        
         System.out.println("=================");
         System.out.println("0. Exit");
    }
    
    
    public static int askArraySize(Scanner sc)
    {
        System.out.print("Type size of array: ");
        return Integer.parseInt(sc.nextLine());
    }
    
    public static int askForNewValue(Scanner sc, int element)
    {
        System.out.println("Enter value for element - [" + element + "]: ");
        return Integer.parseInt(sc.nextLine());
    }
    
    public static int askChoice(Scanner sc)
    {
        System.out.print("Your choice: ");
        return Integer.parseInt(sc.nextLine());
    }
    
    public static void printArray(CustomArray arr, Scanner sc)
    {
        System.out.println("Printing array: ");
        for (int i = 0; i < arr.getSize(); i++)
        {
            System.out.print(arr.getElementByIndex(i));
            if (i < (arr.getSize() - 1))
            {
                System.out.print(", ");
            }
        }
        System.out.println("\nPress any key");
        sc.nextLine();
    }
    
    public static void errorZeroSize(Scanner sc)
    {
        System.out.println("Error - there are no elements");
        System.out.println("=======================");
        System.out.println("Press any key");
        sc.nextLine();
    }
    
    public static void printResult(int max, int sum)
    {
        System.out.println("Results:");
        System.out.println("=======================");
        System.out.println("Max element: [" + max+"]");
        System.out.println("Sum of elements: " + sum);
    }
    
}
