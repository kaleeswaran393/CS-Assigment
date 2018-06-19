package com.cs.canvas.controller;

import com.cs.canvas.component.Container;
import com.cs.canvas.datastore.InMemoryCanvasDataStore;
import com.cs.canvas.model.CommandDto;

/**
 *
 * @author kaleeswarankaruppusamy
 */
public enum CanvasInputValidator implements Validator<CommandDto> {

    C("C") {
                @Override
                public CommandDto validate(Container container, String input) {
                    try {
                        String str[] = input.split(" ");
                        if(str.length != 3){
                          throw new IllegalArgumentException("Invalid Input");
                        }
                        CommandDto commandDto = new CommandDto(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]));
                        if (commandDto.getX1() <= commandDto.getY1()) {
                            throw new IllegalArgumentException(" No. of column shuold greater tha no. of ro");
                        }
                        return commandDto;
                    } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
                        throw new ArrayIndexOutOfBoundsException("Invalid Input, Sample valid input format is C 20 4");
                    }

                }
            },
    L("L") {
                @Override
                public CommandDto validate(Container container, String input) {
                    try {
                        String str[] = input.split(" ");
                        if(str.length != 5){
                          throw new IllegalArgumentException("Invalid Input");
                        }
                        CommandDto commandDto = new CommandDto(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4]));
                        validateInput(container, commandDto);
                        return commandDto;
                    } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
                        throw new ArrayIndexOutOfBoundsException("Invalid Input, Sample valid input format is L 1 2 6 2");
                    }

                }
            },
    R("R") {
                @Override
                public CommandDto validate(Container container, String input) {
                    try {
                        String str[] = input.split(" ");
                        if(str.length != 5){
                          throw new IllegalArgumentException("Invalid Input");
                        }
                        CommandDto commandDto = new CommandDto(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4]));
                        validateInput(container, commandDto);
                        return commandDto;
                    } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
                        throw new ArrayIndexOutOfBoundsException("Invalid Input, Sample valid input format is R 14 1 18 3");
                    }
                }
            },
    B("B") {
                @Override
                public CommandDto validate(Container container, String input) {
                    try {
                        String str[] = input.split(" ");
                        if(str.length != 4){
                          throw new IllegalArgumentException("Invalid Input");
                        }
                        CommandDto commandDto =  new CommandDto(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), str[3].charAt(0));
                        if(container==null){
                           throw new IllegalArgumentException("Create Canvas First"); 
                        }
                        if (commandDto.getX1() > container.getDataStore().getDataStoreColumnSize() - 2
                        || commandDto.getX2() > container.getDataStore().getDataStoreRowSize() - 2) {
                          throw new IllegalArgumentException("Column size should be less than the Total Canvas Column size");
                        }               
                      return commandDto;
                    } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
                        throw new ArrayIndexOutOfBoundsException("Invalid Input, Sample valid input format is B 10 3 o");
                    }
                }
            };

    private final String action;

    CanvasInputValidator(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    private static void validateInput(Container container, CommandDto commandDto) {
        if(container==null){
                           throw new IllegalArgumentException("Create Canvas First"); 
        }else if (commandDto.getX1() > container.getDataStore().getDataStoreColumnSize() - InMemoryCanvasDataStore.ARRAY_EXT_FOR_BORDER
                || commandDto.getX2() > container.getDataStore().getDataStoreColumnSize() - InMemoryCanvasDataStore.ARRAY_EXT_FOR_BORDER) {
            throw new IllegalArgumentException("Column size should be less than the Total Canvas Column size");
        } else if (commandDto.getY1() > container.getDataStore().getDataStoreRowSize() - InMemoryCanvasDataStore.ARRAY_EXT_FOR_BORDER
                || commandDto.getY2() > container.getDataStore().getDataStoreRowSize() - InMemoryCanvasDataStore.ARRAY_EXT_FOR_BORDER) {
            throw new IllegalArgumentException("Row size should be less than the Total Canvas Row size");
        }
    }

}
