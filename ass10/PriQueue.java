/************************************************************************************
  The PriQueue class (an implementation of a Priority Queque using a Min-Heap for HW10)
*************************************************************************************/

	        /** 
		* @author               Ehsan Kourkchi
		* @lecture              ICS 211 November 2013
		* @date                 November 22, 2013
		* @class type           public generic class
		*/
/************************************************************************************/

import java.util.* ;




public class PriQueue<E> {



    Comparator<E> comparator = null;   // a comparator which provids the compare method
    MinHeap<E> priorityHeap = null;   // the pointer to a MinHeap which plays the role of priority queque


    /*************************************************/
         /** constructor(s) 
            @param initialCapacity The initial capacity of the PriorityQueque
            @param comparator a comparator which provides the compare method          
         */
    /*************************************************/
    public PriQueue(int initialCapacity, Comparator<E> comparator) {
    
        this.priorityHeap = new MinHeap(initialCapacity, comparator);
    
    }

    /*************************************************/
       /**
          Inserts the specified element into this priority queue.
          
       */
   /*************************************************/
    boolean add(E record) {
    
        return priorityHeap.add(record);
    
    }
    
    
    /*************************************************/
      /**
         Retrieves and removes the head of this queue, or returns null if this queue is empty.
      */
    /*************************************************/
    E poll() {
        
        E temp;
        
        try {
            temp = priorityHeap.remove();
        } catch(java.util.NoSuchElementException ex) {
            return null;
        }

        return temp;  
    
    }

    
    /*************************************************/
    /**
        A methos to print the Heap elements successively
    */
    /*************************************************/
    public void printMe() {
    
        priorityHeap.printMe();
    
    }




}   /** The end of "PriQueque" class */