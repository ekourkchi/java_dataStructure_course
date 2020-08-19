/*Jiajie Li
  ICS 211
  Assignment2*/

public interface SegmentInterface
{
   Point left(); // the point at the left end of the segment
   Point right(); // the point at the right end of the segment
   Point upper(); // the point at the upper end of the segment
   Point lower(); // the point at the lower end of the segment
   double length(); // the length of the segment, that is, the distance between its endpoints 
}