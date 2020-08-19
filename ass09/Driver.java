
/**************************************************************************
  The Driver class which test HW9Tree class. (An implementation of Tree for HW09)
***************************************************************************/

	        /** 
		* @author               Ehsan Kourkchi
		* @lecture              ICS 211 November 2013
		* @date                 November 4, 2013
		*/
/***************************************************************************/

public class Driver {
    
    
    public static void main(String [] argv) {
    
        HW9Tree<String> myTree = new HW9Tree();
        
        boolean [] lefts1 = new boolean[1];
        boolean [] lefts2 = new boolean[2];
        boolean [] lefts3 = new boolean[3];
        
        System.out.println("\n********************\nTree is empty here.");
        System.out.println("What toString() method returns for a gibven empty tree: " + myTree.toString());
        
        System.out.println("\n********************\nAdding the word \'hello\' as the root.\n********************\n");
        myTree.add("hello", lefts1);
        System.out.println(myTree.toString());
        
        System.out.println("\n********************\nAdding the word \'bar\' to the right.\n********************\n");
        lefts1 = new boolean[] {false};
        myTree.add("bar", lefts1);    
        System.out.println(myTree.toString());    
        
        System.out.println("\n********************\nCunstructing the entire tree like the presented example in the assignment.\n********************\n");
        lefts1 = new boolean[] {true};
        myTree.add("foo", lefts1);       
        
        lefts2 = new boolean[] {true, false};
        myTree.add("baz", lefts2);  
        
        lefts2 = new boolean[] {true, true};
        myTree.add("world", lefts2);  
        
        lefts2 = new boolean[] {false, true};
        myTree.add("bug", lefts2);         
        
        lefts2 = new boolean[] {false, false};
        myTree.add("loop", lefts2); 
        
        System.out.println(myTree.toString());
        
        
        System.out.println("\n********************\nTesting \'toList()\' recursive method.");
        System.out.println("The printed list reflects the in-order tree traversal.\n********************\n");
        System.out.println(myTree.toList().toString());
        
        System.out.println("\n********************\nAdding the word \'fum\' to the tree with this address {false, true, false}.\n********************\n");
        lefts3 = new boolean[] {false, true, false};
        myTree.add ("fum", lefts3);
        System.out.println(myTree.toString());
        
        System.out.println("\n********************\nTesting \'toList()\' method again.");
        System.out.println("The printed list reflects the in-order tree traversal.\n********************\n");
        System.out.println(myTree.toList().toString());
        
        
        System.out.println("\n********************\nAdding the word \'ehsan\' to the tree with a wrong address {true, false}.");
        System.out.println("The \"ArrayIndexOutOfBoundsException\" should be thrown.\n********************\n");
        lefts2 = new boolean[] {true, false};
        myTree.add("ehsan", lefts2); 
        
    } // The end of main method

} // The end of Driver calss