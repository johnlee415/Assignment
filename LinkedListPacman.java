package ADT;


public class LinkedListPacman<T> implements ListInterface<T> {

    private Node firstNode;
    private int length;  	
  
    @Override
    public final void clear() {
        firstNode = null;
        length = 0;
    }

    @Override
    public boolean storeDots(T newDots) {
            Node newNode = new Node(newDots);	
        
        
            if (isEmpty()) {
              firstNode = newNode;
            } else {                        
              Node currentNode = firstNode;	
              while (currentNode.next != null) { 
                currentNode = currentNode.next;
              }
              currentNode.next = newNode; 
            }

            length++;
            return true;
    }

      
    @Override
    public boolean replace(int givenPosition, T newEntry) {
            boolean isSuccessful = true;

            if ((givenPosition >= 1) && (givenPosition <= length)) {
              Node currentNode = firstNode;
              for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;		
              }
              currentNode.data = newEntry;	
            } else {
              isSuccessful = false;
            }

            return isSuccessful;
    }


    @Override
    public int getLength() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        boolean result;

        result = length == 0;

        return result;
    }
      
    @Override
    public boolean chckAllEaten(T anEntry){
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
              found = true;
            } else {
              currentNode = currentNode.next;
            }
        }
          return found;
    }

    @Override
    public String toString() {
        String outputStr = "";
        Node currentNode = firstNode;
        while (currentNode != null) {
            outputStr += currentNode.data + " ";
            currentNode = currentNode.next;
        }
          return outputStr;
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
