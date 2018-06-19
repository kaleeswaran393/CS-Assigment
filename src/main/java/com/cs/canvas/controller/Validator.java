package com.cs.canvas.controller;

import com.cs.canvas.component.Container;

/**
 *
 * @author kaleeswarankaruppusamy
 * 
 */
public interface Validator<T> {
  public T validate(Container container,String input);  
}
