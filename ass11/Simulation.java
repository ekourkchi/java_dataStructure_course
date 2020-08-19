import java.util.Random;


public class Simulation {

   
    
    /*************************************************
                 M A I N   M E T H O D
    *************************************************/  
    public static void main(String [] argv) { 
    
         
         int n;
         int size = 1000000;
         int load = size/10;
         //int load = size*10;
         Hash211<String, Integer> myTable = new Hash211(size, false);
         
         Random rand = new Random((long) (10));
         
         
         for (int i=0; i < load+1; i++) {  // adding #load random elements
            
            n = rand.nextInt(10*size);
            myTable.put(Integer.toString(n), n);
         
         }
         
         rand.setSeed(50);
         
         for (int i=0; i < 21; i++) {  // putting and getting value 20 times
            
            myTable.printTimes = true;
            n = rand.nextInt(10*size);
            myTable.put(Integer.toString(n), n);
            
            myTable.printTimes = false;
            n = rand.nextInt(10*size);
            myTable.get(n);
            
         }
         
         
         
         
         
    
    
    
    }

    




}