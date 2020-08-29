package ADT;

/**
 * LinkedQueue.java A class that implements the ADT queue by using a chain of
 * nodes that has both head and tail references. NOTE: This version does not
 * include the setNextNode, getNextNode, setData and getData methods in the Node
 * class
 */
public class LinkedQueueMap<T> implements QueueInterfaceMap<T> {

  private Node firstNode; // references node at front of queue
  private Node lastNode;  // references node at back of queue
  private short storeData = 0;

  public LinkedQueueMap() {
    firstNode = null;
    lastNode = null;
  } 

  public void enqueue(T newEntry) {
    Node newNode = new Node(newEntry, null);

    if (isEmpty()) {
      firstNode = newNode;
    } else {
      lastNode.next = newNode;
    }

    lastNode = newNode;
    
    storeData++;
  } 

  public T getFront() {
    T front = null;

    if (!isEmpty()) {
      front = firstNode.data;
    }

    return front;
  } 

  public T dequeue() {
    T front = null;

    if (!isEmpty()) {
      front = firstNode.data;
      firstNode = firstNode.next;

      if (firstNode == null) {
        lastNode = null;
      }
    } 

    storeData--;
    
    return front;
    
  } 

  public boolean isEmpty() {
    return (firstNode == null) && (lastNode == null);
  }

  public void clear() {
    firstNode = null;
    lastNode = null;
    storeData = 0;
  } 


  private class Node {

    private T data; 
    private Node next; 

    private Node(T data) {
      this.data = data;
      this.next = null;
    } 

    private Node(T data, Node next) {
      this.data = data;
      this.next = next;
    } 
  } 
} 
