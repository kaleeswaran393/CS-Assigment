
package com.cs.canvas.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kaleeswarankaruppusamy
 */
public class CanvasActionControllerTest {
    
    public CanvasActionControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAction method, of class CanvasActionController.
     */
    @Test
    public void testCreateCanvasAction() {
        System.out.println("getAction");
        String str = "C";
        CanvasActionController instance = CanvasActionController.valueOf(String.valueOf(Character.toString(str.charAt(0))));
        assertEquals(CanvasActionController.C,instance);
    }
  
    @Test
    public void testCreateLineAction() {
        System.out.println("getAction");
        String str = "L";
        CanvasActionController instance = CanvasActionController.valueOf(String.valueOf(Character.toString(str.charAt(0))));
        assertEquals(CanvasActionController.L, instance);
    }
    
    @Test
    public void testCreateRectangleAction() {
        System.out.println("getAction");
        String str = "R";
        CanvasActionController instance = CanvasActionController.valueOf(String.valueOf(Character.toString(str.charAt(0))));
        assertEquals(CanvasActionController.R, instance);
    }
}
