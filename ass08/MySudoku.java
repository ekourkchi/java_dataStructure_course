
public class  MySudoku  {


public static void main(String [] argv) {

//int [9] [9] matrix;

int [] [] matrix = {{1, 0, 0, 0, 0, 7, 0, 9, 0},
          {0, 3, 0, 0, 2, 0, 0, 0, 8},
          {0, 0, 9, 6, 0, 0, 5, 0, 0},
          {0, 0, 5, 3, 0, 0, 9, 0, 0},
          {0, 1, 0, 0, 8, 0, 0, 0, 2},
          {6, 0, 0, 0, 0, 4, 0, 0, 0},
          {3, 0, 0, 0, 0, 0, 0, 1, 0},
          {0, 4, 0, 0, 0, 0, 0, 0, 7},
          {0, 0, 7, 0, 0, 0, 3, 0, 0}};
          
          
fillSudoku(matrix);
//System.out.println (toString(matrix, false));


}


  public static boolean fillSudoku (int [] [] sudoku)
  {
    int i, j;
    boolean isFul = true;
    System.out.println ("fillSudoku is being implemented\n");
    
    for (i=0; i<9; i++)
      for (j=0; j<9; j++)
        if (sudoku[0][j] == 0) isFul = false;
    
    System.out.println (isFul);
    
    
    
    
    
    return false;
  }
  
  
  
  
  
  
    public static String toString (int [] [] sudoku, boolean debug) {

      String result = "";
      for (int i = 0; i < sudoku.length; i++) {
        if (i % 3 == 0) {
          result = result + "+-------+-------+-------+\n";
        }
        for (int j = 0; j < sudoku.length; j++) {
          if (j % 3 == 0) {
            result = result + "| ";
          }
          if (sudoku [i] [j] == 0) {
            result = result + "  ";
          } else {
            result = result + sudoku [i] [j] + " ";
          }
        }
        result = result + "|\n";
      }
      result = result + "+-------+-------+-------+\n";
      return result;
 
  }

  
  
  
} /** End of Class */

