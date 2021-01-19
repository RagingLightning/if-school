package code.oop.OOP210119;

public class Stift {

  private int hardness = 1;
  private int thickness = 1;
  private int length = 100;
  private int pointyness = 5;

  public boolean write(String something) {
    if (length > 0 && pointyness > 0) {
      System.out.println("Written " + something);
      length--;
      pointyness--;
      return true;
    }
    return false;
  }

  public void sharpen() {
    pointyness = 5;
    System.out.println("Sharpened pencil");
  }

  public void snap() {
    length /= 2;
    System.out.println("Snapped pen in half");
  }

  public static void main(String[] args) {
    Stift s = new Stift();
    s.write("1");
    s.write("2");
    s.write("3");
    s.write("4");
    s.write("5");
    s.write("6");
    s.sharpen();
    s.write("6 again");
  }

}
