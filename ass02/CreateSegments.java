public class CreateSegments {

    static void printFour(SegmentInterface seg1, SegmentInterface seg2, SegmentInterface seg3, SegmentInterface seg4) {
    
    System.out.println(seg1.toString() + "  " + seg2.toString() + "  " + seg3.toString() + "  " + seg4.toString());


    }
    
    static void unitTest()  {
    
    Point A = new Point(1,2);
    Point B = new Point(4,5);   
    Point C = new Point(4,2);   
    Point D = new Point(0,0);  
    Point E = new Point(7,1.5);  
    
    Point move = new Point();

    SegmentInterface segment_1 = new Segment(A,B);
    SegmentInterface segment_2 = new Segment(A,C);
    
    Segment segment_3 =  new Segment(B,C);
    Segment segment_4 =  new Segment(D,E);
    
    printFour(segment_1, segment_2, segment_3, segment_4);
    
    segment_4.shiftRight(-5.30);
    printFour(segment_1, segment_2, segment_3, segment_4);

    //System.out.println(segment_1.toString());
    
    }




}