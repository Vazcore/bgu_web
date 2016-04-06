/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.mvcProject.view;

import by.bsu.ibmt.mvcProject.model.entity.MegaArray;
import java.util.Arrays;

/**
 *
 * @author user
 */
public class ConsolepPrinter {

    public static void print(String msg, int value) {
        System.out.println(msg + value);
    }

    public static void printArray(MegaArray array) {
        System.out.println(array.toString());
    }
}
