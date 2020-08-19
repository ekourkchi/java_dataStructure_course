
/**************************************************************************
  The Main class which Decompresses the Huffman compressed file (.huff)
  (Written for HW12) ...  If filename ends in .huff, will decompress.
***************************************************************************/
	        /** 
		* @author               Ehsan Kourkchi
		* @lecture              ICS 211 Desember 2013
		* @date                 Desember 6, 2013
		* @class name           public class HuffDecompress
		*/
/***************************************************************************/


import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.NullPointerException;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.*;


public class HuffDecompress {
    
    
    /** Global variables  */
    static private FileInputStream fin;
    static private int index = -1;
    static private int oneByte;
    
    
    /*************************************************/
         /** A function that returns the next bit of the openned file
            
            @output (integer) .. 0 or 1 
            @throws IOException
         */
    /*************************************************/
    static int getBit() throws IOException
    {
    
        index = (index + 1)%8;
        
        if (index == 0)
        {
            oneByte = fin.read();
            if (oneByte == -1)
               throw new IOException();
            
        }
        return (oneByte >>> (7-index)) & 1;
        
    
    }
    
    
    /*************************************************/
         /** A function that returns the next byte of the openned file
            
            @output (integer) contains 8-bit information. The other 3 bytes are zero
            @throws IOException
         */
    /*************************************************/    
    static int getByte() throws IOException
    {
        int myByte = 0;
        
        for(int i=0; i<8; i++)
            myByte = myByte | getBit() << (7-i);
        
        return myByte;
    
    }
    

    /*************************************************
                 M A I N   M E T H O D
    *************************************************/  
    public static void main(String [] argv) { 
 
         
         // Check for the number of input arguments
         // This need to have only the input filename as the argument
         if (argv.length != 1) {
            
            System.out.println("\nNAME");
            System.out.println("  HuffDecompress -- This program decompresses files that were compressed");
            System.out.println("  using Huffman encoding. It just gets the name of the compressed file as the only argument ... \n");
            System.out.println("SYNOPSIS");
            System.out.println("  $ java HuffDecompress inputfile\n");
            System.out.println("DESCRIPTION");
            System.out.println("  If filename ends in \'.huff\', will decompress."); 
            System.out.println("  It removes the \'.huff\' extension from the output decompressed file.\n\n");
            System.out.println("AUTHOR");
            System.out.println("  Ehsan Kourkchi (C) 2013  <ehsan@ifa.hawaii.edu> \n");
            
            return;
         
         }
            
            // Checking the name of input filename
            /****************************************************************/
            
            String infile = argv[0], outfile = "";
            String extension = ""; 
            int length = infile.length();
            
            if (length > 5)
                extension = infile.substring(length-5,length);
            
            if(extension.equals(".huff"))
                outfile = infile.substring(0,length-5);
            else
            {
                System.out.println("\nThe name of the compressed file must end with \'.huff\' extension.\n");
                return;
            }
            
            
            System.out.println("\nInput file-name:  " + infile); 
            System.out.println("Output file-name: " + outfile);     
            
            /****************************************************************/

         
         
         
         
         
	    // Open the file for decompression
           /****************************************************************/
	    try {
	    
		fin = new FileInputStream(infile);

	    }
	    catch (FileNotFoundException fne)
	    {
		    System.out.println("\nThe file \"" + infile  + "\" not found. \n");
		    return;
	    }

	    
	    
	    // Determining the size of the original uncompressed file (usinf the calue of the first 4 bytes)
           /****************************************************************/
	    int    size = 0;
	    int    b;
		
	    try {
	    
	    size = size | fin.read() << 24;
	    size = size | fin.read() << 16;
	    size = size | fin.read() << 8;
	    size = size | fin.read() << 0;
		
	    System.out.println("The size of uncompressed file is " + size + " bytes.\n");

	    
	    // Bulding the Huffman tree for decoding
           /****************************************************************/       
		HuffTree<Integer> myTree = new HuffTree();
		
		while(!myTree.isComplete()) {
		      
		      if (getBit() == 0) // mid node
		         myTree.add(false, null);
		      else
		         myTree.add(true, getByte());
		}
                
                
	    // testing if the output file exists, and aske the user to either 
	    // replace the existing file or to enter a new name
           /****************************************************************/            
	    File f = new File(outfile);

	    if(f.exists())  {
		
		  Scanner sc = new Scanner(System.in);
		  boolean repeat = true;
		  
		  do {
		  
			System.out.printf("The file \"%s\" exists, Overwrite (Y/N)? ", outfile);
			String st = sc.nextLine(); 
			
			if(st.equals("Y") || st.equals("y") || st.equals("Yes") || st.equals("yes") || st.equals("YES"))
				repeat = false;
			
			if(st.equals("N") || st.equals("n") || st.equals("No") || st.equals("no") || st.equals("NO"))
			{
				System.out.printf("\nPlease enter the output file name: ");
				outfile = sc.nextLine(); 
				f = new File(outfile);
				repeat = f.exists();
			}
		  
		  } while(repeat);
		
	    }
      

            // Creating the output file 
           /****************************************************************/                 
                
                FileOutputStream fout = new FileOutputStream(outfile);
                
                while(size > 0) {
                  
                  //reset the tree traverser (starts from the root)
                  myTree.resetTraverser();
                  
                  boolean isLeaf = true;
                              
                              // Travrse the tree untill to reach the leaf node
			      do {
				  
					try {
						isLeaf = myTree.traverse(getBit() == 1);                       
					  
					} catch (NullPointerException nlpointer) {
					  
						// bad tree traversal = bad compressed file
						System.out.println("\nBad compressed file ... " + nlpointer);
						fout.close();
						return;
					}
			      
			      } while(!isLeaf);

		fout.write(myTree.getTraverserValue());

		size--;
		
		}

                fout.flush();
                fout.close();
                System.out.println("\nDecompressed file is saved as \"" + outfile + "\" successfully ....\n");
       
         
         } // end of try
         // Catching the IO exception
         catch (IOException ioe)
         {
              System.out.println(ioe + "\n");
              return;
         }        

     
     } // End of main method

} /** End of the class */
