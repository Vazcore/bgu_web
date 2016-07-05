/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.ibmt.group115po.gabrusev.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexey
 */
public class HumanTest {
    
    Human instance = null;
    String name = "Tom";
    int age = 10;
    String city = "Minsk";
    
    public HumanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Human(this.name, this.age, this.city, 10, 10, new HumanRank());
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    
    /**
     * Test of toString method, of class Human.
     */
    @Test
    public void testToString() {
        System.out.println("toString");        
        String expResult = "" + instance.rel;
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getName method, of class Human.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");        
        String expResult = this.name;
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getName method, of class Human.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");        
        int expResult = this.age;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of pray method, of class Human.
     */
    @Test
    public void testPray() {
        System.out.println("pray");        
        boolean result1 = instance.pray(instance.getGod());
        assertEquals(false, result1);
        
        Human religious = new Human("Paul", 50, "Kiev", 100, 100, new ReligiousHumanRank());
        boolean result2 = religious.pray(religious.getGod());
        assertEquals(true, result2);
    }
    
}
