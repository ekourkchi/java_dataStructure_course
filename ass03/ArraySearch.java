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

public class ArraySearch<E> {

      
      /**
          This function finds the index of the needle in haystack array, if it is available
          
          @param haystack The array which cntains the elements
          @param needle The value for which we are searching the haystack
          
          @return an integer number for the index. If the value is not found, this function returns -1
      
      */
      int find (E [] haystack, E needle) {

	    int index=-1, i=0;

	      for (i=0; i < haystack.length; i++) {
		if (needle.equals(haystack[i])) {
		  index = i;
		  break;
		}
	      }
	    if (index == -1) {  // needle is not avaialable in haystack
	       throw new MissingResourceException("\nThe passed array does not have the requested element.", "ArraySearch", "Error");
	    }
      return index;

      }


      /**
        This function returns the index of the member in the array "data" which is duplicated
        
        @return the index of the first duplicate found, 
        or -1 if each of the elements of the array is unique, 
        i.e., no element of the array is equal to any other element of the array. 
      
      */
      int first_duplicate (E [] data) {
      
	    int i=0, j=0;
	    int datalength = data.length;
	    int index=-1;
	    
	    for (i=0; i < datalength-1; i++)
	    {
		for (j=i+1; j < datalength; j++)
		{
		
		    if (data[i].equals(data[j])) 
		    {
		      index = i;
		      i = datalength-1;
		      j = datalength;
		    }
		
		}
      }
      
          return index;

      }


} // End of the ArraySearch class

/***************************************************************************/



