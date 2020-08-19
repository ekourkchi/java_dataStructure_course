import java.util.*;

/** @CircularDoubleLinkedList.java
     @CircularDoubleLinkedList   // definition of the circular linked list
       @CircularDoubleIterator      // definition of the ListIterator that spans CircularDoubleLinkedList
*/


public class CircularDoubleLinkedList<E> implements Iterable<E> {


private DoubleLinkedNode<E> head = null;
private DoubleLinkedNode<E> tail = null;
private int size = 0;




  /** Constructor: it constructs an empty double-linked list. */
  public CircularDoubleLinkedList() {
     head = null;
     tail = null;
     size = 0;
  }

  /** This calss implements Iterable interface
      @ Therefore the "iterator" method is provided
      @ "CircularDoubleIterator" is an inner class of the current class
  */
  public ListIterator<E> iterator() {
     return new CircularDoubleIterator();
  }

  
  
  /** adds an item to the end of the list */
  public void add(E data) {
  
     if (size == 0) {
        head = new DoubleLinkedNode(data);
        tail = head;
        head.setNext(head);
        head.setPrevious(head);
     }
     else {
        DoubleLinkedNode<E> newNode = new DoubleLinkedNode(data);
        tail.setNext(newNode);        
        newNode.setPrevious(tail);
        tail = newNode;   // tail points to the new node
        head.setPrevious(tail);
        newNode.setNext(head);
     }
     
     size++;
  }
  
  
  
  /** adds an item at the specified index */
  public void add(int index, E data) {
     
     if (size == 0)
	  add(data);
     else {
	  int i;
	  DoubleLinkedNode<E> current = head;
	  size++;
	  
	  // This is an circular list. So module is used in order "index" circles around the circular list.
	  index = ((index % size) + size ) % size;  
    
	  for(i=0; i < index; i++)
	      current = current.getNext();
	  
	  DoubleLinkedNode<E> newNode = new DoubleLinkedNode(data);
	  
	  newNode.setNext(current);
	  newNode.setPrevious(current.getPrevious());
	  current.getPrevious().setNext(newNode);
	  current.setPrevious(newNode);
	  
	  if (index == size-1) 
	      tail = newNode;
	      
	  if (index == 0)
	      head = newNode;
     }
  }
  
  
  
  private void addFirst(E data) {
     
     if (size == 0) {
     
        head = new DoubleLinkedNode(data);
        tail = head;
        head.setNext(head);
        head.setPrevious(head);
     }
     else {
     
        DoubleLinkedNode<E> newNode = new DoubleLinkedNode(data);
        head.setPrevious(newNode);
        newNode.setNext(head);
        newNode.setPrevious(tail);
        tail.setNext(newNode);
        head = newNode;
     }

     size++;
  }
  
  
  
  /** returns the data stored at the specified index */
  public E get(int index) {
  
     int i;

     index = ((index % size) + size ) % size;
     DoubleLinkedNode<E> current = head;
     
     for(i=0; i < index; i++)
        current = current.getNext();
     
     return current.getData();
  
  }
  
  /** removes and returns an item from the list */
  public E remove(int index) {

     if (size == 0)
        return null;

     int i;
     DoubleLinkedNode<E> current = head;
     index = ((index % size) + size ) % size;
      
     for(i=0; i < index; i++)
        current = current.getNext();
     
     current.getNext().setPrevious(current.getPrevious());
     current.getPrevious().setNext(current.getNext());
     
     if (current.equals(head)) 
        head = current.getNext();
     
     if (current.equals(tail)) 
        tail = current.getPrevious();
       
     size--;
        
     if (size == 0) {
        head = null; 
        tail = null;
     }
        
     return current.getData();     
   
  }
  
  /** Returns the size of the list */
  public int size() {
     return size;
  }
     
  
  
  
  /** returns a String of all values V from the front to the end of the list 
      using the following format: [V0,V1,V,V,V,...,VN] 
  */   
  public String toString() {
          
     int i;
     String outString="[";
     DoubleLinkedNode<E> current = head;
          
     if (head == null) 
        return "[]";
     
     i = 1;
     
     do {
     
        if (i > 1) outString += ",";
        outString += current.getData().toString();
        current = current.getNext();  
        i++;
     }  while (!current.equals(head));
     
     outString += "]";
     
     return outString;
     
  }
 

/*****************************************************************************************************
@CircularDoubleIterator 
@ implements ListIterator interface
@ All provided interface methods are defined in this innr class 

@ Note: If user uses the provided "add" and "remove" methods 
in this class, by any other use of "add" and "remove" method of 
the outer, the iterator can no longer be used.
*****************************************************************************************************/

  private class CircularDoubleIterator implements ListIterator<E> {
                 
       private DoubleLinkedNode<E> currentNode;
       private DoubleLinkedNode<E> lastCall;
       boolean previousIndicator = false ; 
       private int index;
                 

          public CircularDoubleIterator() {
                 
             currentNode = head;
             lastCall = null;
             index = 0;
          }

/*****************************************************************************************************/


