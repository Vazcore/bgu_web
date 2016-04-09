/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.model;

/**
 *
 * @author Alexey
 */
public class CustomArray {
    
    private final int size;
    private final int[] array;
    
    public CustomArray(int size)
    {
        this.size = size;
        this.array = new int[size];
    }
    
    public CustomArray(int[] arr)
    {
        this.size = arr.length;
        this.array = arr;
    }
    
    public int getSize()
    {
        return this.size;
    }
    
    public int getElementByIndex(int index)
    {
        if (index > (this.size - 1) || index < 0)
        {
            return 0;
        }
        return this.array[index];
    }
    
    public boolean setElementByIndex(int index, int value)
    {
        if (index > (this.size - 1) || index < 0)
        {
            return false;
        }
        this.array[index] = value;
        return true;
    }
    
    public int findAbsMax()
    {
        int max = Math.abs(array[0]);
        int current;
        for (int i = 0; i < array.length; i++)
        {
            current = Math.abs(array[i]);
            if (current > max)
            {
                max = current;
            }
        }
        
        return max;
    }
    
    public int getSum()
    {
        int sum = 0;
        for (int i = 0; i < this.array.length; i++)
        {
            sum += this.array[i];
        }
        return sum;
    }
    
    public CustomArray substractElementsBetweenPositive()
    {
        int count_positives = 0;
        int length = 0;
        int from = 0;
        int to = this.array.length;
        
        // iterate to find out - size of new array
        for (int i = 0; i < this.array.length; i++)
        {
            if (this.array[i] >= 0)
            {
                count_positives++;
                if (count_positives == 1)
                {
                    from = i;
                }
                if (count_positives == 2)
                {
                    to = i;
                }
            }
            
        }
        length = to-from - 1;
        if (length <= 0)
        {
            return new CustomArray(new int[0]);
        }
        int[] substracted_array = new int[length];
        // iterate to fill new array with values
        int outer_it = 0;
        for (int i = from + 1; i < to; i++)
        {
            substracted_array[outer_it] = this.array[i];
            outer_it++;
        }
        
        return new CustomArray(substracted_array);
    }
    
}
