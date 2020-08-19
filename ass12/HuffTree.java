import java.util.*;
import java.lang.NullPointerException;

/**************************************************************************
  The outer class (An implementation of a Huffman binary Tree for HW12)
***************************************************************************/

	        /** 
		* @author               Ehsan Kourkchi
		* @lecture              ICS 211 Desember 2013
		* @date                 Desember 6, 2013
		* @class type           public generic class HuffTree
		*/
/***************************************************************************/

public class HuffTree<E> {



    // class field parameter, the root of tree
    private BinaryNode<E> root;
    private Stack<BinaryNode<E>> midNodeStack = new Stack<BinaryNode<E>>();
    private BinaryNode<E> traverser;
    
    
    
    /*************************************************/
         /** constructor(s) */
    /*************************************************/
    public HuffTree() {
    
        root = null;
        traverser = root;
    }
    
    /*************************************************/
    public HuffTree(E item) {
    
        root = new BinaryNode(item);
        midNodeStack.push(root);
        traverser = root;
    
    }
    
    /*************************************************/
    public HuffTree(BinaryNode<E> root) {
    
        this.root = root;
        midNodeStack.push(root);
        traverser = root;
    
    }
    
    /*************************************************/
    public HuffTree(E item, BinaryNode<E> l, BinaryNode<E> r) {
    
        root = new BinaryNode(item, l, r);
        midNodeStack.push(root);
        traverser = root;
    
    }
    
    
    
     
    /*************************************************/
         /** a method to add an item to the tree
             @param itam : to be added to tree
             @param isLeaf : a boolean parmaeter which indicates whether the added
             node is leaf or not. 
             = True for leaf node
             = False for middle node
         */
    /*************************************************/      
    public boolean add(boolean isLeaf, E item) {
    
      BinaryNode<E> newNode = new BinaryNode(item);
      
      
          if(!midNodeStack.empty()) { // Not empty
               
               BinaryNode<E> topStack = midNodeStack.peek();
               
               if(topStack.left == null) {
                    
                    topStack.left = newNode;
                    
               } else {
               
                    topStack.right = newNode; // the mid-node is full, so remove it from the stack
                    midNodeStack.pop();
                    
               }
          // If the stack is empty, no node can be added, unless the tree is undefined (i.e. root == null)
          } else {
                   if (root == null) {
                      root = newNode;
                      traverser = root;
                      }
                   else
                      return false;
                 }
              
      if(!isLeaf)  // IS mid-node 
          midNodeStack.push(newNode);
    
      return true;
    }


    
    /*************************************************/
      /**
          True : If all leaves are defined, and the mid-node stack is empty
          Flase: If there is at least one mid-node left where a new leaf node can be added
      /*
    /*************************************************/   
    public boolean isComplete() {
    
       if (root == null)
           return false;
       else
           return midNodeStack.empty();
    
    }
    
    
    
    /*************************************************/
      /** 
          Reset the location of the traverser node to the root.
          Each time, the method "traverse" is called, this node changes to 
          its new location based on the right/left call
      
      */
    /*************************************************/   
    public void resetTraverser() { 
    
       traverser = root;
       
    }
    
    
    /*************************************************/
      /**
         Traverse the tree.
         
         @param goRight (boolean) ... goes to right if it is true and goes left if it sets as false
         
         By calling this method the traverser node changes it location, pointing at different node
         
         Output: Flase ... if the traversed node is a leaf node
         True if the current traverser node (after this ethod call) is a leaf node
      */
    /*************************************************/       
    public boolean traverse(boolean goRight) throws NullPointerException {
    
       if(traverser != null)
       {
           if(goRight)
                traverser = traverser.right;
           else 
                traverser = traverser.left;
       }
       
       if(traverser == null)
            throw new NullPointerException("Traverser null pointer");
       else
            return isLeaf(traverser);
       
    } 
    
    
    /*************************************************/
      /**
         A private method which checkes whether an input node is a leaf node
         
         Returns True if the node is a leaf-node and false if it is not
         
         @param node The node to be tested
      
      */
    /*************************************************/   
    private boolean isLeaf(BinaryNode<E> node)  {
    
        if(node != null)
              return (node.left == null && node.right == null);
        else 
              return false;
    
    }

    
    /*************************************************/
      /**
         This method returns the item of the traverser node
         
         In the case of Huffman tree, all ndoes have null values except for the leaf-nodes.
         
      
      */
    /*************************************************/    
    public E getTraverserValue() throws NullPointerException  {
    
        if(traverser == null)
            throw new NullPointerException("Traverser null pointer");
        else
            return traverser.item;
               
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
	      

/***************************************************************************/
}  // End of the outer class
/***************************************************************************/



} // The end of the outer class
