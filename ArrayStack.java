/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author Lei
 * @param <T>
 */
public class ArrayStack<T> implements StackInterfaceGhost<T> {
    
    
   private T[] array;
  private int topIndex; // index of top entry
  private static final int DEFAULT_CAPACITY = 50;
private boolean test = false;
  
  public ArrayStack() {
    this(DEFAULT_CAPACITY);
  }

  public ArrayStack(int initialCapacity) {
    array = (T[]) new Object[initialCapacity];
    topIndex = -1;
  }

  public void push(T newEntry) {
    topIndex++;

    if (topIndex < array.length) {
      array[topIndex] = newEntry;
    }
    
  test = true;
  }

  public T peek() {
    T top = null;

    if (!isEmpty()) {
      top = array[topIndex];
    }

    return top;
  } 

  public T pop() {
    T top = null;

    if (!isEmpty()) {
      top = array[topIndex];
      array[topIndex] = null;
      topIndex--;
    } // end if

    return top;
    
  } 

  public boolean isEmpty() {
    return topIndex < 0;
  } 

  public void clear() {
    topIndex = -1;
  } 
  
  public boolean getTest(){
      return test;
  }
  

    public int getLength(){
        return DEFAULT_CAPACITY;
    }
} 
