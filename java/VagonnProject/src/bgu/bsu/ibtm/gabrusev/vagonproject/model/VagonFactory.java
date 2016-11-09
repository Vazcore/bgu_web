/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bgu.bsu.ibtm.gabrusev.vagonproject.model;

import bgu.bsu.ibtm.gabrusev.vagonproject.view.Dispetcher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class VagonFactory {
    
    private List<Vagon> vagons = null;    
    private boolean runner_vagon = false;    
    
    public VagonFactory()
    {
        this.vagons = new ArrayList<Vagon>();
    }
    
    public Vagon createSingleVagon(int type, int number, double w)
    {
        if (type == 1)
        {
            return new Vagon(number, w);
        }
        else if (type == 2)
        {
            if (this.runner_vagon)
            {
                Dispetcher.inform("Running vagon was already created");
                return null;
            }
            return new RunningVagon(number, w);
        }
        else
        {
            return new PassengerVagon(number, w);
        }
    }
    
    public List<Vagon> add(int t, int n, double w)
    {
        Vagon v = this.createSingleVagon(t, n, w);
        this.vagons.add(v);
        return this.vagons;
    }
    
    public List<Vagon> add(Vagon v)
    {        
        this.vagons.add(v);
        return this.vagons;
    }
    
    public List<Vagon> remove(int index)
    {
        if (this.vagons.size() <= index)
        {
            Dispetcher.inform("There is no vagon with such number");
            return this.vagons;
        }
        this.vagons.remove(index);
        return this.vagons;
    }
    
    public double getTotalWeight()
    {
        double total = 0;
        for (int i = 0; i < this.vagons.size(); i++) {
            total += this.vagons.get(i).getWeight();
        }
        return total;
    }
    
}
