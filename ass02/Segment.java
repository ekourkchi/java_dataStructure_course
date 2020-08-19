public class Segment implements SegmentInterface  {

private Point A ;
private Point B ;

    public Segment(Point p1, Point p2) {
    
    A = p1;
    B = p2;
    
    }
    
    public Segment() {
    
    A = new Point();
    B = new Point();
    
    }   
    public Point left() { // the point at the left end of the segment
    
    if (A.getX() <= B.getX()) return A;
    else 
    return B;
    
    }
    
    public Point right() {  // the point at the right end of the segment
    
    if (A.getX() > B.getX()) return A;
    else 
    return B;
    
    }
    
    public Point upper() {  // the point at the upper end of the segment
    
    if (A.getY() > B.getY()) return A;
    else 
    return B;
    
    }
    
    public Point lower() {  // the point at the lower end of the segment
    
    if (A.getY() <= B.getY()) return A;
    else 
    return B;
    
    }
    
    public double length() {  // the length of the segment, that is, the distance between its endpoints 
    
    return A.distance(B);
       
    }    
    
    
    public boolean isHorizontal()  {
    
    if (A.getY() == B.getY())   return true;
    else
    return false;
    
    }
    
    public boolean isVertical()  {
    
    if (A.getX() == B.getX())   return true;
    else
    return false;
    
    }
    
    
    public void move(Point newLowerOrLeft) {
    
    Point lowerOrleft = new Point();
    Segment AB = new Segment(A,B);
    
    if (AB.isHorizontal()) lowerOrleft = AB.left();
    else 
    lowerOrleft = AB.lower();
    
    double x2 = newLowerOrLeft.getX();
    double y2 = newLowerOrLeft.getY();
    double x1 = lowerOrleft.getX();
    double y1 = lowerOrleft.getY();
    double delta_x = x2 - x1;
    double delta_y = y2 - y1;
    
    A.x += delta_x;
    B.x += delta_x;
    A.y += delta_y;
    B.y += delta_y;   

    }
 
    public void shiftRight(double delta) {
    
    A.x += delta;
    B.x += delta;

    } 
 
 
   public String toString() {
   
   String s = A.toString() + B.toString();
   return s;
   
   }


}