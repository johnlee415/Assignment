package ADT;

public class ArrayQueuePacman<T> implements QueueInterface<T> {

    private T[] array;
    private final static int frontIndex = 0;
    private int backIndex;
    private static final int DEFAULT_CAPACITY = 3;
    private int pacmanLeft = 0;
    
    public ArrayQueuePacman() {
        this(DEFAULT_CAPACITY);
    } 
    
    
    public ArrayQueuePacman(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
        backIndex = -1;
    } 

    @Override 
    public void enqueue(T newEntry) {
        if (!isArrayFull()) {
            backIndex++;
            array[backIndex] = newEntry;
        }
        pacmanLeft++; 
    }

    @Override
    public T getFront() {
        T front = null;

        if (!isEmpty()) {
            front = array[frontIndex];
        }

        return front;
    } 

    @Override
    public T dequeue() {
        T front = null;

        if (!isEmpty()) {
            front = array[frontIndex];

        
            for (int i = frontIndex; i < backIndex; ++i) {
                array[i] = array[i + 1];
            }

            backIndex--;
            pacmanLeft--;
        } 
      return front;
    } 

    @Override
    public boolean isEmpty() {
        return frontIndex > backIndex;
    } 

    @Override
    public void clear() {
        if (!isEmpty()) { 
            for (int index = frontIndex; index <= backIndex; index++) {
                array[index] = null;
            } 

        backIndex = -1;
        pacmanLeft = 0;
        } 
    } 
    
    @Override
    public int getLength(){
        return DEFAULT_CAPACITY;
    }
    
    @Override
    public int getPacmanLeft(){
        return pacmanLeft;
    }

    private boolean isArrayFull() {
        return backIndex == array.length - 1;
    } 
}  
