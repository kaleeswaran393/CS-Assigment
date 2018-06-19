
package com.cs.canvas.ui;

import com.cs.canvas.datastore.InMemoryCanvasDataStore;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kaleeswarankaruppusamy
 */
public class UiScreenTest {
    
    public UiScreenTest() {
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
     * Test of display method, of class UiScreen.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        int column = 20;
        int row = 6;
        InMemoryCanvasDataStore instance = new InMemoryCanvasDataStore();
        instance.createDataStore(column, row);
        UiScreen screen = new UiScreen();
        screen.display(instance);
     }
    
}
