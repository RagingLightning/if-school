package code.oop;

public class Point {

  public String name;
  public double x, y;
  private int number;
  
  private static int nextNumber = 1;

  public Point(String name, double x, double y) {
    this.x = x;
    this.y = y;
    this.name = name;
    this.number = this.nextNumber;
    this.nextNumber = this.nextNumber + 1;
  }

  public Point(double x, double y) {
    this("Unbekannt", x, y);
  }

  public int getNumber() {
    return this.number;
  }
  
  public String toString() { return this.name + "(" + this.x + "|" + this.y + ") #" + this.number;  }
  
  public double distanceToOrigin() { return this.distanceTo(new Point(0, 0)); }
  
  public Point mirrorAtOrigin() { return new Point(this.name + "'", -this.x, -this.y);  }
  
  public double distanceTo(Point p) {
    return Math.sqrt(Math.pow(p.x - this.x,2) + Math.pow(p.y - this.y,2));
  }

  public Point mirrorAtXAxis() {
    return new Point(this.name + "'", this.x, -this.y);
  } 
  
  public Point mirrorAtYAxis() { return new Point(this.name + "'", -this.x, this.y); }
   
}
