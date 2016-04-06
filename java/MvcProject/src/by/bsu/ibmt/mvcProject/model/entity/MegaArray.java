/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.mvcProject.model.entity;

import java.util.Arrays;

/**
 *
 * @author USER
 */
public class MegaArray {
    
    private int[] arr;
    
    public MegaArray(int size)
    {
        this.arr = new int[size];
    }
    
    public int getSize()
    {
        return this.arr.length;
    }
    
    public int getElement(int index)
    {
        return this.arr[index];
    }
    
    public void setElement(int index, int val)
    {
        arr[index] = val;
    }
    
    @Override
    public String toString()
    {
        return Arrays.toString(this.arr);
    }
    
}
