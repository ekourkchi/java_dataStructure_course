import java.util.*;
import java.io.IOException;



/**************************************************************************
  The outer class (An implementation of Tree for HW09)
***************************************************************************/

	        /** 
		* @author               Ehsan Kourkchi
		* @lecture              ICS 211 November 2013
		* @date                 November 4, 2013
		* @class type           public generic class HW9Tree
		*/
/***************************************************************************/

public class HW9Tree<E>  {

    
    // class field parameter, the root of tree
    private BinaryNode<E> root;

    
    
    
    /*************************************************/
         /** constructor(s) */
    /*************************************************/
    public HW9Tree() {
    
        root = null;
    
    }
    
    /*************************************************/
    public HW9Tree(E item) {
    
        root = new BinaryNode(item);
    
    }
    
    /*************************************************/
    public HW9Tree(BinaryNode<E> root) {
    
        this.root = root;
    
    }
    
    /*************************************************/
    public HW9Tree(E item, BinaryNode<E> l, BinaryNode<E> r) {
    
        root = new BinaryNode(item, l, r);
    
    }
    

    
    
    /*************************************************/
         /** a method to add an item to this tree recursively
             @param itam : to be added to tree
             @param left : a boolea array to address where the item to be added
             Starting from the root, at each node, the method must go down to 
             the left if the corresponding position in the array is true, and 
             otherwise must go down to the right. Once a null pointer is reached, 
             the item must be added to the tree in place of the null pointer.
             
             @throws ArrayIndexOutOfBoundsException
         */
    /*************************************************/    
    
    public boolean add(E item, boolean [] left) throws ArrayIndexOutOfBoundsException {
    
        
        
        if (root == null) 
               this.root = new BinaryNode(item); // an emtpy tree, adding the item regardless of "left" values
        else {
        
               if (left == null || left.length < 1) return false; // if tree is not empty, but left array is null or funky
             
               if (left.length == 1) {
               
               
                      if (root.left == null || root.right == null) {
			      if (left[0] == true && root.left == null) {
			      
				  root.left =  new BinaryNode(item);   // add to left
				  return true;
			      }
			      else if (left[0] == false && root.right == null) {
			      
				  root.right =  new BinaryNode(item);   // add to right
				  return true;
			      }
			      else 
				  return false;
                      } else 
                           throw new ArrayIndexOutOfBoundsException("The array of booleans is too short and does not correctly address a tree node.");
                           
               } else {
		
		      boolean [] newleft = new boolean[left.length-1];  
		      System.arraycopy(left, 1, newleft, 0, left.length-1);   // newleft = left[1..n-1]
		
		      if (left[0] == true)  // add to left
		    
			    if (root.left == null) { // once a null pointer is reached, the item is added
				    root.left =  new BinaryNode(item); 
				    return true;
			    } else {  // adding to the left subtree
				    HW9Tree leftTree = new HW9Tree(root.left);
				    return leftTree.add(item, newleft);
			    }
		    
		      else {  // add to right
		    
			    if (root.right == null) { // once a null pointer is reached, the item is added
			            root.right =  new BinaryNode(item); 
			            return true;
			    } else {  // adding to the right subtree
			            HW9Tree rightTree = new HW9Tree(root.right);
			            return rightTree.add(item, newleft);
		            }
		      }
               }
        }
        
        return false;
    }
        
         
    /*************************************************/
         /** private stringBuilder helper method, that works recursively
             
             This helper method is used by toString method
             @param root : the root of subtree
             @param depth : the depth of subtree, based on which 
             the number of spcaes is determined
         */
    /*************************************************/
    private String stringBuilder(BinaryNode<E> root, int depth) {
        
        String outputString = "";
        
        if (root == null)   // in the case of empty tree, it does not begin the recursive phase
             outputString = "Tree is empty\n";
             
        else {
              
              for(int i=0; i<depth; i++)  // as the depth increases,
                   outputString+="    "; //  it adds 4 spaces
                   
              outputString += root.item; // adding the root item
              outputString += "\n";      // adding a newline specifier adding an item
              
              if(root.left != null)
                   outputString+=stringBuilder(root.left, depth+1);  // adding the left subtree recursively
                   
              if(root.right != null) 
                   outputString+=stringBuilder(root.right, depth+1);  // adding the right subtree recursively
        
        }

    
    return outputString;
    
    }
    
    /*************************************************/
         /** toString method.
             It converts the tree to a string, in the same way 
             that folders are printed: the root is first, followed 
             by the children of the node indented 4 spaces, 
             the grandchildren indented 8 spaces, and so on
             
             It uses the stringBuilder recursive method
         */ 
    public String toString() {
    
        return stringBuilder(this.root, 0);   
    
    }
    /*************************************************/
    /*************************************************/

    
    
    
    
    /*************************************************/
         /** private addtoList recursive method.
             
             It is a helper method which is used by 
             toList method
         */
    /*************************************************/    
    private LinkedList<E> addtoList(BinaryNode<E> root, LinkedList<E> list) {
        
        // If root is null, this method does not change the input list
        if (root != null) {
              
              if(root.left != null)  // adding the left subtree recursively
                    addtoList(root.left, list);
              
              list.add(root.item);   // adding the subtree root
              
              if(root.right != null)   // adding the right subtree recursively
                    addtoList(root.right, list);
        
        }
    
        return list;
    
   }

   
   /*************************************************/
         /** 
            toList method that stores in a list a reference 
            to each of the objects in the tree, 
            as visited in an in-order traversal. 
             
             It works based on standard java LinkedList
             that satisfies the List interface. 
             
             It uses the addtoList recursive method
         */

    public LinkedList<E> toList() {
    
        return addtoList(this.root, new LinkedList());
    }
    /*************************************************/
    /*************************************************/ 


    
    
    



/**************************************************************************
  Inner class (defenition of tree nodes)
***************************************************************************/

	      /** 
		* A node in a binary tree 
		* @author         Edo Biagioni
		* @lecture        ICS 211 Mar 15 or later
		* @date           March 14, 2011
		* @bugs           private class: include this code within a larger class
		*/

	      private static class BinaryNode<T> {
		private T item;
		private BinaryNode<T> left;
		private BinaryNode<T> right;


	      /** 
		* constructor to build a node with no subtrees
		* @param the value to be stored by this node
		*/
		private BinaryNode(T value) {
		  item = value;
		  left = null;
		  right = null;
		}


	      /** 
		* constructor to build a node with a specified (perhaps null) subtrees
		* @param the value to be stored by this node
		* @param the left subtree for this node
		* @param the right subtree for this node
		*/
		private BinaryNode(T value, BinaryNode<T> l, BinaryNode<T> r) {
		  item = value;
		  left = l;
		  right = r;
		}
	      }

/***************************************************************************/
}  // End of the outer class
/***************************************************************************/
