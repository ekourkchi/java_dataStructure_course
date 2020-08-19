public class Assignment3Test
{
   public static void main(String[] args)
   {
      Integer [] numbers = {1,2,3,4,5,6,7,5,9,4};
      String [] names = {"Ehsan", "Hossein", "Nader", "Sean", "Mark"};
      
      ArraySearch<String> search1 = new ArraySearch<String>();
      ArraySearch<Integer> search2 = new ArraySearch<Integer>();
      
      //TESTS THE FIND METHOD
      int search1Result = search1.find( names, "Nader" );
      int search2Result = search2.find( numbers, (Integer) 6 );
      
      //PRINTS RESULTS FOR FIND TEST
      System.out.println("Search1 Find Result: " + search1Result);
      System.out.println("Search2 Find Result: " + search2Result);
      
      //TESTS THE FIRST_DUPLICATE METHOD
      int search1DuplicateResult = search1.first_duplicate(names);
      int search2DuplicateResult = search2.first_duplicate(numbers);
      
      //PRINTS RESULT FOR FIRST_DUPLICATE TEST
      System.out.println("Search1 First_Duplicate Result: " + search1DuplicateResult);
      System.out.println("Search2 First_Duplicate Result: " + search2DuplicateResult);
   }
}

/* 

 Test 1 Results:
 
 int search1Result = search1.find( names, "Nader" );
 Search1 Find Result: 2
 --correct--
 
 int search2Result = search2.find( numbers, (Integer) 6 );
 Search2 Find Result: 5
 --correct--
 
 int search1DuplicateResult = search1.first_duplicate(names);
 Search1 First_Duplicate Result: -1
 --correct--
 
 int search2DuplicateResult = search2.first_duplicate(numbers);
 Search2 First_Duplicate Result: 3
 --correct--
 
 int search2Result = search2.find( numbers, (Integer) 100 );
 Search2 Find Result (Test to make sure it throws exception): 
 Exception in thread "main" java.util.MissingResourceException: The passed array does not have the requested element.
 	at ArraySearch.find(ArraySearch.java:16)
 	at Assignment3.main(Assignment3.java:52)
 --Would be better to catch the exception and print out the error--

 Test 2 Results:
 
 int search1Result = search1.find( names, "" ); and int search2Result = search2.find( numbers, (Integer) 8 );
 Exception in thread "main" java.util.MissingResourceException: The passed array does not have the requested element.
 	at ArraySearch.find(ArraySearch.java:16)
 	at Assignment3Test.main(Assignment3Test.java:12)
 --Would be better to catch the exception and print out the error--

*/