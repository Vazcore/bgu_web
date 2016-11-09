/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bgu.bsu.ibtm.gabrusev.vagonproject.model;

/**
 *
 * @author USER
 */
public class PassengerVagon extends Vagon{
    public int inner_type = 3;
    public int number_of_passengers;
    public boolean conditioning = false;
    
    public PassengerVagon(int n, double w, int p)
    {
        super(n, w);
        this.number_of_passengers = p;
    }
    
    public PassengerVagon(int n, double w)
    {
        super(n, w);
        this.number_of_passengers = 0;
    }
    
    public boolean conditionerOn()
    {
        this.conditioning = true;
        return this.conditioning;
    }
    
    public boolean conditionerOff()
    {
        this.conditioning = false;
        return this.conditioning;
    }
    
    public boolean isConditioning()
    {
        return this.conditioning;
    }
    
    public int getNumberOfPassengers()
    {
        return this.number_of_passengers;
    }
    
}
