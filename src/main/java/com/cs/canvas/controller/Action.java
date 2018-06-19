package com.cs.canvas.controller;


/**
 *
 * @author kaleeswarankaruppusamy
 */
public interface Action<T> {
  public T execute(T t,String input);  
}
