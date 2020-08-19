public class TestLinkedQueue {



    public static void main(String []args) {
    
    
    
    /** Following lines were used for testing offer and poll methods  */
    /*************************************************************/    
    /**************  Testing the "LinkedQueue"  class   ************/    
    /*************************************************************/    
    /*************************************************************/  
    
        System.out.println("\n\n *****************************");
        System.out.println(" + This unit test just examine \'offer\' and \'poll\' \n methods as it is asked by the assignment.");
        System.out.println("\n + Nevertheless, the otehr usuall queque methods \n are provided as well.");
        System.out.println(" *****************************");
        System.out.println(" *****************************");
        
        
        System.out.println("\n*****************************");
        System.out.println("*****************************");
        System.out.println("Testing the \"LinkedQueue\" class \ncontaining strings. \nNote: This is a generic class.");
        System.out.println("*****************************");
        System.out.println("*****************************\n");

        LinkedQueue<String> myQueque = new LinkedQueue();       
        
        System.out.println("Queque is empty.\n");
        
        System.out.printf("1) Offering \"Ehsan\" returns: %b", myQueque.offer("Ehsan"));
        System.out.printf("\nThe queue element(s): "); 
        myQueque.toPrint();
        System.out.printf("\n"); 
        
        System.out.printf("2) Offering \"Sean\" returns: %b", myQueque.offer("Sean"));
        System.out.printf("\nThe queue element(s): "); 
        myQueque.toPrint();
        System.out.printf("\n");         

        System.out.println("*** Offering values which alreay exists in the queque ***\n"); 
        
        System.out.printf("3) Offering \"Ehsan\" returns: %b", myQueque.offer("Ehsan"));
        System.out.printf("\nThe queue element(s): "); 
        myQueque.toPrint();
        System.out.printf("\n");  
        
        System.out.printf("4) Offering \"Sean\" returns: %b", myQueque.offer("Sean"));
        System.out.printf("\nThe queue element(s): "); 
        myQueque.toPrint();
        System.out.printf("\n"); 
        
        System.out.println("*** Offering NULL value ***\n"); 
        System.out.printf("5) Offering \"null\" returns: %b", myQueque.offer(null));
        System.out.printf("\nThe queue element(s): "); 
        myQueque.toPrint();
        System.out.printf("\n");         
        
        System.out.println("*** polling ***\n"); 
        
        System.out.printf("6) Polling returns: %s", myQueque.poll());
        System.out.printf("\nThe queue element(s): "); 
        myQueque.toPrint();
        System.out.printf("\n"); 
        
        System.out.printf("7) Polling returns: %s", myQueque.poll());
        System.out.printf("\nThe queue element(s): "); 
        myQueque.toPrint();
        System.out.printf("\n");             
            
        System.out.println("*** polling from an empty queque ***\n"); 
            
        System.out.printf("8) Polling returns: %s", myQueque.poll());
        System.out.printf("\nThe queue element(s): "); 
        myQueque.toPrint();
        System.out.printf("\n");                
            
  
    /*************************************************************/    
    /**************  Testing the "ArrayQueue"  class   ************/    
    /*************************************************************/    
    /*************************************************************/    

        System.out.println("\n*****************************");
        System.out.println("*****************************");
        System.out.println("Testing the \"ArrayQueue\" class \ncontainig Integer. \nNote: This is a generic class.");
        System.out.println("*****************************");
        System.out.println("*****************************\n");        
        
        ArrayQueue<Integer> myArrayQueque = new ArrayQueue();
      
        System.out.println("*** Queque is empty ***\n");
        
        System.out.printf("9) Offering \"10\" returns: %b", myArrayQueque.offer(10));
        System.out.printf("\nThe queue element(s): "); 
        myArrayQueque.toPrint();
        System.out.printf("\n"); 
        
        System.out.printf("10) Offering \"2\" returns: %b", myArrayQueque.offer(2));
        System.out.printf("\nThe queue element(s): "); 
        myArrayQueque.toPrint();
        System.out.printf("\n");         

        System.out.println("*** Offering values which alreay exists in the queque ***\n"); 
        
        System.out.printf("11) Offering \"10\" returns: %b", myArrayQueque.offer(10));
        System.out.printf("\nThe queue element(s): "); 
        myArrayQueque.toPrint();
        System.out.printf("\n");  
        
        System.out.printf("12) Offering \"2\" returns: %b", myArrayQueque.offer(2));
        System.out.printf("\nThe queue element(s): "); 
        myArrayQueque.toPrint();
        System.out.printf("\n"); 
        
        System.out.println("*** Offering NULL value ***\n"); 
        System.out.printf("13) Offering \"null\" returns: %b", myArrayQueque.offer(null));
        System.out.printf("\nThe queue element(s): "); 
        myArrayQueque.toPrint();
        System.out.printf("\n");
        
        
        System.out.printf("14) Offering \"5,2,4,3,7,14,1,23,100\" values consequently ***");
        myArrayQueque.offer(5);
        myArrayQueque.offer(2);
        myArrayQueque.offer(4);
        myArrayQueque.offer(3);
        myArrayQueque.offer(7);
        myArrayQueque.offer(14);
        myArrayQueque.offer(1);
        myArrayQueque.offer(23);
        myArrayQueque.offer(100);
        System.out.printf("\nThe queue element(s): "); 
        myArrayQueque.toPrint();
        System.out.printf("\"2\" is not added since it is still in the queque \n");        
        

        System.out.printf("\n15) Offering \"200\" when the queque is full");
        System.out.printf("\nOffering \"200\" returns: %b", myArrayQueque.offer(200));
        System.out.printf("\nThe queue element(s): "); 
        myArrayQueque.toPrint();
        System.out.printf("\"200\" is not added since queque is full \n");           
        
        System.out.println("\n*** polling ***\n"); 
        
        System.out.printf("16) Polling returns: %s", myArrayQueque.poll());
        System.out.printf("\nThe queue element(s): "); 
        myArrayQueque.toPrint();
        System.out.printf("\n"); 
        
        System.out.printf("17) Polling returns: %s", myArrayQueque.poll());
        System.out.printf("\nThe queue element(s): "); 
        myArrayQueque.toPrint();
        System.out.printf("\n");             
            
        System.out.println("*** polling from an empty queque ***\n"); 
            
        System.out.printf("18) Polling returns: %s", myArrayQueque.poll());
        System.out.printf("\nThe queue element(s): "); 
        myArrayQueque.toPrint();
        System.out.printf("\n");        
        
        System.out.printf("19) Offering \"2\" returns: %b", myArrayQueque.offer(2));
        System.out.printf("\nThe queue element(s): "); 
        myArrayQueque.toPrint();
        System.out.printf("\"2\" is at the end of the queque, since it is got removed in previous task.\n");        
        
          
        System.out.printf("\n20) Polling all queque elements");
        myArrayQueque.poll();
        myArrayQueque.poll();
        myArrayQueque.poll();
        myArrayQueque.poll();
        myArrayQueque.poll();
        myArrayQueque.poll();
        myArrayQueque.poll();
        myArrayQueque.poll();
        System.out.printf("\nThe queue element(s): "); 
        myArrayQueque.toPrint();
        System.out.printf("\n");         
        
        System.out.println("*** Queque is empty ***");       
        System.out.println("*** polling from an empty queque ***\n"); 
            
        System.out.printf("21) Polling returns: %s", myArrayQueque.poll());
        System.out.printf("\nThe queue element(s): "); 
        myArrayQueque.toPrint();
        System.out.printf("\n");         
        
        
        /** Following lines were used for quick test of the otehr methods*/
        /*
        ArrayQueue<Integer> myArrayQueque = new ArrayQueue();
        
        
        System.out.println(myArrayQueque.offer(10)); myArrayQueque.toPrint();
        System.out.println(myArrayQueque.poll());
        System.out.println(myArrayQueque.poll());
        
        System.out.println(myArrayQueque.offer(20)); myArrayQueque.toPrint();
        System.out.println(myArrayQueque.offer(30)); myArrayQueque.toPrint();
        System.out.println(myArrayQueque.offer(40)); myArrayQueque.toPrint();
        System.out.println(myArrayQueque.offer(10)); myArrayQueque.toPrint(); 
        System.out.println(myArrayQueque.offer(50)); myArrayQueque.toPrint(); 
        System.out.println(myArrayQueque.offer(60)); myArrayQueque.toPrint(); 
        System.out.println(myArrayQueque.offer(20)); myArrayQueque.toPrint(); 
        System.out.println(myArrayQueque.offer(70)); myArrayQueque.toPrint(); 
        System.out.println(myArrayQueque.offer(80)); myArrayQueque.toPrint(); 
        System.out.println(myArrayQueque.offer(90)); myArrayQueque.toPrint(); 
        System.out.println(myArrayQueque.offer(100)); myArrayQueque.toPrint(); 
        System.out.println(myArrayQueque.offer(110)); myArrayQueque.toPrint(); 
        System.out.println(myArrayQueque.offer(150)); myArrayQueque.toPrint(); 
        
        System.out.println(myArrayQueque.poll());  myArrayQueque.toPrint(); 
        System.out.println(myArrayQueque.offer(2)); myArrayQueque.toPrint(); 
        
        System.out.println(myArrayQueque.poll());  myArrayQueque.toPrint(); 
        System.out.println(myArrayQueque.poll());  myArrayQueque.toPrint(); 

        System.out.println(myArrayQueque.offer(500)); myArrayQueque.toPrint();       
        System.out.println(myArrayQueque.offer(70)); myArrayQueque.toPrint();       
        System.out.println(myArrayQueque.add(500)); myArrayQueque.toPrint();       
        System.out.println(myArrayQueque.poll());  myArrayQueque.toPrint(); 
        System.out.println(myArrayQueque.add(15)); myArrayQueque.toPrint();       
        System.out.println(myArrayQueque.peek()); myArrayQueque.toPrint();
        System.out.println(myArrayQueque.poll());  myArrayQueque.toPrint(); 
        System.out.println(myArrayQueque.peek()); myArrayQueque.toPrint();
    
    
        myArrayQueque.poll();
        myArrayQueque.poll();
        myArrayQueque.poll();
        myArrayQueque.poll();
        myArrayQueque.poll();
        myArrayQueque.poll();
        myArrayQueque.poll();
        myArrayQueque.poll();
        myArrayQueque.poll();
        myArrayQueque.poll();
        
        System.out.println(myArrayQueque.poll());  myArrayQueque.toPrint(); 
        System.out.println(myArrayQueque.add(15)); myArrayQueque.toPrint();   
        System.out.println(myArrayQueque.element());
        myArrayQueque.poll();; myArrayQueque.toPrint();  
        myArrayQueque.element();

        System.out.println(myArrayQueque.add(15)); myArrayQueque.toPrint();   
        System.out.println(myArrayQueque.add(25)); myArrayQueque.toPrint();   
        System.out.println(myArrayQueque.offer(20)); myArrayQueque.toPrint();
        System.out.println(myArrayQueque.offer(25)); myArrayQueque.toPrint();
        System.out.println(myArrayQueque.remove()); myArrayQueque.toPrint();
        System.out.println(myArrayQueque.remove()); myArrayQueque.toPrint();
        System.out.println(myArrayQueque.remove()); myArrayQueque.toPrint();
        System.out.println(myArrayQueque.remove()); myArrayQueque.toPrint();*/

    }  /** end of main method */




}  /** end of TestLinkedQueue class */