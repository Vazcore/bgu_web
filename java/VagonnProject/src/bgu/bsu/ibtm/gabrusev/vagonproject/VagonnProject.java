/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bgu.bsu.ibtm.gabrusev.vagonproject;

import bgu.bsu.ibtm.gabrusev.vagonproject.model.PassengerVagon;
import bgu.bsu.ibtm.gabrusev.vagonproject.model.VagonFactory;
import bgu.bsu.ibtm.gabrusev.vagonproject.view.Dispetcher;

/**
 *
 * @author USER
 */
public class VagonnProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        VagonFactory f1 = new VagonFactory();
        
        f1.add(1, 1, 23.5);
        f1.add(1, 2, 23.5);
        f1.add(2, 1, 35.5);
        
        // create manually
        PassengerVagon p1 = new PassengerVagon(3, 300);
        f1.add(p1);
        
        Dispetcher.inform("Total weight " + f1.getTotalWeight());
        
    }
}
