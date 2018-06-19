
package com.cs.canvas.component;

import com.cs.canvas.datastore.DataStore;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author kaleeswarankaruppusamy
 */
@Data
@AllArgsConstructor
public class BloodFill implements Component{
    private int x1,y1;
    private char charToUpdate;
    @Override
    public void createComponent(DataStore dataStore) {
       dataStore.bloodFill(x1,y1,charToUpdate);
    }
}
