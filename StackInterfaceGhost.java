/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author Lei
 */
public interface StackInterfaceGhost<T> {

  
  public void push(T nEntry);

 
  public T pop();

 
  public T peek();

 
  public boolean isEmpty();

 
  public void clear();
  
  public boolean getTest();
  
  public int getLength();
} 