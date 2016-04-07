
package by.bsu.ibmt.grouppv115po.gabrusev;

/**
 * Description: The program tests operations under primitive types
 * @version 0.0.1
 * @author Alexey Gabrusev 
 * group: PVO15
 * date: 28.02.2016
 */

public class StartApp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Tetser is just a tool, so I've used a static class Tester
        
        // Integer
        Tester.test(5, 3);
        // Integer negative
        Tester.test(-8, 3);   
        // Boolean
        Tester.test(true, false); 
        // Char
        Tester.test('f', 'd');
        // Byte
        Tester.test((byte)7, (byte)3);        
        //Short
        Tester.test((short)22,(short)11);
        //Long
        Tester.test((long)25,(long)15);
    }
    
}
