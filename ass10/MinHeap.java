/**************************************************************************
  The MinHeap class (an implementation of a Mean Heap for HW10)
***************************************************************************/

	        /** 
		* @author               Ehsan Kourkchi
		* @lecture              ICS 211 November 2013
		* @date                 November 22, 2013
		* @class type           public generic class
		*/
/***************************************************************************/

import java.util.* ;



public class MinHeap<E> {


	/** Field variables */
	private E [] heap;       // the pointer to the array containing the min Heap
	private int capacity;   // Capacity of the Heap
	private int size;       // The number of available elements in the Heap
	Comparator<E> comparator = null;   // a comparator which provids the compare method


    /*************************************************/
         /** constructor(s) 
             @param initialCapacity The initial capacity of the array containing the Heap
             @param comparator a comparator which provides the compare method 
         */
    /*************************************************/
    public MinHeap(int initialCapacity, Comparator<E> comparator) {
        
        if (initialCapacity < 1) 
              throw new java.lang.IllegalArgumentException("The initial capacity is leass than 1.");
        
        this.capacity = initialCapacity;
        heap = (E[]) new Object[capacity];
        this.comparator = comparator;
        size = 0;
    
    }
    
    /*************************************************/
    /** add method (as defined in the interface Collection)
        This method uses a loop to re-heapify from the bottom up
    */ 
    /*************************************************/
    boolean add(E newelement) {
        
        long startTime = System.nanoTime();  // recording the system time
        
        
        // 1. Incrreasing the array size if there is not any available space in the array, 
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity*2);
            capacity *= 2;
        }
        
        
        // 2. Adding the new element at the end of the heap array
        heap[size++] =  newelement;
        
        
        
        int child = size-1;
        int parent = (child-1)/2;
        int counter = 0;  // Holds the number of level traversing
 
        
        // 3. Using a loop for re-heapifying
        while (parent >= 0 && compare(heap[parent],heap[child]) > 0)
        {
           
		  // Swaping
		  if(compare(heap[parent], heap[child]) > 0)
		  {
		      swap(parent,child);
		      counter++;
		  }

		  child = parent;
		  parent = (child-1)/2;
        }
 
        
        long estimatedTime = System.nanoTime() - startTime;   // Calculate the method run-time
        System.out.println("\n# of levels traversed to re-heapify (add): " + counter);
        System.out.println("Insertion time [nano-second]: " + estimatedTime);
        
        return true;
        
    } /** End of "add" Method */
    
    
    
    /*************************************************/
    /** Remove method.
        The top most element of the heap would be removed and then it would be replaced with
        the last element.
        This method use a recursive method (i.e. reheapify) to re-heapify
    */
    /*************************************************/
   
    E remove() throws java.util.NoSuchElementException {
        
        long startTime = System.nanoTime();  // recording the system time
        
        if(size == 0) 
               throw new java.util.NoSuchElementException("The Heap is empty.");

               
        E temp = heap[0];      // The Heap root would be returned
        heap[0] = heap[size-1];  // The last element in the heap is replaced with the root
        
        
        // Recursive method for re-heapifying
        // reheapify(first, second)  ... 
        // first is the root index, second is the initial value for the traversed level for re-heapifying
        int counter = reheapify(0, 0);
    
        size--;
        
        System.out.println("\n# of levels traversed to re-heapify (remove): " + counter);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Removing time [nano-second]: " + estimatedTime);
        return temp;
    }
    
    /*************************************************/
    /**  reheapify .. recursive method
         @param index The index of the node which defines a sub-tree to be reheapified
         @param counter The number of level traversed
         @output integer: the final number of traversed levels
    */
    /*************************************************/
    
    private int reheapify(int index, int counter) {
        
        // Base-case: a node with no child
        if(2*index+1 > size-1) return counter;
        
        //  Base-case: a node with just left child
        if(2*index+2 > size-1) {
        
		if(compare(heap[index], heap[2*index+1]) > 0) {
		    swap(index,2*index+1);
		    counter++;
		}
            
        } else {  // a node with both right and left children
        
		int left = 2*index+1;
		int right = 2*index+2;
		int minimum = min(left,right);
		
		if(compare(heap[index], heap[minimum]) < 0) {
		    return counter;   //  Base-case: children are larger than the parent
		    
		} else {
		    
		    swap(index,minimum);   // parent and child are swapped and reheapification continues
		    counter = reheapify(minimum, counter+1);
		
		}
        
        }
        
        return counter;
    
    }
    
    /*************************************************/
      /**
         Swaping the elements with given indices
         @param p first index
         @param q second index
         @scope private
      */
    /*************************************************/   
    private void swap(int p, int q) {
    
         E temp = heap[p];
         heap[p] = heap[q];
         heap[q] = temp;
    
    }
    
    
    /*************************************************/
    /**
        Returning the index of the maximum element   
        @param p first index
        @param q second index
        @scope private
    */
    /*************************************************/
    private int max(int p, int q) {
    
        if(compare(heap[p], heap[q]) < 0)
            return q;
        else
            return p;    
    
    }
    
    /*************************************************/
    /**
        Returning the index of the minimum element   
        @param p first index
        @param q second index
        @scope private
    */    
    /*************************************************/
    private int min(int p, int q) {
    
        if(compare(heap[p], heap[q]) > 0)
            return q;
        else
            return p;
    
    }
    
    /*************************************************/
    /**
        Comparint the input arguments using the compare method provided by comparator 
        @param E left
        @param E right
        @scope private
        
        Comparator is what provided for the constructor when instanciating the Heap object
    */  
    /*************************************************/
    private int compare(E left, E right) {
    
        return comparator.compare(left, right);
        
    }
    
    
    /*************************************************/
    /**
        A methos to print the Heap elements successively
    */
    /*************************************************/
    public void printMe() {
       
       String str="";
       
	  for(int i=0; i<size; i++) {
	      
	      str = str + heap[i].toString() + "  ";
	  
	  }
	  
	  System.out.println(str);
    
    }
    
    


}  /** The end of "MinHeap" class */