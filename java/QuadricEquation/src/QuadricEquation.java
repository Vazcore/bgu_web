
import java.util.Scanner;
import static java.lang.Math.sqrt;

/**
 * Description: The program calculates quadric equation
 * @version 0.0.1
 * @author Alexey Gabrusev 
 * group: PVO15
 * date: 08.03.2016
 */

/**
 * Class reads input values
 */

class EquationReader
{   
    public int read(String prompt_text)
    {
        // ask user to type equation arguments
        System.out.print(prompt_text + ": ");
        // creation an object of the class Scanner
        Scanner reader = new Scanner(System.in);
        // read input
        return reader.nextInt();
    }
}

/**
 * Class calculates quadric equation
 */
class EquationCalculator
{
    private final int a;
    private final int b;
    private final int c;
    private double discr;
    private final double[] roots = new double[2];
    
    public EquationCalculator(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private void calc_roots()
    {
        this.roots[0] = (-1*this.b + sqrt(this.discr))/ 2 * this.a;
        this.roots[1] = (-1*this.b - sqrt(this.discr))/ 2 * this.a;
    }
    
    public void print_result()
    {
        System.out.print("a = " + this.a + "; ");
        System.out.print("b = " + this.b + "; ");
        System.out.println("c = " + this.c);
        if (this.discr < 0)
        {
            System.out.println("Equation has no roots!");
        }
        else if (this.discr > 0)
        {
            System.out.println("Equation has 2 roots!");
            System.out.printf("x1: %5.1f \n", this.roots[0]);
            System.out.printf("x2: %5.1f \n", this.roots[1]);
        }
        else
        {
            System.out.println("Equation has 1 root!");
            System.out.printf("x1: %5.1f \n", this.roots[0]);
        }
            
    }
    
    public boolean validate()
    {
        if (this.a == 0)
        {
            System.out.println("Argument `a` shouldn\'t be equal zero");
            return false;
        }
        return true;
    }
    
    public void calculate()
    {
       this.discr = this.b * this.b - 4 * this.a * this.c;
       if (discr >= 0)
       {
           this.calc_roots();
       }       
    }
}

public class QuadricEquation{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int a,b,c;
       if (args.length != 3)
       {
            System.out.println("No arguments a,b,c were found! \n Should be 3 argumnts for a, b and c \n Starting manual input ... \n");
            
            // creation object of class EquationReader
            EquationReader e_reader = new EquationReader();
            // read a
            a = e_reader.read("Enter value of a");
            b = e_reader.read("Enter value of b");
            c = e_reader.read("Enter value of c");
            
       }
       else
       {
           a = Integer.parseInt(args[0]);
           b = Integer.parseInt(args[1]);
           c = Integer.parseInt(args[2]);
       }       
       
       // creation object of class EquationCalculator
       EquationCalculator e_calcuator = new EquationCalculator(a, b, c);
       if (e_calcuator.validate())
       {
           e_calcuator.calculate();
           e_calcuator.print_result();
       }      
       
    }
    
}
