package com.cs.canvas.model;

import lombok.Data;
import lombok.ToString;
/**
 *
 * @author kaleeswarankaruppusamy
 */
@Data
@ToString
public class CommandDto {

    private String action;
    private char charToUpdate;
    private int x1, y1, x2, y2;

    public CommandDto(int x1,int y1){
        this.x1=x1;
        this.y1=y1;
    }
    
    public CommandDto(String action){
        this.action=action;
    }
    public CommandDto(String action,int x1,int y1){
        this.action=action;
        this.x1=x1;
        this.y1=y1;
    }
    public CommandDto(String action,int x1,int y1,int x2,int y2){
        this.action=action;
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }
    public CommandDto(String action,int x1,int y1,char charToUpdate){
        this.action=action;
        this.x1=x1;
        this.y1=y1;
        this.charToUpdate=charToUpdate;
    }
}
