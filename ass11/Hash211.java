/************************************************************************************
  Hash211 (an implementation of a Hash-table for HW11)
*************************************************************************************/

	        /** 
		* @author               Ehsan Kourkchi
		* @lecture              ICS 211 November 2013
		* @date                 November 29, 2013
		* @class type           public generic class
		*/
/************************************************************************************/

import java.util.*;



public class Hash211<K,V> {


   private LinkedList<KeyValuePair> [] table;
   public boolean printTimes;
   private int capacity;
   
   
   /****************************************************/
   /**
      Constructor
      
      @param capacity (int) the fixed capacity of the Hash-table
      @param printTimes (boolean) if set as true, it prints the time elapsed to
      execute put or get methods
   
   */
   public Hash211(int capacity, boolean printTimes)  {
       
       table = new LinkedList[capacity];
       
       for (int i=0; i < capacity; i++)
          table[i] = new LinkedList<KeyValuePair>();
       this.printTimes = printTimes;
       this.capacity = capacity;
       
       
   }
   /****************************************************/
   
   /****************************************************/
   /**
        Mapping the input key to a value
        
        @param key The key for the inoput value
        @param value The value that is to be added to the table
        
        @feature1: If any element in the table has the same key as the input parameter, the input value
        would be replaced and the old value would be returned
        
        @feature2: The input value is added to te front of the corresponding linke-list, make it faster to retrive
        (using the 'get' method) the value which has been recently entered to the hash-table
        
        @feature3: In any of the input variables is null, a NullPointerException would be thrown
   */
   /****************************************************/
   V put(K key, V value) throws NullPointerException {              // add or replace a Key,Value
       
       long startTime = System.nanoTime();
       
       
       if (key == null && value == null)
          throw new NullPointerException("Both input key and value are null.");
          
       if (key == null)
          throw new NullPointerException("The input key is null.");
          
       if (value == null)
          throw new NullPointerException("The input value is null");
          
       int index;
       boolean isAdded = false;
       KeyValuePair<K,V> newrecord = new KeyValuePair(key,value);
       KeyValuePair<K,V> currentrecord;
       V output = value;  // this would be finally returned
       
       index = hashCode(key);
       // using an iterator to traverse the list in constant time   
       ListIterator<KeyValuePair> myIter = table[index].listIterator(0); 
       
       
       while (myIter.hasNext())
       {
         
          currentrecord = myIter.next();
          
          if (key.equals(currentrecord.key))
          {
             myIter.set(newrecord);
             output = currentrecord.value;
             isAdded = true;
             break;
          }
       
       }
       
       if (!isAdded)
          table[index].addFirst(newrecord);
      
      
      long estimatedTime = System.nanoTime() - startTime;
      
      if(printTimes)  // print if printTimes is true
           System.out.println("put took " + estimatedTime + "  ns.");
      
      return output;
   
   }
   
   
   /****************************************************/
   /**
        Returning the value using the inpout key.
        
        @param key The key for which the value would be returned
        
        @feature1: If the key is not available, null would be returned
        @feature2: If key is null, NullPointerException would be thrown
   
   */
   /****************************************************/
   V get(Object key) throws NullPointerException  {        // return a value for the given key
      
      if (key == null)
          throw new NullPointerException("The input key is null.");
      
      long startTime = System.nanoTime();
      KeyValuePair<K,V> currentrecord ;
      
      int index = hashCode(key);
      // using an iterator to traverse the list in constant time
      ListIterator<KeyValuePair> myIter = table[index].listIterator(0); 
      
      while (myIter.hasNext())
      {
         
         currentrecord = myIter.next();
         if (key.equals(currentrecord.key)) 
         {
           
             long estimatedTime = System.nanoTime() - startTime;
            
             if(printTimes) 
             {
                   System.out.println("get took " + estimatedTime + "  ns.");
             }
                 
             return currentrecord.value;
         }
      
      }
      
      long estimatedTime = System.nanoTime() - startTime;
      if(printTimes)  // print if printTimes is true
           System.out.println("get took " + estimatedTime + "  ns.");

      return null;
   }
   
 
  
   
   /****************************************************/
   /**
       calculatig an integer number based on the input key
       
       The hashCode method of the inout key object is used as the initial seed
       
       @param key (object), any hashable Object
   
   */
   /****************************************************/
   private int hashCode(Object key) {
   
        int hash = Math.abs(key.hashCode()) % capacity;
        
        return hash;
    }


   /****************************************************/
   /**
        This method prints the hash-table, indicating the Table-indicies followed by the 
        corresponding linked-list values
   */
   /****************************************************/
   public void print() {
   
   
         for (int i=0; i < capacity; i++)
         {
         
               System.out.println("Index: " + i);
              
               ListIterator<KeyValuePair> myIter = table[i].listIterator(0);
            
               while (myIter.hasNext())
               {
                      myIter.next().print();
               }
       
         }
   
   }

   
/********************************************************
  KeyValuePair ... inner class holding the pair
  of key and value
*********************************************************/

	        /** 
		* @author               Ehsan Kourkchi
		* @date                 November 29, 2013
		* @class type           public generic class
		*/
/*********************************************************/

    class KeyValuePair<K,V>  {
        
        public K  key;
        public V  value;
        
        /**
          Constructor: initializing the parameters
        */
        KeyValuePair(K key, V value) {
            
            this.key = key;
            this.value = value;
        
        }
        
        
        /**
           printing out the "value"
        */
        private void print() {
          
          System.out.println("  " + this.value);
         
        }
        
    }  /** End of the inner class  */

    
    
    
/*********************************************************/
}  /** Edn of the oute class "hash211"  */
/*********************************************************/
