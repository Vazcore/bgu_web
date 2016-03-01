/**
 * Description: The program tests operations under primitive types
 * @version 0.0.1
 * @author Alexey Gabrusev 
 * group: PVO15
 * date: 28.02.2016
 */

class Tester{
    
    /**
     * Operations between 2 integers
     */
    public static void test(int val1, int val2){   
        int temp = val1;
        // double number
        double d_val = val1 / val2;
        // float number
        float f_val = val1 / val2;        
        
        System.out.println("-----Operations between integers-------------");
        
        System.out.println("val1 = " + val1 + ", val2 = " + val2);
        System.out.println("d_val = " + d_val + ", f_val = " + f_val);
        
        System.out.println("val1 = " + val1 + ", val2 = " + val2);
        System.out.printf("%d + %d => %d\n", val1, val2, val1+val2);
        System.out.printf("%d-%d => %d\n", val1, val2, val1-val2);
        System.out.printf("%d/%d => %f\n", val1, val2, (double)val1/val2);
        System.out.printf("%d*%d => %d\n",  val1, val2, val1*val2);
        System.out.println(d_val+"*"+val2+" => " + d_val*val2);
        System.out.println(val1+"/"+f_val+" => " + val1/f_val);
        System.out.printf(val1+"++ => %d\n", temp++);
        temp = val1;
        System.out.printf("++"+val1+" => %d\n", ++temp);        
        System.out.printf(val1+"%%"+val2+" => %d\n", val1%val2);
        System.out.printf(val1+"=="+val2+" => %b\n", val1==val2);
        System.out.printf(val1+"!="+val2+" => %b\n", val1!=val2);
        System.out.printf(val1+">"+val2+" => %b\n", val1>val2);
        System.out.printf(val1+"<"+val2+" => %b\n", val1<val2);
        System.out.println(val1 + " >> " + val2 + " => " + (val1 >> val2));
        System.out.println(val1 + " << " + val2 + " => " + (val1 << val2));
        System.out.println(val1 + " & " + val2 + " => " + (val1 & val2));
        System.out.println(val1 + " | " + val2 + " => " + (val1 | val2));
        System.out.printf(val1+" += "+val2+" => %d\n", temp += val2);
        temp = val1;
        System.out.printf(val1+" -= "+val2+" => %d\n", temp -= val2);
        temp = val1;
        System.out.printf(val1+" *= "+val2+" => %d\n", temp *= val2);
        temp = val1;
        System.out.printf(val1+" /= "+val2+" => %f\n", (double)(temp /= val2));
        temp = val1;
        System.out.printf(val1+" %%= "+val2+" => %d\n", temp %= val2);
        temp = val1;
        System.out.printf(val1+" <<= "+val2+" => %d\n", temp <<= val2);
        temp = val1;
        System.out.printf(val1+" &= "+val2+" => %d\n", temp &= val2);
        temp = val1;
        System.out.printf(val1+" ^= "+val2+" => %d\n", temp ^= val2);
        temp = val1;
        System.out.printf(val1+" |= "+val2+" => %d\n", temp |= val2);
        System.out.printf(val1+" |= "+val2+" => %d\n", temp |= val2);
        System.out.println("----------------------------------------");
    }    
    
    /**
     * Operations between 2 booleans
     */
    public static void test(boolean val1, boolean val2){
        System.out.println("----- Operations booleans -------------");
        System.out.println("val1 = true, val2 = false \n");
        System.out.printf("%b == %b => %b\n", val1, val2, val1 == val2);
        System.out.printf("%b != %b => %b\n", val1, val2, val1 != val2);
        System.out.printf("(%b == %b) && (%b == %b) => %b\n", val1, val1, val1, val2, (val1 == val1) && (val1 == val2));
        System.out.printf("(%b == %b) || (%b == %b) => %b\n", val1, val1, val1, val2, (val1 == val1) || (val1 == val2));
        System.out.printf("%b ^ %b => %b\n", val1, val1, val1 ^ val1);
        System.out.printf("!%b == %b => %b\n", val1, val2, !val1 == val2);
        System.out.printf("!%b != %b => %b\n", val1, val2, !val1 != val2);
        System.out.println("----------------------------------------");
    }
    
    public static void test(char ch1, char ch2)
    {
        System.out.println("----- Operations char -------------");
        System.out.println(ch1 + " = " + (int)ch1 );
        System.out.println(ch2 + " = " + (int)ch2 );
        System.out.println(ch1 + " + " + ch2 + " => " + (ch1+ch2));
        System.out.println(ch1 + " - " + ch2 + " => " + (ch1-ch2));
        System.out.println(ch1 + " / " + ch2 + " => " + (ch1/ch2));
        System.out.println(ch1 + " * " + ch2 + " => " + (ch1*ch2));
        System.out.println(ch1 + " * " + 5.2 + " => " + (ch1*5.2));
        System.out.println(ch1 + " >> " + ch2 + " => " + (ch1>>ch2));
        System.out.println(ch1 + " << " + ch2 + " => " + (ch1<<ch2));
        System.out.println(ch1 + " == " + ch2 + " => " + (ch1==ch2));
    }
    
    public static void test(byte b1, byte b2)
    {
        System.out.println("----- Operations byte -------------");        
        test((int)b1, (int)b2);
    }
    
    public static void test(short b1, short b2)
    {
        System.out.println("----- Operations short -------------");        
        test((int)b1, (int)b2);
    }
    
    public static void test(long b1, long b2)
    {
        System.out.println("----- Operations long -------------");        
        test((int)b1, (int)b2);
    }
   
}

public class TestingApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
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
