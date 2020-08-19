import java.util.*;


public class Test {



     public static void main(String []args) {
         
         LinkedList<Integer> results;
         
         
         System.out.println("\nJosephus Table #1 .........");
           System.out.println("size: 7");
             System.out.println("start: 1");
               System.out.println("step: 3");
                 System.out.println("isClockwise: Yes");
         results = Josephus.testList(7, 1, 3, true);
         System.out.println("Final Results: " + results.toString()+ "\n");
         
         System.out.println("\nJosephus Table #2 .........");
           System.out.println("size: 10");
             System.out.println("start: 4");
               System.out.println("step: 5");
                 System.out.println("isClockwise: Yes");
         results = Josephus.testList(10, 4, 5, true);
         System.out.println("Final Results: " + results.toString()+ "\n");         
         
         System.out.println("\nJosephus Table #3 .........");
           System.out.println("size: 1");
             System.out.println("start: 2");
               System.out.println("step: 3");
                 System.out.println("isClockwise: No");
         results = Josephus.testList(1, 2, 3, false);
         System.out.println("Final Results: " + results.toString()+ "\n");          
         
         System.out.println("\nJosephus Table #4 .........");
           System.out.println("size: 7");
             System.out.println("start: 2");
               System.out.println("step: 3");
                 System.out.println("isClockwise: No");
         results = Josephus.testList(7, 2, 3, false);
         System.out.println("Final Results: " + results.toString()+ "\n");
         
         
         System.out.println("\nJosephus Table #5 .........");
           System.out.println("size: 5");
             System.out.println("start: 6");
               System.out.println("step: 2");
                 System.out.println("isClockwise: No");
         results = Josephus.testList(5, 6, 2, false);
         System.out.println("Final Results: " + results.toString()+ "\n");   
         
     
     }



}