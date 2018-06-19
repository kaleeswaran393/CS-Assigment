
package com.cs.canvas.controller;

import com.cs.canvas.component.Container;
import com.cs.canvas.model.CommandDto;
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
public class CanvasInputValidatorTest {
    
    public CanvasInputValidatorTest() {
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

    @Test
    public void testGetAction() {
        System.out.println("getAction");
        Container container=null;
        String input = "C 20 4 ";
        CanvasInputValidator val = CanvasInputValidator.valueOf(Character.toString(input.charAt(0)));
        CommandDto command = val.validate(container,input);
        assertEquals(CanvasInputValidator.C, val);
      
    }

    
}
