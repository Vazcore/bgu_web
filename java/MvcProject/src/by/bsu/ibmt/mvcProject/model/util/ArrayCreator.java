/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.mvcProject.model.util;

import by.bsu.ibmt.mvcProject.model.entity.MegaArray;

/**
 *
 * @author user
 */
public class ArrayCreator {
    public static MegaArray create(int size) {
        return new MegaArray(size);
    }
}
