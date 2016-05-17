/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.models.interfaces;

import by.bsu.ibmt.group115po.gabrusev.models.God;
import by.bsu.ibmt.group115po.gabrusev.models.GodEntity;

/**
 *
 * @author Alexey
 */
public interface GodBehavior {
    public void atack(GodEntity cr, GodEntity g);
    public void takeImmortality(GodEntity cr, GodEntity g);
}
