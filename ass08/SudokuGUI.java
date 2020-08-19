import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.applet.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class SudokuGUI extends JFrame implements  ActionListener, KeyListener, MouseListener {

JPanel keypanel = new JPanel();
JPanel infopanel = new JPanel();
JPanel [] rowpanel = new JPanel[11];
JTextField [] cell = new JTextField[81];
JButton exit = new JButton("Exit");
JButton clear = new JButton("Clear");
JButton solve = new JButton("Solve");
JLabel infolabel = new JLabel("Sudoku Solver --- Copyright (2013) --- Ehsan Kourkchi");

   

   
   /** constructor */
   
   public SudokuGUI() {
   
   int i=0, j=0, n;
    
   MyLine content = new MyLine(new GridLayout(11, 0, 2, 4));
   

   
   
   keypanel.add(exit);
   keypanel.add(clear);
   keypanel.add(solve);
   
   infopanel.add(infolabel);
   
   
   content.add(infopanel);
   
   


   
   for (i=0; i<9; i++) rowpanel[i] = new JPanel(new GridLayout(1, 9, 4, 2));
   for (i=0; i<81; i++) cell[i] = new JTextField(2);
   
   Font font1 = new Font("SansSerif", Font.BOLD, 20);
   for (n=0; n < 81; n++) {
       j = n%9;
       i = (n-j)/9; // row number
       //cell[n].setSize(200,200);
       cell[n].setHorizontalAlignment(JTextField.CENTER);
       cell[n].setFont(font1);
       cell[n].setForeground(Color.BLUE);
       cell[n].addKeyListener(this);
       cell[n].addActionListener(this);
       rowpanel[i].add(cell[n]);
       //if (j==2 || j== 5) rowpanel[i].add(new JSeparator(SwingConstants.VERTICAL));
                
   }
   
   
   
    
   for (i=0; i<9; i++) {
       content.add(rowpanel[i]);
       //if (i==2 || i== 5) content.add(new JSeparator(SwingConstants.HORIZONTAL));
          
   }  
   
   

   content.add(keypanel);
   

   exit.addActionListener(this);
   clear.addActionListener(this);
   solve.addActionListener(this);
   this.getContentPane().add(content);
   

   }
   
   
   

   
   
   
   private void setCenter() {
   
    // Get the size of the screen
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
 
    // Determine the new location of the window
    int w = this.getSize().width;
    int h = this.getSize().height;
    int x = (dim.width-w)*1/3;
    int y = (dim.height-h)*1/3;
 
    // Move the window
    this.setLocation(x, y);
   
   }

   
   
   public void mouseClicked(MouseEvent e) {}
   public void mouseReleased(MouseEvent e) {}
   public void mouseEntered(MouseEvent e) {}
   public void mouseExited(MouseEvent e) {}
   
   
   public void mousePressed(MouseEvent e) {

   
   
   
   //  if (e.getClickCount() == 2 && !textField.getText().equals("")) 
      
}

   
   
   public void keyTyped(KeyEvent event) {
   

   }
   public void keyReleased(KeyEvent event) {
   
      
      int n;
      int key = event.getKeyCode();
     

     
     for (n=0; n < 81; n++) {
       if (event.getSource() == cell[n])
           {
           
           String outString = "";
           if (cell[n].getText().length() > 1)  {
           
           String s = cell[n].getText();
           
           outString += s.charAt(1);
           
           cell[n].setText(outString);
           outString = "" + s.charAt(0);
           
           }   
           
           
           if (cell[n].getText().equals("1"))  cell[n].setText("1");
           else if (cell[n].getText().equals("2"))  cell[n].setText("2");
           else if (cell[n].getText().equals("3"))  cell[n].setText("3");
           else if (cell[n].getText().equals("4"))  cell[n].setText("4");
           else if (cell[n].getText().equals("5"))  cell[n].setText("5");
           else if (cell[n].getText().equals("6"))  cell[n].setText("6");
           else if (cell[n].getText().equals("7"))  cell[n].setText("7");
           else if (cell[n].getText().equals("8"))  cell[n].setText("8");
           else if (cell[n].getText().equals("9"))  cell[n].setText("9");
           else cell[n].setText(outString);
           


           
           
           cell[n].setForeground(Color.BLUE);
           
           }
           //if (cell[n].getText().length() > 0 )  cell[n].setText("0");
     }

   
   
   
   }
   
   public void keyPressed(KeyEvent event) {
      
 
   
   }
   
   
   
   
   

   
   
   public void actionPerformed(ActionEvent event) {
        
 
     int n;
     if (event.getSource() == exit)  
       System.exit(0);
       
     if (event.getSource() == clear)  {
     for (n=0; n < 81; n++) {
     
     cell[n].setText("");
     cell[n].setForeground(Color.BLUE);
     }}
  
  
     if (event.getSource() == solve) { 
     
         /* a hard sudoku known as AI Escargot */
    int i,j;
    int [] [] sudoku = {{1, 0, 0, 0, 0, 7, 0, 9, 0},
                          {0, 3, 0, 0, 2, 0, 0, 0, 8},
                          {0, 0, 9, 6, 0, 0, 5, 0, 0},
                          {0, 0, 5, 3, 0, 0, 9, 0, 0},
                          {0, 1, 0, 0, 8, 0, 0, 0, 2},
                          {6, 0, 0, 0, 0, 4, 0, 0, 0},
                          {3, 0, 0, 0, 0, 0, 0, 1, 0},
                          {0, 4, 0, 0, 0, 0, 0, 0, 7},
                          {0, 0, 7, 0, 0, 0, 3, 0, 0}};
                          
     Sudoku.toString (sudoku, false);                     
     for (n=0; n < 81; n++) {
         
         j = n%9;
         i = (n-j)/9; // row number
         
         if (!cell[n].getText().equals("")) {
             sudoku[i][j] = Integer.parseInt(cell[n].getText());
             }
         else {
            sudoku[i][j] = 0;
            cell[n].setForeground(Color.BLACK);
            }
         
     }
     //System.out.println("hello");
     Sudoku.fillSudoku (sudoku);
     Sudoku.toString (sudoku, false);
     
     
     for (n=0; n < 81; n++) {
         
         j = n%9;
         i = (n-j)/9; // row number
      
      
      cell[n].setText(Integer.toString(sudoku[i][j]));
         
     }
     
     
     }
  
  
  
  
  
  
  
  
  }
   

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   public static void main(String [] args) {
   
   SudokuGUI myWindow = new SudokuGUI();
   myWindow.setTitle("Ehsan's Sudoku Solver");

   myWindow.setSize(700,200);
   
   myWindow.setCenter();
   myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   myWindow.pack();
   
   
   myWindow.setResizable(false);
   myWindow.setVisible(true);
   myWindow.toFront();
   }







}