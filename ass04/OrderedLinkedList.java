/******************************************************************/

	        /** 
		* @author               Ehsan Kourkchi
		* @lecture              ICS 211 November 2013
		* @date                 December 9, 2013
		* @class type           public generic class
		*/
/******************************************************************/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;


public class OrderedLinkedList<E> {

private KeyedNode<E> head = null;
private int size=0; 


///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////

	private class KeyedNode<E> {

	    private String key;
	    private E item;
	    private KeyedNode<E> next;
	    
	    
	      private KeyedNode(String key, E value) {
		item = value;
		this.key = key;
		next = null;
	      }

	      private KeyedNode(String key, E value, KeyedNode<E> reference) {
		item = value;
		this.key = key;
		next = reference;
	      }
	    
	 }

///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////    

    // A no-arguments constructor public OrderedLinkedList() 
    // class to create an empty ordered linked list.
     public OrderedLinkedList() {
          head = null;
          size = 0;          
     }
     
    
     public OrderedLinkedList(String key, E value) {
     
          head = new KeyedNode<E> (key, value);
          size = 1;          
     }   
    
    // Returns the number of elements in the linked list.
    int size() {
         return size;
    }
    
    
///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////    
    
    // If the list does not already contain the given key, 
    // the key and value are added to the linked list, and add returns null.
    // Otherwise, the existing object with the given key is replaced with 
    // the new object (and the new key), and add returns the old (removed) object.
    E add(String key, E value) {
       
       int i;
       KeyedNode<E> currentNode = head;
       KeyedNode<E> previousNode = null;

       if (currentNode == null)
       {
	  head = new KeyedNode<E> (key, value, head);
	  size ++;
	  return null;
       }
       else
       {
	  while(currentNode != null && key.compareToIgnoreCase(currentNode.key) > 0)
	  { 
	      previousNode = currentNode;
	      currentNode = currentNode.next;
	  }
	  
	  // Adiing the new node in front of the list
	  if (previousNode == null) 
	  {
	      head = new KeyedNode<E> (key, value, currentNode);
	      size ++;
	      
	      // Removing the first node, if it has the same key as the node which is added
	      if (currentNode.key.compareToIgnoreCase(key) == 0) 
	      {
		  E temp = currentNode.item;
		  head.next = currentNode.next;
		  size --;
		  return temp;
	      }
	  return null;
	  }
	  else
	  {   
	      // Adding the noe between previous node and current node
	      previousNode.next = new KeyedNode<E> (key, value, currentNode);
	      size ++;
	      
	      // Removing the current node, if it has the same key as the node which is added
	      if (currentNode != null && previousNode.next.key.compareToIgnoreCase(currentNode.key) == 0) 
	      {
		  previousNode.next.next = currentNode.next;
		  size --;
		  return currentNode.item;
	      }


	  }
       
       }
       
    return null;
    }  // The end of 'add' method
    

///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////    
    
    // This method prints the database on the screen.
    void printList() {
    
       int i;
       KeyedNode<E> currentNode = head;

       System.out.println("\n  ************************************");
       while(currentNode != null)
       {
          System.out.printf("  %-15s  Tel: %s \n"  , currentNode.key, currentNode.item);
	  currentNode = currentNode.next;
       }
       
       System.out.println("  ************************************");
       System.out.println("  Size of the list: " + size );
       System.out.println("  ************************************\n");

    }  // the end of printList method
    
///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////
    
    // Returns the matching object if the corresponding key is 
    // in the ordered linked list, and null otherwise.
     E find(String key) {
       
       KeyedNode<E> currentNode = head;
      
       while(currentNode != null && key.compareToIgnoreCase(currentNode.key) != 0)
	  { 
	      currentNode = currentNode.next;
	  }
	  
	  if (currentNode != null) 
	    return currentNode.item;
	       else 
	          return null;
       
       
     }
    
    
///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////   
    
      // Removes the matching object if the corresponding key 
      E remove(String key) {
       KeyedNode<E> currentNode = head;
       KeyedNode<E> previousNode = null;

       
       while(currentNode != null && key.compareToIgnoreCase(currentNode.key) != 0)
	  { 
	      previousNode = currentNode;
	      currentNode = currentNode.next;
	      
	  }
	  
	  if (currentNode != null) 
	  {
	     if (currentNode == head) 
	        head = currentNode.next; 
	            else 
	                previousNode.next = currentNode.next;
	     size--;
	     return currentNode.item;
	  }
	  else 
	    return null;
       
       
     }   
    
    
///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////   
    
    // Returns the object at the given position, as long as the index is valid. 
    // Otherwise, it returns null (this is unlike the standard get, 
    // which throws an exception if the index is invalid). 
     E get(int position) {
     
       KeyedNode<E> currentNode = head;
       int index = 1;
       position++;  // first element has the index=0
       
       if (position > size || position < 1 || currentNode == null) 
           return null;
       else 
       {
       
           while(index != position)
 	  { 

 	      currentNode = currentNode.next;
	      index++;
	  }
	  
          return currentNode.item;
       }
     
     }

///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////    
     
    // Prints the entire database into a file
    // it gets the ponter to the destination file
    // it does not care if the file already exists. It overwrites the previously available file
    // it's better the availability of the in the User Interface 
     int write_file(BufferedWriter bw) {
     KeyedNode<E> currentNode = head;

     try {
     
			bw.write("***********************" + "\n");
			bw.write("Size of the list: " + (Integer) size + "\n");
			bw.write("***********************" + "\n\n");

       
		      while(currentNode != null)
		      { 
		      bw.write("Name: " + currentNode.key+ "\n");
		      bw.write("Tel: " + currentNode.item+ "\n\n");
		      currentNode = currentNode.next;
		      }
		      
		      
	 } 
	 catch (IOException e) {
	   e.printStackTrace();
	   return 1;
	 }

     return 0;
     }
     
     
     
} //the end of the main class (i.e OrderedLinkedList<E>)


///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////