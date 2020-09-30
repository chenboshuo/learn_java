/**
 * This class use to finding the closes points
 * @author chenboshuo
 * @version 0.1
 * @see <a href="https://www.geeksforgeeks.org/closest-pair-of-points-using-divide-and-conquer-algorithm/">Closest Pair of Points using Divide and Conquer algorithm</a>
 */

// package algorithm;


public class ClosestPoints {

  /**
   * find the closest using brute force
   * 蛮力法求解平面最近点对
   * @param points the sets of the points
   * @return the index of the closest indexes
   */
	public static int[] bruteForceClosesPoints(Point[] points){
    int[] closestPointsIndex = {-1,-1};
    double minDistance = Integer.MAX_VALUE;

    for(int i=0;i< points.length;++i){
      for(int j=i+1; j < points.length;++j){
        double d = points[i].distance(points[j]);
        if(d < minDistance){
          closestPointsIndex[0] = i;
          closestPointsIndex[1] = j;
          minDistance = d;
        }
      }
    }
    
    return closestPointsIndex;
	}

	public static void main(String[] args){

    Point p1 = new Point(0,0); 
    Point p2 = new Point(1,1); 
    Point p3 = new Point(1,2); 
    Point p4 = new Point(3,1);

		Point[] p = {p1, p2, p3, p4};
		int[] closesPointsIndex = bruteForceClosesPoints(p);

    System.out.println("Your output");
		System.out.println(closesPointsIndex[0]);
    System.out.println(closesPointsIndex[1]);
    
    System.out.println("Expected:\n1\n2");
	}  
}
