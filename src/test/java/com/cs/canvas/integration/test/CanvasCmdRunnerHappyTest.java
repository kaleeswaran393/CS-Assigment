
package com.cs.canvas.integration.test;

import com.cs.canvas.component.Container;
import com.cs.canvas.controller.Action;
import com.cs.canvas.controller.CanvasActionController;
import com.cs.canvas.datastore.InMemoryCanvasDataStore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kaleeswarankaruppusamy
 */
public class CanvasCmdRunnerHappyTest {
    //
    @Test
    public void shouldCreateCanvas() {
        Container container = null;
        String command = "C 20 4";
        Action<Container> parser = CanvasActionController.valueOf(String.valueOf(Character.toString(command.charAt(0))));
        container =  parser.execute(container,command);
        assertEquals(20L, container.getDataStore().getDataStoreColumnSize()- InMemoryCanvasDataStore.ARRAY_EXT_FOR_BORDER);
        assertEquals(4L, container.getDataStore().getDataStoreRowSize()-InMemoryCanvasDataStore.ARRAY_EXT_FOR_BORDER);
        container.releaseResource();
    }
    
    @Test
    public void shouldCreateVerticalLine() {
        Container container = null;
        String command = "C 20 4";
        Action<Container> parser = CanvasActionController.valueOf(String.valueOf(Character.toString(command.charAt(0))));
        container =  parser.execute(container,command);
        
        command = "L 1 2 6 2";
        parser = CanvasActionController.valueOf(String.valueOf(Character.toString(command.charAt(0))));
        container =  parser.execute(container,command);
        char[][] store = container.getDataStore().getDataStore();
        assertEquals(InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE,store[2][1]);
        assertEquals(InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE,store[2][2]);
        assertEquals(InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE,store[2][3]);
        assertEquals(InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE,store[2][4]);
        assertEquals(InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE,store[2][5]);
        assertEquals(InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE,store[2][6]);
        
        container.releaseResource();
    }
    
    @Test
    public void shouldCreateHorizantalLine() {
        Container container = null;
        String command = "C 20 4";
        Action<Container> parser = CanvasActionController.valueOf(String.valueOf(Character.toString(command.charAt(0))));
        container =  parser.execute(container,command);
       
        
        String str = "L 6 3 6 4";
        parser = CanvasActionController.valueOf(String.valueOf(Character.toString(str.charAt(0))));
        container =  parser.execute(container,str);
        char[][] store = container.getDataStore().getDataStore();
        assertEquals(InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE,store[3][6]);
        assertEquals(InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE,store[4][6]);
        
        container.releaseResource();
        
    }
    
    
    @Test
    public void shouldCreateRectangle() {
        Container container = null;
        String command = "C 20 4";
        Action<Container> parser = CanvasActionController.valueOf(String.valueOf(Character.toString(command.charAt(0))));
        container =  parser.execute(container,command);
        
        
        String str = "R 14 1 18 3";
        parser = CanvasActionController.valueOf(String.valueOf(Character.toString(str.charAt(0))));
        container =  parser.execute(container,str);
        char[][] store = container.getDataStore().getDataStore();
        assertEquals(store[1][14], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(store[1][15], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(store[1][16], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(store[1][17], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(store[1][18], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        
        assertEquals(store[2][14], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(store[2][18], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        
        assertEquals(store[3][14], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(store[3][15], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(store[3][16], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(store[3][17], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        assertEquals(store[3][18], InMemoryCanvasDataStore.CHAR_TO_PRINT_LINE);
        
        container.releaseResource();
       
        
    }
    
    @Test
    public void shouldBloodFill() {
        Container container = null;
        String command = "C 20 4";
        Action<Container> parser = CanvasActionController.valueOf(String.valueOf(Character.toString(command.charAt(0))));
        container =  parser.execute(container,command);
      
        command = "L 1 2 6 2";
        parser = CanvasActionController.valueOf(String.valueOf(Character.toString(command.charAt(0))));
        container =  parser.execute(container,command);
        
        command = "L 6 3 6 4";
        parser = CanvasActionController.valueOf(String.valueOf(Character.toString(command.charAt(0))));
        container =  parser.execute(container,command);
        
        command = "R 14 1 18 3";
        parser = CanvasActionController.valueOf(String.valueOf(Character.toString(command.charAt(0))));
        container =  parser.execute(container,command);
        
        command = "B 10 3 o";
        parser = CanvasActionController.valueOf(String.valueOf(Character.toString(command.charAt(0))));
        container =  parser.execute(container,command);
        container =  parser.execute(container,command);
        char[][] store = container.getDataStore().getDataStore();
        assertEquals(Character.MIN_VALUE, store[2][15]);
        assertEquals(Character.MIN_VALUE, store[2][16]);
        assertEquals(Character.MIN_VALUE, store[2][17]);
        
        assertEquals(Character.MIN_VALUE, store[3][1]);
        assertEquals(Character.MIN_VALUE, store[3][2]);
        assertEquals(Character.MIN_VALUE, store[3][3]);
        assertEquals(Character.MIN_VALUE, store[3][4]);
        assertEquals(Character.MIN_VALUE, store[3][5]);
        
        assertEquals(Character.MIN_VALUE, store[4][1] );
        assertEquals(Character.MIN_VALUE, store[4][2]);
        assertEquals(Character.MIN_VALUE, store[4][3]);
        assertEquals(Character.MIN_VALUE, store[4][4]);
        assertEquals(Character.MIN_VALUE, store[4][5]);
        
        container.releaseResource();
    }
    
    
}
