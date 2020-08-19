import java.util.*;

/**
  * An implementation of Queue using Linked List
  * @author         Ehsan Kourkchi
  * @date           October 23, 2013
*/

public class LinkedQueue<E> {
    
  protected LinkedNode<E> head;
  protected LinkedNode<E> tail;
  protected int size;
  
  /** 
  * constructor to build an empty linkedQueue
  */
  
  public LinkedQueue() {
     
     head = null;
     tail = null;
     size = 0;
  
  }
  
  
  /** 
  * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions
  * 1) Any null value given to offer is discarded rather than added at the end of the queue, and offer returns false
  * 2) If the value is the same as any value already in the queue, the value would not be inserted, and offer returns false
  */
  public boolean offer(E value)  {
  
     int i;
     
     if (value == null) return false;
     
     // if queque is not empty
     if (head != null) {   // if queque is not empty, check if the entered value is already available
        
        LinkedNode<E> temp;
        
        temp = head;
	while (temp != null) {
	    
	    if (value.equals(temp.item)) return false;
	    temp = temp.next;
	}
	
	tail.next = new LinkedNode(value, null);  // adding to the queque end
	tail = tail.next;
	size++;
	
     }
     else {  // queque is Empty
        
        head = new LinkedNode(value, null);  // add the value
        tail = head;
        size ++;     
     }
     
     
    return true;
    
  }
    
  
  /**  
  *  Retrieves and removes the head of this queue, or returns null if this queue is empty
  */
  public E poll() {
  
    if (head == null) 
        return null;   // queue is empty
    else {
        
        E value = head.item;
        head = head.next;
        size--;
        if (head == null) tail = null;  // queue is empty now
        return value;
    
    }
  
  }
    
    
  
  /**  
  *  Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, 
  *  returning true upon success
  */
  public boolean add(E value) {
  
     if (head != null) {   // if queque is not empty,
        
	tail.next = new LinkedNode(value, null);  // adding to the queque end
	tail = tail.next;
	size++;
	
     }
     else {  // queque is Empty
        
        head = new LinkedNode(value, null);  // add the value
        tail = head;
        size ++;     
     }
   
    return true;
  }  
  
  
   
  /**  
  *  Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
  */
  public E peek() {
  
    if (head == null) 
        return null;   // queue is empty
    else return head.item;
  
  } 
  
  
   
  /**  
  *   Retrieves, but does not remove, the head of this queue.
  */
  public E element() throws NoSuchElementException  {
  
    if (head == null) 
        throw new NoSuchElementException("There is no element in this queque.");   // queue is empty
    else return head.item;
  
  }  
  
  
  /**  
  *   Retrieves and removes the head of this queue.
  */
  public E remove() throws NoSuchElementException  {
  
    if (head == null) 
        throw new NoSuchElementException("There is no element in this queque.");   // queue is empty
    else {
        
        E value = head.item;
        head = head.next;
        size--;
        if (head == null) tail = null;  // queue is empty now
        return value;
    
    }
  }   
  
  
  
  /** 
  * This method prints the entire queque. This method is just useful to test the functionality of the other methods.
  */
  public void toPrint() {
  
    if (head == null) 
        System.out.println("Empty, size= " + size);   // queue is empty
    else {
        
        LinkedNode<E> temp = head;
        String st = "";
        
        while (temp != null) {
        
           st += "\""+ (String) temp.item + "\"  ";
           temp = temp.next;
        }
        System.out.println(st+ "  size= " + size);
    }
  
  }
   
    
    

/** 
  * A node in a singly-linked list (this method is taken from class-webpage)
  * @on-line link: http://www2.hawaii.edu/~esb/2013fall.ics211/LinkedNode.java.html
  * @author         Edo Biagioni
  * @lecture        ICS 211 Jan 27 or later
  * @date           January 26, 2011
  * @bugs           private class: include this code within a larger class
  */

private static class LinkedNode<E> {
  private E item;
  private LinkedNode<E> next;


/** 
  * constructor to build a node with no successor
  * @param the value to be stored by this node
  */
  private LinkedNode(E value) {
    item = value;
    next = null;
  }


/** 
  * constructor to build a node with a specified (perhaps null) successor
  * @param the value to be stored by this node
  * @param the next field for this node
  */
  private LinkedNode(E value, LinkedNode<E> reference) {
    item = value;
    next = reference;
  }
}


}   // The end of the outer class