/************************************************************************************
  The Driver class (a job scheduler using a Priority Queue for HW10)
*************************************************************************************/

	        /** 
		* @author               Ehsan Kourkchi
		* @lecture              ICS 211 November 2013
		* @date                 November 22, 2013
		* @class type           public generic class
		*/
/************************************************************************************/

import java.io.*;
import java.util.Scanner;


public class Driver {





         /** Field variables */
         
         // global PriQueue object which is an Priorityqueue that holds the tasks for scheduling
         static PriQueue<Record<String>> schedulerQueue = new PriQueue(5, new Record<String>());
         
         // global PrintWriter object to write in the output file
         static PrintWriter writer; 
         
         // The simulated time
         // Any long integer number can be used as the time regardless of the unit
         // Note: hour-minute-second is not supported in this version
         static long time = 0;
    
    
    
    
    
    
    /*************************************************/
      /**  add method
           Adding a new element to PriorityQueue.
           The results will be displayed on the screen and 
           would be printed in an output file
      */
    /*************************************************/
    private static void add(String task, long deadline, long duration) {
    
         Record<String> newRecord = new Record<String>(task,deadline,duration);
         
         System.out.println(time + ": adding " + task + " with deadline " + deadline + " and duration " + duration);
         writer.println(time + ": adding " + task + " with deadline " + deadline + " and duration " + duration);
         
         schedulerQueue.add(newRecord); 
    }
    
    
  
  
    /*************************************************/
      /**
         This method is called if any task is done
      */
    /*************************************************/    
    private static void done(Record<String> Record) {
         
 
              System.out.print(time +": done with "+Record.data);
              writer.print(time +": done with "+Record.data);
         
		  if(time > Record.deadline) {
		      System.out.print(" (late)\n");
		      writer.print(" (late)\n");
		  } else { 
		      System.out.print("\n");
		      writer.print("\n");
		  }

    }
       
    
    
    
    
    
    /*************************************************
                 M A I N   M E T H O D
    *************************************************/  
    public static void main(String [] argv) throws IOException { 
    
    
        String outfilename = "mySchedule.txt";
        String infilename = "input.txt";
        
        
        // creating the output file to be written
        try { 
              writer = new PrintWriter(outfilename, "UTF-8");
        } catch (IOException ex) {
              System.out.println("\""+outfilename+"\" can not be created.");
              System.exit(1);
        }
 
        
        Scanner s = null;
        

        try {
            
            // openning the input file for reading
            s = new Scanner(new BufferedReader(new FileReader(infilename)));

            while (s.hasNext()) {
            
		    String command = s.next();
		    
		    // if line starts with "schedule"
		    if (command.equals("schedule"))  {
		        
		        // reding the line
			String task = s.next();
			long deadline = Long.valueOf(s.next()).intValue();
			long duration = Long.valueOf(s.next()).intValue();
			add(task, deadline, duration);
			
		    // if line starts with "run"
		    } else if (command.equals("run"))  {
		        
		        // reding the line
			long runtime = Long.valueOf(s.next()).intValue();
			    
			    // task execution starts
			    while (time < runtime) {
			    
				Record<String> topRecord = schedulerQueue.poll();
				    if (topRecord == null) break;  // Queue is empty
				
				System.out.println(time + ": busy with " + topRecord.data + " with deadline " + topRecord.deadline + " and duration " + topRecord.duration);
				writer.println(time + ": busy with " + topRecord.data + " with deadline " + topRecord.deadline + " and duration " + topRecord.duration);
				
				time += topRecord.duration;
				
				    // done with the task
				    if (time <= runtime)
					done(topRecord);
				    else {  // taks is partially executed
				    
					add(topRecord.data, topRecord.deadline, (long) (time-runtime));
					time = runtime;
					break;
					
				    }
			    }
		    } else ;
            }
        } finally {
        
            if (s != null) s.close();
        }



     System.out.println("\n\n  * Please find the final clean schedule in this file: \""+outfilename+"\" ... \n  * Thank you ... Goodbye ...\n\n");
     writer.close();


     }  // End of MAIN method


}  /** The end of driver class */

