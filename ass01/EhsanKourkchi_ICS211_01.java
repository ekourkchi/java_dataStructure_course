import java.util.Scanner;
import java.util.InputMismatchException;

public class EhsanKourkchi_ICS211_01 {


	  public static void main(String []args) {
	    String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

	    // Trying to read an integer entered bu the user and put it in "i"
	    System.out.printf("\nEnter an integer number (0..25): ");
	    Scanner sc = new Scanner(System.in);
	    
	    int i = 0;
	      try {			// get the start position
		i = sc.nextInt();
	      } catch(InputMismatchException ex) {	// Checking the exception for anything other than an integer number
		System.out.println("Error: You did not enter an integer number");
		System.exit(1);
	      }
	    
	    // Cheking if the entered number is within the desired interval
	    if (i>=26 || i<0) {
	      System.out.println("Error: The number must be between 0 and 25");
	      System.exit(1); 
	    }
	  
	    // If anything goes alright, printing the corresponding letter 
	    System.out.println("The corresponding letter is: " +alphabet[i]);
	    

	    // Defining a new array of strings with 27 members
	    String[] new_alphabet = new String [27];
	    
	    // The firt member of the defiend array is a blank space
	    new_alphabet[0] = " ";
	    // copying the array "alphabet" to the new array from the index 1
	    System.arraycopy(alphabet, 0,   // source array, and the starting index
			    new_alphabet,  1,  // destination array and the starting index from which the source would be copied
			    26); // number of elemnets which are being copied 

	    String s = " ";  
	    int non_vowel = 0;   // declaring a counter for the number of non-vowel alphabets
	    for(int index=0; index < new_alphabet.length; index++)  {
		  s = new_alphabet[index];
		    if (s=="a" || s=="e" || s=="i" || s=="o" || s=="u")  // checking for vowels and change them to UpperCase
		      s = s.toUpperCase(); 
		    else if (s!=" ") non_vowel++; // checking for a probable blank space which does not contain any character
		  System.out.printf("%s ",s);  // all memebers of the new array would be printed in the same line separated with a sapce
	    }
	    System.out.printf("\n");
	    System.out.println("No. of non-vowel strings: " + non_vowel);
	    System.out.printf("\n");
	  }
}
