package com.cs.canvas.ui;

import com.cs.canvas.component.Container;
import com.cs.canvas.datastore.DataStore;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import java.util.StringJoiner;

/**
 *
 * @author kaleeswarankaruppusamy
 */
public class UiScreen implements Observer {
   public static String EMPTY = "";
   public static char EMPTY_CHAR = ' ';
    @Override
    public void update(Observable o, Object arg) {
        display(((Container)o).getDataStore());
    }
    
    public void display(DataStore store) {
        Arrays.stream(store.getDataStore())
                .map(a -> {
                    StringJoiner joiner = new StringJoiner(EMPTY);
                    for (char cs : a) {
                        joiner.add(Character.toString(cs ==  Character.MIN_VALUE ? EMPTY_CHAR : cs ));
                    }
                    return joiner.toString();
                })
                .forEach(System.out::println);
    }
}
