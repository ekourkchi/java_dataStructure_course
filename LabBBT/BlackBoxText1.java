import java.util.*;

/**
* Assignment 13 due december 10, 2013 
* BlackBoxTest1, testing Ehsan Kourkchi's Assignment 3, ArraySearch
* There were some problems that occured 
* nullpointerexception for both find and first_duplicate methods 
* the main method compiles but it won't run due to the exceptions had occur 
* @Assignment 3 author Ehsan Kourkchi
* @BlackBoxTest1 author Micah Angeles 
**/

public class BlackBoxText1 
{
   public static void main(String[] args)
   {
      //the author's class is nonstatic method 
      //in order to test this, an instanciating of an ArraySearch class is needed 
      ArraySearch blackBoxArrTest = new ArraySearch(); 
      
      //two different types of arrays to see if this class is able to take generic types (e.g  <E>)
      //string array 
      String[] strArray = new String[10]; 
      //integer array 
      Integer[] intArray = new Integer[10]; 
      
      strArray[0] = "micah"; 
      strArray[1] = "paul"; 
      strArray[2] = "dude"; 
      strArray[3] = "jai"; 
      strArray[4] = "aron"; //first duplicate
      strArray[5] = "aron"; //second duplicate
      
      intArray[0] = 2; 
      intArray[1] = 4;
      intArray[2] = 5; 
      
      //returns the index of where jai is 
      System.out.println(blackBoxArrTest.find(strArray, "jai") ); 
      
      //returns the index of where the dude is
      System.out.println(blackBoxArrTest.find(strArray, "dude") ); 
      
      //prints out the first duplicate
      System.out.println(blackBoxArrTest.first_duplicate(strArray) ); 
      
      // it should return -1 since there is no duplicates on intArray
      // however, it gives a nullpointer exception 
      // this should returns -1 since there is duplicates
      //it is somewhere around the author's code that is causing the nullpointerexception 
      System.out.println(blackBoxArrTest.first_duplicate(intArray) ); 
      
      //try/catch to see if the MissingResourceException would be caught 
      //however, it also has a nullpointer exception 
      //this should be returning a statement saying "sorry there is no jojo in the strArray"
      //it is somewhere around the author's code that is causing the nullpointerexception 
      try 
      {
         System.out.println(blackBoxArrTest.find(strArray, "jojo") );
         assert false; 
      }
      catch(MissingResourceException error)
      {
         System.out.println("sorry there is no jojo in the strArray"); 
      }
      
      
   }
}