
package com.cs.canvas.datastore;

import lombok.Data;
import lombok.ToString;
/**
 *
 * @author kaleeswarankaruppusamy
 */
@Data
@ToString
public class InMemoryCanvasDataStore  implements DataStore{
    
    private int column;
    private int row;
    private char[][] container;
    
    public static int ARRAY_EXT_FOR_BORDER = 2;
    
    public static char CHAR_TO_PRINT_LINE = 'x';
    
    public static char CHAR_TO_PRINT_ROW_BORDER = '|';
    
    public static char CHAR_TO_PRINT_COLUMN_BORDER = '-';
   
    @Override
    public void createDataStore(int column,int row) {
        this.column = column + ARRAY_EXT_FOR_BORDER;
        this.row=  row + ARRAY_EXT_FOR_BORDER;
        container = new char[this.getRow()][this.getColumn()];
        drawBorder();
        
    }
    
    @Override
    public void drawLine(int column1,int row1,int column2,int row2) {
        if(row1 == row2){
            for(int j = column1; j<=column2; j++){
                container[row1][j] = CHAR_TO_PRINT_LINE;
            }
        }   
        if(column1==column2){
            for(int i = row1; i<=row2; i++){
                container[i][column1] = CHAR_TO_PRINT_LINE;
            }
        }
    }

    @Override
    public void drawRectangle(int column1,int row1,int column2,int row2) {
        for (int i = row1; i <= row2; i++) {
            for (int j = column1; j <= column2; j++) {
                   if(i==row1 || i==row2){
                     container[i][j]=CHAR_TO_PRINT_LINE; 
                   }
                   if( (i!= row1 && i!= row2 && j == column1) 
                           || (i!= row1 && i!= getRow() && j == column2)){
                     container[i][j]=CHAR_TO_PRINT_LINE;   
                   }
              }
         }  
    }

    @Override
    public void bloodFill(int column,int row, char charToUpdate) {
        if(container[row][column] == Character.MIN_VALUE ){
           container[row][column] = charToUpdate ;
           bloodFill(column+1,row,charToUpdate);
           bloodFill(column-1,row,charToUpdate);
           bloodFill(column,row+1,charToUpdate);
           bloodFill(column,row-1,charToUpdate);
        }
    }
     
    private void drawBorder(){
        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getColumn(); j++) {
                   if(i==0 || i==getRow()-1){
                     container[i][j]=CHAR_TO_PRINT_COLUMN_BORDER; 
                   }
                   if( (i!= 0 && i!= getRow()-1 && j == 0) 
                           || (i!= 0 && i!= getRow()-1 && j == getColumn()-1)){
                     container[i][j]=CHAR_TO_PRINT_ROW_BORDER;   
                   }
              }
         }  
    }  

     public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    @Override
    public char[][] getDataStore() {
        return container;
    }

    @Override
    public int getDataStoreRowSize() {
        return row;
    }

    @Override
    public int getDataStoreColumnSize() {
        return column;
    }
    
    @Override
    public void deleteDataStore(){
        container = null;
    }
    
    
    
}
