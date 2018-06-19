
package com.cs.canvas.component;

import com.cs.canvas.datastore.DataStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import lombok.Data;

/**
 *
 * @author kaleeswarankaruppusamy
 */
@Data
public abstract class Container extends Observable {
    
   
   
   private DataStore dataStore;  
   
   private List<Component> listOfcComponents = new ArrayList<>();
  
   public abstract void createContainer();
   
   public void addComponent(Component component) {
       component.createComponent(dataStore);
       listOfcComponents.add(component);
       setChanged();
   }

    public void releaseResource() {
        dataStore.deleteDataStore();
    }
   
}
