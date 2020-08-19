/**************************************************************************
  The revision of the Assignment 3, after Black Box Testing (BBT)
***************************************************************************/

	        /** 
		* @author               Ehsan Kourkchi
		* @lecture              ICS 211 Desember 2013
		* @date                 Desember 13, 2013
		* @class type           public generic class ArraySearch
		*/
/***************************************************************************/

import java.util.*;


public class HomeWork3 {


	  public static void main(String []args) {
	  
	  Integer [] numbers = {1,2,3,4,5,6,7,5,9,4};
	  String [] names = {"Ehsan", "Hossein", "Nader", "Sean", "Mark"};


	  ArraySearch<String> mySearch1 = new ArraySearch<String>();
	  ArraySearch<Integer> mySearch2 = new ArraySearch<Integer>();

	  
	  System.out.println("\n\n\n\n");
	  System.out.println("\n1) *** Test 'find' method  for an integer array ***");
	  System.out.println("\nThe test array is: {1,2,3,4,5,6,7,5,9,4}");
	  System.out.println("Looking for the number '6' in this array.");
	  System.out.printf("The returned index by 'find' method is: %d", mySearch2.find( numbers, (Integer) 6 ));
	  System.out.println("\n ************************************");


          System.out.println("\n2) *** Test 'find' method  for a string array ***"); 
	  System.out.println("\nThe test array is: \n   {\"Ehsan\", \"Hossein\", \"Nader\", \"Sean\", \"Mark\"}");
	  System.out.println("Looking for the string \"Nader\" in this array.");
	  System.out.printf("The returned index by 'find' method is: %d", mySearch1.find( names, "Nader" ));
	  System.out.println("\n ************************************");

	  System.out.println("\n3) *** Test 'first_duplicate' method  for an integer array ***");
	  System.out.println("\nThe test array is: {1,2,3,4,5,6,7,5,9,4}");
	  System.out.printf("The index of the first duplicated element: %d",mySearch2.first_duplicate(numbers)  );	  
	  System.out.println("\n ************************************");

	   
	  System.out.println("\n4) *** Test 'first_duplicate' method  for a string array ***");
	  System.out.println("\nThe test array is: \n   {\"Ehsan\", \"Hossein\", \"Nader\", \"Sean\", \"Mark\"}");
	  System.out.printf("The index of the first duplicated element: %d",mySearch1.first_duplicate(names)  );	
	  

	  
	  System.out.println("\n ************************************");
	  System.out.println("\n5) *** Test 'find' method  for throwing an exception ***");
	  System.out.println("\nThe test array is: {1,2,3,4,5,6,7,5,9,4}");
	  System.out.println("Looking for the number '100' in this array.");
	      
	      // Here, throwing an exception is expected. So, using try and catch syntax to handle the exception
	      try {
	      System.out.printf("The returned index by 'find' method is: %d", mySearch2.find( numbers, (Integer) 100 ));

	      } catch(MissingResourceException ex) {
		System.out.println("\n" + ex);
	      }
	      
	      System.out.println("\n ************************************");	  
	  
	  }    /** The end of main method */

/***************************************************************************/
}   // end of the class
/***************************************************************************/

