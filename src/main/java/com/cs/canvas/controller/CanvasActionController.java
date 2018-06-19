package com.cs.canvas.controller;

import com.cs.canvas.component.BloodFill;
import com.cs.canvas.component.Canvas;
import com.cs.canvas.component.Component;
import com.cs.canvas.component.Container;
import com.cs.canvas.component.Line;
import com.cs.canvas.component.Rectangle;
import com.cs.canvas.datastore.InMemoryCanvasDataStore;
import com.cs.canvas.model.CommandDto;
import com.cs.canvas.ui.UiScreen;

/**
 *
 * @author kaleeswarankaruppusamy
 */
public enum CanvasActionController implements Action<Container> {

    C("C") {
                @Override
                public Container execute(Container container, String input) {
                    Validator<CommandDto> validator = CanvasInputValidator.valueOf(Character.toString(input.charAt(0)));
                    CommandDto command = validator.validate(container,input);
                    container = new Canvas(command.getX1(), command.getY1());
                    container.setDataStore(new InMemoryCanvasDataStore());
                    container.createContainer();
                    UiScreen screen = new UiScreen();
                    container.addObserver(screen);                    
                    container.notifyObservers();
                    return container;
                }
            },
    L("L") {
                @Override
                public Container execute(Container container, String input) {
                    Validator<CommandDto> validator = CanvasInputValidator.valueOf(Character.toString(input.charAt(0)));
                    CommandDto command = validator.validate(container,input);
                    Component component = new Line(command.getX1(), command.getY1(), command.getX2(), command.getY2());
                    container.addComponent(component);
                    container.notifyObservers();
                    return container;
                }
            },
    R("R") {
                @Override
                public Container execute(Container container, String input) {
                    Validator<CommandDto> validator = CanvasInputValidator.valueOf(Character.toString(input.charAt(0)));
                    CommandDto command = validator.validate(container,input);
                    container.addComponent(new Rectangle(command.getX1(), command.getY1(), command.getX2(), command.getY2()));
                    container.notifyObservers();
                    return container;
                }
            },
    B("B") {
                @Override
                public Container execute(Container container, String input) {
                    Validator<CommandDto> validator = CanvasInputValidator.valueOf(Character.toString(input.charAt(0)));
                    CommandDto command = validator.validate(container,input);
                    container.addComponent(new BloodFill(command.getX1(), command.getY1(), command.getCharToUpdate()));
                    container.notifyObservers();
                    return container;
                }
            },
    Q("Q") {
                @Override
                public Container execute(Container container, String input) {
                    if (container == null) {
                        return null;
                    }
                    container.releaseResource();
                    return null;
                }
            };

    private final String action;

    CanvasActionController(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

}
