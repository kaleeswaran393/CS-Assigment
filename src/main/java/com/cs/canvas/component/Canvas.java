package com.cs.canvas.component;

import lombok.Data;

/**
 *
 * @author kaleeswarankaruppusamy
 */
@Data
public class Canvas extends Container {
    private int column, row;

    public Canvas(int column,int row) {
        this.column=column;
        this.row=row;
    }

    @Override
    public void createContainer() {
        getDataStore().createDataStore(column, row);
        setChanged();
    }   

}
