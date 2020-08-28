package ADT;


public interface ListInterface<T> {

    public boolean storeDots(T newDots);
    public void clear();
    public boolean replace(int givenPosition, T newEntry);
    public int getLength();
    public boolean isEmpty();
    public boolean chckAllEaten(T anEntry);
}