          /** Checks whther there is any element next to the current position of the iterator */
          
          public boolean hasNext() {
          
             return (size != 0 && currentNode != null && currentNode.getNext() != null);
          
          }
                 
                 
/*****************************************************************************************************/
                
          /** Checks is there is any elements before the current position of the iterator */
          
          public boolean hasPrevious() {
          
             return (size != 0 && currentNode != null && currentNode.getPrevious() != null);
          
          } 
          
                 
/*****************************************************************************************************/
          
          /** Returns the next element after the curent position of the iterator and push
          the iterator index forward
          If the iterator is at the end of the list, it starts again from the beginning
          
          */ 
          
          public E next() {
             
             if (size == 0) 
                 throw new NoSuchElementException("The circular linked list is empty.");
                 
             if (size != 0 && currentNode == null) 
                 currentNode = head;

             lastCall = currentNode;
             currentNode = currentNode.getNext();
             index = (index + 1) % size;
             previousIndicator = false;
             
             return lastCall.getData();
                 
          }
                 
 /*****************************************************************************************************/
          
          /**  Return the next index whose value would be returned by calling the next() method */
          
          public int nextIndex() {
          
             if (size == 0) 
                 throw new NoSuchElementException("The circular linked list is empty.");
               
             return (index) % size;
          }
                 
 /*****************************************************************************************************/
         
          /** Return the previous element of the list respect to the iterator and
          push the iterator index backward
          If the iterator is at the beginning of the list, it starts again from the last element          
          */
          
          public E previous() {
                 
              if (size == 0) 
                  throw new NoSuchElementException("The circular linked list is empty.");
                       
              if ( size != 0 && currentNode == null)  
                  currentNode = head; 
                       
              currentNode = currentNode.getPrevious();
              lastCall = currentNode;

              index = ((index - 1) % size + size) % size  ;
              previousIndicator = true;
              
              return currentNode.getData();
          }
                 
 /*****************************************************************************************************/
                
          /**  Return the prvious index whose value would be returned by calling the previous() method */       
                 
          public int previousIndex() {
               
               if (size == 0) 
                  throw new NoSuchElementException("The circular linked list is empty.");
               
               return ((index - 1) % size + size) % size  ;
          }
                 
                 
                 
 /*****************************************************************************************************/
          
          /** Removes the next element which was returned by either next() or previous() methods
          If no next() nor previous() methods have been called before, it returns NoSuchElementException          
          */ 
                 
          public void remove() {
               
               if (size == 0 || lastCall == null) 
                  throw new NoSuchElementException("Either the circular linked list is empty or no previous use of next() or previous() methods.");
                    
               lastCall.getNext().setPrevious(lastCall.getPrevious());
               lastCall.getPrevious().setNext(lastCall.getNext());
        
               if (lastCall.equals(head)) 
                  head = lastCall.getNext();
               
               if (lastCall.equals(tail)) 
                  tail = lastCall.getPrevious();
                  
               currentNode = lastCall.getNext();
               lastCall = null;
               size--;
               
               if (size == 0) {
                  head = null; 
                  tail = null;
                  index = 0;
                  currentNode = head;
                  lastCall = null;
               }
               else {  
               
                  if (previousIndicator == false) 
                     index = ((((index-1) % (size+1))+(size+1)) % (size+1)) % size; 
                        else 
                           index = ((((index) % (size+1))+(size+1)) % (size+1)) % size;
               }
          }
                 
                 
/*****************************************************************************************************/
         
         /** changes the value of the last returned element by either next() or previous() methods */
                 
          public void set(E data) throws NoSuchElementException  {

               if (size == 0 || lastCall == null) 
                  throw new NoSuchElementException("Either the circular linked list is empty or no previous use of next() or previous() methods."); 
                    
               lastCall.setData(data);
                     
          }
  
  
/*****************************************************************************************************/
         
          /** Add a new element next to the current position of the iterator and pushes the iterator forward.          
          */
  
          public void add(E data) {
                 
               if (size == 0) {
                      
                  head = new DoubleLinkedNode(data);
                  tail = head;
                  head.setNext(head);
                  head.setPrevious(head);
                  index = 0 ;
                  currentNode = head;
                  lastCall = null;
                  size++;
                  index = ((index % size) + size ) % size;                  
                               
               }
               else {
                              
                  DoubleLinkedNode<E> newNode = new DoubleLinkedNode(data);
                  newNode.setNext(currentNode);
                  newNode.setPrevious(currentNode.getPrevious());
                  currentNode.getPrevious().setNext(newNode);
                  currentNode.setPrevious(newNode);
                  size++;                       
                  index = (((index+1) % size) + size ) % size; // pushing the iterator forward in a circular way                    
                       
                  if (currentNode.equals(head)) 
                      head = newNode;
                       
                  currentNode = newNode.getNext();
                          
               }
                     
          } /** The end of the s"add" method. */
                 
/*****************************************************************************************************/
  
  
  
  } /** The End of the inner class */
  
} /** The End of the outer class */