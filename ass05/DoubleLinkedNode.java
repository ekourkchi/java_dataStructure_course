/** DoubleLinkedNode 

This is a single node as a bulding block of a double linked list

@data: holds a single "data" points
@next: pointer to the "next" node
@previous: pointer to the "previous" node

@Author: Ehsan Kourkchi
@Date: October, 3, 2013 

*/

public class DoubleLinkedNode<E> {

  private E data;
  private DoubleLinkedNode<E> next;
  private DoubleLinkedNode<E> previous;
  
  /** Constructor method*/
  public DoubleLinkedNode(E data)  {
  
  this.data = data;
  this.next = null;
  this.previous = null;
  
  }
  
 
  /** Returns the data */
  public E getData() {
     return data;   
  }
  
  /** Sets the node data by the input value */
  public void setData(E data) {
     this.data = data;  
  }
  
  
  /***************************************
  /** Methods to habdle the "next" pointer
  /***************************************/

  public DoubleLinkedNode<E> getNext() {
     return next;
  }

  
  
  public void setNext(DoubleLinkedNode<E> next) {
     this.next = next;
  }
  
  
  /***************************************
  /** Methods to handle the "previous" pointer
  /***************************************/

  public DoubleLinkedNode<E> getPrevious() {
     return previous;
  }
  
  
  
  public void setPrevious(DoubleLinkedNode<E> previous) {
     this.previous = previous;
  }
  /***************************************/
  
  
  
  
  /** Overriden tostring method */
  public String toString() {
     return data.toString();
  }




}