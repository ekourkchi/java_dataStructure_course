/**************************************************************************
  The Record class (which holds each task information for HW10)
***************************************************************************/

	        /** 
		* @author               Ehsan Kourkchi
		* @lecture              ICS 211 November 2013
		* @date                 November 22, 2013
		* @class type           public generic class
		*/
/***************************************************************************/

import java.util.* ;




public class Record<E> implements Comparator<Record<E>> {
    
    E data;
    long deadline;
    long duration;
    
    
    /** Empty constructor */
    public Record() {
        
        data = null;
        deadline = 0;
        duration = 0;
    }
    
    
    /** 
       Data constructor
       @param data Holds the name or id of the task
       @param deadline Holds the deadline of the task by when the taks must be completed
       @param duration Holds the needed time to execute the task
    
    */
    public Record(E data, long deadline, long duration)  {
        
        this.data = data;
        this.deadline = deadline;
        this.duration = duration;
        
    }
   
    /**
       Equals method: It compares the deadline of the current record with 
       the deadline of the input record to see if they are the same
    */
    public boolean equals(Record<E> record) {
        
        return (record.deadline == this.deadline);      
        
    }
     
    
    /**
       Compare method: This is main method which is needed to be provided for a Comparator interface
       
       @param rec1 First input record
       @param rec2 Second input record
       
       In this method the deadline of the two inout records would be compared
    */
    public int compare(Record<E> rec1, Record<E> rec2) {
    
        return (int) (rec1.deadline - rec2.deadline);
    } 
    
    
    /**
       toString method 
    */
    public String toString() {
    
        return data.toString();
    
    }




} /** End of the "record" class */