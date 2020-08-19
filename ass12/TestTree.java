


public class TestTree {


    /*************************************************
                 M A I N   M E T H O D
    *************************************************/  
    public static void main(String [] argv) { 

        
        HuffTree<String> myTree = new HuffTree();
        
        
        System.out.println(myTree.add(false, null));
            System.out.println(myTree.add(false, "hossein"));
                System.out.println(myTree.add(true, "hossein1"));
                System.out.println(myTree.add(true, "hossein2"));
            System.out.println(myTree.add(false, "Sarah"));
                System.out.println(myTree.add(true, "S1"));
                System.out.println(myTree.add(false, "S2"));
                    System.out.println(myTree.add(true, "baby1"));
                    System.out.println(myTree.add(true, "baby2"));
          
          System.out.println(myTree.toString());
          System.out.println("\nComplete:  " + myTree.isComplete());
        
    
        System.out.println(myTree.getTraverserValue());
        
        System.out.println(myTree.traverse(false));
        System.out.println(myTree.getTraverserValue());
        
        System.out.println(myTree.traverse(true));
        System.out.println(myTree.getTraverserValue());
        
        myTree.resetTraverser();
        System.out.println(myTree.traverse(true));
        System.out.println(myTree.getTraverserValue());
        System.out.println(myTree.traverse(true));
        System.out.println(myTree.getTraverserValue());
        
        System.out.println(myTree.traverse(false));
        System.out.println(myTree.getTraverserValue());
   } 




} 