/*Jiajie Li
  ICS 211
  Assignment2*/

public class Point
{
   private double x;
   private double y;
   
   public Point (double a, double b)
   {
      this.x = a;
      this.y = b;
   }
   
   public Point()
   {
      this.x = 0.0;
      this.y = 0.0;
   }
   
   public double getX()
   {
      return x;
   }
   
   public double getY()
   {
      return y;
   }
   
   public double distance(Point other)
   {
      double result;
      double a;
      double b;
      double apow;
      double bpow;
      a = other.getX() - this.getX();
      b = other.getY() - this.getY();
      apow = Math.pow(a,2);
      bpow = Math.pow(b,2);
      result = Math.sqrt(apow + bpow);
      return result;
   }
   
   public String toString()
   {
      String num = "(" + x + "," + y + ")";
      return num;
   }
}