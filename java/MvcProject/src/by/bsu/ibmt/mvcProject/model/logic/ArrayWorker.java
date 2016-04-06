/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.mvcProject.model.logic;

import by.bsu.ibmt.mvcProject.model.entity.MegaArray;

/**
 *
 * @author user
 */
public class ArrayWorker {
    public static int findMax(MegaArray arr){
        int max = arr.getElement(0);
        
        int temp;
        for (int i = 0; i < arr.getSize(); i++)
        {
            temp = arr.getElement(i);
            if (temp > max)
                max = temp;
        }
        
        return max;
    }
    
    public static int findMin(MegaArray arr){
        int min = arr.getElement(0);
        
        int temp;
        for (int i = 0; i < arr.getSize(); i++)
        {
            temp = arr.getElement(i);
            if (temp < min)
                min = temp;
        }
        
        return min;
    }
}
