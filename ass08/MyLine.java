import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.applet.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.BorderLayout;



public class MyLine extends JPanel
{    


     MyLine(LayoutManager layout) {
     
      super(layout);
     
     }

     @Override public void paint(Graphics g)
     {
         
         super.paint(g);
         //Get the current size of this component
         Dimension d = this.getSize();

         //draw in red
         g.setColor(Color.RED);
         //draw a centered horizontal line
         //g.drawLine(0,d.height/2,d.width,d.height/2);
         
         //g.drawLine(0,(int) Math.ceil(d.height*(1.9/11)),d.width,(int) Math.ceil(d.height*(1.9/11)));
         //g.drawLine(0,(int) Math.ceil(d.height*(1.95/11)),d.width,(int) Math.ceil(d.height*(1.95/11)));
         g.drawLine(0,(int) Math.ceil(d.height*(3.95/11)),d.width,(int) Math.ceil(d.height*(3.95/11)));
         g.drawLine(0,(int) Math.ceil(d.height*(6.97/11)),d.width,(int) Math.ceil(d.height*(6.97/11)));
         g.drawLine(0,(int) Math.ceil(d.height*(0.95/11)),d.width,(int) Math.ceil(d.height*(0.95/11)));
         g.drawLine(0,(int) Math.ceil(d.height*(10./11)),d.width,(int) Math.ceil(d.height*(10./11)));
         
         g.drawLine((int) Math.ceil(d.width*(2.95/9)),(int) Math.ceil(d.height*(0.95/11)),(int) Math.ceil(d.width*(2.95/9)),(int) Math.ceil(d.height*(10./11)));
         g.drawLine((int) Math.ceil(d.width*(5.98/9)),(int) Math.ceil(d.height*(0.95/11)),(int) Math.ceil(d.width*(5.98/9)),(int) Math.ceil(d.height*(10./11)));
         
     }
     

     
     

     
     
}

