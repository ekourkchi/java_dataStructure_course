public class assignment2
{
   public static void main(String[] args)
   {
      Point test = new Point();
      double x = test.getX();
      System.out.println(x);
      double y = test.getY();
      System.out.println(y);
      String output = test.toString();
      System.out.println(output);
      CreateSegments segment = new CreateSegments();
      segment.unitTest();
   }
}