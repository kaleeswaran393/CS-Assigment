package com.cs.canvas.datastore;

public interface DataStore{
    public void createDataStore(int column,int row) ;
    public void drawLine(int column1,int row1,int column2,int row2); 
    public void drawRectangle(int column1,int row1,int column2,int row2) ;
    public void bloodFill(int column,int row, char charToUpdate) ;
    public char[][] getDataStore();
    public int getDataStoreRowSize();
    public int getDataStoreColumnSize();
    public void deleteDataStore();
}