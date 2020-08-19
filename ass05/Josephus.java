import java.util.*;

/**

@Homework 5
@ICS 211

@class Josephus include the main() driver of the program
@testList() is method which is called insode the main method and build the Josephus round table 
and selects which member must leave in each round

@Author: Ehsan Kourkchi
@October 2013

*/


public class Josephus {




    /** 
    * this method tests the CircularDoubleLinkedList object to form the Josephus round table
    and returns a regular inbuilt LinkedList containing the number of the members who leave the circle in order
    
    @size: the number of members sitting around the Josephus table
    @start: the nemumber of the member from whom we star counting off
    @step: the number of members that we count off to find the next member who leaves the circle
    @isClockwise: it indicates whether to count off clock-wise or counter clock-wise. 
        
    */

     public static LinkedList<Integer> testList(int size, int start, int step, boolean isClockwise) {
     
        int i, index, result;
        
        // Creating the output LinkedList (i.e. outList) which holds the output of this method
        LinkedList<Integer> outList = new LinkedList();
        
        // Defining an iterator in outList to use its 'add" method
        ListIterator<Integer> outIter = outList.listIterator();
        
        
        // definig the Josephus table which is in fact a circular double lined list
        CircularDoubleLinkedList<Integer> JosephusTable = new CircularDoubleLinkedList();
        
        // filling in the Josephus table with the member numbers using a single for-loop.
        // the numbers stars from one and is assumed to be incremented Clock-wise
        for (i=0; i< size; i++) {
            JosephusTable.add(i+1);
        }
        
        
        // Taking the advantage of the circular linked list iterator to faster span the Josephus table
        ListIterator<Integer> iter = JosephusTable.iterator();
        
        
        // Moving the Josephus table iterator to the starting point
        for (index =1; index < start; index++) { 
        iter.next();         
        }
        
        
        // if the counting is counter clock-wise, we have to use the previous method of the 
        // iterator. Therefore, we have to push the iterator forward one more time
        if (!isClockwise) iter.next(); 
        
        
		index = 1;  // member counter
		while (JosephusTable.size() >= 1) {
		  
		  if (isClockwise) result = iter.next(); else {result = iter.previous();}
		  
		  
		  // determining when we meet the person who has to leave the table
		  if ((index % step) == 0 ) { 
		      
		      // each leaving member is removed from the circular list 
		      // and is added to the output linkedlist
		      iter.remove();
		      outIter.add(result);
		  }
		  
		
		index++;
		}
		
        
     return  outList;
     }


    /** 
    * The main method to test the implementation of the Josephus table.
        
    */
    
    
     public static void main(String []args) {
         
         
         LinkedList<Integer> results;
         
         
         System.out.println("\n Josephus Test Table .........");
           System.out.println(" size: 7");
             System.out.println(" start: 1");
               System.out.println(" step: 3");
                 System.out.println(" isClockwise: Yes");
         results = Josephus.testList(7, 1, 3, true);
         System.out.println(" Final Results: " + results.toString()+ "\n");
          
         System.out.println(" To see more testin examples please run \"Test.java\"\n");

     }

}