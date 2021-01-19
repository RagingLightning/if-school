package code.oop.OOP210119;

public class Mensch {

  private final static int MIN_WEIGHT = 20;

  private boolean is_awake = true;
  private String name = null;
  private int weight = 20;

  public Mensch(String name) {
    this.name = name;
  }

  public boolean getIsAwake() {
    return is_awake;
  }

  public void awake() {
    System.out.println("Now Awake");
    is_awake = true;
  }

  public void go_to_sleep() {
    System.out.println("Now Asleep");
    is_awake = false;
  }

  public boolean eat() {
    if (is_awake) {
      System.out.println("Ate something");
      weight++;
      return true;
    }
    return false;
  }

  public boolean drink() {
    if (is_awake) {
      System.out.println("Drank something");
      weight++;
      return true;
    }
    return false;
  }

  public boolean excercise() {
    if (is_awake && weight > MIN_WEIGHT) {
      System.out.println("Did some stuff");
      weight--;
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Mensch m = new Mensch("Peter-Klaus");
    m.eat();
    m.drink();
    m.excercise();
    m.go_to_sleep();
    m.excercise();
    m.drink();
    m.awake();
    m.excercise();
    m.excercise();
  }

}
