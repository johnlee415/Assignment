/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author WellPLY
 */

   /**
 * SortedListInterface - An interface for the ADT sorted list.
 */
public interface SortedArrayListint<T extends Comparable<T>> {

  /**
   * Task: Adds a new entry to the sorted list in its proper order.
   *
   * @param newEntry the object to be added as a new entry
   * @return true if the addition is successful
   */
  public boolean add(T newEntry);

  /**
   * Task: Removes a specified entry from the sorted list.
   *
   * @param anEntry the object to be removed
   * @return true if anEntry was located and removed
   */
  public boolean remove(T anEntry);

  public boolean contains(T anEntry);

  public void clear();

  public int getLength();
  public T getEntry(int givenPosition);
public boolean replace(int givenPosition, T newEntry);
 

}
