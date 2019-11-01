package code.sem1;

import de.r13g.lib.console.ConsoleExt;

public class Kreisberechnung {

  public static void main(String[] args) {
    System.out.println("*** Kreis-/Zylinderrechner ***");
    double radius = ConsoleExt.getInputDouble("Radius");
    double height = ConsoleExt.getInputDouble("Höhe");
    double area = Math.PI * radius * radius;
    double circumference = 2 * Math.PI * radius;
    double volume = area * height;

    System.out.printf("Grundfläche: %.2f" + "%n", area);
    System.out.printf("Umfang: %.2f" + "%n", circumference);
    System.out.printf("Volumen: %.2f" + "%n", volume);
  }
}
