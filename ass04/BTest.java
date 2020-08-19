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

public class BTest {

    public static void main(String []args) {

         OrderedLinkedList<Integer> list = new OrderedLinkedList();
         
    System.out.println(list.add("z", 23)); // null
    System.out.println(list.add("a", 77)); // null
    System.out.println(list.add("b", 19)); // null
    System.out.println(list.add("r", 72)); // null
    System.out.println(list.add("b", 814)); // 19
    System.out.println(list.get(1));  // 814


   }
  



}

