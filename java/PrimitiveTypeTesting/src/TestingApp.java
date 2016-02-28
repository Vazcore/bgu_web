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
        System.out.println("-----Operations booleans integers-------------");
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
}

public class TestingApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Tester.test(5, 3);
        Tester.test(-8, 3);   
        Tester.test(true, false);  
    }
    
}
