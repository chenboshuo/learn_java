/**
 * this create the data structure of point
 * (x,y)
 * 
 * @author chenboshuo
 * @version 0.1
 * 
 */


public class Point {
  private int x;
  private int y;

	public Point(){
    x=0;y=0;
  }

	public Point(int x, int y){
    this.x = x;
    this.y = y;
  }

	public void setX(int x){
    this.x = x;
  }

	public void setY(int y){
    this.y = y;
  }

	public int getX(){return x;}
	
	public int getY(){return y;}

	public double distance(Point p)	{
		int xShift = p.getX() - this.x;
		int yShift = p.getY() - this.y;
		return Math.sqrt(xShift * xShift + yShift * yShift);
	}
  
}
