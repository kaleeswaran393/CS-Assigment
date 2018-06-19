package com.cs.canvas.main;

import com.cs.canvas.controller.Action;
import com.cs.canvas.component.Container;
import com.cs.canvas.controller.CanvasActionController;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author kaleeswarankaruppusamy
 */
@Slf4j
public class CanvasCmdRunner {
    public static char QUIT = 'Q';
    static Container container = null;
    public static void main(String arg[]) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("enter command : ");
            while (scan.hasNextLine()) {
                String str = StringUtils.trim(scan.nextLine());
                try {
                    log.debug("Output Object, {}", str.charAt(0));
                    Action<Container> parser = CanvasActionController.valueOf(String.valueOf(Character.toString(str.charAt(0))));
                    container = parser.execute(container,str);
                    if(str.charAt(0) == QUIT){
                      break;
                    }
                }catch(NumberFormatException | ArrayIndexOutOfBoundsException ex){   
                    log.error(ex.getMessage());
                }
                catch(IllegalArgumentException ex){   //intentionally suppressing message log
                    log.error("Invalid Command, Please refer imput manual");
                }
                System.out.print("enter command : ");
            }
        }
    }
}
