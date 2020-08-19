import java.util.*;

/**  @Test.java
     @main   // This method tests Josephus.testList for few different cases
     */

public class MyTestDriver {




   public static void main(String []args) {
   
      System.out.println("\nTesting NODE class ....");  
      DoubleLinkedNode myNode = new DoubleLinkedNode("NODE works very well");
      System.out.println(myNode.getData());   
      
      
      System.out.println("\nTesting CircularDoubleLinkedList Class ....");  
      CircularDoubleLinkedList<Integer> myList = new CircularDoubleLinkedList();
      System.out.println("## [empty list] " + myList.toString());
      
      System.out.println("\nadd(0,-1)");
      myList.add(0,-1);
      System.out.println("add(1,3)");
      myList.add(1,3);
      System.out.println("add(20)");
      myList.add(20);
      System.out.println("add(3,30)");
      myList.add(3,30);
      System.out.println("add(200)");
      myList.add(200);
      System.out.println("add(-2,500)");
      myList.add(-2,500);

      System.out.println("## [not empty list] " + myList.toString());
      System.out.println("size of the list: " + myList.size());    
      
      System.out.println("\nadd(0,10)");      
      myList.add(0,10);
      System.out.println("add(2,20)");  
      myList.add(2,20);
      System.out.println("add(5,50)");  
      myList.add(5,50);
      System.out.println("## [not empty list] " + myList.toString());


      System.out.println("\nremoved index = 2"); 
      myList.remove(2);
      System.out.println("## [not empty list] " + myList.toString());
      
      System.out.println("\nremoved index = -4"); 
      myList.remove(-4);
      System.out.println("## [not empty list] " + myList.toString());
      
      
      System.out.println("\nremoved index = 6"); 
       myList.remove(6);
      System.out.println("## [not empty list] " + myList.toString());  
      
      
      System.out.println("\nremoved index = 8"); 
      myList.remove(8);
      System.out.println("## [not empty list] " + myList.toString());
      
      
      System.out.println("\n## [get index = -4] " + myList.get(-4));
      System.out.println("size of the list: " + myList.size());
      
      System.out.println("\n****  I T E R A T O R **** TEST **** ");
      System.out.println("Testing the CircularDoubleLinkedList iterator");
      System.out.println("****  *************** **** *** **** \n");

      CircularDoubleLinkedList<Integer> myList1 = new CircularDoubleLinkedList();
      myList1.add(0,-1);
      myList1.add(10);
      myList1.add(20);
      System.out.println("## [not empty list] " + myList1.toString());
       ListIterator<Integer> iter = myList1.iterator();


      System.out.println("next iter index: " + iter.nextIndex());
      System.out.println("next value returned by iter.next(): " + iter.next());
      
      System.out.println("\nprevious index: " + iter.previousIndex());
      System.out.println("previous value: " + iter.previous());

      iter.remove();
      System.out.println("## [after removing] " + myList1.toString());
       System.out.println("\nnext iter index: " + iter.nextIndex());
       
       
      System.out.println("\niter.add(999)"); 
      iter.add(999);
      System.out.println("## [after adding] " + myList1.toString());      
      
      System.out.println("\nnext iter index: "  + iter.nextIndex());
      System.out.println("next value returned by iter.next(): " + iter.next());

      System.out.println("\nnext iter index: "  + iter.nextIndex());
      System.out.println("next value returned by iter.next(): " + iter.next());
      
      System.out.println("\niter.add(1000)");
      iter.add(1000);
      System.out.println("## [after adding] " + myList1.toString()); 
      
      System.out.println("\nnext iter index: "  + iter.nextIndex());
      System.out.println("next value returned by iter.next(): " + iter.next());
      
      System.out.println("\nnext iter index: "  + iter.nextIndex());
      System.out.println("next value returned by iter.next(): "+iter.next());    
     
      iter.remove();
      System.out.println("## [after removing] " + myList1.toString());
      System.out.println("\nnext iter index: "  + iter.nextIndex());
      System.out.println("next value returned by iter.next(): "+iter.next());

      iter.remove();
      System.out.println("## [after removing] " + myList1.toString());
      System.out.println("\nnext iter index: "  + iter.nextIndex());
      System.out.println("next value returned by iter.next(): "+iter.next());
      
      System.out.println("\niter.add(55)"); 
      iter.add(55);
      System.out.println("## [after adding] " + myList1.toString());  
            
            
      System.out.println("\niter.add(66)"); 
      iter.add(66);
      System.out.println("## [after adding] " + myList1.toString());

 
      System.out.println("\nnext value returned by iter.next(): "+iter.next());
      System.out.println("next value returned by iter.next(): "+iter.next());
      System.out.println("next value returned by iter.next(): "+iter.next());
      System.out.println("\n## [not empty list] " + myList1.toString());
      
      iter.remove();
      System.out.println("\n## [after removing] " + myList1.toString());

      System.out.println("\nnext iter index: "  + iter.nextIndex());
      System.out.println("next value returned by iter.next(): "+iter.next());

      System.out.println("next value returned by iter.next(): "+iter.next());
      iter.remove();
      System.out.println("\n## [after removing] " + myList1.toString());

      System.out.println("\nnext iter index: "  + iter.nextIndex());

      System.out.println("next value returned by iter.next(): "+ iter.next());
      System.out.println("next iter index: "  + iter.nextIndex());

      System.out.println("\niter.add(99)"); 
     
      iter.add(99);
      System.out.println("## [after adding] " + myList1.toString());
      System.out.println("\nsize of the list: " + myList1.size());
      System.out.println("next iter index: "  + iter.nextIndex());

      
      
      System.out.println("\n#######################\n");
      System.out.println("\n## [not empty list] " + myList1.toString());
      System.out.println("next iter index: "  + iter.nextIndex());
      System.out.println("previous iter index: "  + iter.previousIndex());
      System.out.println("previous value returned by iter.previous(): "+ iter.previous());


     
      iter.remove();
      System.out.println("\n## [after removing] " + myList1.toString());
     
      System.out.println("next iter index: "  + iter.nextIndex());

      System.out.println("previous iter index: "  + iter.previousIndex());
      System.out.println("previous value returned by iter.previous(): "+ iter.previous());
      
      iter.remove();
      System.out.println("\n## [after removing] " + myList1.toString());
      
      System.out.println("next iter index: "  + iter.nextIndex());
      System.out.println("previous iter index: "  + iter.previousIndex());
      System.out.println("previous value returned by iter.previous(): "+ iter.previous());

      iter.remove();
      System.out.println("\n## [after removing] " + myList1.toString());
      
      System.out.println("\niter.add(200)"); 
      iter.add(200);
      System.out.println("## [after adding] " + myList1.toString());
      System.out.println("next iter index: "  + iter.nextIndex());
      
      System.out.println("\niter.add(300)"); 
      iter.add(300);
      System.out.println("## [after adding] " + myList1.toString());
      System.out.println("next iter index: "  + iter.nextIndex());
      
      
      System.out.println("\niter.add(400)"); 
      iter.add(400);
      System.out.println("## [after adding] " + myList1.toString());
      System.out.println("next iter index: "  + iter.nextIndex());

      System.out.println("previous iter index: "  + iter.previousIndex());
      System.out.println("previous value returned by iter.previous(): "+ iter.previous());            
  

      iter.remove();
      System.out.println("\n## [after removing] " + myList1.toString());
      
      System.out.println("\nnext iter index: "  + iter.nextIndex());
      System.out.println("next value returned by iter.next(): "+iter.next());

      System.out.println("previous iter index: "  + iter.previousIndex());
      System.out.println("previous value returned by iter.previous(): "+ iter.previous()); 
      
      
      iter.remove();
      System.out.println("\n## [after removing] " + myList1.toString());
      
      System.out.println("next iter index: "  + iter.nextIndex());
       System.out.println("previous iter index: "  + iter.previousIndex());
      System.out.println("previous value returned by iter.previous(): "+ iter.previous());   
      
      System.out.println("\nnext iter index: "  + iter.nextIndex());
      System.out.println("next value returned by iter.next(): "+iter.next());
      System.out.println("next iter index: "  + iter.nextIndex());
      
      System.out.println("\nsize of the list: " + myList1.size());
      System.out.println("## [not empty list] " + myList1.toString());
      System.out.println("#######################\n");
             
                            
                            
   }



}