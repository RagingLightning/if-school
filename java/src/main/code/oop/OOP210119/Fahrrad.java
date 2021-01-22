package code.oop.OOP210119;

import java.util.ArrayList;
import java.util.UUID;

public class Fahrrad {

  private static int CURRENT_SERIAL = 1;

  private String model = null;
  private int color = -1;
  private int gearCount = -1;
  private int gear = 1;
  private boolean lights = false;

  private int speed = 0;

  private int serial = -1;

  public Fahrrad(String _model, int _color, int _gearCount) {
    serial = CURRENT_SERIAL;
    CURRENT_SERIAL++;
    model = _model;
    color = _color;
    gearCount = _gearCount;
  }

  public boolean shiftUp() {
    if (gear < gearCount) {
      System.out.println("Shifting up to " + gear++);
      return true;
    }
    return false;
  }

  public boolean shiftDown() {
    if (gear > 1) {
      System.out.println("Shifting down to " + gear--);
      return true;
    }
    return false;
  }

  public void toggleLights() {
    System.out.println("Toggeling lights");
    lights = !lights;
  }

  public void pedal() {
    System.out.println("Speeding up");
    speed++;
  }

  public void brake() {
    if (speed > 0) {
      System.out.println("Braking");
      speed--;
    }
  }

  public static void main(String[] args) {
    Fahrrad f = new Fahrrad("ModelX", 3 ,21);
    f.shiftUp();
    f.shiftUp();
  }

}
