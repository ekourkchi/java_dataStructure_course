public class Point {

 double x ;
 double y ;

  public Point(double x, double y) {
  
  this.x = x;
  this.y = y;
  
  }
  
  public Point() {
  
  this.x = 0.;
  this.y = 0.;
  
  }
  public double getX() {
    
    return x;
  }

  public double getY() {
    
    return y;
  }

  public double distance(Point other) {
  
  double x1 = this.x;
  double y1 = this.y;
  
  double x2 = other.getX();
  double y2 =  other.getY();
  
  double distance = Math.sqrt((x1-x2)*(y1-y2)+(y1-y2)*(y1-y2));
  return distance;
  }

  public String toString() {
  
  String s = "(" + x + "," + y + ")";
  return s;
  }

}