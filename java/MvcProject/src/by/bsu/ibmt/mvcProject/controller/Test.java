
package by.bsu.ibmt.mvcProject.controller;

import by.bsu.ibmt.mvcProject.model.entity.MegaArray;
import by.bsu.ibmt.mvcProject.model.logic.ArrayWorker;
import by.bsu.ibmt.mvcProject.model.util.ArrayCreator;
import by.bsu.ibmt.mvcProject.model.util.Initializer;
import by.bsu.ibmt.mvcProject.view.ConsolepPrinter;

public class Test {
    public static void main(String[] args) {
        int size = 20;
        MegaArray array = ArrayCreator.create(size);
        
        Initializer.init(array,-10,10);
        
        int max = ArrayWorker.findMax(array);
        int min = ArrayWorker.findMin(array);
        
        ConsolepPrinter.print("Max: ",max);
        
        ConsolepPrinter.print("Min: ", min);
        
        ConsolepPrinter.printArray(array);
        
    }
}
