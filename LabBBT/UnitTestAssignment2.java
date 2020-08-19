


public class UnitTestAssignment2{


   public static void main(String []args) {
   
        System.out.println("\n ****************************");
        Point A = new Point();
        System.out.println("\nDefault constructor (): " + A.toString());
        
        A = new Point(1.2, 4.5);
        System.out.println("Constructor with (1.2, 4.5): " + A.toString());
        
        Point B = new Point(3.5, 10.2);
        System.out.println("Constructor with (3.5, 10.2): " + B.toString());
        
        System.out.println("\nTesting toString()");
        System.out.println("  A = " + A.toString());
        System.out.println("  B = " + B.toString());
        
        System.out.println("\nTesting GetX()");
        System.out.println("  Ax = " + A.getX());
        System.out.println("  Bx = " + B.getX());
   
        System.out.println("\nTesting GetY()");
        System.out.println("  Ay = " + A.getY());
        System.out.println("  By = " + B.getY());   
        
        System.out.println("\nTesting Distance: (expected ~ 6.146543744)");
        System.out.println("  A-B distance = " + A.distance(B));
        
        
        System.out.println("\nDefining a segment ....");
        //Segment AB = new Segment();
        System.out.println("  NO Default constructor is provided ... ERROR");
        
        System.out.println("\nDefining the A-B segment ....");
        Segment AB = new Segment(A,B);
        System.out.println("  A-B toString test: " + AB.toString());
        
        System.out.println("  A-B segment ... length(): " + AB.length());
        System.out.println("  A-B segment ... left(): " + AB.left());
        System.out.println("  A-B segment ... right(): " + AB.right());
        System.out.println("  A-B segment ... upper(): " + AB.upper());
        System.out.println("  A-B segment ... lower(): " + AB.lower());
        System.out.println("  A-B segment ... isHorizontal(): " + AB.isHorizontal());
        System.out.println("  A-B segment ... isVertical(): " + AB.isVertical());
        
        AB.move(new Point(0,0));
        System.out.println("\n  A-B segment ... move(0,0): " + AB.toString());
        System.out.println("\n ****************************");
        
        System.out.println(" ****************************");
        System.out.println("\nA Vertical Segment .... \n");
        Point C = new Point(1, 2);
        Point D = new Point(1, 5);
        System.out.println("  C = " + C.toString());
        System.out.println("  D = " + D.toString());
        

        System.out.println("\nDefining the C-D segment ....");
        Segment CD = new Segment(C,D);
        System.out.println("  C-D toString test: " + CD.toString());
        
        System.out.println("  C-D segment ... length(): " + CD.length());
        System.out.println("  C-D segment ... left(): " + CD.left());
        System.out.println("  C-D segment ... right(): " + CD.right());
        System.out.println("  C-D segment ... upper(): " + CD.upper());
        System.out.println("  C-D segment ... lower(): " + CD.lower());
        System.out.println("  C-D segment ... isHorizontal(): " + CD.isHorizontal());
        System.out.println("  C-D segment ... isVertical(): " + CD.isVertical());
        
        CD.move(new Point(0,0));
        System.out.println("\n  C-D segment ... move(0,0): " + CD.toString());
        System.out.println(" ****************************");
        
        System.out.println(" ****************************");
        System.out.println("\nA Horizontal Segment .... \n");
        Point E = new Point(1.5, 7);
        Point F = new Point(5.5, 7);
        System.out.println("  E = " + E.toString());
        System.out.println("  F = " + F.toString());
        

        System.out.println("\nDefining the E-F segment ....");
        Segment EF = new Segment(E,F);
        System.out.println("  E-F toString test: " + EF.toString());
        
        System.out.println("  E-F segment ... length(): " + EF.length());
        System.out.println("  E-F segment ... left(): " + EF.left());
        System.out.println("  E-F segment ... right(): " + EF.right());
        System.out.println("  E-F segment ... upper(): " + EF.upper());
        System.out.println("  E-F segment ... lower(): " + EF.lower());
        System.out.println("  E-F segment ... isHorizontal(): " + EF.isHorizontal());
        System.out.println("  E-F segment ... isVertical(): " + EF.isVertical());
        
        EF.move(new Point(0,0));
        System.out.println("\n  E-F segment ... move(0,0): " + EF.toString());
        System.out.println(" ****************************");        
        
        
        
        
        
        System.out.println("\n\n ****************************");
        System.out.println("Testing CreateSegments.printFour() .... \n");
        SegmentInterface seg1 = new Segment(new Point(6,2), new Point(3,4));
        SegmentInterface seg2 = new Segment(new Point(2,1), new Point(5,0));
        SegmentInterface seg3 = new Segment(new Point(-1,2), new Point(7,-3));
        SegmentInterface seg4 = new Segment(new Point(3,9), new Point(1,8));
        CreateSegments myTestCreateSegments = new CreateSegments();
        myTestCreateSegments.printFour(seg1, seg2, seg3, seg4);
        
        System.out.println("\n\n ****************************");
        System.out.println("Testing CreateSegments.unitTest() .... \n");
        CreateSegments.unitTest();

        
        System.out.println("\n   End of test ...\n\n");
   
   
   
   }










}