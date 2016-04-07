/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.grouppv115po.gabrusev;

import java.util.Scanner;

/**
 * Class reads input values
 */

public class EquationReader {
    public static int read(String prompt_text)
    {
        // ask user to type equation arguments
        System.out.print(prompt_text + ": ");
        // creation an object of the class Scanner
        Scanner reader = new Scanner(System.in);
        // read input
        return reader.nextInt();
    }
}
