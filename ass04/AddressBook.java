/******************************************************************/

	        /** 
		* @author               Ehsan Kourkchi
		* @lecture              ICS 211 November 2013
		* @date                 December 9, 2013
		* @class type           public generic class
		*/
/******************************************************************/

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////   

public class AddressBook {

/////////////////////////////////////////////////// 

	  static int add(OrderedLinkedList<String> myList) {

	  String name = " ", tel_number= " ";
	  String output = " ", get_key = " ";
	  Scanner scan = new Scanner(System.in);


	  System.out.printf("Enter a name to add : ");
	      try {
		name = scan.next();
	      } catch(InputMismatchException ex) {
		System.out.println(" Error: You did not enter a valid input\n");
		return 1;
	      } scan.nextLine();


	  System.out.printf("Enter telephone number for '%s\': ", name);
	      try {
		tel_number = scan.next();
	      } catch(InputMismatchException ex) {
		System.out.println(" Error: You did not enter a valid input\n");
		return 1;
	      } scan.nextLine();

	      
	      output = myList.find(name);
	      
	      
	      if (output == null) 
	      {
	         output = myList.add(name, tel_number);
	         System.out.printf("\n'%s' added to telephone book, with number '%s'\n", name, tel_number);
	         }
	         else 
	         {
	            System.out.printf("\n'%s' already exists with the phone number of '%s'.\n", name, output);
	            System.out.printf("Do you want to replace '%s' by '%s'? (Y/N): ", output, tel_number);
	         
	            try {
		    get_key = scan.next();
	            } catch(InputMismatchException ex) {
		           System.out.println(" Error: You did not enter a valid input\n");
		           System.exit(1);
	                   } scan.nextLine();

	            if (get_key.compareToIgnoreCase("Y") == 0 || get_key.compareToIgnoreCase("yes") == 0) 
	            {
	              output = myList.add(name, tel_number);
	              System.out.printf("\nDone ... \nThe updated phone number for '%s' is '%s'.\n", name, tel_number);
	            } 
	            else 
	            { 
	              System.out.printf("\nNot changed ...\nThe phone number for '%s' is '%s'.\n", name, output);
	              return 0; 
	            }
	       
	         }
	      
	      return 0;
	  
	  }
	  
	  
///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////   


	  static int save(OrderedLinkedList<String> myList) {
	  
	  String output = " ";
	  Scanner scan = new Scanner(System.in);
	  String Yes_No = " ";
	  int check = 0;
	  
	  do {
	  
	        System.out.printf("\nEnter the output file name: ");
	        try {
		       output = scan.next();
	        } 
	        catch(InputMismatchException ex) {
		       System.out.println(" Error: You did not enter a valid input\n");
		       return 1;
	        } scan.nextLine();


		try {
		       File file = new File(output);
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
			   file.createNewFile();
			   check = 0 ;
			}
			else {
			  System.out.printf("\n'%s' already exists. \nDo you want to overwrite it? (Y/N): ", output);
			  Yes_No = scan.next();
			  if (Yes_No.compareToIgnoreCase("Y") == 0 || Yes_No.compareToIgnoreCase("yes") == 0) {
			       file.createNewFile(); check = 0; 
			  }
			  else {
			     System.out.printf("'%s' was NOT overwritten ...\n", output);
			     check = 1;
			  }
			}
 
                       if (check == 0) {
                         FileWriter fw = new FileWriter(file.getAbsoluteFile());
			 BufferedWriter bw = new BufferedWriter(fw); 
			 check = myList.write_file(bw);
			 bw.close();
			 System.out.println("Your address book was successfully saved in \'" + output + "\'.\n");
		       }
		} 
		catch (IOException e) {
		   e.printStackTrace();
		   check = 1;
		}
	      
	  }  while (check != 0); 
	  
	  
	  return 0;
	  }
	
	
///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////   
	  
	  static int find(OrderedLinkedList<String> myList) {
	  
	  String name = " ", tel_number= " ";
	  String output = " ";
	  Scanner scan = new Scanner(System.in);
	  
	  if (myList.size() == 0) {
	  System.out.printf("\nThe list is empty.\n");  
	  return 0;
	  }
	  
	  System.out.printf("Enter a name to search for: ");

	  try {
		name = scan.next();
	      } 
	      catch(InputMismatchException ex) {
		System.out.println(" Error: You did not enter a valid input\n");
		return 1;
	      } scan.nextLine();

	  
	  output = myList.find(name);
	  if (output != null)  
	        System.out.printf("\n'%s' was found, number is %s\n", name, output);
	           else
	             System.out.printf("\n'%s' was not found.\n", name);  
	  
	
	  return 0;
	  }
	  
