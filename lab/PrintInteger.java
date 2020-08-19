public class PrintInteger {

   
   public static String toSt(int n) {
   
       if (n<1000) return Integer.toString(n);
       
       int m = (n - (n % 1000)) / 1000 ;
       
       if (n % 1000 < 10)
        return toSt(m) + ",00" + Integer.toString(n % 1000);
       else if (n % 1000 < 100)
        return toSt(m) + ",0" + Integer.toString(n % 1000);
       else;
        return toSt(m) + "," + Integer.toString(n % 1000);
       
   
   }
   
   
   public static void main(String [] argv) {
   
      
      System.out.println(toSt(1008));
   
   
   
   }





}