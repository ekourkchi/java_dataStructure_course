import java.util.*;

/**
  * An implementation of Queue using Array (Size = 10)
  * @author         Ehsan Kourkchi
  * @date           October 23, 2013
*/

public class ArrayQueue<E> {


private E[] array;
private int begin;
private int end;
boolean isFull;


  public ArrayQueue() {
     
     array = (E []) (new Object[10]);  // make room for at least 10 items
     begin = 0;
     end = 0;
     isFull = false;
  }

   
  /** 
  * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions
  *    Any null value given to offer is discarded rather than added at the end of the queue, and offer returns false
  * 1) If the value is the same as any value already in the queue, the value would not be inserted, and offer returns false
  * 2) If the Queue is full (i.e. size=10) then the value won't be added, and offer returns false
  */
  public boolean offer(E value)  {
  
     int i;
     
     if (value == null || isFull == true) return false;
     
     // if queque is not empty
     if (begin != end) {   // if queque is neither empty nor full, check if the entered value is already available
        
	i = begin;
	do {
	    
	    if (value.equals(array[i])) return false;
	    i = (i+1)%10;
	} while (i != end);
	
	
	array[end] = value;  // adding to the queque end
	end = (i+1)%10;
	
	if (end == begin) isFull = true;
	
     }
     else {  // queque is Empty
        
        array[end] = value;  // add the value
        end = (end+1)%10;
     }
     
     
    return true;
    
  }


  
  /**  
  *  Retrieves and removes the head of this queue, or returns null if this queue is empty
  */
  public E poll() {
  
    if (begin == end && isFull == false) 
        return null;   // queue is empty
    else {
        
        E value = array[begin];
        begin = (begin+1)%10;
        isFull = false;    // after removing an element, queue has always at least one room
        return value;
    }
  
  }  
  

  
  /**  
  *  Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, 
  *  returning true upon success
  */
  public boolean add(E value) {
  
    if (!isFull) {
       
       array[end] = value;
       end = (end+1)%10;
       if (end == begin) isFull = true;
       
       return true;
    }
    else
       return false;
  }  
 
 
  
  /**  
  *  Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
  */
  public E peek() {
  
    if (begin == end && isFull == false) 
        return null;   // queue is empty
    else return array[begin];
  
  } 
 
 
 
  /**  
  *   Retrieves, but does not remove, the head of this queue.
  */
  public E element() throws NoSuchElementException  {
  
    if (begin == end && isFull == false)  // queue is empty
        throw new NoSuchElementException("There is no element in this queque.");   // queue is empty
    else return array[begin];
  
  }  

  
  /**  
  *   Retrieves and removes the head of this queue.
  */
  public E remove() throws NoSuchElementException  {
  
    if (begin == end && isFull == false)   // queue is empty
        throw new NoSuchElementException("There is no element in this queque.");   // queue is empty
    else {
        
        E value = array[begin];
        begin = (begin+1)%10;
        isFull = false;    // after removing an element, queue has always at least one room
        return value;
    
    }
  }   
  
  
      
  /** 
  * This method prints the entire queque. This method is just useful to test the functionality of the other methods.
  */
  public void toPrint() {
    
    int i;
    int size = 0;
  
    if (begin == end && isFull == false) 
        System.out.println("Empty, size= " + size);   // queue is empty
    else {
        
	i = begin;
	String st = "";
	do {
	    
	    st += "\"" + array[i].toString() + "\"  ";
	    size++;
	    i = (i+1)%10;
	} while (i != end);
	
        System.out.println(st+ "  size= " + size);
    }
  
  }     
      
      
  
}  // End of class



