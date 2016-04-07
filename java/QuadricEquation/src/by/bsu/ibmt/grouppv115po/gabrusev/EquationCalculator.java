
package by.bsu.ibmt.grouppv115po.gabrusev;

import static java.lang.Math.sqrt;

/**
 * Class calculates quadric equation
 */
public class EquationCalculator {
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
