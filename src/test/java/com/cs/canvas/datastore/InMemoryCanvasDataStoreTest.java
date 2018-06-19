
package com.cs.canvas.datastore;

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
public class InMemoryCanvasDataStoreTest {
    
    public InMemoryCanvasDataStoreTest() {}
    
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
    public void testCreateDataStore() {
        System.out.println("createDataStore");
        int column = 20;
        int row = 6;
        InMemoryCanvasDataStore instance = new InMemoryCanvasDataStore();
        instance.createDataStore(column, row);
        assertEquals(22, instance.getDataStoreColumnSize());
    }

    /**
     * Test of drawLine method, of class InMemoryCanvasDataStore.
     */
    @Test
    public void testDrawLine() {
        System.out.println("drawLine");
        int column = 20;
        int row = 6;
        InMemoryCanvasDataStore instance = new InMemoryCanvasDataStore();
        instance.createDataStore(column, row);
        
        int column1 = 6;
        int row1 = 3;
        int column2 = 6;
        int row2 = 4;
        instance.drawLine(column1, row1, column2, row2);
        assertEquals(InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE,instance.getDataStore()[3][6]);
        assertEquals(InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE,instance.getDataStore()[4][6]);
       
    }

    /**
     * Test of drawRectangle method, of class InMemoryCanvasDataStore.
     */
    @Test
    public void testDrawRectangle() {
        System.out.println("drawRectangle");
        
        int column = 20;
        int row = 6;
        InMemoryCanvasDataStore instance = new InMemoryCanvasDataStore();
        instance.createDataStore(column, row);
        
        int column1 = 14;
        int row1 = 1;
        int column2 = 18;
        int row2 = 3;
        instance.drawRectangle(column1, row1, column2, row2);
        assertEquals(instance.getDataStore()[1][14], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(instance.getDataStore()[1][15], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(instance.getDataStore()[1][16], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(instance.getDataStore()[1][17], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(instance.getDataStore()[1][18], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        
        assertEquals(instance.getDataStore()[2][14], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(instance.getDataStore()[2][18], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        
        assertEquals(instance.getDataStore()[3][14], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(instance.getDataStore()[3][15], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(instance.getDataStore()[3][16], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(instance.getDataStore()[3][17], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(instance.getDataStore()[3][18], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
    }

    
    @Test
    public void testBloodFill() {
        System.out.println("bloodFill");
        int column = 20;
        int row = 6;
        InMemoryCanvasDataStore instance = new InMemoryCanvasDataStore();
        instance.createDataStore(column, row);
       
        int column1 = 14;
        int row1 = 1;
        int column2 = 18;
        int row2 = 3;
        
        instance.drawRectangle(column1, row1, column2, row2);
        
         int column3 = 0;
         int row4 = 0;
         char charToUpdate = 'c';
         instance.bloodFill(column3, row4, charToUpdate);
         assertEquals(Character.MIN_VALUE, instance.getDataStore()[2][15]);
         assertEquals(Character.MIN_VALUE, instance.getDataStore()[2][16]);
         assertEquals(Character.MIN_VALUE, instance.getDataStore()[2][17]);
        
    } 

    /**
     * Test of deleteDataStore method, of class InMemoryCanvasDataStore.
     */
    @Test
    public void testDeleteDataStore() {
        System.out.println("deleteDataStore");
        InMemoryCanvasDataStore instance = new InMemoryCanvasDataStore();
        instance.deleteDataStore();
        assertNull(instance.getDataStore());
    }

   
    
}
