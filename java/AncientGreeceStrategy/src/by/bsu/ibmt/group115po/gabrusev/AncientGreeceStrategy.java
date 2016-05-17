/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev;

import by.bsu.ibmt.group115po.gabrusev.models.God;
import by.bsu.ibmt.group115po.gabrusev.models.Power;
import by.bsu.ibmt.group115po.gabrusev.models.GodEntity;
import by.bsu.ibmt.group115po.gabrusev.models.SupremeGod;
import by.bsu.ibmt.group115po.gabrusev.utils.Logger;

/**
 *
 * @author Alexey
 */
public class AncientGreeceStrategy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creation of God Cupid
        // first create power
        Power love = new Power("Love", 50);
        GodEntity cupid = new God("Cupid", 3000, love, 30000);        
        cupid.introduce();
        
        // Creation of God Zeus
        Power lighting = new Power("Lighting", 150);
        GodEntity zeus = new SupremeGod("Zues", 9000, lighting, 20000);
        zeus.introduce();
        
        // Atacking
        zeus.atack(cupid);
        
        // Taking immortality        
        zeus.takeImmortality(cupid);
        
        zeus.atack(cupid);
        zeus.takeImmortality(cupid);
        
    }
    
}
