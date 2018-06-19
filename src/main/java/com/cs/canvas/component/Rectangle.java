
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
public class Rectangle implements Component{
    int x1, y1,x2,y2;
    @Override
    public void createComponent(DataStore dataStore) {
        dataStore.drawRectangle(x1,y1,x2,y2);
    }
    
}