///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////   

	  static int remove(OrderedLinkedList<String> myList) {

	  String name = " ", tel_number= " ";
	  String output = " ", get_key= " ";
	  Scanner scan = new Scanner(System.in);

	  if (myList.size() == 0) {
	  System.out.printf("\nThe list is empty.\n");  
	  return 0;
	  }
	  
	  System.out.printf("Enter a name to remove: ");
	  
	  try {
	        name = scan.next();
	  } 
	  catch(InputMismatchException ex) {
	    System.out.println(" Error: You did not enter a valid input\n");
	    return 1;
	  } scan.nextLine();

	  output = myList.find(name);

	  if (output != null)  {
	    System.out.printf("\n'%s' was found, number is %s\n", name, output);
	    System.out.printf("Do you want to remove it? (Y/N): ");
	         
	    try {
	      get_key = scan.next();
	    } 
	    catch(InputMismatchException ex) {
	      System.out.println(" Error: You did not enter a valid input\n");
	      System.exit(1);
	    } scan.nextLine();

	    if (get_key.compareToIgnoreCase("Y") == 0 || get_key.compareToIgnoreCase("yes") == 0) {
	      output = myList.remove(name);
              System.out.printf("\nName: '%s' Telephone:'%s'.\nsuccessfully removed ...\n", name, output);
	    }
	  }
	  else
	    System.out.printf("\n'%s' was not found.\n", name);  

	  return 0;
	  }
	  
///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////   
	  
	  static void print(OrderedLinkedList<String> myList) {
	  
	  myList.printList();
	  
	  }


///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////   
/* 
//   THIS IS THE MAIN METHOD
//   By: Ehsan Kourkchi 
//   September 2013
//   Testing the database
*/
///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////    
  
  
 public static void main(String []args) {

 Scanner scan = new Scanner(System.in);
 OrderedLinkedList<String> myList = new OrderedLinkedList<String>();
 String menu = " ";
 int menu_index = 100;
 int check = 1;

  while ( menu_index != 0) {
	
	  if (check == 1)
	    System.out.println("\nWelcome ....\nThe address book is empty. ");

	  if (check == 0)
	    System.out.printf("\nThe address book has %d entry. \n", myList.size());

	  System.out.printf("Enter one of <add, remove, find, print, save, quit> : ");

	  try {
	    menu = scan.next();
	  } 
	  catch(InputMismatchException ex) {
	    System.out.println(" Error: You did not enter a valid input\n");
	    System.exit(1);
	  }
	  
	  scan.nextLine();

	  if (menu.compareToIgnoreCase("add") == 0 || menu.compareToIgnoreCase("a") == 0) 
	    menu_index = 1 ;
	  else if (menu.compareToIgnoreCase("remove") == 0 || menu.compareToIgnoreCase("r") == 0)  
	    menu_index = 2 ;
	  else if (menu.compareToIgnoreCase("find") == 0 || menu.compareToIgnoreCase("f") == 0)  
	    menu_index = 3 ;
	  else if (menu.compareToIgnoreCase("print") == 0 || menu.compareToIgnoreCase("p") == 0)   
	    menu_index = 4 ;
	  else if (menu.compareToIgnoreCase("save") == 0 || menu.compareToIgnoreCase("s") == 0)   
	    menu_index = 5 ;
	  else if (menu.compareToIgnoreCase("quit") == 0 || menu.compareToIgnoreCase("q") == 0)   
	    menu_index = 0 ;
	  else { 
	    menu_index = 100; 
	    System.out.println("\nWarning: wrong entry, try again ...");
	  }

	  switch (menu_index) {

	    case 1:  add(myList);
		break;
		
	    case 2:  remove(myList); 
		break;
	    
	    case 3:  find(myList); 
		break; 
	      
	    case 4:  print(myList); 
		break; 
		
	    case 5:  save(myList); 
		break;         

	  }

	  check =0;

	  if (menu_index == 0) {
		System.out.printf("\nAre you sure you want to exit? (Y/N): ");
		
		try {
		  menu = scan.next();
		} 
		catch(InputMismatchException ex) {
		  System.out.println(" Error: You did not enter a valid input\n");
		  System.exit(1);
		}

		scan.nextLine();
		
		if (menu.compareToIgnoreCase("Y") == 0 || menu.compareToIgnoreCase("yes") == 0) 
		{
			System.out.printf("\nDo you want to save the address book? (Y/N): ");
		  
			try {
			  menu = scan.next();
			} 
			catch(InputMismatchException ex) {
			  System.out.println(" Error: You did not enter a valid input\n");
			  System.exit(1);
			} 

			scan.nextLine();
		    
			if (menu.compareToIgnoreCase("Y") == 0 || menu.compareToIgnoreCase("yes") == 0) {
			  save(myList); 
			} 
			else if (menu.compareToIgnoreCase("N") == 0 || menu.compareToIgnoreCase("No") == 0) {
			}      
			else 
			  menu_index = 100;
		      
		}
		else 
		  menu_index = 100;
		
	  }

  }
  
  System.out.println("\n  Quit, closing the address book.\n  Goodbye ...\n\n");

 }


///////////////////////////////////////////////////

}  // end of the class
///////////////////////////////////////////////////
///////////////////////////////////////////////////
///////////////////////////////////////////////////   