
package com.cs.canvas.integration.test;

import com.cs.canvas.component.Container;
import com.cs.canvas.controller.Action;
import com.cs.canvas.controller.CanvasActionController;
import org.junit.Test;

/**
 *
 * @author kaleeswarankaruppusamy
 */
public class CanvasCmdRunnerUnHappyTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() {
        String command = "D 20 4";
        Action<Container> parser = CanvasActionController.valueOf(String.valueOf(Character.toString(command.charAt(0))));        
    }
    
    
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowNumberFormatException() {
        Container container = null;
        String command = "C Y 4";
        Action<Container> parser = CanvasActionController.valueOf(String.valueOf(Character.toString(command.charAt(0))));
        container =  parser.execute(container,command);
      
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForSize() {
        Container container = null;
        String command = "C 10 20";
        Action<Container> parser = CanvasActionController.valueOf(String.valueOf(Character.toString(command.charAt(0))));
        container =  parser.execute(container,command);      
    }
   
}
