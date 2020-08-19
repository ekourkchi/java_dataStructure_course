/*Jiajie Li
  ICS 211
  Assignment2*/

public class Segment implements SegmentInterface
{
   private Point first = new Point();
   private Point second = new Point();
    
   public Segment(Point first, Point second)
   {
      this.first = first;
      this.second = second;
   }
   
   public Point left() 
   {
      if (first.getX() < second.getX())
      {
         return first;
      }
      else 
      {
         return second;
      }
   }
   
   public Point right()
   {
      if (first.getX() < second.getX())
      {
         return second;
      }
      else 
      {
         return first;
      }
   }
   
   public Point upper()
   {
      if (first.getY() < second.getY())
      {
         return second;
      }
      else 
      {
         return first;
      }
   }
   
   public Point lower()
   {
      if (first.getY() < second.getY())
      {
         return first;
      }
      else 
      {
         return second;
      }
   }
   
   public double length()
   {
      double length = first.distance(second);
      return length;
   }
   
   public boolean isHorizontal()
   {
      if(first.getY() == second.getY())
      {
         return true;
      } 
      else
      {
         return false;
      }
   }
   
   public boolean isVertical()
   {
      if(first.getX() == second.getX())
      {
         return true;
      }
      else 
      {
         return false;
      }
   }
   
   public void move(Point newLowerOrLeft)
   {
    //find lower left
      double pointone;
      double pointtwo;
      if (isHorizontal())
      {
         if (first.equals(this.left()))
         {
            pointone = first.getX() - newLowerOrLeft.getX();
            pointtwo = first.getY() - newLowerOrLeft.getY();
            first = newLowerOrLeft;
         }
         else 
         {
            pointone = second.getX() - newLowerOrLeft.getX();
            pointtwo = second.getY() - newLowerOrLeft.getY();
            second = newLowerOrLeft;
         }
      }
      else if (isVertical())
      {
         if (first.equals(this.lower()))
         {
            pointone = first.getX() - newLowerOrLeft.getX();
            pointtwo = first.getY() - newLowerOrLeft.getY();
            first = newLowerOrLeft;
         }
         else
         {
            pointone = second.getX() - newLowerOrLeft.getX();
            pointtwo = second.getY() - newLowerOrLeft.getY();
            second = newLowerOrLeft;
         }
      }
   }
   
   public String toString()
   {
      String test = "(" + first + "), (" + second + ")";
      return test;
   }
}