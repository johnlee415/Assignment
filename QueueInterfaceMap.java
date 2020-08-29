package ADT;

public interface QueueInterfaceMap<T> {

  public void enqueue(T newEntry);
  public T dequeue();
  public T getFront();
  public boolean isEmpty();
  public void clear();
} 
