/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;
import entity.Leaderboard;



/**
 *
 * @author WellPLY
 * @param <T>
 */ 
public class SortedArrayList <T extends Comparable<T>> implements SortedArrayListint<T> {
 
 private T[] array;
  private int length;
  private static final int DEFAULT_CAPACITY = 10000;


  public SortedArrayList() {
    this(DEFAULT_CAPACITY);
  }
 @Override
   public boolean replace(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      array[givenPosition - 1] = newEntry;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  public SortedArrayList(int initialCapacity) {
    length = 0;
    array = (T[]) new Comparable[initialCapacity];
  }
 @Override
  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      result = array[givenPosition - 1];
    }

    return result;
  }
  

  public boolean add(T newEntry) {
    int i = 0;
    while (i < length && newEntry.compareTo(array[i]) < 0) {
      i++;
    }
    makeRoom(i + 1);
    array[i] = newEntry;
    length++;
    return true;
  }

  public boolean remove(T anEntry) {
    throw new UnsupportedOperationException();
  }
 
  public void clear() {
    length = 0;
  }

  public boolean contains(T anEntry) {
    boolean found = false;
    for (int index = 0; !found && (index < length); index++) {
      if (anEntry.equals(array[index])) {
        found = true;
      }
    }
    return found;
  }

  public int getLength() {
    return length;
  }
 

  public boolean isEmpty() {
    return length == 0;
  }

  public String toString() {
    String outputStr = "";
    for (int index = 0; index < length; ++index) {
      outputStr += array[index] + "\n";
    }

    return outputStr;
  }

  private boolean isArrayFull() {
    return length == array.length;
  }

  private void doubleArray() {
    T[] oldList = array;
    int oldSize = oldList.length;

    array = (T[]) new Object[2 * oldSize];

    for (int index = 0; index < oldSize; index++) {
      array[index] = oldList[index];
    }
  }

  private void makeRoom(int newPosition) {
    int newIndex = newPosition - 1;
    int lastIndex = length - 1;

    for (int index = lastIndex; index >= newIndex; index--) {
      array[index + 1] = array[index];
    }
  }

  private void removeGap(int givenPosition) {
    int removedIndex = givenPosition - 1;
    int lastIndex = length - 1;

    for (int index = removedIndex; index < lastIndex; index++) {
      array[index] = array[index + 1];
    }
  }

}
